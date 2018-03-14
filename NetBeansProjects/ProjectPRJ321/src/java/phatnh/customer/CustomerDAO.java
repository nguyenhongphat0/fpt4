/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnh.customer;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import phatnh.utils.DatabaseUtils;

/**
 *
 * @author nguyenhongphat0
 */
public class CustomerDAO implements Serializable {
    public String checkLogin(String username, String password) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        try {
            con = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM customer WHERE custID = ? AND password = ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2, password);
            res = pre.executeQuery();
            if (res.next()) {
                return res.getString("custID");
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
        return null;
    }
    
    public CustomerDTO getCustomer(String custID) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        try {
            con = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM customer WHERE custID = ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, custID);
            res = pre.executeQuery();
            if (res.next()) {
                CustomerDTO dto = new CustomerDTO();
                dto.setCustID(res.getString(1));
                dto.setPassword(res.getString(2));
                dto.setCustName(res.getString(3));
                dto.setLastName(res.getString(4));
                dto.setMiddleName(res.getString(5));
                dto.setAddress(res.getString(6));
                dto.setPhone(res.getString(7));
                dto.setCustLevel(res.getInt(8));
                return dto;
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
        return null;
    }
    
    public boolean createCustomer(CustomerDTO dto) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pre = null;
        try {
            con = DatabaseUtils.getConnection();
            String sql = "INSERT INTO customer VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pre = con.prepareStatement(sql);
            pre.setString(1, dto.getCustID());
            pre.setString(2, dto.getPassword());
            pre.setString(3, dto.getCustName());
            pre.setString(4, dto.getLastName());
            pre.setString(5, dto.getMiddleName());
            pre.setString(6, dto.getAddress());
            pre.setString(7, dto.getPhone());
            pre.setInt(8, dto.getCustLevel());
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
}
