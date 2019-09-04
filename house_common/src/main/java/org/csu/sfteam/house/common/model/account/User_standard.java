package org.csu.sfteam.house.common.model.account;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/9/4 15:01
 */
public class User_standard {
    private long ID;
    private String username;
    private int type;
    private String email;
    private String info;
    private String icon;
    private int sex;
    private String address;
    private String tele;

    public User_standard() {

    }

    public User_standard(User user) {
        this.address = user.getAddress();
        this.email = user.getEmail();
        this.icon = user.getIcon();
        this.ID = user.getID();
        this.info = user.getInfo();
        this.sex = user.getSex();
        this.tele = user.getTele();
        this.type = user.getType();
        this.username = user.getUsername();
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
