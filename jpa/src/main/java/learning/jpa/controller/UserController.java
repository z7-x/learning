package learning.jpa.controller;

import learning.jpa.bean.User;
import learning.jpa.service.UserService;
import learning.jpa.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2020/8/12 6:11 下午
 * @Author z7-x
 */
@RestController
@RequestMapping(name = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/findUsers")
    public List<User> findUsers() {
        return userService.findUsers();
    }

    @RequestMapping(value = "/createUser/{userName}/{passWord}")
    public User createUser(@PathVariable String userName, @PathVariable String passWord) {
        User user = User.builder().userName(userName).passWord(MD5Util.backMD5(passWord)).build();
        return userService.createUser(user);
    }

    @RequestMapping(value = "/updateUser/{userName}/{passWord}")
    public User updateUser(@PathVariable String userName, @PathVariable String passWord) {
        User user = User.builder().userName(userName).passWord(MD5Util.backMD5(passWord)).build();
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/deleteUser/{userId}")
    public Boolean updateUser(@PathVariable Long userId) {
       return userService.deleteUser(userId);
    }

}
