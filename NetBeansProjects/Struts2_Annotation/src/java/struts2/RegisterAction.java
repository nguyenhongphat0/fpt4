/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struts2;

import com.opensymphony.xwork2.ActionSupport;
import users.UsersDAO;

/**
 *
 * @author nguyenhongphat0
 */
public class RegisterAction extends ActionSupport {
    private String username;
    private String password;
    private String lastname;
    private String confirm;

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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }
    
    public RegisterAction() {
    }
    
    public String execute() throws Exception {
        UsersDAO dao = new UsersDAO();
        boolean res = dao.createNewAccount(username, password, lastname, false);
        String url = "fail";
        if (res) {
            url = "success";
        }
        return url;
    }
    
}
