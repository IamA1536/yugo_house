package org.csu.sfteam.house.common.utils;

import org.csu.sfteam.house.common.model.account.User;
import org.jasypt.util.text.BasicTextEncryptor;

import java.util.Iterator;
import java.util.List;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/9/5 15:14
 */
public class JasyptTools {

    public User UserEncryptor(User user) {
        BasicTextEncryptor basicTextEncryptorUserName = new BasicTextEncryptor();
        BasicTextEncryptor basicTextEncryptorID = new BasicTextEncryptor();
        //加密所需的salt为用户名
        basicTextEncryptorUserName.setPassword(String.valueOf(user.getUsername()));
        //加密密码

        user.setPw(basicTextEncryptorUserName.encrypt(user.getPw()));

        if (user.getIDnumber() != null) {
            basicTextEncryptorID.setPassword(String.valueOf(user.getID()));
            //加密所需的salt为用户名
            user.setIDnumber(basicTextEncryptorID.encrypt(user.getIDnumber()));
        }
        return user;
    }

    public User UserDecryptor(User user) {
        BasicTextEncryptor basicTextEncryptorUserName = new BasicTextEncryptor();
        BasicTextEncryptor basicTextEncryptorID = new BasicTextEncryptor();
        //加密所需的salt为用户名
        basicTextEncryptorUserName.setPassword(String.valueOf(user.getUsername()));
        //加密密码

        user.setPw(basicTextEncryptorUserName.decrypt(user.getPw()));

        if (user.getIDnumber() != null) {
            basicTextEncryptorID.setPassword(String.valueOf(user.getID()));
            //加密所需的salt为用户名
            user.setIDnumber(basicTextEncryptorID.decrypt(user.getIDnumber()));
        }
        return user;
    }

    public List<User> UserListDecryptor(List<User> userList) {
        for (int i = 0; i < userList.size(); i++)
            userList.set(i, UserDecryptor(userList.get(i)));
        return userList;
    }

}
