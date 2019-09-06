package org.csu.sfteam.house.biz.service;

import org.csu.sfteam.house.common.model.items.Building;

import java.util.List;


public interface SaleOldHouseService {
    //创立二手房房源
    //可用
    public int CreateOldHouse(Building building);

    //修改二手房信息
    //可用
    public int UpdateOldHouse(Building building);

    //忽略
    public int DeleteByID(int ID);
    //忽略
    public int Delete(Building building);

    //通过关键字查找租房信息
    //可用
    public List<Building> SearchOldHouseListByKeyword(String keyword);

    //通过名字获得租房信息
    //可用
    public Building GetOldHouseByItemname(String itemname);

    //展示房源信息
    //可用
    public List<Building> ShowOldHouse();

    //通过价格显示房源信息
    //可用
    public List<Building> ShowOldHouseByPrice(double priceMax, double priceMin);

    //可用
    public List<Building> ShowOldHouseByArea(double areaMax, double areaMin);

    //可用
    public List<Building> ShowOldHouseByAddress(String address);

    //可用
    public List<Building> ShowOldHouseByItemFrom(int ID);

    public int selectOldHouseCount();

}
