package org.csu.sfteam.house.biz.service.impl;

import org.csu.sfteam.house.common.model.items.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.csu.sfteam.house.biz.mapper.BuildingMapper;
import org.csu.sfteam.house.biz.service.SalePropertyService;

import java.util.List;

@Service
public class SalePropertyServiceImpl implements SalePropertyService {

    @Autowired
    private BuildingMapper buildingMapper;

    @Override
    public int CreateProperty(Building building) {
        return buildingMapper.insert(building);
    }

    @Override
    public int UpdateProperty(Building building) {
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
    public List<Building> SearchPropertyByKeyword(String keyword) {
        return buildingMapper.getPropertyListByKeywords(keyword);
    }

    @Override
    public Building GetPropertyByItemname(String itemname) {
        return buildingMapper.getPropertyByItemName(itemname);
    }

    @Override
    public List<Building> ShowProperty(int type) {
        return buildingMapper.showBuilding(type);
    }

    @Override
    public List<Building> ShowPropertyByPrice(double priceMax, double priceMin) {
        return buildingMapper.showOldHouseByPrice(priceMax, priceMin);
    }

    @Override
    public List<Building> ShowPropertyByAddress(String address) {
        return buildingMapper.showPropertyByAddress(address);
    }
}
