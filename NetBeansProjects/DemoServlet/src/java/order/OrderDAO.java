/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import javax.naming.NamingException;
import utils.DBUtils;

/**
 *
 * @author nguyenhongphat0
 */
public class OrderDAO implements Serializable {
    private boolean saveOrderDetailToDB(String book, int quantity, int orderId) 
            throws SQLException, NamingException {
        Connection conn = DBUtils.makeConnection();
        String url = "INSERT INTO orders_detail(order_id, book, quantity) VALUES (?, ?, ?)";
        PreparedStatement pre = conn.prepareStatement(url);
        pre.setInt(1, orderId);
        pre.setString(2, book);
        pre.setInt(3, quantity);
        return pre.executeUpdate() > 0;
    }
    
    public boolean saveOrderToDB(OrderDTO order) 
            throws SQLException, NamingException {
        Connection conn = DBUtils.makeConnection();
        String url = "INSERT INTO orders(total) VALUES (?)";
        PreparedStatement pre = conn.prepareStatement(url, Statement.RETURN_GENERATED_KEYS);
        pre.setInt(1, order.getTotalQuantity());
        boolean res = pre.executeUpdate() > 0;
        if (res) {
            pre.getGeneratedKeys().next();
            int orderId = pre.getGeneratedKeys().getInt(1);
            for (Map.Entry<String, Integer> entry : order.getItems().entrySet()) {
                String book = entry.getKey();
                int quantity = entry.getValue();
                res = saveOrderDetailToDB(book, quantity, orderId);
                if (!res) {
                    return false;
                }
            }
        }
        return res;
    }
    
}
