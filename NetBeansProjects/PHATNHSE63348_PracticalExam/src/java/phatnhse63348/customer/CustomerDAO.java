/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnhse63348.customer;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import phatnhse63348.utils.DatabaseUtils;

/**
 *
 * @author nguyenhongphat0
 */
public class CustomerDAO implements Serializable {
    public boolean checkLogin(String id, String password) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        try {
            con = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM tbl_Customer WHERE id = ? AND password = ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, id);
            pre.setString(2, password);
            res = pre.executeQuery();
            if (res.next()) {
                return true;
            } else {
                return false;
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
