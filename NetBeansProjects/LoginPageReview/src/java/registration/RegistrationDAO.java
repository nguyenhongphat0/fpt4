/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registration;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import review.utils.DatabaseUtils;

/**
 *
 * @author nguyenhongphat0
 */
public class RegistrationDAO implements Serializable {
    public boolean checkLogin(int id, int pin)
        throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        try {
            conn = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM Registration WHERE id = ? AND pin = ?";
            pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            pre.setInt(2, pin);
            res = pre.executeQuery();
            if (res.next()) {
                return true;
            }
        } finally {
            if (res != null) {
                res.close();
            }
            if (pre != null) {
                pre.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }
}
