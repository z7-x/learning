package learning.jpa.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import learning.jpa.bean.Permission;
import learning.jpa.service.PermissionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname PermissionController
 * @Description TODO
 * @Date 2020/8/12 6:12 下午
 * @Author z7-x
 */
@RestController
@RequestMapping("/permission")
@Api(tags = "权限控制", description = "CRUD操作")
public class PermissionController {


    @Autowired
    private PermissionServices permissionServices;

    @ApiOperation(value = "新增权限信息", notes = "新增权限信息")
    @RequestMapping(method = RequestMethod.POST, value = "/createPermission")
    public Permission createPermission(@RequestBody @ApiParam(value = "输入权限对象", required = true)  Permission permission) {
        return permissionServices.createPermission(permission);
    }
}
