/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnh.struts2;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import java.util.Map;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import phatnh.user.UserDAO;

/**
 *
 * @author nguyenhongphat0
 */
@ResultPath("/")
@Results({
    @Result(name = "manager", location = "manager.html", type = "redirect"),
    @Result(name = "user", location = "user.jsp", type = "redirect"),
    @Result(name = "staff", location = "staff.jsp", type = "redirect"),
    @Result(name = "input", location = "login.jsp"),
    @Result(name = "fail", location = "invalid.html", type = "redirect")
})
public class LoginAction extends ActionSupport {
    private String userId;
    private String password;

    public String getUserId() {
        return userId;
    }

    @RequiredStringValidator(trim = true, message = "User ID must not be null")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @RequiredStringValidator(message = "Password must not be null")
    @RegexFieldValidator(regex = "^\\d+$", message = "Password is a number")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public LoginAction() {
    }
    
    public String execute() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        String url = "fail";
        int pass = Integer.parseInt(password);
        UserDAO dao = new UserDAO();
        int role = dao.checkLogin(userId, pass);
        if (role > -1) {
            switch (role) {
                case 0:
                    url = "user";
                    break;
                case 1:
                    url = "manager";
                    break;
                case 2:
                    url = "staff";
                    break;
            }
            session.put("userId", userId);
            session.put("role", role);
        }
        return url;
    }
    
}
