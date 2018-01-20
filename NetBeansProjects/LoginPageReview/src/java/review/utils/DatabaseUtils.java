/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package review.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author nguyenhongphat0
 */
public class DatabaseUtils implements Serializable {
    public static Connection getConnection()
            throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/JAVAWEB";
        conn = DriverManager.getConnection(url, "root", "hongphat");        
        return conn;
    }
    
}
