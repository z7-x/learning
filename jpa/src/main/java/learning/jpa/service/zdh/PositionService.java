package learning.jpa.service.zdh;

import learning.jpa.bean.zdh.EmployeePosition;
import learning.jpa.bean.zdh.Job;
import learning.jpa.bean.zdh.Position;
import learning.jpa.dao.zdh.EmployeePositionRepository;
import learning.jpa.dao.zdh.JobRepository;
import learning.jpa.dao.zdh.PositionRepository;
import learning.jpa.utils.DistinctByKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Classname PositionService
 * @Description TODO
 * @Date 2020/11/5 2:40 下午
 * @Author z7-x
 */
@Service
@Transactional
public class PositionService {

    @Autowired
    private EmployeePositionRepository employeePositionRepository;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private PositionRepository positionRepository;

    /**
     * @param
     * @Description: 方法 assemble 的功能描述：TODD 构造org_position表的数据
     * @Return java.lang.String
     * @Author z7-x
     * @Date 2020/11/9 3:22 下午
     */
    public String assemble() {
        List<Position> position = new ArrayList<>();

        List<EmployeePosition> employeePositions = employeePositionRepository.findAll();
        List<EmployeePosition> departments =
                employeePositions.stream()
                        .filter(DistinctByKey.distinctByKey(EmployeePosition::getDepartment))
                        .collect(Collectors.toList());

        List<Job> jobs = jobRepository.findAll();

        departments.stream().forEach(department -> {
            jobs.stream().forEach(job -> {
                Position build =
                        Position.builder()
                                .department(department.getDepartment())
                                .job(job.getId())
                                .name(job.getName())
                                .organization("zdh")
                                .build();
                position.add(build);
            });
        });

        List<Position> positions = positionRepository.saveAll(position);
        if (positions.size() > 0) {
            return "SUCCESS";
        } else {
            return "ERROR";
        }
    }
}
