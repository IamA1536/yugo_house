package org.csu.sfteam.house.biz.service;

import org.csu.sfteam.house.common.model.items.Building;

import java.util.List;


public interface SaleOldHouseService {
    //创立二手房房源
    public int CreateOldHouse(Building building);

    //修改二手房信息
    public int UpdateOldHouse(Building building);

    public int DeleteByID(int ID);

    public int Delete(Building building);

    //通过关键字查找租房信息
    public List<Building> SearchOldHouseListByKeyword(String keyword);

    //通过名字获得租房信息
    public Building GetOldHouseByItemname(String itemname);

    //展示房源信息
    public List<Building> ShowOldHouse();

    //通过价格显示房源信息
    public List<Building> ShowOldHouseByPrice(double priceMax, double priceMin);

    //
    public List<Building> ShowOldHouseByArea(double areaMax, double areaMin);

    //
    public List<Building> ShowOldHouseByAddress(String address);

    public List<Building> ShowOldHouseByItemFrom(int ID);

}
