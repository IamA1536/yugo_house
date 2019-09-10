package org.csu.sfteam.house.common.model.items;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/9/4 17:08
 */
public class Building_standard {
    private long ID;
    private int type;
    private String itemName;
    private double price;
    private String img;
    private long itemFrom;
    private String info;
    private String address;
    private int decStatus;
    private String LocationX;
    private String LocationY;


    public Building_standard() {

    }

    public Building_standard(Building building) {
        this.address = building.getAddress();
        this.decStatus = building.getDecStatus();
        this.ID = building.getID();
        this.img = building.getImg();
        this.info = building.getInfo();
        this.itemFrom = building.getItemFrom();
        this.itemName = building.getItemName();
        this.price = building.getPrice();
        this.type = building.getType();
        this.LocationX = building.getLocationX();
        this.LocationY = building.getLocationY();
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public long getItemFrom() {
        return itemFrom;
    }

    public void setItemFrom(long itemFrom) {
        this.itemFrom = itemFrom;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDecStatus() {
        return decStatus;
    }

    public void setDecStatus(int decStatus) {
        this.decStatus = decStatus;
    }

    public String getLocationX() {
        return LocationX;
    }

    public void setLocationX(String locationX) {
        LocationX = locationX;
    }

    public String getLocationY() {
        return LocationY;
    }

    public void setLocationY(String locationY) {
        LocationY = locationY;
    }
}
