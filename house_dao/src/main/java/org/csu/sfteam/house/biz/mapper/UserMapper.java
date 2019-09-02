package org.csu.sfteam.house.biz.mapper;

import org.csu.sfteam.house.common.model.account.User;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/9/1 12:22
 */
public interface UserMapper {
    public int insert(User user);

    public int delete(User user);

    public int delete(int id);

    public int update(User user);

    public int addToCollection(int userId, int buildingId, String time);

    public User getUsers(String email, String pw);

    public long selectUserCount();
}
