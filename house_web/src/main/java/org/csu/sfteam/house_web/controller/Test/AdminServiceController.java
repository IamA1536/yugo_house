package org.csu.sfteam.house_web.controller.Test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.csu.sfteam.house.biz.service.*;
import org.csu.sfteam.house.common.model.account.User;
import org.csu.sfteam.house.common.model.items.Building;
import org.csu.sfteam.house.common.model.items.Decoration;
import org.csu.sfteam.house.common.model.utils.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@RestController
public class AdminServiceController {

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

    @RequestMapping("/get_users")
    public void ViewAllUser(HttpServletResponse response) throws IOException {

        List<User> userList = userService.showUser();
        response.setContentType("application/json; charset=utf-8");
        JSONArray responseJSONObject = JSONArray.fromObject(userList);

        PrintWriter out = response.getWriter();
        out.print(responseJSONObject.toString());
        out.flush();
        out.close();
    }
    @RequestMapping("get_buildings")
    public void ViewAllBuilding(HttpServletResponse response) throws IOException {

        List<Building> buildingList = salePropertyService.ShowProperty();
        response.setContentType("application/json; charset=utf-8");
        JSONArray responseJSONObject = JSONArray.fromObject(buildingList);

        PrintWriter out = response.getWriter();
        out.print(responseJSONObject.toString());
        out.flush();
        out.close();
    }
    //@RequestMapping("")
    public void ViewAllOldHouse(HttpServletResponse response) throws IOException {

        List<Building> buildingList = saleOldHouseService.ShowOldHouse();
        response.setContentType("application/json; charset=utf-8");
        JSONArray responseJSONObject = JSONArray.fromObject(buildingList);

        PrintWriter out = response.getWriter();
        out.print(responseJSONObject.toString());
        out.flush();
        out.close();
    }
    @RequestMapping("get_rents")
    public void ViewAllRent(HttpServletResponse response) throws IOException {

        List<Building> buildingList = rentService.ShowRent();
        response.setContentType("application/json; charset=utf-8");
        JSONArray responseJSONObject = JSONArray.fromObject(buildingList);

        PrintWriter out = response.getWriter();
        out.print(responseJSONObject.toString());
        out.flush();
        out.close();
    }
    @RequestMapping("get_decorates")
    public void ViewAllDecoration(HttpServletResponse response) throws IOException {

        List<Decoration> decorationList = decorationService.ShowDecorations();
        response.setContentType("application/json; charset=utf-8");
        JSONArray responseJSONObject = JSONArray.fromObject(decorationList);

        PrintWriter out = response.getWriter();
        out.print(responseJSONObject.toString());
        out.flush();
        out.close();
    }
    @RequestMapping("destroy_building")
    public @ResponseBody void deleteBuilding(int ID) throws IOException{
        //String ID = request.getParameter("ID");
        System.out.println("destroy_building");
        System.out.println(ID);
    }
    @RequestMapping("destroy_rent")
    public @ResponseBody void deleteRent(int ID) throws IOException{
        //String ID = request.getParameter("ID");
        System.out.println("destroy_rent");
        System.out.println(ID);
    }
    @RequestMapping("destroy_decorate")
    public @ResponseBody void deleteDecorate(int ID) throws IOException{
        //String ID = request.getParameter("ID");
        System.out.println("destroy_decorate");
        System.out.println(ID);
    }
    @RequestMapping("destroy_user")
    public @ResponseBody void deleteUser(int ID) throws IOException{
        //String ID = request.getParameter("ID");
        System.out.println("user");
        System.out.println(ID);
    }





}

