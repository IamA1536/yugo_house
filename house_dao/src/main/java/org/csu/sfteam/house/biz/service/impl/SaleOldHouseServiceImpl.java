package org.csu.sfteam.house.biz.service.impl;

import org.csu.sfteam.house.common.model.items.Building;
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
        return buildingMapper.insert(building);
    }

    @Override
    public int UpdateOldHouse(Building building) {
        return buildingMapper.update(building);
    }

    @Override
    public int Delete(Building building) {
        return buildingMapper.delete(building);
    }

    @Override
    public int DeleteByIDAndType(int ID, int type) {
        return buildingMapper.delete(ID, type);
    }

    @Override
    public List<Building> SearchOldHouseListByKeyword(String keyword) {
        return null;
    }

    @Override
    public Building GetOldHouseByItemname(String itemname) {
        return null;
    }

    @Override
    public List<Building> ShowOldHouse(int type) {
        return buildingMapper.showBuilding(type);
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
}