/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnh.order;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import phatnh.utils.DatabaseUtils;

/**
 *
 * @author nguyenhongphat0
 */
public class OrderDAO implements Serializable {
    private List<OrderDTO> ordersList;

    public List<OrderDTO> getOrdersList() {
        return ordersList;
    }
    
    public void search(Timestamp fromdate, Timestamp todate, boolean isDeliver) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        try {
            con = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM orders WHERE orderDate >= ? AND orderDate <= ? AND isDeliver = ?";
            pre = con.prepareStatement(sql);
            pre.setTimestamp(1, fromdate);
            pre.setTimestamp(2, todate);
            pre.setBoolean(3, isDeliver);
            res = pre.executeQuery();
            while (res.next()) {                
                if (this.ordersList == null) {
                    this.ordersList = new ArrayList<>();
                }
                OrderDTO dto = new OrderDTO();
                dto.setOrderID(res.getInt(1));
                dto.setOrderDate(res.getTimestamp(2));
                dto.setCustID(res.getString(3));
                dto.setTotal(res.getFloat(4));
                dto.setIsDeliver(res.getBoolean(5));
                dto.setReason(res.getString(6));
                this.ordersList.add(dto);
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
    
    public boolean update(OrderDTO dto) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pre = null;
        int res;
        try {
            con = DatabaseUtils.getConnection();
            String sql = "UPDATE orders SET orderDate = ?, custID = ?, total = ?, isDeliver = ?, reason = ? WHERE orderID = ?";
            pre = con.prepareStatement(sql);
            pre.setTimestamp(1, dto.getOrderDate());
            pre.setString(2, dto.getCustID());
            pre.setFloat(3, dto.getTotal());
            pre.setBoolean(4, dto.isIsDeliver());
            pre.setString(5, dto.getReason());
            pre.setInt(6, dto.getOrderID());
            res = pre.executeUpdate();
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
