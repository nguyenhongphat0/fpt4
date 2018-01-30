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
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author nguyenhongphat0
 */
public class DBUtils implements  Serializable {
    public static Connection makeConnection()
        throws SQLException, NamingException {
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        String url = "jdbc:sqlserver://localhost:1433;databaseName=JAVAWEB;";
//        Connection conn = DriverManager.getConnection(url, "sa", "HongPhat0");
//        return conn;

        Context context = new InitialContext();
        Context webAppContext = (Context) context.lookup("java:comp/env");
        DataSource ds = (DataSource)webAppContext.lookup("Datasource");
        Connection conn = ds.getConnection();
        return conn;
    }
}
