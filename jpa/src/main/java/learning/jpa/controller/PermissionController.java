package learning.jpa.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import learning.jpa.bean.Permission;
import learning.jpa.bean.User;
import learning.jpa.service.PermissionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @Classname PermissionController
 * @Description TODO
 * @Date 2020/8/12 6:12 下午
 * @Author z7-x
 */
@RestController
@RequestMapping("/permission")
@Api(tags = "权限控制", description = "台帐信息基础维护")
public class PermissionController {

    @Autowired
    private PermissionServices permissionServices;

    @ApiOperation(value = "新增权限信息", notes = "新增权限信息")
    @RequestMapping(method = RequestMethod.POST, value = "/createPermission")
    public ResponseEntity<List<Permission>> createPermission(@ApiParam(value = "输入权限对象", required = true)
                                                             @RequestBody List<Permission> permissions) {
        Function<List<Permission>, List<Permission>> function = (param) -> permissionServices.add(param);
        List<Permission> apply = function.apply(permissions);
        return ResponseEntity.ok(apply);
    }

    @ApiOperation(value = "移除权限信息", notes = "移除权限信息")
    @RequestMapping(method = RequestMethod.POST, value = "/removePermission")
    public ResponseEntity<Boolean> removePermission(@ApiParam(value = "权限id", required = true)
                                                    @RequestParam Long... id) {
        Predicate<Long[]> predicate = (param) -> permissionServices.remove(param);
        return ResponseEntity.ok(predicate.test(id));
    }

    @ApiOperation(value = "修改权限信息", notes = "修改权限信息")
    @RequestMapping(method = RequestMethod.POST, value = "/updatePermission")
    public ResponseEntity<Permission> updatePermission(@ApiParam(value = "输入权限对象", required = true)
                                                       @RequestBody Permission permission) {
        Function<Permission, Permission> function = (param) -> permissionServices.modify(param);
        Permission apply = function.apply(permission);
        return ResponseEntity.ok(apply);
    }

    @ApiOperation(value = "根据ID查询权限信息", notes = "根据ID查询权限信息")
    @RequestMapping(method = RequestMethod.POST, value = "/findPermissionById")
    public ResponseEntity<Permission> findPermissionById(@ApiParam(value = "权限id", required = true)
                                                         @RequestParam Long id) {
        Function<Long, Permission> function = (param) -> permissionServices.findById(param);
        Permission apply = function.apply(id);
        return ResponseEntity.ok(apply);
    }

    @ApiOperation(value = "分页查询:根据过滤条件匹配", notes = "分页查询:根据过滤条件匹配")
    @RequestMapping(method = RequestMethod.POST, value = "/filterQuery")
    public Page filterQueryPermissions(
            @ApiParam(value = "权限对象", required = false) @RequestBody Permission filter,
            @ApiParam(value = "起始行", required = true) @RequestParam Integer page,
            @ApiParam(value = "每页行数", required = true) @RequestParam Integer size) {
        return permissionServices.findAll(filter, page, size);
    }
}
