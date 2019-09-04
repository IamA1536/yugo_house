package org.csu.sfteam.house_web.controller;

import org.csu.sfteam.house.biz.service.UserService;
import org.csu.sfteam.house.common.model.account.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/9/3 22:18
 */
@RestController

public class TestController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/getUser/{code}", method = RequestMethod.GET)
    public User getUser(@PathVariable("code") String code) {
        User user = userService.GetUserByUsername(code);
        System.out.println(user.getEmail());
        return user;
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.GET)
    public int getUser() {
        User user = new User();
        user.setID(2114514);
        user.setAddress("123231");
        user.setEmail("1233222@163.com");
        user.setIcon("asdasda");
        user.setIDnumber("43040019198101111");
        user.setInfo("24, des");
        user.setPw("123123444");
        user.setRealname("kan555");
        user.setSex(2);
        user.setTele("1800000000");
        user.setType(1);
        user.setUsername("4654456");
        userService.CreateUser(user);
        System.out.println(1111);
        return 111;
    }

}
