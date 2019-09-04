package org.csu.sfteam.house.common.model.account;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/9/4 14:58
 */
public class User_important {
    private long ID;
    private String realname;
    private String IDnumber;
    private String pw;
    private String email;

    public User_important(){

    }


    public User_important(User user){
        this.email = user.getEmail();
        this.ID = user.getID();
        this.IDnumber = user.getIDnumber();
        this.pw = user.getPw();
        this.realname = user.getRealname();
    }

    public long getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getIDnumber() {
        return IDnumber;
    }

    public void setIDnumber(String IDnumber) {
        this.IDnumber = IDnumber;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
