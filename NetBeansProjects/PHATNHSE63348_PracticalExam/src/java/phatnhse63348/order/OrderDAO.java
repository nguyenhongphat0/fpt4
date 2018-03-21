/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnhse63348.order;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.NamingException;
import phatnhse63348.utils.DatabaseUtils;

/**
 *
 * @author nguyenhongphat0
 */
public class OrderDAO implements Serializable {
    public boolean checkOut(OrderDTO cart) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pre = null;
        try {
            con = DatabaseUtils.getConnection();
            String sql = "INSERT INTO tbl_order VALUES (\n" +
                        "    (SELECT COUNT(*) FROM tbl_order),\n" +
                        "    getdate(),\n" +
                        "    ?,\n" +
                        "    0,\n" +
                        "    ?)\n";
            pre = con.prepareStatement(sql);
            pre.setFloat(1, cart.getTotal());
            pre.setString(2, cart.getCustomerId());
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
