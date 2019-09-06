package org.csu.sfteam.house.biz.service;

import org.csu.sfteam.house.common.model.items.Building;

import java.util.List;

public interface SalePropertyService {
    //新建楼盘
    //可用
    public int CreateProperty(Building building);

    //更新楼盘信息
    //可用
    public int UpdateProperty(Building building);

    //删除楼盘
    //可用
    public int DeleteByID(int ID);

    //可用
    public int Delete(Building building);

    //通过关键字查找楼盘
    //可用
    public List<Building> SearchPropertyByKeyword(String keyword);

    //通过名字获得楼盘
    //可用
    public Building GetPropertyByItemname(String itemname);

    //展示楼盘
    //可用
    public List<Building> ShowProperty();

    //通过地址显示楼盘
    //可用
    public List<Building> ShowPropertyByAddress(String address);

    //可用
    public List<Building> ShowPropertyByItemFrom(int ID);
}
