/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnh.orderdetail;

import java.io.Serializable;
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
public class OrderDetailDAO implements Serializable {
    private List<OrderDetailDTO> detailList;

    public List<OrderDetailDTO> getDetailList() {
        return detailList;
    }
    
    public void getOrderDetail(String orderID) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        try {
            con = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM tbl_orderDetail WHERE orderID = ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, orderID);
            res = pre.executeQuery();
            while (res.next()) {                
                if (detailList == null) {
                    this.detailList = new ArrayList<>();
                }
                OrderDetailDTO dto = new OrderDetailDTO();
                dto.setId(res.getInt(1));
                dto.setProductID(res.getString(2));
                dto.setQuantity(res.getInt(3));
                dto.setUnitPrice(res.getFloat(4));
                dto.setTotal(res.getFloat(5));
                dto.setOrderID(res.getString(6));
                detailList.add(dto);
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