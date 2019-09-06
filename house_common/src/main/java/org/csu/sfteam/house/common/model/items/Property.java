package org.csu.sfteam.house.common.model.items;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/9/4 17:09
 */
public class Property {
    private long ID;
    private long buildingID;
    private int saleStatus;

    public Property() {

    }

    public Property(Building building) {
        this.buildingID = building.getID();
        this.saleStatus = building.getSaleStatus();
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

    public void setBuildingID(int buildingID) {
        this.buildingID = buildingID;
    }

    public int getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(int saleStatus) {
        this.saleStatus = saleStatus;
    }
}
