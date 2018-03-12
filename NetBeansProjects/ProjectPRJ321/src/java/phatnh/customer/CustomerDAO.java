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
    public boolean checkLogin(String username, String password) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        boolean check = false;
        try {
            con = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM customer WHERE custID = ? AND password = ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2, password);
            res = pre.executeQuery();
            if (res.next()) {
                check = true;
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
        return check;
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
}
