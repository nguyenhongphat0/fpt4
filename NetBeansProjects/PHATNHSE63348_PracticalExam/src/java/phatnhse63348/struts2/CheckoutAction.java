/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnhse63348.struts2;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import phatnhse63348.order.OrderDAO;
import phatnhse63348.order.OrderDTO;

/**
 *
 * @author nguyenhongphat0
 */
@ResultPath("/")
@Results({
    @Result(type = "redirectAction", params = {
        "actionName", "search",
        "bookTitle", "${lastSearchValue}"
    }),
    @Result(name = "fail", location = "error.jsp", type = "redirect", params = {
        "msg", "Error checkout your cart!!!"
    })
    
})
public class CheckoutAction {
    private static final String success = "success";
    private static final String fail = "fail";
    private String lastSearchValue;

    public String getLastSearchValue() {
        return lastSearchValue;
    }

    public void setLastSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }
    
    public CheckoutAction() {
    }
    
    public String execute() throws Exception {
        OrderDAO dao = new OrderDAO();
        Map session = ActionContext.getContext().getSession();
        String custId = (String) session.get("id");
        if (custId == null) {
            return fail;
        }
        OrderDTO cart = (OrderDTO) session.get("cart");
        cart.setCustomerId(custId);
        boolean res = dao.checkOut(cart);
        if (res) {
            session.remove("cart");
            return success;
        } else {
            return fail;
        }
    }
    
}
