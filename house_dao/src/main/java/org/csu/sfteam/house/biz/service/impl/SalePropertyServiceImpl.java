package org.csu.sfteam.house.biz.service.impl;

import org.csu.sfteam.house.common.model.items.Building;
import org.csu.sfteam.house.common.model.items.Building_standard;
import org.csu.sfteam.house.common.model.items.Property;
import org.springframework.beans.BeanUtils;
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
        buildingMapper.insertBuilding(new Building_standard(building));
        buildingMapper.insertProperty(new Property(building));
        return 0;

    }

    @Override
    public int UpdateProperty(Building building) {
        buildingMapper.updateBuilding(new Building_standard(building));
        buildingMapper.updateProperty(new Property(building));
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
    public List<Building> SearchPropertyByKeyword(String keyword) {
        return buildingMapper.getPropertyListByKeywords(keyword);
    }

    @Override
    public Building GetPropertyByItemname(String itemname) {
        return buildingMapper.getPropertyByItemName(itemname);
    }

    @Override
    public Building GetPropertyByID(int ID) {
        return buildingMapper.getOldHouseByID(ID);
    }

    @Override
    public List<Building> ShowProperty() {
        return buildingMapper.showProperty();
    }

    @Override
    public List<Building> ShowPropertyByAddress(String address) {
        return buildingMapper.showPropertyByAddress(address);
    }

    @Override
    public List<Building> ShowPropertyByItemFrom(int ID) {
        return buildingMapper.showPropertyByItemFrom(ID);
    }

    @Override
    public int selectPropertyCount() {
        return buildingMapper.selectPropertyCount();
    }
}
