package org.csu.sfteam.house_web.controller;

import org.csu.sfteam.house.biz.service.AdminService;
import org.csu.sfteam.house.common.model.utils.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/9/4 20:30
 */
@RestController
public class TestAdminController {
    @Autowired
    AdminService adminService;


    @RequestMapping(value = "/getAdminByUserIDAndPassword", method = RequestMethod.GET)
    public Admin getAdminByUserIDAndPassword() {
        System.out.println(1111);
        return adminService.getAdminByUserIDAndPassword("a", "123");
    }

}
