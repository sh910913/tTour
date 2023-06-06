/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttour.service;

import com.ttour.entiy.Member;
import com.ttour.exception.TOURException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Owner
 */
public class MemberDAO implements DAOInterface<String, Member> {

    private static final String INSERT_SQL = " INSERT INTO members"
            + "( `name`, `password`,`email`,`gender`, `phone`,`country`,`birthday`) "
            + "VALUES(?,?,?,?,?,?,?)";//七個值

    @Override
    public void insert(Member c) throws TOURException {
        //1.建立連線
        try (Connection connection = RDBConnection.getConnection();
                //2.建立指令
                PreparedStatement pstmt = connection.prepareStatement(INSERT_SQL);) {
            //3.傳入sql指令的參數
            
            pstmt.setString(1, c.getName());
            pstmt.setString(2, c.getPassword());
            pstmt.setString(3, c.getEmail());
            pstmt.setString(4, String.valueOf(c.getGender()));
            pstmt.setString(5, c.getPhone());
            pstmt.setString(6, c.getCountry());
            if (c.getBirthday() != null) {
                pstmt.setDate(7, new java.sql.Date(c.getBirthday().getTime()));
            } else {
                pstmt.setDate(7, null);
            }
            //4.執行指令
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, "客戶新增失敗", ex);
            throw new TOURException("客戶新增失敗", ex);//拋給前端的訊息
        }
    }
//-------------------------------------客戶修改------------------------------------------
    private static final String UPDATE_SQL = " UPDATE members "
            + "SET name=? , password=? , email=? , gender=?,"
            + "phone=?,country=? ,birthday=? "
            + "WHERE id =?";

    @Override
    public void update(Member c) throws TOURException {
        if (c == null) {
            throw new IllegalArgumentException("沒有此客戶");
        }
        try (Connection connection = RDBConnection.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(UPDATE_SQL);) {
            pstmt.setString(1, c.getName());
            pstmt.setString(2, c.getPassword());
            pstmt.setString(3, c.getEmail());
            pstmt.setString(4, String.valueOf(c.getGender()));
            pstmt.setString(5, c.getPhone());
            pstmt.setString(6, c.getCountry());
            if (c.getBirthday() != null) {
                pstmt.setDate(7, new java.sql.Date(c.getBirthday().getTime()));
            } else {
                pstmt.setDate(7, null);
            }
            pstmt.setInt(8, c.getId());
            //4.執行指令
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, "客戶修改失敗", ex);
            throw new TOURException("客戶修改失敗", ex);//拋給前端的訊息
        }
    }

//-------------------------------------客戶刪除------------------------------------------
    private static final String DELETE_SQL = "DELETE FROM members WHERE email = ?";

    @Override
    public void delete(Member c) throws TOURException {
        if (c == null || c.getEmail() == null) {
            throw new IllegalArgumentException("刪除客戶主鍵值不得為null");
        }
        try (Connection connection = RDBConnection.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(DELETE_SQL);) {
            pstmt.setString(1, c.getEmail());
            pstmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, "客戶刪除失敗", ex);
            throw new TOURException("客戶刪除失敗!", ex);
        }

    }
    //-------------------------------------客戶查詢------------------------------------------   
    private static final String SELECT_SQL = "SELECT * FROM members WHERE email=?";


    public Member get(String email) throws TOURException {
        if (email == null) {
            throw new IllegalArgumentException("查詢客戶不得為null");
        }
        try (Connection connection = RDBConnection.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(SELECT_SQL);) {
            pstmt.setString(1, email);
            try (ResultSet rs = pstmt.executeQuery();) {
                Member c = new Member();
                while (rs.next()) {
                    String emailData = rs.getString("email");
                    c.setEmail(emailData);
                    c.setId(rs.getInt("id"));
                    c.setName(rs.getString("name"));
                    c.setPassword(rs.getString("password"));
                    c.setGender(rs.getString("gender").charAt(0));
                    c.setPhone(rs.getString("phone"));
                    c.setCountry(rs.getString("country"));
                    System.out.println("c =" + c);
                }
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, "無法查詢客戶", ex);
            throw new TOURException("無法查詢客戶!", ex);
        }
    }
//-------------------------------------查詢客戶部分姓名------------------------------
    private static final String SELECT_MEMBERS_BY_NAME = "SELECT id,name,password,email,gender,"
            + "phone,birthday "
            + "FROM members "
            + "WHERE name LIKE ? ";//setString 問號就不用加單引號

    public List<Member> getMemberListByName(String name) throws  TOURException {//不只一個客戶
//        try {//符合就  回傳集合
        List<Member> list = new ArrayList<>();//空集合 size為0
        try (Connection connection = RDBConnection.getConnection(); 
                PreparedStatement pstmt = connection.prepareStatement(SELECT_MEMBERS_BY_NAME);) {
            pstmt.setString(1, name + '%');//第一個參數代表第一個問號,第二個參數為查名子開頭的
            try (ResultSet rs = pstmt.executeQuery()) {//4.執行指令
                //5.處理ResultSet
                while (rs.next()) {
                    Member c = new Member();
                    c.setId(rs.getInt("id"));
                    c.setName(rs.getString("name"));
                    c.setPassword(rs.getString("password"));
                    c.setGender(rs.getString("gender").charAt(0));
                    c.setEmail(rs.getString("email"));
                    c.setPhone(rs.getString("phone"));
                    c.setBirthday(rs.getDate("birthday"));
                    list.add(c);//加入集合
                }
                return list;//都讀完了再回傳
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, "無法用部分姓名查詢客戶", ex);
            throw new TOURException("無法用部分姓名查詢客戶", ex);
        }

//        } catch (ClassNotFoundException ex) {//載入不需要
//            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, "無法載入:" + driver, ex);
//            throw new VGBException("無法載入:" + driver, ex);
//        }
    }    
    
}