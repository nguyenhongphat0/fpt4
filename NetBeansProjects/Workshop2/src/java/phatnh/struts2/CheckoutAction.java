/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnh.struts2;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import phatnh.cart.CartDAO;
import phatnh.cart.CartDTO;

/**
 *
 * @author nguyenhongphat0
 */
@ResultPath("/")
@Results({
    @Result(type = "redirectAction", params = {
        "actionName", "searchPrice",
        "min", "${min}",
        "max", "${max}"
    }),
    @Result(name = "fail", location = "errorPage.jsp", type = "redirect")
})
@ExceptionMappings({
    @ExceptionMapping(exception = "com.microsoft.sqlserver.jdbc.SQLServerException", result = "fail")
})
public class CheckoutAction {
    private int min;
    private int max;

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
    
    public CheckoutAction() {
    }
    
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        CartDTO cart = (CartDTO) session.get("cart");
        CartDAO dao = new CartDAO();
        boolean res = dao.checkout(cart);
        if (res) {
            session.remove("cart");
            return "success";
        } else {
            return "fail";
        }
    }
    
}
