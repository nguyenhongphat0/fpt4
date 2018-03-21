/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnhse63348.struts2;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import java.util.Map;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import phatnhse63348.customer.CustomerDAO;

/**
 *
 * @author nguyenhongphat0
 */
@ResultPath("/")
@Results({
    @Result(location = "search.jsp", type = "redirect"),
    @Result(name = "fail", location = "error.jsp", type = "redirect", params = {
        "msg", "Invalid id or password, click <a href='login.jsp'>here</a> to try again!"
    }),
    @Result(name = "input", location = "login.jsp")
})
public class LoginAction extends ActionSupport {
    private String id;
    private String password;
    private static final String success = "success";
    private static final String fail = "fail";

    public String getId() {
        return id;
    }

    @RequiredStringValidator(message = "ID must not be null")
    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    @RequiredStringValidator(message = "Password must not be null")
    public void setPassword(String password) {
        this.password = password;
    }
    
    public LoginAction() {
    }
    
    public String execute() throws Exception {
        CustomerDAO dao = new CustomerDAO();
        boolean res = dao.checkLogin(id, password);
        if (res) {
            Map session = ActionContext.getContext().getSession();
            session.put("id", id);
            return success;
        } else {
            return fail;
        }
    }
    
}
