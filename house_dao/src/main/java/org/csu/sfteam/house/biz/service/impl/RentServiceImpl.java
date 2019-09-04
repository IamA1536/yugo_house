package org.csu.sfteam.house.biz.service.impl;

import org.csu.sfteam.house.common.model.items.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.csu.sfteam.house.biz.service.RentService;
import org.csu.sfteam.house.biz.mapper.BuildingMapper;

import java.util.List;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private BuildingMapper buildingMapper;

    @Override
    public int CreateRent(Building building) {
        return buildingMapper.insert(building);
    }

    @Override
    public int UpdateRent(Building building) {
        return buildingMapper.update(building);
    }

    @Override
    public int DeleteByIDAndType(int ID, int type) {
        return buildingMapper.deleteByID(ID, type);
    }

    @Override
    public int Delete(Building building) {
        return buildingMapper.delete(building);
    }

    @Override
    public List<Building> SearchRentListByKeyword(String keyword) {
        return buildingMapper.getRentListByKeywords(keyword);
    }

    @Override
    public Building GetRentByItemname(String itemname) {
        return buildingMapper.getRentByItemName(itemname);
    }

    @Override
    public List<Building> ShowRent(int type) {
        return buildingMapper.showBuilding(type);
    }

    @Override
    public List<Building> ShowRentByPrice(double priceMax, double priceMin) {
        return buildingMapper.showRentByPrice(priceMax, priceMin);
    }

    @Override
    public List<Building> ShowRentByArea(double areaMax, double areaMin) {
        return buildingMapper.showRentByArea(areaMax, areaMin);
    }

    @Override
    public List<Building> ShowRentByAddress(String address) {
        return buildingMapper.showRentByAddress(address);
    }
}
