/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author nguyenhongphat0
 */
public class DBUtils implements  Serializable {
    public static Connection makeConnection()
        throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=JAVAWEB;";
        Connection conn = DriverManager.getConnection(url, "sa", "HongPhat0");
        return conn;
    }
}
