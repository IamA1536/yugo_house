package org.csu.sfteam.house.common.model.items;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/8/30 16:21
 */
public class Decoration {
    private int ID;
    private String company;
    private String address;
    private String tele;
    private String img;
    private int itemFrom;
    private String info;
    private int style;
    private String link;

    public Decoration() {

    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getItemFrom() {
        return itemFrom;
    }

    public void setItemFrom(int itemFrom) {
        this.itemFrom = itemFrom;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
