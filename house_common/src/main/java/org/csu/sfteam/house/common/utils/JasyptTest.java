package org.csu.sfteam.house.common.utils;

import org.jasypt.util.text.BasicTextEncryptor;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/9/5 14:18
 */
public class JasyptTest {
    public static void main(String[] args) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //加密所需的salt(盐)
        textEncryptor.setPassword("HAisiugsi123HSQsAHhbgsuYY5554ssdSSS4444");
        //要加密的数据（数据库的用户名或密码）
        String username = textEncryptor.encrypt("root");
        String password = textEncryptor.encrypt("CSU2019lhj<>");
        String driver = textEncryptor.encrypt("jdbc:mysql://176.122.180.77:3306/houses?serverTimezone=UTC");
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        System.out.println("driver:"+driver);
    }
}
