/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnh.struts2;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import phatnh.cart.CartDTO;
import phatnh.user.UserDTO;

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
    })
})
public class AddToCartAction {
    private String mobileId;
    private float min;
    private float max;

    public float getMin() {
        return min;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public float getMax() {
        return max;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public String getMobileId() {
        return mobileId;
    }

    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }
    
    public AddToCartAction() {
    }
    
    @Action("addToCart")
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        CartDTO cart = (CartDTO) session.get("cart");
        if (cart == null) {
            UserDTO user = new UserDTO();
            user.setUserId((String) session.get("userId"));
            cart = new CartDTO(user);
        }
        cart.addToCart(mobileId);
        session.put("cart", cart);
        return "success";
    }
    
}
