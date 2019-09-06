package org.csu.sfteam.house.biz.service;

import org.csu.sfteam.house.common.model.account.User;
import org.csu.sfteam.house.common.model.utils.Collections;

import java.util.List;

public interface UserService {

    //用户注册
    //可用
    public int CreateUser(User user);

    //用户登录
    //可用
    public User GetUserByUsernameAndPassword(String username, String password);

    //使用用户名取User
    //可用
    public User GetUserByUsername(String username);

    //关键字查找用户
    //可用
    public List<User> GetUserByKeyword(String keyword);

    //更新用户数据
    //可用
    public int UpdateUser(User user);

    //添加用户收藏
    //可用
    public int AddToCollection(int UserId, int BuildingId, String time);

    //查找用户收藏
    //可用
    public List<Collections> ShowCollections(int UserId, int type);

    //用户注销
    //蜜汁问题
    public int DeleteById(int id);

    //蜜汁问题
    public int Delete(User user);

    //可用
    public long selectUserCount();
    //可用
    public List<User> showUser();

}
