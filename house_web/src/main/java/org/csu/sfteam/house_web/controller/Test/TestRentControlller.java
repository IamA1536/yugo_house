package org.csu.sfteam.house_web.controller.Test;

import org.csu.sfteam.house.biz.service.RentService;
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
 * @date: 2019/9/4 19:52
 */
@RestController
public class TestRentControlller {
    @Autowired
    RentService rentService;

    @RequestMapping(value = "/CreateRentTest", method = RequestMethod.GET)
    public int CreateOldHouse() {
        System.out.println(1111);
        Building building = new Building();
        building.setAddress("123312");
        building.setArea(12312);
        building.setDecStatus(1);
        building.setID(3114514);
        building.setImg("44444444");
        building.setInfo("44656");
        building.setItemFrom(123);
        building.setItemName("12312");
        building.setSaleStatus(1);
        building.setPrice(123);
        building.setType(3);
        rentService.CreateRent(building);
        return 111;
    }

    @RequestMapping(value = "/UpdateRentTest", method = RequestMethod.GET)
    public int UpdateRent() {
        System.out.println(2222);
        Building building = new Building();
        building.setAddress("123312");
        building.setArea(12312);
        building.setDecStatus(1);
        building.setID(3114514);
        building.setImg("44444444");
        building.setInfo("asdasdsad");
        building.setItemFrom(123);
        building.setItemName("12312");
        building.setSaleStatus(1);
        building.setPrice(123);
        building.setType(3);
        rentService.UpdateRent(building);
        return 111;
    }

    @RequestMapping(value = "/SearchRentListByKeywordTest", method = RequestMethod.GET)
    public List<Building> SearchRentListByKeyword() {
        System.out.println(3333);
        return rentService.SearchRentListByKeyword("3");
    }

    @RequestMapping(value = "/GetRentByItemnameTest", method = RequestMethod.GET)
    public Building GetRentByItemname() {
        System.out.println(4444);
        return rentService.GetRentByItemname("33333");
    }

    @RequestMapping(value = "/ShowRentTest", method = RequestMethod.GET)
    public List<Building> ShowOldHouse() {
        System.out.println(5555);
        return rentService.ShowRent();
    }

    @RequestMapping(value = "/ShowRentByPriceTest", method = RequestMethod.GET)
    public List<Building> ShowRentByPrice() {
        System.out.println(6666);
        return rentService.ShowRentByPrice(10000, 300);
    }

    @RequestMapping(value = "/ShowRentByAreaTest", method = RequestMethod.GET)
    public List<Building> ShowRentByArea() {
        System.out.println(7777);
        return rentService.ShowRentByArea(20000, 500);
    }

    @RequestMapping(value = "/ShowRentByAddressTest", method = RequestMethod.GET)
    public List<Building> ShowRentByAddress() {
        System.out.println(8888);
        return rentService.ShowRentByAddress("3333");
    }

    @RequestMapping(value = "/ShowRentByItemFromTest", method = RequestMethod.GET)
    public List<Building> ShowOldHouseByItemFrom() {
        System.out.println(9999);
        return rentService.ShowRentByItemFrom(123);
    }
}
