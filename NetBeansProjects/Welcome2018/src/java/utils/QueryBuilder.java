/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author nguyenhongphat0
 */
public class QueryBuilder {
    public Connection con;
    public PreparedStatement pre;
    public ResultSet res;
    public int counter;

    public QueryBuilder() {
    }
    
    public QueryBuilder connect() throws NamingException, SQLException {
        con = DatabaseUtil.getConnection();
        return this;
    }
    
    public QueryBuilder prepare(String sql) throws SQLException {
        pre = con.prepareStatement(sql);
        counter = 0;
        return this;
    }
    
    public QueryBuilder setString(String s) throws SQLException {
        pre.setString(++counter, s);
        return this;
    }
    
    public QueryBuilder setInt(int x) throws SQLException {
        pre.setInt(++counter, x);
        return this;
    }
    
    public QueryBuilder setBoolean(boolean b) throws SQLException {
        pre.setBoolean(++counter, b);
        return this;
    }
    
    public QueryBuilder execute() throws SQLException {
        res = pre.executeQuery();
        return this;
    }
    
    public int update() throws SQLException {
        return pre.executeUpdate();
    }
    
    public QueryBuilder each(RowProcess rp) throws SQLException {
        while (res.next()) {            
            rp.each(res);
        }
        return this;
    }
    
    public QueryBuilder close() throws SQLException {
        if (res != null) {
            res.close();
        }
        if (pre != null) {
            pre.close();
        }
        if (con != null) {
            con.close();
        }
        return this;
    }
}
