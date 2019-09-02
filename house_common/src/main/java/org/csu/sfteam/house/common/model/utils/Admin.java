package org.csu.sfteam.house.common.model.utils;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/8/30 16:24
 */
public class Admin {
    private long ID;
    private String userID;
    private String pw;

    public Admin() {

    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }
}
