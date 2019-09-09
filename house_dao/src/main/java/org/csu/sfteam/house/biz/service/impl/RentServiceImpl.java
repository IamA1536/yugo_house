package org.csu.sfteam.house.biz.service.impl;

import org.csu.sfteam.house.common.model.items.Building;
import org.csu.sfteam.house.common.model.items.Building_standard;
import org.csu.sfteam.house.common.model.items.Rent;
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
        buildingMapper.insertBuilding(new Building_standard(building));
        buildingMapper.insertRent(new Rent(building));
        return 0;
    }

    @Override
    public int UpdateRent(Building building) {
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
    public List<Building> SearchRentListByKeyword(String keyword) {
        return buildingMapper.getRentListByKeywords(keyword);
    }

    @Override
    public Building GetRentByItemname(String itemname) {
        return buildingMapper.getRentByItemName(itemname);
    }

    @Override
    public Building GetRentByID(int ID) {
        return buildingMapper.getRentByID(ID);
    }

    @Override
    public List<Building> ShowRent() {
        return buildingMapper.showRent();
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

    @Override
    public List<Building> ShowRentByItemFrom(int ID) {
        return buildingMapper.showRentByItemFrom(ID);
    }

    @Override
    public int selectRentCount() {
        return buildingMapper.selectRentCount();
    }
}
