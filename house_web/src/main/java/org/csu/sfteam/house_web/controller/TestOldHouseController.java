package org.csu.sfteam.house_web.controller;

import org.csu.sfteam.house.biz.service.SaleOldHouseService;
import org.csu.sfteam.house.common.model.items.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/9/4 19:16
 */
@RestController
public class TestOldHouseController {
    @Autowired
    SaleOldHouseService saleOldHouseService;

    @RequestMapping(value = "/CreateOldHouse", method = RequestMethod.GET)
    public int CreateOldHouse() {
        System.out.println(1111);
        Building building = new Building();
        building.setAddress("123312");
        building.setArea(12312);
        building.setDecStatus(1);
        building.setID(2114514);
        building.setImg("44444444");
        building.setInfo("44656");
        building.setItemFrom(123);
        building.setItemName("12312");
        building.setSaleStatus(1);
        building.setPrice(123);
        building.setType(2);
        saleOldHouseService.CreateOldHouse(building);
        return 111;
    }

    @RequestMapping(value = "/UpdateOldHouse", method = RequestMethod.GET)
    public int UpdateOldHouse() {
        System.out.println(2222);
        Building building = new Building();
        building.setAddress("123312");
        building.setArea(12312);
        building.setDecStatus(1);
        building.setID(2114514);
        building.setImg("44444444");
        building.setInfo("asdasdsad");
        building.setItemFrom(123);
        building.setItemName("12312");
        building.setSaleStatus(1);
        building.setPrice(123);
        building.setType(2);
        saleOldHouseService.UpdateOldHouse(building);
        return 111;
    }

    @RequestMapping(value = "/SearchOldHouseListByKeyword", method = RequestMethod.GET)
    public List<Building> SearchOldHouseListByKeyword() {
        System.out.println(3333);
        return saleOldHouseService.SearchOldHouseListByKeyword("3");
    }

    @RequestMapping(value = "/GetOldHouseByItemname", method = RequestMethod.GET)
    public Building GetOldHouseByItemname() {
        System.out.println(4444);
        return saleOldHouseService.GetOldHouseByItemname("12321");
    }

    @RequestMapping(value = "/ShowOldHouse", method = RequestMethod.GET)
    public List<Building> ShowOldHouse() {
        System.out.println(5555);
        return saleOldHouseService.ShowOldHouse();
    }

    @RequestMapping(value = "/ShowOldHouseByPrice", method = RequestMethod.GET)
    public List<Building> ShowOldHouseByPrice() {
        System.out.println(6666);
        return saleOldHouseService.ShowOldHouseByPrice(2000, 1000);
    }

    @RequestMapping(value = "/ShowOldHouseByArea", method = RequestMethod.GET)
    public List<Building> ShowOldHouseByArea() {
        System.out.println(7777);
        return saleOldHouseService.ShowOldHouseByArea(20000, 10000);
    }

    @RequestMapping(value = "/ShowOldHouseByAddress", method = RequestMethod.GET)
    public List<Building> ShowOldHouseByAddress() {
        System.out.println(8888);
        return saleOldHouseService.ShowOldHouseByAddress("1111");
    }

    @RequestMapping(value = "/ShowOldHouseByItemFrom", method = RequestMethod.GET)
    public List<Building> ShowOldHouseByItemFrom() {
        System.out.println(9999);
        return saleOldHouseService.ShowOldHouseByItemFrom(123);
    }
}
