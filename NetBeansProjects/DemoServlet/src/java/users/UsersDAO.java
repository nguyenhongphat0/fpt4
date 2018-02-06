/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import utils.DBUtils;

/**
 *
 * @author nguyenhongphat0
 */
public class UsersDAO implements Serializable {
    public boolean checkLogin(String username, String password) 
        throws SQLException, NamingException {
        // 1. Mo connection
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                // 2. Tao cau lenh truy van
                String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";
                
                // 3. Tao statement
                stm = con.prepareStatement(sql);
                
                // 4. Truyen tham so
                stm.setString(1, username);
                stm.setString(2, password);
                
                // 5. Thuc thi cau lenh truy van
                rs = stm.executeQuery();
                
                if (rs.next()) {
                    return true;
                }
            }
        } finally {
            if (rs !=null ) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
    private List<UsersDTO> usersList;

    public List<UsersDTO> getUsersList() {
        return usersList;
    }
    
    public void searchLastname(String searchValue)
        throws SQLException, NamingException {
        // 1. Mo connection
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                // 2. Tao cau lenh truy van
                String sql = "SELECT * FROM Users WHERE fullname LIKE ?";
                
                // 3. Tao statement
                stm = con.prepareStatement(sql);
                
                // 4. Truyen tham so
                stm.setString(1, "%" + searchValue + "%");
                
                // 5. Thuc thi cau lenh truy van
                rs = stm.executeQuery();
                
                while (rs.next()) {                    
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String lastname = rs.getString("fullname");
                    boolean role = rs.getBoolean("roles");
                    
                    UsersDTO dto = new UsersDTO(username, password, lastname, role);
                    if (this.usersList == null) {
                        this.usersList = new ArrayList<>();
                    }
                    this.usersList.add(dto);
                    
                }
            }
        } finally {
            if (rs !=null ) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    public boolean deleteByPk(String username)
            throws SQLException, NamingException {
        // 1. Mo connection
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                // 2. Tao cau lenh truy van
                String sql = "DELETE FROM Users WHERE username = ?";
                
                // 3. Tao statement
                stm = con.prepareStatement(sql);
                
                // 4. Truyen tham so
                stm.setString(1, username);
                
                // 5. Thuc thi cau lenh truy van
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
    public boolean updatePasswordRole(String username, String password, boolean isAdmin)
            throws SQLException, NamingException {
        // 1. Mo connection
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                // 2. Tao cau lenh truy van
                String sql = "UPDATE Users SET password = ?, roles = ? WHERE username = ?";
                
                // 3. Tao statement
                stm = con.prepareStatement(sql);
                
                // 4. Truyen tham so
                stm.setString(1, password);
                stm.setBoolean(2, isAdmin);
                stm.setString(3, username);
                
                // 5. Thuc thi cau lenh truy van
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
    public boolean createNewAccount(String username, String password, String lastname, boolean isAdmin) 
            throws SQLException, NamingException {
        // 1. Mo connection
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                // 2. Tao cau lenh truy van
                String sql = "INSERT INTO users VALUES(?, ?, ?, ?)";
                
                // 3. Tao statement
                stm = con.prepareStatement(sql);
                
                // 4. Truyen tham so
                stm.setString(1, username);
                stm.setString(2, password);
                stm.setString(3, lastname);
                stm.setBoolean(4, isAdmin);
                
                // 5. Thuc thi cau lenh truy van
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
}
