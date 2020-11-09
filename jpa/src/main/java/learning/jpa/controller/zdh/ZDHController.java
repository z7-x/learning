package learning.jpa.controller.zdh;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import learning.jpa.service.XMLDocumentService;
import learning.jpa.service.zdh.EmployeePositionService;
import learning.jpa.service.zdh.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @Classname ZDHController
 * @Description TODO
 * @Date 2020/11/5 2:36 下午
 * @Author z7-x
 */
@RestController
@RequestMapping("/zdh")
@Api(tags = "构建职代会基础数据", description = "解析EXCEL构建职代会基础数据")
public class ZDHController {

    @Autowired
    private PositionService positionService;
    @Autowired
    private EmployeePositionService employeePositionService;

    @ApiOperation(value = "批量保存至职位表中", notes = "批量保存职位")
    @RequestMapping(method = RequestMethod.GET, value = "/excel1")
    public String savePosition() {
        return positionService.assemble();
    }

    @ApiOperation(value = "解析excel,批量保存至人员职位表中", notes = "解析excel")
    @RequestMapping(method = RequestMethod.GET, value = "/excel2")
    public void analysisExcel() {
        employeePositionService.analysisExcel();
    }
}
