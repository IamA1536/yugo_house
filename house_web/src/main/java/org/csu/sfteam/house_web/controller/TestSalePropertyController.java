package org.csu.sfteam.house_web.controller;

import org.csu.sfteam.house.biz.service.SalePropertyService;
import org.csu.sfteam.house.biz.service.UserService;
import org.csu.sfteam.house.common.model.account.User;
import org.csu.sfteam.house.common.model.items.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/9/4 16:42
 */

@RestController
public class TestSalePropertyController {
    @Autowired
    SalePropertyService salePropertyService;

    @RequestMapping(value = "/CreateProperty", method = RequestMethod.GET)
    public int CreateProperty() {
        Building building = new Building();
        building.setAddress("123312");
        building.setArea(12312);
        building.setDecStatus(1);
        building.setID(114514);
        building.setImg("44444444");
        building.setInfo("44656");
        building.setItemFrom(123);
        building.setItemName("12312");
        building.setSaleStatus(1);
        building.setPrice(123);
        building.setType(1);
        salePropertyService.CreateProperty(building);
        return 111;
    }

    @RequestMapping(value = "/UpdateProperty", method = RequestMethod.GET)
    public int UpdateProperty() {
        System.out.println(2222);
        Building building = new Building();
        building.setAddress("123312");
        building.setArea(12312);
        building.setDecStatus(1);
        building.setID(114514);
        building.setImg("44444444");
        building.setInfo("44656");
        building.setItemFrom(123);
        building.setItemName("ASSSS");
        building.setSaleStatus(1);
        building.setPrice(123);
        building.setType(1);
        salePropertyService.UpdateProperty(building);
        return 111;
    }

    @RequestMapping(value = "/DeleteBuilding", method = RequestMethod.GET)
    public int Delete() {
        System.out.println(3333);
        Building building = new Building();
        building.setAddress("123312");
        building.setArea(12312);
        building.setDecStatus(1);
        building.setID(114514);
        building.setImg("44444444");
        building.setInfo("44656");
        building.setItemFrom(123);
        building.setItemName("ASSSS");
        building.setSaleStatus(1);
        building.setPrice(123);
        building.setType(1);
        salePropertyService.Delete(building);
        return 111;
    }

    @RequestMapping(value = "/DeleteBuildingByID", method = RequestMethod.GET)
    public int DeleteByID() {
        System.out.println(4444);
        salePropertyService.DeleteByID(123);
        return 111;
    }

    @RequestMapping(value = "/SearchPropertyByKeyword", method = RequestMethod.GET)
    public List<Building> SearchPropertyByKeyword() {
        System.out.println(5555);
        return salePropertyService.SearchPropertyByKeyword("3");
    }

    @RequestMapping(value = "/GetPropertyByItemname", method = RequestMethod.GET)
    public Building GetPropertyByItemname() {
        System.out.println(6666);
        return salePropertyService.GetPropertyByItemname("3333");
    }

    @RequestMapping(value = "/ShowProperty", method = RequestMethod.GET)
    public List<Building> ShowProperty() {
        System.out.println(7777);
        return salePropertyService.ShowProperty();
    }
}
