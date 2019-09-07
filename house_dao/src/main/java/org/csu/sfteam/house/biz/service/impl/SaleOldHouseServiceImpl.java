package org.csu.sfteam.house.biz.service.impl;

import org.csu.sfteam.house.common.model.items.Building;
import org.csu.sfteam.house.common.model.items.Building_standard;
import org.csu.sfteam.house.common.model.items.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.csu.sfteam.house.biz.mapper.BuildingMapper;
import org.csu.sfteam.house.biz.service.SaleOldHouseService;

import java.util.List;

@Service
public class SaleOldHouseServiceImpl implements SaleOldHouseService {

    @Autowired
    private BuildingMapper buildingMapper;

    @Override
    public int CreateOldHouse(Building building) {
        buildingMapper.insertBuilding(new Building_standard(building));
        buildingMapper.insertRent(new Rent(building));
        return 0;
    }

    @Override
    public int UpdateOldHouse(Building building) {
        buildingMapper.updateBuilding(new Building_standard(building));
        buildingMapper.updateRent(new Rent(building));
        return 0;
    }

    @Override
    public int DeleteByID(int ID) {
        return buildingMapper.deleteByID(ID);
    }

    @Override
    public int Delete(Building building) {
        return buildingMapper.delete(new Building_standard(building));
    }


    @Override
    public List<Building> SearchOldHouseListByKeyword(String keyword) {
        return buildingMapper.getOldHouseListByKeywords(keyword);
    }

    @Override
    public Building GetOldHouseByItemname(String itemname) {
        return buildingMapper.getOldHouseByItemName(itemname);
    }

    @Override
    public Building GetOldHouseByID(int ID) {
        return buildingMapper.getOldHouseByID(ID);
    }

    @Override
    public List<Building> ShowOldHouse() {
        return buildingMapper.showOldHouse();
    }

    @Override
    public List<Building> ShowOldHouseByPrice(double priceMax, double priceMin) {
        return buildingMapper.showOldHouseByPrice(priceMax, priceMin);
    }

    @Override
    public List<Building> ShowOldHouseByArea(double areaMax, double areaMin) {
        return buildingMapper.showOldHouseByArea(areaMax, areaMin);
    }

    @Override
    public List<Building> ShowOldHouseByAddress(String address) {
        return buildingMapper.showOldHouseByAddress(address);
    }

    @Override
    public List<Building> ShowOldHouseByItemFrom(int ID) {
        return buildingMapper.showOldHouseByItemFrom(ID);
    }

    @Override
    public int selectOldHouseCount() {
        return buildingMapper.selectOldHouseCount() - 1;
    }
}