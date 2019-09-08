package org.csu.sfteam.house_web.controller;

import org.csu.sfteam.house.biz.service.*;
import org.csu.sfteam.house.common.model.account.User;
import org.csu.sfteam.house.common.model.items.Building;
import org.csu.sfteam.house.common.model.items.Decoration;
import org.csu.sfteam.house.common.model.items.Property;
import org.csu.sfteam.house.common.model.utils.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.List;

@Controller
public class UserCollectionController {
    @Autowired
    private SalePropertyService salePropertyService;
    @Autowired
    private DecorationService decorationService;
    @Autowired
    private SaleOldHouseService saleOldHouseService;
    @Autowired
    private RentService rentService;
    @Autowired
    private UserService userService;

    //跳往用户收藏界面，展示用户收藏
    @GetMapping("/showusercollection")
    public String ShowUserCollection(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        //
        List<Collections> PropertyCollectionList = userService.ShowCollections((int) user.getID(), 1);
        List<Building> PropertyList = null;
        for (int i = 0; i < PropertyCollectionList.size(); i++) {
            PropertyList.add(salePropertyService.GetPropertyByID(PropertyCollectionList.get(i).getBuildingID()));
        }
        model.addAttribute("PropertyList", PropertyList);
        //
        List<Collections> OldHouseCollectionList = userService.ShowCollections((int) user.getID(), 2);
        List<Building> OldHouseList = null;
        for (int i = 0; i < OldHouseCollectionList.size(); i++) {
            OldHouseList.add(saleOldHouseService.GetOldHouseByID(OldHouseCollectionList.get(i).getBuildingID()));
        }
        model.addAttribute("OldHouseList", OldHouseList);
        //
        List<Collections> RentCollectionList = userService.ShowCollections((int) user.getID(), 3);
        List<Building> RentList = null;
        for (int i = 0; i < RentCollectionList.size(); i++) {
            RentList.add(rentService.GetRentByID(RentCollectionList.get(i).getBuildingID()));
        }
        model.addAttribute("RentList", RentList);
        //
        List<Collections> DecorationCollectionList = userService.ShowCollections((int) user.getID(), 4);
        List<Decoration> DecorationList = null;
        for (int i = 0; i < DecorationCollectionList.size(); i++) {
            DecorationList.add(decorationService.GetDecorationByID(DecorationCollectionList.get(i).getDecorationID()));
        }
        model.addAttribute("DecorationList", DecorationList);
        //
        return "account/myCollection";
    }

    //删除用户收藏
    @PostMapping("")
    public String DeleteCollection(@RequestParam("ItemID") int ItemID, @RequestParam("type") int type, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (type == 1) {
            userService.deleteCollection(user.getID(), ItemID, 0);
        } else if (type == 2) {
            Building building = saleOldHouseService.GetOldHouseByID(ItemID);
            userService.deleteCollection(user.getID(), ItemID, 0);
        } else if (type == 3) {
            Building building = rentService.GetRentByID(ItemID);
            userService.deleteCollection(user.getID(), ItemID, 0);
        } else if (type == 4) {
            userService.deleteCollection(user.getID(), 0, ItemID);
        }
        return "";
    }


}
