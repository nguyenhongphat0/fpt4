/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnhse63348.order;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author nguyenhongphat0
 */
public class OrderDTO implements Serializable {
    private String id;
    private Timestamp orderDate;
    private float total;
    private boolean isDeliver;
    private String customerId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public boolean isIsDeliver() {
        return isDeliver;
    }

    public void setIsDeliver(boolean isDeliver) {
        this.isDeliver = isDeliver;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public OrderDTO() {
    }

    public OrderDTO(String id, Timestamp orderDate, float total, boolean isDeliver, String customerId) {
        this.id = id;
        this.orderDate = orderDate;
        this.total = total;
        this.isDeliver = isDeliver;
        this.customerId = customerId;
    }
    
    
    
}
