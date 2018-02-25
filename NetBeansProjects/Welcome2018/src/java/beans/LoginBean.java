/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import users.UserDAO;
import users.UserDTO;

/**
 *
 * @author nguyenhongphat0
 */
public class LoginBean {
    private String userId;
    private int password;
    private String search;

    public LoginBean() {
    }

    public LoginBean(String username, int password) {
        this.userId = username;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String username) {
        this.userId = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
    
    public boolean checkLogin() {
        UserDAO dao = new UserDAO();
        boolean res = false;
        try {
            res = dao.checkLogin(userId, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        return res;
    }
    
    public List<UserDTO> search() throws SQLException, NamingException {
        return new UserDAO().searchFullname(search);
    }
}
