/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnh.cart;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import javax.naming.NamingException;
import phatnh.utils.DatabaseUtils;

/**
 *
 * @author nguyenhongphat0
 */
public class CartDAO implements Serializable {
    public boolean checkout(CartDTO cart) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet keys = null;
        boolean ok = true;
        try {
            con = DatabaseUtils.getConnection();
            String sql = "INSERT INTO tbl_Order(userId) VALUES (?)";
            pre = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pre.setString(1, cart.getUser().getUserId());
            int res = pre.executeUpdate();
            if (res == 0) {
                ok = false;
            }
            keys = pre.getGeneratedKeys();
            if (keys.next()) {                
                String key = keys.getString(1);
                String subsql = "INSERT INTO tbl_OrderDetail(orderId, mobileId, quantity) VALUES (?, ?, ?)";
                pre = con.prepareStatement(subsql);
                pre.setString(1, key);
                for (Map.Entry<String, Integer> item : cart.getItems().entrySet()) {
                    String mobileId = item.getKey();
                    Integer quantity = item.getValue();
                    pre.setString(2, mobileId);
                    pre.setInt(3, quantity);
                    int subres = pre.executeUpdate();
                    if (subres == 0) {
                        ok = false;
                    }
                }
            }
        } finally {
            if (keys != null) {
                keys.close();
            }
            if (pre != null) {
                pre.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return ok;
    }
}
