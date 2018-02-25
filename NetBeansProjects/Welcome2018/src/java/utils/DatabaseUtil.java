/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author nguyenhongphat0
 */
public class DatabaseUtil {
    public static Connection getConnection() throws NamingException, SQLException {
        DataSource ds = (DataSource) new InitialContext().lookup("java:comp/env/Datasource");
        return ds.getConnection();
    }
}
