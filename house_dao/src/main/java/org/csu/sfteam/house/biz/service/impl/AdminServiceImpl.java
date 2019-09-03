package org.csu.sfteam.house.biz.service.impl;

import org.csu.sfteam.house.biz.service.AdminService;
import org.csu.sfteam.house.common.model.utils.Admin;
import org.csu.sfteam.house.biz.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int getAdminByUserIDAndPassword(String userID, String password) {
        return adminMapper.getAdminByUserIDAndPassword(userID, password);
    }
}
