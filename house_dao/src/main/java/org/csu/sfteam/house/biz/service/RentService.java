package org.csu.sfteam.house.biz.service;

import org.csu.sfteam.house.common.model.items.Building;

import java.util.List;

//都可用

public interface RentService {
    //发布租房房源
    public int CreateRent(Building building);

    //修改房源信息
    public int UpdateRent(Building building);

    //删除房源
    public int DeleteByID(int ID);

    public int Delete(Building building);

    //通过关键字查找租房信息
    public List<Building> SearchRentListByKeyword(String keyword);

    //通过名字获得租房信息
    public Building GetRentByItemname(String itemname);

    public Building GetRentByID(int ID);


    //展示房源信息
    public List<Building> ShowRent();

    //通过价格显示房源信息
    public List<Building> ShowRentByPrice(double priceMax, double priceMin);

    //
    public List<Building> ShowRentByArea(double areaMax, double areaMin);

    //
    public List<Building> ShowRentByAddress(String address);

    public List<Building> ShowRentByItemFrom(int ID);



    public int selectRentCount();

}

