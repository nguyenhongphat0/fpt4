/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnhse63348.struts2;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
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
    })
})
public class AddToCartAction {
    private String bookId;
    private float price;
    private String lastSearchValue;

    private static final String success = "success";
    
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getLastSearchValue() {
        return lastSearchValue;
    }

    public void setLastSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }
    
    public AddToCartAction() {
    }
    
    @Action("addToCart")
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        String custID = (String) session.get("id");
        OrderDTO cart = (OrderDTO) session.get("cart");
        if (cart == null) {
            cart = new OrderDTO();
            cart.setCustomerId(custID);
        }
        float total = cart.getTotal();
        total += price;
        cart.setTotal(total);
        session.put("cart", cart);
        return success;
    }
    
}
