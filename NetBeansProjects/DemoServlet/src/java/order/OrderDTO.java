/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import java.io.Serializable;
import java.util.Map;
import session.CartObject;

/**
 *
 * @author nguyenhongphat0
 */
public class OrderDTO implements Serializable {
    private Map<String, Integer> items;

    public OrderDTO() {
    }

    public OrderDTO(CartObject cart) {
        this.items = cart.getItems();
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public void setItems(Map<String, Integer> items) {
        this.items = items;
    }
    
    public int getTotalQuantity() {
        int d = 0;
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            d += entry.getValue();
        }
        return d;
    }
    
}
