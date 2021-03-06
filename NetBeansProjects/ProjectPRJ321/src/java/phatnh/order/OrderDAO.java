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
import phatnh.orderdetail.OrderDetailDAO;
import phatnh.orderdetail.OrderDetailDTO;
import phatnh.session.CartObject;
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
    
    public void searchBetween(Timestamp from, Timestamp to, boolean isDeliver) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        try {
            con = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM tbl_order WHERE orderDate >= ? AND orderDate <= ? AND isDeliver = ?";
            pre = con.prepareStatement(sql);
            pre.setTimestamp(1, from);
            pre.setTimestamp(2, to);
            pre.setBoolean(3, isDeliver);
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
    
    public boolean changeStatus(String orderID, boolean isDeliver, String reason) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pre = null;
        try {
            con = DatabaseUtils.getConnection();
            String sql = "UPDATE tbl_order SET isDeliver = ?, Reason = ? WHERE orderID = ?";
            pre = con.prepareStatement(sql);
            pre.setBoolean(1, isDeliver);
            pre.setString(2, reason);
            pre.setString(3, orderID);
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
    
    public boolean submitCart(CartObject cart) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        String key = null;
        boolean res = true;
        try {
            con = DatabaseUtils.getConnection();
            con.setAutoCommit(false);
            String sql = "SELECT COUNT(*) FROM tbl_order";
            pre = con.prepareStatement(sql);
            rs = pre.executeQuery();
            if (rs.next()) {
                key = rs.getString(1);
            }
            sql = "INSERT INTO tbl_order VALUES(?, getdate(), ?, ?, 0, '')";
            pre = con.prepareStatement(sql);
            pre.setString(1, key);
            pre.setString(2, cart.getCustomer().getCustID());
            pre.setFloat(3, cart.getOrder().getTotal());
            int rows = pre.executeUpdate();
            if (rows > 0) {
                OrderDetailDAO dao = new OrderDetailDAO();
                for (OrderDetailDTO orderDetailDTO : cart.getDetailList()) {
                    boolean ck = dao.insertDetail(con, orderDetailDTO, key);
                    if (ck == false) {
                        res = false;
                    }
                }
            }
            if (res) {
                con.commit();
            } else {
                con.rollback();
            }
        } catch (SQLException e) {
            con.rollback();
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pre != null) {
                pre.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return res;
    } 
}
