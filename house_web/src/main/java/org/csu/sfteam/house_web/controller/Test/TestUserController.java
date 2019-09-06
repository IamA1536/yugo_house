package org.csu.sfteam.house_web.controller.Test;

import org.csu.sfteam.house.biz.service.UserService;
import org.csu.sfteam.house.common.model.account.User;
import org.csu.sfteam.house.common.model.utils.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/9/3 22:18
 */
@RestController

public class TestUserController {
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
        user.setEmail("1233422@163.com");
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
        user = new User();
        user.setID(2214514);
        user.setAddress("123231");
        user.setEmail("1233222@163.com");
        user.setIcon("asdasda");
        user.setIDnumber("43040019191111810X");
        user.setInfo("24, des");
        user.setPw("2019");
        user.setRealname("yagoo");
        user.setSex(2);
        user.setTele("1855550000");
        user.setType(1);
        user.setUsername("11487");
        userService.CreateUser(user);
        System.out.println(1111);
        return 111;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public int getUserByUsernameAndPassword() {
        userService.GetUserByUsernameAndPassword("haoer", "1919810");
        System.out.println(2222);
        return 222;
    }

    @RequestMapping(value = "/searchUser", method = RequestMethod.GET)
    public List<User> GetUserByKeyword() {
        System.out.println(3333);
        List<User> users = userService.GetUserByKeyword("4");
        User user = users.get(0);
        System.out.println(user.getEmail());
        return users;
    }


    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    public int UpdateUser() {
        System.out.println(4444);
        User user = new User();
        user.setID(2114514);
        user.setAddress("123231");
        user.setEmail("114514@163.com");
        user.setIcon("asdasda");
        user.setIDnumber("43040019198101111");
        user.setInfo("24, des");
        user.setPw("123123444");
        user.setRealname("kan555");
        user.setSex(2);
        user.setTele("1800000000");
        user.setType(1);
        user.setUsername("4654456");
        userService.UpdateUser(user);

        return 444;
    }

    @RequestMapping(value = "/addCollections", method = RequestMethod.GET)
    public int AddCollections() {
        System.out.println(5555);
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        String time = dateFormat.format(date);
        userService.AddToCollection(114514, 1919810, time);
        return 555;
    }

    @RequestMapping(value = "/showCollections", method = RequestMethod.GET)
    public List<Collections> ShowCollections() {
        System.out.println(6666);
        return userService.ShowCollections(111, 0);
    }

    @RequestMapping(value = "/DeleteByID", method = RequestMethod.GET)
    public int DeleteByID() {
        System.out.println(7777);
        userService.DeleteById(123);
        return 777;
    }

    @RequestMapping(value = "/DeleteUser", method = RequestMethod.GET)
    public int DeleteBy() {
        System.out.println(8888);
        User user = new User();
        user.setID(2114514);
        user.setAddress("123231");
        user.setEmail("114514@163.com");
        user.setIcon("asdasda");
        user.setIDnumber("43040019198101111");
        user.setInfo("24, des");
        user.setPw("123123444");
        user.setRealname("kan555");
        user.setSex(2);
        user.setTele("1800000000");
        user.setType(1);
        user.setUsername("4654456");
        userService.Delete(user);
        return 888;
    }

    @RequestMapping(value = "/selectUserCount", method = RequestMethod.GET)
    public long SelectUserCount() {
        System.out.println(9999);
        return userService.selectUserCount();
    }

    @RequestMapping(value = "/showUsers", method = RequestMethod.GET)
    public List<User> showUser() {
        System.out.println(10101010);
        return userService.showUser();
    }

}
