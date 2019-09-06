package org.csu.sfteam.house.common.model.utils;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/9/2 16:25
 */
public class Collections {
    private int ID;
    private int userID;
    private int buildingID;
    private int decorationID;
    private String time;

    public Collections() {

    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getDecorationID() {
        return decorationID;
    }

    public void setDecorationID(int decorationID) {
        this.decorationID = decorationID;
    }

    public int getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(int buildingID) {
        this.buildingID = buildingID;
    }
}
