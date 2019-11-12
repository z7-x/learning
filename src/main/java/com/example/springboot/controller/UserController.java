package com.example.springboot.controller;

import com.example.springboot.entity.User;
import com.example.springboot.service.impl.UserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * User控制层
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index")
    public String index(){
        return "测试测试测试测www试";
    }

    @RequestMapping(value = "/show",method = RequestMethod.GET)
    @ResponseBody
    public String show(@RequestParam(value = "name")String name){
        User user = userService.findUserByName(name);
        if(null != user)
            return user.getId()+"/"+user.getName()+"/"+user.getPassword();
        else return "null";
    }

    @RequestMapping("/showlist")
    @ResponseBody
    public JSONObject showList(){
        List<User> list = userService.find();
        JSONObject jo = new JSONObject();
        if(list!=null){
            jo.put("code",0);
            jo.put("msg",true);
            jo.put("count",list.size());
            jo.put("data",list);
        }
        return jo;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String  deleteUserById(@RequestParam(value = "id")Integer id){
        return  userService.deleteUserById(id);
    }

    @RequestMapping("/update")
    @ResponseBody
    public String queryUserById(@RequestParam(value = "id")Integer id,@RequestParam(value = "name")String  name){

        return userService.queryUserById(id,name);
    }

    @RequestMapping("/add")
    @ResponseBody
    public String countUserBy(@RequestParam(value = "id")Integer id,@RequestParam(value = "name")String name,@RequestParam(value = "password")String  password){
        return userService.countUserBy(id,name,password);
    }
}