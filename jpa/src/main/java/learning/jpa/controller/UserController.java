package learning.jpa.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import learning.jpa.bean.User;
import learning.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2020/8/12 6:11 下午
 * @Author z7-x
 */
@RestController
@RequestMapping("/user")
@Api(tags = "基础用户控制", description = "新增、修改、删除、查询及添加操作角色")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询全部用户信息", notes = "查询全部用户信息")
    @RequestMapping(method = RequestMethod.GET, value = "/findUsers")
    public List<User> findUsers() {
        return userService.findUsers();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createUser")
    public ResponseEntity<User> createUser(@RequestBody @ApiParam(value = "新增用户信息", required = true) User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateUser")
    public User updateUser(@RequestBody @ApiParam(value = "修改用户信息", required = true) User user) {
        return userService.updateUser(user);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/deleteUser")
    public Boolean updateUser(@RequestParam(required = true) @ApiParam(value = "删除用户", required = true) Long userId) {
        return userService.deleteUser(userId);
    }
}
