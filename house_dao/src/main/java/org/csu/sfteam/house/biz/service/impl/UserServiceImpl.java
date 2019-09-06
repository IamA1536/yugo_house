package org.csu.sfteam.house.biz.service.impl;


import org.csu.sfteam.house.biz.service.UserService;
import org.csu.sfteam.house.biz.mapper.UserMapper;
import org.csu.sfteam.house.common.model.account.User;
import org.csu.sfteam.house.common.model.account.User_important;
import org.csu.sfteam.house.common.model.account.User_standard;
import org.csu.sfteam.house.common.model.utils.Collections;
import org.csu.sfteam.house.common.utils.JasyptTools;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int CreateUser(User user) {

        user = new JasyptTools().UserEncryptor(user);

        userMapper.insert_important(new User_important(user));
        userMapper.insert_standard(new User_standard(user));
        return 0;
    }

    @Override
    public User GetUserByUsernameAndPassword(String username, String password) {
        BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
        basicTextEncryptor.setPassword(String.valueOf(username));
        password = basicTextEncryptor.encrypt(password);
        return userMapper.getUserByUsernameAndPassword(username, password);
    }

    @Override
    public User GetUserByUsername(String username) {
        return new JasyptTools().UserDecryptor(userMapper.getUser(username));
    }

    @Override
    public List<User> GetUserByKeyword(String keyword) {
        return new JasyptTools().UserListDecryptor(userMapper.getUsersListByKeywords(keyword));
    }

    @Override
    public int UpdateUser(User user) {
        user = new JasyptTools().UserEncryptor(user);
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
            for (Collections collections : list) {
                int ItemID = collections.getItemID();
                String tem = String.valueOf(ItemID);
                int IDFirst = tem.charAt(0) - '0';
                if (IDFirst == type) {
                    assert listChoice != null;
                    listChoice.add(collections);
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
        return userMapper.delete(new User_important(user));
    }

    @Override
    public long selectUserCount() {
        return userMapper.selectUserCount();
    }

    @Override
    public List<User> showUser() {
        return new JasyptTools().UserListDecryptor(userMapper.showUsers());
    }
}
