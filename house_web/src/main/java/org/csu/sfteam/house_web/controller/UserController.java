package org.csu.sfteam.house_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.csu.sfteam.house.common.model.account.User;
import org.csu.sfteam.house.common.model.account.User_important;
import org.csu.sfteam.house.common.model.account.User_standard;
import org.csu.sfteam.house.biz.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.SendResult;
import javax.websocket.Session;
import java.io.File;
import java.io.IOException;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //登录界面跳转 ok
    @GetMapping("/account/login")
    public String viewLogin() {
        return "account/login";
    }

    @PostMapping("/account/login")
    //登录 ok一半
    public String login(HttpServletRequest req, HttpSession session) {
        String username = req.getParameter("username");
        System.out.println("username" + username);
        String password = req.getParameter("password");
        System.out.println("password" + password);
        User user = userService.GetUserByUsernameAndPassword(username, password);
        if (user == null) {

            System.out.println("failed");
            return "account/login";
        } else {
            session.setAttribute("user", user);
            System.out.println("success");

            return "index";
        }

    }

    @GetMapping("account/register")
    public String ViewRegister() {
        return "account/register";
    }

    //基本成功
    @PostMapping("account/register")
    public String register(User user, Model model) {
        if (!"".equals(user.getUsername()) && !"".equals(user.getPw())) {
            User temp = userService.GetUserByUsername(user.getUsername());

            if (temp == null) {

                System.out.println("pw is:" + user.getSex());
                long ID = (user.getType() * 1000000) + Math.round((Math.random() * 9 + 1) * 100000);
                user.setID(ID);
                userService.CreateUser(user);
                User clear = null;
                model.addAttribute("user", clear);
                return "index";
            } else {

                User clear = null;
                model.addAttribute("user", clear);
                return "account/register";
            }
        }
        return "";
    }

    //登出
    @PostMapping("/account/logout")
    public String Logout(Model model, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        user = null;
        httpSession.setAttribute("user", user);
        model.addAttribute("user", user);
        return "index";
    }

    //跳往用户信息界面
    @GetMapping("account/userCenter")
    public String GetUserInfo(HttpSession session) {
        User user = (User) session.getAttribute("user");
        //System.out.println(user.getUsername());
        return "account/userCenter";
    }

    //修改用户个人信息
    @PostMapping("/user/update_information")

    public String UpdateInfo(@Valid User user, Model model, HttpSession session) {
        if (!user.getPw().equals("")) {
            userService.UpdateUser(user);
            model.addAttribute("user", user);
            session.setAttribute("user", user);

            return "";
        } else {
            return "";
        }
    }


    //修改用户头像
    public String UpdateIcon(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败";
        }
        String fileName = file.getOriginalFilename();
        String filePath = filePath = "";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            return "上传成功";
        } catch (IOException e) {
            return "上传失败！";
        }
    }

}
