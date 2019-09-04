package org.csu.sfteam.house_web.controller;

import org.csu.sfteam.house.biz.service.DecorationService;
import org.csu.sfteam.house.common.model.items.Decoration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/9/4 20:09
 */
@RestController
public class TestDecorationController {
    @Autowired
    DecorationService decorationService;

    @RequestMapping(value = "/CreateDecoration", method = RequestMethod.GET)
    public int CreateDecoration() {
        System.out.println(1111);

        Decoration decoration = new Decoration();
        decoration.setAddress("1233123");
        decoration.setCompany("465456465");
        decoration.setID(4114514);
        decoration.setImg("1312312");
        decoration.setInfo("123123");
        decoration.setItemFrom(2114514);
        decoration.setLink("123123123");
        decoration.setStyle(1);
        decoration.setTele("12312312");
        decorationService.CreateDecoration(decoration);
        return 111;
    }


    @RequestMapping(value = "/UpdateDecoration", method = RequestMethod.GET)
    public int UpdateDecoration() {
        System.out.println(2222);
        Decoration decoration = new Decoration();
        decoration.setAddress("1233123");
        decoration.setCompany("465456465");
        decoration.setID(4114514);
        decoration.setImg("1312312");
        decoration.setInfo("123123");
        decoration.setItemFrom(2114514);
        decoration.setLink("asdsadasqwq");
        decoration.setStyle(1);
        decoration.setTele("12312312");
        decorationService.UpdateDecoration(decoration);
        return 111;
    }

    @RequestMapping(value = "/DeleteDecoration", method = RequestMethod.GET)
    public int DeleteDecoration() {
        System.out.println(3333);
        Decoration decoration = new Decoration();
        decoration.setAddress("1233123");
        decoration.setCompany("465456465");
        decoration.setID(4114514);
        decoration.setImg("1312312");
        decoration.setInfo("123123");
        decoration.setItemFrom(2114514);
        decoration.setLink("asdsadasqwq");
        decoration.setStyle(1);
        decoration.setTele("12312312");
        decorationService.delete(decoration);
        return 111;
    }

    @RequestMapping(value = "/DeleteDecorationByID", method = RequestMethod.GET)
    public int DeleteDecorationByID() {
        System.out.println(4444);
        decorationService.delete(12313);
        return 111;
    }

    @RequestMapping(value = "/GetDecoration", method = RequestMethod.GET)
    public Decoration GetDecoration() {
        System.out.println(5555);
        return decorationService.GetDecoration("44444");
    }

    @RequestMapping(value = "/GetDecorationListByKeywords", method = RequestMethod.GET)
    public List<Decoration> GetDecorationListByKeywords() {
        System.out.println(5555);
        return decorationService.GetDecorationListByKeywords("4");
    }

    @RequestMapping(value = "/ShowDecorations", method = RequestMethod.GET)
    public List<Decoration> ShowDecorations() {
        System.out.println(5555);
        return decorationService.ShowDecorations();
    }

    @RequestMapping(value = "/ShowDecorationsByStyle", method = RequestMethod.GET)
    public List<Decoration> ShowDecorationsByStyle() {
        System.out.println(5555);
        return decorationService.ShowDecorationsByStyle(1);
    }

    @RequestMapping(value = "/ShowDecorationsByAddress", method = RequestMethod.GET)
    public List<Decoration> ShowDecorationsByAddress() {
        System.out.println(5555);
        return decorationService.ShowDecorationsByAddress("4444");
    }

    @RequestMapping(value = "/showDecorationsByItemFrom", method = RequestMethod.GET)
    public List<Decoration> showDecorationsByItemFrom() {
        System.out.println(5555);
        return decorationService.showDecorationsByItemFrom(2114514);
    }

}
