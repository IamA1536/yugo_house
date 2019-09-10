package org.csu.sfteam.house_web.controller;

import org.csu.sfteam.house.biz.service.*;
import org.csu.sfteam.house.common.model.items.Building;
import org.csu.sfteam.house.common.model.items.Decoration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.csu.sfteam.house.common.model.account.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private SaleOldHouseService saleOldHouseService;
    @Autowired
    private SalePropertyService salePropertyService;
    @Autowired
    private RentService rentService;
    @Autowired
    private DecorationService decorationService;

    @GetMapping("/account/publishedInfoManage")
    public String viewPublishedInfoManage(HttpSession httpSession, Model model) {

        User user = (User) httpSession.getAttribute("user");

        List<Building> buildingProperty = salePropertyService.ShowPropertyByItemFrom((int) user.getID());
        List<Building> buildingOldHouse = saleOldHouseService.ShowOldHouseByItemFrom((int) user.getID());
        List<Building> buildingRent = rentService.ShowRentByItemFrom((int) user.getID());
        List<Decoration> decorationList = decorationService.showDecorationsByItemFrom((int) user.getID());

        model.addAttribute("buildingProperty", buildingProperty);
        model.addAttribute("buildingOldHouse", buildingOldHouse);
        model.addAttribute("buildingRent", buildingRent);
        model.addAttribute("decorationList", decorationList);
        System.out.println(user.getIcon());
        model.addAttribute("user", user);


        return "account/publishedInfoManage";
    }


    //登录界面跳转 ok
    @GetMapping("/account/login")
    public String viewLogin() {
        return "account/login";
    }

    @PostMapping("/account/login")
    //登录 ok一半
    public String login(HttpSession session, String username, String password, Model model) {

//        System.out.println("username" + username);

//        System.out.println("password" + password);
        User user = userService.GetUserByUsernameAndPassword(username, password);
        if (user == null) {
//            System.out.println("failed");
            return "account/login";
        } else {
            session.setAttribute("user", user);
//            System.out.println("success");

            List<Building> buildingProperty = salePropertyService.ShowProperty();
            List<Building> buildingOldHouse = saleOldHouseService.ShowOldHouse();
            List<Building> buildingRent = rentService.ShowRent();
            List<Decoration> decorationList = decorationService.ShowDecorations();
            Collections.reverse(buildingProperty);
            Collections.reverse(buildingOldHouse);
            Collections.reverse(buildingRent);
            Collections.reverse(decorationList);

            model.addAttribute("buildingProperty", buildingProperty);
            model.addAttribute("buildingOldHouse", buildingOldHouse);
            model.addAttribute("buildingRent", buildingRent);
            model.addAttribute("decorationList", decorationList);

            return "index";
        }

    }

    @GetMapping("/account/register")
    public String ViewRegister() {
        return "account/register";
    }

    //基本成功
    @PostMapping("/account/registerForm")
    public String register(@Valid User user, Model model) {
        System.out.println(user + "111111");

        if (!"".equals(user.getUsername()) && !"".equals(user.getPw())) {
            User temp = userService.GetUserByUsername(user.getUsername());

            if (temp == null) {

                long ID = (user.getType() * 1000000) + Math.round((Math.random() * 9 + 1) * 100000);
                user.setID(ID);
                userService.CreateUser(user);

                List<Building> buildingProperty = salePropertyService.ShowProperty();
                List<Building> buildingOldHouse = saleOldHouseService.ShowOldHouse();
                List<Building> buildingRent = rentService.ShowRent();
                List<Decoration> decorationList = decorationService.ShowDecorations();
                Collections.reverse(buildingProperty);
                Collections.reverse(buildingOldHouse);
                Collections.reverse(buildingRent);
                Collections.reverse(decorationList);

                model.addAttribute("buildingProperty", buildingProperty);
                model.addAttribute("buildingOldHouse", buildingOldHouse);
                model.addAttribute("buildingRent", buildingRent);
                model.addAttribute("decorationList", decorationList);

                model.addAttribute("user", null);
                return "index";
            } else {

                model.addAttribute("user", null);

                List<Building> buildingProperty = salePropertyService.ShowProperty();
                List<Building> buildingOldHouse = saleOldHouseService.ShowOldHouse();
                List<Building> buildingRent = rentService.ShowRent();
                List<Decoration> decorationList = decorationService.ShowDecorations();
                Collections.reverse(buildingProperty);
                Collections.reverse(buildingOldHouse);
                Collections.reverse(buildingRent);
                Collections.reverse(decorationList);

                model.addAttribute("buildingProperty", buildingProperty);
                model.addAttribute("buildingOldHouse", buildingOldHouse);
                model.addAttribute("buildingRent", buildingRent);
                model.addAttribute("decorationList", decorationList);

                return "account/register";
            }
        }
        return "";
    }

    //登出
    @GetMapping("/account/logout")
    public String Logout(Model model, HttpSession httpSession) {
        httpSession.setAttribute("user", null);

        List<Building> buildingProperty = salePropertyService.ShowProperty();
        List<Building> buildingOldHouse = saleOldHouseService.ShowOldHouse();
        List<Building> buildingRent = rentService.ShowRent();
        List<Decoration> decorationList = decorationService.ShowDecorations();
        Collections.reverse(buildingProperty);
        Collections.reverse(buildingOldHouse);
        Collections.reverse(buildingRent);
        Collections.reverse(decorationList);

        model.addAttribute("buildingProperty", buildingProperty);
        model.addAttribute("buildingOldHouse", buildingOldHouse);
        model.addAttribute("buildingRent", buildingRent);
        model.addAttribute("decorationList", decorationList);

        return "index";
    }

    //跳往用户信息界面
    @GetMapping("/account/userCenter")
    public String GetUserInfo(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null)
            return "account/login";
        //System.out.println(user.getUsername());
        model.addAttribute("user", user);
        return "account/userCenter";
    }

    //修改用户个人信息
    @PostMapping("/account/update_information")
    public String UpdateInfo(@Valid User user, Model model, HttpSession session) {

        System.out.println(user.getEmail() + "111");
        User nowUser = (User) session.getAttribute("user");

        user.setID(nowUser.getID());
        userService.UpdateUser(user);
        nowUser = userService.GetUserByUsername(nowUser.getUsername());
        session.setAttribute("user", nowUser);
        return "account/userCenter";
    }


    //修改用户头像
    @PostMapping("/account/update_icon")
//    public String UpdateIcon(@RequestParam("file") MultipartFile file,HttpSession session,Model model) {
//        User user = (User)session.getAttribute("user");
//        System.out.println("icon");
//        if (file.isEmpty()) {
//         System.out.println("上传为空");
//        }
//        String fileName = file.getOriginalFilename();
//        String filePath = "static/images/";
//        File dest = new File(filePath + fileName);
//        try {
//            file.transferTo(dest);
//            System.out.println("上传成功");
//            System.out.println("url " + filePath + fileName);
//            String url = filePath + fileName;
//            //user.setIcon(url);
//          //  userService.UpdateUser(user);
//          //  model.addAttribute("user",user);
//
//        } catch (IOException e) {
//            System.out.println("上传失败");
//            System.out.println(user.getIcon());
//            String orgimghurl = userService.GetUserByID(user.getID()).getIcon();
//            System.out.println(" orgimghurl" + orgimghurl);
//        }
//        //删除原有文件
//        //把新图片的uml放入新的对象中
//        return "index";
//    }

    public String a(HttpServletRequest req, @RequestParam("file") MultipartFile file, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        try {
            //2.根据时间戳创建新的文件名，这样即便是第二次上传相同名称的文件，也不会把第一次的文件覆盖了
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            //3.通过req.getServletContext().getRealPath("") 获取当前项目的真实路径，然后拼接前面的文件名
            String destFileName = req.getServletContext().getRealPath("") + "img" + File.separator + fileName;
            //4.第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录（创建到了webapp下uploaded文件夹下）
            File destFile = new File(destFileName);
            System.out.println("destFileName" + destFileName);
            destFile.getParentFile().mkdirs();
            //5.把浏览器上传的文件复制到希望的位置
            file.transferTo(destFile);
            //6.把文件名放在model里，以便后续显示用
            // model.addAttribute("fileName", fileName);

            user.setIcon(destFileName);
            if (user.getIDnumber() != null || !user.getIDnumber().equals("") || user.getRealname() != null || !user.getRealname().equals(""))
                userService.UpdateUser(user);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        }

        User nowUser = (User) session.getAttribute("user");
        session.setAttribute("user", nowUser);
        return "account/userCenter";
    }
}


