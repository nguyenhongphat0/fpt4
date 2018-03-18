/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnh.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import phatnh.user.UserDTO;

/**
 *
 * @author nguyenhongphat0
 */
public class CartDTO implements Serializable {
    private UserDTO user;
    private Map<String, Integer> items;

    public CartDTO(UserDTO user) {
        this.user = user;
        this.items = new HashMap<>();
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
    
    public void addToCart(String mobileId) {
        if (!items.containsKey(mobileId)) {
            items.put(mobileId, 1);
        } else {
            int quantity = items.get(mobileId);
            quantity++;
            items.put(mobileId, quantity);
        }
    }
    
    public void removeFromCart(String mobileId) {
        if (items.containsKey(mobileId)) {
            items.remove(mobileId);
        }
    }
}
