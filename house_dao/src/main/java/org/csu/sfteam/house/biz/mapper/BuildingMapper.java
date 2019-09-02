package org.csu.sfteam.house.biz.mapper;

import org.csu.sfteam.house.common.model.items.Building;

import java.util.List;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/9/1 12:26
 */
public interface BuildingMapper {
    public int insert(Building building);

    public int delete(Building building);

    public int delete(int id, int type);

    public int update(Building building);

    public List<Building> getPropertyListByKeywords(String keywords);

    public List<Building> getRentListByKeywords(String keywords);

    public Building getPropertyByItemName(String itemName);

    public Building getRentByItemName(String itemName);

    public List<Building> showBuilding(int type);

}
