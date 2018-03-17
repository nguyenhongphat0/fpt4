/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnh.mobile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import phatnh.utils.DatabaseUtils;

/**
 *
 * @author nguyenhongphat0
 */
public class MobileDAO {
    private List<MobileDTO> list;

    public List<MobileDTO> getList() {
        return list;
    }
    
    public void searchById(String mobileId) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        try {
            con = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM tbl_Mobile WHERE mobileId = ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, mobileId);
            res = pre.executeQuery();
            while (res.next()) {
                if (list == null) {
                    list = new ArrayList<>();
                }
                String description = res.getString("description");
                float price = res.getFloat("price");
                String mobileName = res.getString("mobileName");
                int yearOfProduction = res.getInt("yearOfProduction");
                int quantity = res.getInt("quantity");
                boolean notSale = res.getBoolean("notSale");
                MobileDTO dto = new MobileDTO(mobileId, description, price, mobileName, yearOfProduction, quantity, notSale);
                list.add(dto);
            }
        } finally {
            if (res != null) {
                res.close();
            }
            if (pre != null) {
                pre.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    public void searchByName(String mobileName) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        try {
            con = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM tbl_Mobile WHERE mobileName LIKE ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, "%" + mobileName + "%");
            res = pre.executeQuery();
            while (res.next()) {
                if (list == null) {
                    list = new ArrayList<>();
                }
                String mobileId = res.getString("mobileId");
                String description = res.getString("description");
                float price = res.getFloat("price");
                String name = res.getString("mobileName");
                int yearOfProduction = res.getInt("yearOfProduction");
                int quantity = res.getInt("quantity");
                boolean notSale = res.getBoolean("notSale");
                MobileDTO dto = new MobileDTO(mobileId, description, price, name, yearOfProduction, quantity, notSale);
                list.add(dto);
            }
        } finally {
            if (res != null) {
                res.close();
            }
            if (pre != null) {
                pre.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    public boolean deleteById(String mobileId) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pre = null;
        try {
            con = DatabaseUtils.getConnection();
            String sql = "DELETE FROM tbl_Mobile WHERE mobileId = ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, mobileId);
            int res = pre.executeUpdate();
            return res > 0;
        } finally {
            if (pre != null) {
                pre.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    public boolean updateMobile(String mobileId, float price, String description, int quantity, boolean notSale) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pre = null;
        try {
            con = DatabaseUtils.getConnection();
            String sql = "UPDATE tbl_Mobile SET price = ?, description = ?, quantity = ?, notSale = ? WHERE mobileId = ?";
            pre = con.prepareStatement(sql);
            pre.setFloat(1, price);
            pre.setString(2, description);
            pre.setInt(3, quantity);
            pre.setBoolean(4, notSale);
            pre.setString(5, mobileId);
            int res = pre.executeUpdate();
            return res > 0;
        } finally {
            if (pre != null) {
                pre.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    public boolean addMobile(String mobileId, String description, float price, String mobileName, int yearOfProduction, int quantity, boolean notSale) 
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pre = null;
        try {
            con = DatabaseUtils.getConnection();
            String sql = "INSERT INTO tbl_Mobile VALUES (?, ?, ?, ?, ?, ?, ?)";
            pre = con.prepareStatement(sql);
            pre.setString(1, mobileId);
            pre.setString(2, description);
            pre.setFloat(3, price);
            pre.setString(4, mobileName);
            pre.setInt(5, yearOfProduction);
            pre.setInt(6, quantity);
            pre.setBoolean(7, notSale);
            int res = pre.executeUpdate();
            return res > 0;
        } finally {
            if (pre != null)
            {
                pre.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    public void searchPriceInRange(float min, float max) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        try {
            con = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM tbl_Mobile WHERE price >= ? AND price <= ?";
            pre = con.prepareStatement(sql);
            pre.setFloat(1, min);
            pre.setFloat(2, max);
            res = pre.executeQuery();
            while (res.next()) {                
                if (list == null) {
                    list = new ArrayList<>();
                }
                String mobileId = res.getString("mobileId");
                String description = res.getString("description");
                float price = res.getFloat("price");
                String name = res.getString("mobileName");
                int yearOfProduction = res.getInt("yearOfProduction");
                int quantity = res.getInt("quantity");
                boolean notSale = res.getBoolean("notSale");
                MobileDTO dto = new MobileDTO(mobileId, description, price, name, yearOfProduction, quantity, notSale);
                list.add(dto);
            }
        } finally {
            if (res != null) {
                res.close();
            }
            if (pre != null) {
                pre.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}
