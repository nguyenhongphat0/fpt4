/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struts2;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import users.UsersDAO;

/**
 *
 * @author nguyenhongphat0
 */
public class LoginAction {
    private String username;
    private String password;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";

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
    
    public LoginAction() {
    }
    
    public String execute() throws Exception {
        UsersDAO dao = new UsersDAO();
        boolean result = dao.checkLogin(username, password);
        String url = FAIL;
        if (result) {
            url = SUCCESS;
            Map session = ActionContext.getContext().getSession();
            session.put("USERNAME", username);
        }
        return url;
    }
    
}
