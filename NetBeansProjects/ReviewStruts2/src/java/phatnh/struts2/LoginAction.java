/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnh.struts2;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import phatnh.customer.CustomerDAO;

/**
 *
 * @author nguyenhongphat0
 */
@ResultPath("/")
@Results({
    @Result(location = "search.jsp", type = "redirect"),
    @Result(name = "fail", location = "invalid.html", type = "redirect")
})
public class LoginAction {
    private String custID;
    private String password;
    
    private static String success = "success";
    private static String fail = "fail";

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
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
        CustomerDAO dao = new CustomerDAO();
        boolean res = dao.checkLogin(custID, password);
        if (res) {
            Map session = ActionContext.getContext().getSession();
            session.put("custID", custID);
            return success;
        } else {
            return fail;
        }
    }
    
}
