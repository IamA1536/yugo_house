package org.csu.sfteam.house.common.model.items;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/8/30 16:09
 */
public class Building {
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


    private int saleStatus;

    private double area;

    public Building() {

    }

    public int getDecStatus() {
        return decStatus;
    }

    public void setDecStatus(int decStatus) {
        this.decStatus = decStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public long getItemFrom() {
        return itemFrom;
    }

    public void setItemFrom(long itemFrom) {
        this.itemFrom = itemFrom;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public int getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(int saleStatus) {
        this.saleStatus = saleStatus;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getLocationY() {
        return LocationY;
    }

    public void setLocationY(String locationY) {
        LocationY = locationY;
    }

    public String getLocationX() {
        return LocationX;
    }

    public void setLocationX(String locationX) {
        LocationX = locationX;
    }
}
