/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struts.login;

import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import users.UsersDAO;

/**
 *
 * @author nguyenhongphat0
 */
public class LoginStrutsActionForm extends org.apache.struts.action.ActionForm {
    private String username;
    private String password;
    
    public LoginStrutsActionForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean checkLogin() throws SQLException, NamingException {
        UsersDAO dao = new UsersDAO();
        return dao.checkLogin(username, password);
    }
}
