/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nguyenhongphat0
 */
public class CartObject {
    private Map<String, Integer> items;
    private String customer;

    public Map<String, Integer> getItems() {
        return items;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
    
    public void addItemToCart(String title) {
        if (this.items == null) {
            items = new HashMap<>();
        }
        int quantity = 1;
        if (this.items.containsKey(title)) {
            quantity = this.items.get(title) + 1;
        }
        this.items.put(title, quantity);
    }
    
    public void removeItemFromCart(String title) {
        if (this.items == null) {
            return;
        }
        if (this.items.containsKey(title)) {
            this.items.remove(title);
            if (this.items.isEmpty()) {
                this.items = null;
            }
        }
    }
}
