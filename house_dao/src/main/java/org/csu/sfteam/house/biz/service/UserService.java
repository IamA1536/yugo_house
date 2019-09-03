package org.csu.sfteam.house.biz.service;

import org.csu.sfteam.house.common.model.account.User;
import org.csu.sfteam.house.common.model.utils.Collections;

import java.util.List;

public interface UserService {

    //用户注册
    public int CreateUser(User user);

    //用户登录
    public User GetUserByUsernameAndPassword(String username, String password);

    //使用用户名取User
    public User GetUserByUsername(String username);

    //关键字查找用户
    public List<User> GetUserByKeyword(String keyword);

    //更新用户数据
    public int UpdateUser(User user);

    //添加用户收藏
    public int AddToCollection(int UserId, int BuildingId, String time);

    //查找用户收藏
    public List<Collections> ShowCollections(int UserId, int type);

    //用户注销
    public int DeleteById(int id);

    public int Delete(User user);
    //查找用户上传的房源

    //查找用户上传的装修

    
}
