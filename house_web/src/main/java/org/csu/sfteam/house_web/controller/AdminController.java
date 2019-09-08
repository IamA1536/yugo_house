package org.csu.sfteam.house_web.controller;

import org.csu.sfteam.house.biz.service.AdminService;
import org.csu.sfteam.house.biz.service.UserService;
import org.csu.sfteam.house.common.model.account.User;
import org.csu.sfteam.house.common.model.utils.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;

    //进行管理员的登录
    @PostMapping()
    public String LoginAdmin(HttpServletRequest req, HttpSession session) {
        String userID = req.getParameter("userID");
        System.out.println("username" + userID);
        String password = req.getParameter("password");
        System.out.println("password" + password);

        Admin admin = adminService.getAdminByUserIDAndPassword(userID, password);
        return "admin";

    }

    /**
     * 用户功能
     * 展示 添加 修改 删除
     */
    //跳转到用户展示页面，展示所有用户
    @RequestMapping()
    public String ViewAllUser() {
        List<User> userList = userService.showUser();
        return "userList";
    }

    //进行用户的删除
    public String DeleteUser() {
        return "";
    }

}
