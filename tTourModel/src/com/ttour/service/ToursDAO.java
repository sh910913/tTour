/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttour.service;

import com.ttour.entiy.Tour;
import com.ttour.exception.TOURException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Owner
 */
public class ToursDAO implements DAOInterface<Integer, Tour> {

    @Override
    public void insert(Tour c) throws TOURException {

    }

    @Override
    public void update(Tour c) throws TOURException {

    }

    @Override
    public void delete(Tour c) throws TOURException {

    }
    private static final String SELECT_TOURS_BY_ID = "SELECT id,name,type,price,area "
            + "FROM tours "
            + "WHERE tours.id = ?";

    @Override
    public Tour get(Integer id) throws TOURException {

        try (Connection connection = RDBConnection.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(SELECT_TOURS_BY_ID);) {

            pstmt.setInt(1, id);
            Tour t = new Tour();
            try (ResultSet rs = pstmt.executeQuery();) {

                while (rs.next()) {

                    t.setId(rs.getInt("id"));
                    t.setArea(rs.getString("area"));
                    t.setName(rs.getString("name"));
                    t.setType(rs.getString("type"));
                    t.setPrice(rs.getInt("price"));
                }
                return t;
            }
        } catch (SQLException ex) {
            throw new TOURException("查詢產品失敗", ex);
        }

    }
    private static final String SELECT_TOURS_BY_TYPE = "SELECT id,name,type,price,area "
            + "FROM tours "
            + "WHERE type = ?";

    public List<Tour> getToursByType(String type) throws TOURException {
        List<Tour> list = new ArrayList<>();

        try (Connection connection = RDBConnection.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(SELECT_TOURS_BY_TYPE);) {
            pstmt.setString(1, type);
            try (ResultSet rs = pstmt.executeQuery();) {
                while (rs.next()) {
                    Tour t = new Tour();
                    String rsType = rs.getString("type");
                    t.setId(rs.getInt("id"));
                    t.setName(rs.getString("name"));
                    t.setType(rs.getString("type"));
                    t.setPrice(rs.getInt("price"));
                    t.setArea(rs.getString("area"));
                    list.add(t);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new TOURException("類型查詢商品失敗", ex);
        }
        return list;
    }
    private static final String SELECT_TOURS_BY_NAME = "SELECT id,name,type,price,area "
            + "FROM tours "
            + "WHERE name LIKE ?";

    public List<Tour> getToursByName(String name) throws SQLException, TOURException {
        List<Tour> list = new ArrayList<>();
        try (Connection connection = RDBConnection.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(SELECT_TOURS_BY_NAME);) {
            pstmt.setString(1, '%' + name + '%');
            try (ResultSet rs = pstmt.executeQuery();) {
                while (rs.next()) {
                    Tour t = new Tour();
                    t.setId(rs.getInt("id"));
                    t.setName(rs.getString("name"));
                    t.setType(rs.getString("type"));
                    t.setPrice(rs.getInt("price"));
                    t.setArea(rs.getString("area"));
                    list.add(t);
                }
            }
        } catch (TOURException ex) {
            Logger.getLogger(ToursDAO.class.getName()).log(Level.SEVERE, "無法用名稱查詢商品", ex);
            throw new TOURException("無法用名稱查詢商品", ex);
        }
        return list;
    }

}
