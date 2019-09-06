package org.csu.sfteam.house.common.model.items;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/9/4 17:08
 */
public class Rent {
    private long ID;
    private long buildingID;
    private double Area;

    public Rent() {

    }

    public Rent(Building building) {
        this.buildingID = building.getID();
        this.Area = building.getArea();
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(long buildingID) {
        this.buildingID = buildingID;
    }

    public double getArea() {
        return Area;
    }

    public void setArea(int area) {
        Area = area;
    }
}
