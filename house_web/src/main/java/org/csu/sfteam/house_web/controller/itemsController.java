package org.csu.sfteam.house_web.controller;

import org.csu.sfteam.house.biz.service.*;
import org.csu.sfteam.house.common.model.account.User;
import org.csu.sfteam.house.common.model.items.Building;
import org.csu.sfteam.house.common.model.items.Decoration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/9/6 9:26
 */
@Controller
public class itemsController {
    @Autowired
    private UserService userService;

    @Autowired
    private SalePropertyService salePropertyService;

    @Autowired
    private SaleOldHouseService saleOldHouseService;

    @Autowired
    private RentService rentService;

    @Autowired
    private DecorationService decorationService;

    @GetMapping("/showProperty")
    public String showProperty(Model model) {
        List<Building> buildingList = salePropertyService.ShowProperty();
        model.addAttribute("type", 1);
        model.addAttribute("itemList", buildingList);
        model.addAttribute("count", salePropertyService.selectPropertyCount());
        return "commodity/itemList";
    }

    @GetMapping("/showOldHouse")
    public String showOldHouse(Model model) {
        List<Building> buildingList = saleOldHouseService.ShowOldHouse();
        model.addAttribute("type", 2);
        model.addAttribute("itemList", buildingList);
        model.addAttribute("count", saleOldHouseService.selectOldHouseCount());
        return "commodity/itemList";
    }

    @GetMapping("/showRent")
    public String showRent(Model model) {
        List<Building> buildingList = rentService.ShowRent();
        model.addAttribute("type", 3);
        model.addAttribute("itemList", buildingList);
        model.addAttribute("count", rentService.selectRentCount());
        return "commodity/itemList";
    }

    @GetMapping("/showDecoration")
    public String showDecoration(Model model) {
        List<Decoration> decorationList = decorationService.ShowDecorations();
        model.addAttribute("type", 4);
        model.addAttribute("itemList", decorationList);
        model.addAttribute("count", decorationService.selectDecorationCount());
        return "commodity/itemList";
    }


    @GetMapping("/showItemInfo")
    public String showItemsByKeyword(@RequestParam("ItemName") String ItemName, @RequestParam("type") int type, Model model) {
        //分类处理
        if (type == 1) {
            Building building = salePropertyService.GetPropertyByItemname(ItemName);
            User user = userService.GetUserByID(building.getItemFrom());
            String tele = user.getTele();
            String username = user.getUsername();

            model.addAttribute("type", 1);
            model.addAttribute("tele", tele);
            model.addAttribute("username", username);
            model.addAttribute("item", building);
        } else if (type == 2) {
            Building building = saleOldHouseService.GetOldHouseByItemname(ItemName);
            model.addAttribute("type", 2);
            model.addAttribute("item", building);
        } else if (type == 3) {
            Building building = rentService.GetRentByItemname(ItemName);
            model.addAttribute("type", 3);
            model.addAttribute("item", building);
        } else if (type == 4) {
            Decoration decoration = decorationService.GetDecoration(ItemName);
            model.addAttribute("type", 4);
            model.addAttribute("item", decoration);
        }
        return "commodity/item";
    }

    @PostMapping("/addToCollection")
    public String addToCollection(@RequestParam("ItemName") String ItemName, int type, Model model, HttpSession httpSession) {

        User user = (User) httpSession.getAttribute("user");
        if (type == 4) {
            Decoration decoration = decorationService.GetDecoration(ItemName);
            model.addAttribute("type", 4);
            model.addAttribute("item", decoration);
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = formatter.format(currentTime);
            userService.AddToCollection(user.getID(), 0, decoration.getID(), time);
        } else if (type == 3) {
            Building building = rentService.GetRentByItemname(ItemName);
            model.addAttribute("type", 3);
            model.addAttribute("item", building);
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = formatter.format(currentTime);
            userService.AddToCollection(user.getID(), building.getID(), 0, time);
        } else if (type == 2) {
            Building building = saleOldHouseService.GetOldHouseByItemname(ItemName);
            model.addAttribute("type", 2);
            model.addAttribute("item", building);
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = formatter.format(currentTime);
            userService.AddToCollection(user.getID(), building.getID(), 0, time);
        } else if (type == 1) {
            Building building = salePropertyService.GetPropertyByItemname(ItemName);
            model.addAttribute("type", 1);
            model.addAttribute("item", building);
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = formatter.format(currentTime);
            userService.AddToCollection(user.getID(), building.getID(), 0, time);
        }
        return "commodity/item";
    }

}
