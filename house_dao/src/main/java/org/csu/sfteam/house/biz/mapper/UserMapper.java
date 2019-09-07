package org.csu.sfteam.house.biz.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.csu.sfteam.house.common.model.account.User;
import org.csu.sfteam.house.common.model.account.User_important;
import org.csu.sfteam.house.common.model.account.User_standard;
import org.csu.sfteam.house.common.model.utils.Collections;
import org.w3c.dom.ls.LSInput;

import java.util.List;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/9/1 12:22
 */
@Mapper
public interface UserMapper {
    public int insert_standard(User_standard user_standard);

    public int insert_important(User_important user_important);

    public int delete(User_important user_important);

    public int deleteByID(int ID);

    public int update(User user);

    public int addToCollection(long userID, long buildingID,int decorationID, String time);

    public int deleteCollection(long userID, long buildingID,int decorationID);

    public List<User> getUsersListByKeywords(String keywords);

    public User getUser(String username);

    public User getUserByID(long ID);

    public User getUserByUsernameAndPassword(String username, String pw);

    public long selectUserCount();

    public List<Collections> showCollections(int userID);

    public List<User> showUsers();
}
