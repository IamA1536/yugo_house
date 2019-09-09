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
    public User GetUserByID(long ID) {
        return userMapper.getUserByID(ID);
    }

    @Override
    public User GetUserByUsernameAndPassword(String username, String password) {

        BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
        basicTextEncryptor.setPassword(String.valueOf(username));

        User user = userMapper.getUser(username);

        String pw = basicTextEncryptor.decrypt(user.getPw());
        if (!pw.equals(password))
            user = null;
        return user;
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
        userMapper.update(user);
        userMapper.updateImportant(user);
        return 0;
    }

    @Override
    public int AddToCollection(long UserID, long BuildingID, int decorationID, String time) {
        return userMapper.addToCollection(UserID, BuildingID, decorationID, time);
    }

    //
    @Override
    public List<Collections> ShowCollections(int UserId, int type) {
        List<Collections> list = userMapper.showCollections(UserId);
        List<Collections> returnlist = null;
        if (type == 0) {
            returnlist = list;
        } else if (type <= 4) {
            List<Collections> listChoice = list;
            int ItemID;
            for (int i = list.size() - 1; i >= 0; i--) {
                Collections collections = list.get(i);
                if (collections.getBuildingID() != 0)
                    ItemID = collections.getBuildingID();
                else
                    ItemID = collections.getDecorationID();
                String tem = String.valueOf(ItemID);
                int IDFirst = tem.charAt(0) - '0';
//                System.out.println(IDFirst + " " + type);
//                System.out.println(listChoice);
                if (IDFirst != type)
                    listChoice.remove(collections);
            }
            returnlist = listChoice;
        } else
            System.out.println("type is the problem");
        return returnlist;
    }

    @Override
    public int deleteCollection(long UserId, long BuildingId, int decorationID) {
        return userMapper.deleteCollection(UserId, BuildingId, decorationID);
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
