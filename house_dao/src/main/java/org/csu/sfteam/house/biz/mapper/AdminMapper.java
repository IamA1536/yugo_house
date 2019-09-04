package org.csu.sfteam.house.biz.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.csu.sfteam.house.common.model.utils.Admin;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/9/2 10:06
 */
@Mapper
public interface AdminMapper {
    public Admin getAdmin(String userID, String pw);
}
