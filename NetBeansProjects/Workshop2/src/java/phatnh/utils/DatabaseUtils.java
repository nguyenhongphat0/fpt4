/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnh.utils;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author nguyenhongphat0
 */
public class DatabaseUtils {
    public static Connection getConnection() throws NamingException, SQLException {
        InitialContext init = new InitialContext();
        DataSource ds = (DataSource) init.lookup("java:comp/env/Datasource");
        Connection con = ds.getConnection();
        return con;
    }
}
