package org.csu.sfteam.house_web.controller;

import org.csu.sfteam.house.biz.service.*;
import org.csu.sfteam.house.common.model.account.User;
import org.csu.sfteam.house.common.model.items.Building;
import org.csu.sfteam.house.common.model.items.Decoration;
import org.csu.sfteam.house.common.model.utils.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;
    @Autowired
    private SalePropertyService salePropertyService;
    @Autowired
    private DecorationService decorationService;
    @Autowired
    private SaleOldHouseService saleOldHouseService;
    @Autowired
    private RentService rentService;

    @GetMapping("/usersList")
    public String viewUsers(){
        return "admin/user/usersList";
    }
    @GetMapping("/buildingsList")
    public String viewBuildings(){
        return "admin/user/buildingsList";
    }
//    @GetMapping("/usersList")
//    public String viewOldHouses(){
//        return "admin/user/List";
//    }
    @GetMapping("/rentsList")
    public String viewRent(){
        return "admin/user/rentsList";
    }
    @GetMapping("/decorateList")
    public String viewDecorate(){
        return "admin/user/decorateList";
    }
    /**
     * 用户功能
     * 展示  删除
     */
    //跳转到用户展示页面，展示所有用户
    @GetMapping("/admin/background")
    public String ViewAll() {
        System.out.println("background");
        return "/admin/background";
    }
}

