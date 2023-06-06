/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttour.service;

import com.ttour.exception.TOURException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Owner
 */
public class RDBConnection {

    private static final String driver = "com.mysql.jdbc.Driver";//從設定檔設定
    private static final String url = "jdbc:mysql://localhost:3306/ttour?zeroDateTimeBehavior=convertToNull";//url也是一個識別子
    private static final String userid = "root";
    private static final String pwd = "1234";//static唯一而且共用的，final要用static (初始化)
    public static final int DUPLICATE_ENTRY_ERROR_CODE = 1062;//mysql的主鍵值重複的錯誤代號

    public static Connection getConnection() throws TOURException {
        try {
            //1.載入driver
            Class.forName(driver);
            try {
                Connection connection = DriverManager.getConnection(url, userid, pwd);
                return connection;
            } catch (SQLException ex) {
                Logger.getLogger(RDBConnection.class.getName()).log(Level.SEVERE, null, ex);
                throw new TOURException("無法建立連線", ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RDBConnection.class.getName()).log(Level.SEVERE, null, ex);
            throw new TOURException("無法載入" + driver,ex);
        }

    }
}
