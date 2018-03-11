/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnh.order;

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
public class OrderDAO {
    private List<OrderDTO> ordersList;

    public List<OrderDTO> getOrdersList() {
        return ordersList;
    }
    
    public void searchBetween(Timestamp from, Timestamp to) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        try {
            con = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM tbl_order WHERE orderDate >= ? AND orderDate <= ?";
            pre = con.prepareStatement(sql);
            pre.setTimestamp(1, from);
            pre.setTimestamp(2, to);
            res = pre.executeQuery();
            while (res.next()) {                
                if (ordersList == null) {
                    this.ordersList = new ArrayList<>();
                }
                OrderDTO dto = new OrderDTO();
                dto.setOrderID(res.getString(1));
                dto.setOrderDate(res.getTimestamp(2));
                dto.setCustID(res.getString(3));
                dto.setTotal(res.getFloat(4));
                dto.setIsDeliver(res.getBoolean(5));
                dto.setReason(res.getString(6));
                ordersList.add(dto);
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
