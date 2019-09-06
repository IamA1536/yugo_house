package org.csu.sfteam.house_web.controller;


import org.csu.sfteam.house.biz.service.*;
import org.csu.sfteam.house.common.model.items.Building;
import org.csu.sfteam.house.common.model.items.Decoration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.management.BufferPoolMXBean;
import java.util.Collections;
import java.util.List;

/**
 * Created by kemp on 2018/8/15.
 */
@Controller
public class IndexController {

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

    @GetMapping("/")
    public String viewMain(Model model) {

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

    @GetMapping("/help")
    public String viewHelp() {
        return "help";
    }


}

