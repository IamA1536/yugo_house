package org.csu.sfteam.house.biz.service.impl;


import org.csu.sfteam.house.biz.service.UserService;
import org.csu.sfteam.house.biz.mapper.UserMapper;
import org.csu.sfteam.house.common.model.account.User;
import org.csu.sfteam.house.common.model.account.User_important;
import org.csu.sfteam.house.common.model.account.User_standard;
import org.csu.sfteam.house.common.model.utils.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int CreateUser(User user) {
        User_standard user_standard = new User_standard(user);
        User_important user_important = new User_important(user);
        userMapper.insert_important(user_important);
        userMapper.insert_standard(user_standard);
        return 0;
    }

    @Override
    public User GetUserByUsernameAndPassword(String username, String password) {
        return userMapper.getUserByUsernameAndPassword(username, password);
    }

    @Override
    public User GetUserByUsername(String username) {
        return userMapper.getUser(username);
    }

    @Override
    public List<User> GetUserByKeyword(String keyword) {
        return userMapper.getUsersListByKeywords(keyword);
    }

    @Override
    public int UpdateUser(User user) {
        return userMapper.update(user);
    }

    @Override
    public int AddToCollection(int UserId, int BuildingId, String time) {
        return userMapper.addToCollection(UserId, BuildingId, time);
    }

    //
    @Override
    public List<Collections> ShowCollections(int UserId, int type) {
        List<Collections> list = userMapper.showCollections(UserId);
        List<Collections> returnlist = null;
        if (type == 0) {
            returnlist = list;
        } else if (type <= 4) {
            List<Collections> listChoice = null;
            for (int i = 0; i < list.size(); i++) {
                int ItemID = list.get(i).getItemID();
                String tem = String.valueOf(ItemID);
                int IDFirst = tem.charAt(0) - '0';
                if (IDFirst == type) {
                    listChoice.add(list.get(i));
                }
                returnlist = listChoice;
            }
        } else {
            System.out.println("type is the problem");
        }
        return returnlist;
    }

    @Override
    public int DeleteById(int id) {
        return userMapper.deleteByID(id);
    }

    @Override
    public int Delete(User user) {

        return userMapper.delete(user);
    }

    @Override
    public long selectUserCount() {
        return userMapper.selectUserCount();
    }

    @Override
    public List<User> showUser() {
        return userMapper.showUsers();
    }
}
