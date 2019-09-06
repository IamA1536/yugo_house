package org.csu.sfteam.house.biz.test;

import org.csu.sfteam.house.biz.mapper.UserMapper;
import org.csu.sfteam.house.biz.service.UserService;
import org.csu.sfteam.house.biz.service.impl.UserServiceImpl;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/9/3 22:05
 */
public class test {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        System.out.println(userService.selectUserCount());
    }
}
