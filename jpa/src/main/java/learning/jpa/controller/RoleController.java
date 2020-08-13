package learning.jpa.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import learning.jpa.bean.Role;
import learning.jpa.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname RoleController
 * @Description TODO
 * @Date 2020/8/12 6:12 下午
 * @Author z7-x
 */
@RestController
@RequestMapping("/role")
@Api(tags = "角色控制", description = "新增、修改、删除、查询及添加操作权限")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(method = RequestMethod.POST, value = "/createRole")
    public Role createUser(@RequestBody @ApiParam(value = "新增角色信息", required = true) Role role) {
        return roleService.createRole(role);
    }
}
