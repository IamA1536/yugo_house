package org.csu.sfteam.house.biz.service;

import org.csu.sfteam.house.common.model.utils.Admin;

public interface AdminService {

    //可用
    public Admin getAdminByUserIDAndPassword(String userID, String password);

}
