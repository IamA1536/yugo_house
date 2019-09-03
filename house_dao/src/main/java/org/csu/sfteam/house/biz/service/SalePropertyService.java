package org.csu.sfteam.house.biz.service;

import org.csu.sfteam.house.common.model.items.Building;
import java.util.List;

public interface SalePropertyService {
    //新建楼盘
    public int CreateProperty(Building building);
    //更新楼盘信息
    public int UpdateProperty(Building building);
    //删除楼盘
    public int DeleteByIDAndType(int ID, int type);
    public int Delete(Building building);
    //通过关键字查找楼盘
    public List<Building> SearchPropertyByKeyword(String keyword);
    //通过名字获得楼盘
    public Building GetPropertyByItemname(String itemname);
    //展示楼盘
    public List<Building> ShowProperty(int type);
    //通过价格显示楼盘
    public List<Building> ShowPropertyByPrice(double priceMax, double priceMin);
    //通过地址显示楼盘
    public List<Building> ShowPropertyByAddress(String address);
}
