package learning.jpa.service.zdh;

import learning.jpa.bean.zdh.*;
import learning.jpa.dao.zdh.*;
import learning.jpa.utils.ExcelUtils;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname PositionService
 * @Description TODO
 * @Date 2020/11/5 2:40 下午
 * @Author z7-x
 */
@Service
@Transactional
public class EmployeePositionService {

    @Autowired
    private EmployeePositionRepository employeePositionRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private UserDistrictRepository userDistrictRepository;

    final String pathFile = "/Volumes/工作文档/spring/boot-test/springboot/learn-practice/jpa/src/main/resources/static/excel/zdh_person.xlsx";

    /**
     * @param
     * @Description: 方法 analysisExcel 的功能描述：TODD 构造org_employee_position中的position_id字段的数据
     * @Return void
     * @Author z7-x
     * @Date 2020/11/9 3:23 下午
     */
    public void analysisExcel() {
        int i = 0;
        List<EmployeePosition> list = new ArrayList<>();
        List<String[]> excelData = null;
        try {
            File file = new File(pathFile);
            FileInputStream input = new FileInputStream(file);
            MultipartFile multipartFile = new
                    MockMultipartFile("file", file.getName(), "text/plain", IOUtils.toByteArray(input));
            excelData = ExcelUtils.getExcelData(multipartFile);
            excelData.remove(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for (int j = 0; j < excelData.size() - 1; j++) {
            String numberNo = excelData.get(j)[2];
            UserDistrict user = userDistrictRepository.findByUsername(numberNo);
            EmployeePosition employeePosition = employeePositionRepository.findById(user.getEmployee()).orElse(null);
            if (null == employeePosition) {
                continue;
            }
            String type = excelData.get(j)[4];

            //根据部门id和类型name确定  position_id
            Position position = positionRepository.findPositionByDepartmentAndName(employeePosition.getDepartment(), type);
            if (null == position) {
                position = positionRepository.findPositionByDepartmentAndName(employeePosition.getDepartment(), "普通员工");
            }
//            EmployeePosition id =
//                    employeePositionRepository.findEmployeePositionByDepartmentAndEmployee(employeePosition.getDepartment(), employeePosition.getEmployee());
            EmployeePosition build = EmployeePosition.builder()
                    .id(employeePosition.getId())
                    .department(employeePosition.getDepartment())
                    .employee(employeePosition.getEmployee())
                    .organization(employeePosition.getOrganization())
                    .organizationEmployeeId(employeePosition.getOrganizationEmployeeId())
                    .primary(employeePosition.getPrimary())
                    .position(position.getId()).build();

            list.add(build);
            System.out.println(i++);
        }
        List<EmployeePosition> employeePositions = employeePositionRepository.saveAll(list);
        if (employeePositions.size() == 0 && employeePositions == null) {
            System.out.println("ERROR");
        }
        System.out.println("SUCCESS");

    }
}
