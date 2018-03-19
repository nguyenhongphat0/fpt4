/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnh.order;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author nguyenhongphat0
 */
public class OrderDTO implements Serializable {
    private int orderID;
    private Timestamp orderDate;
    private String custID;
    private float total;
    private boolean isDeliver;
    private String reason;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public OrderDTO() {
    }

    public OrderDTO(int orderID, Timestamp orderDate, String custID, float total, boolean isDeliver, String reason) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.custID = custID;
        this.total = total;
        this.isDeliver = isDeliver;
        this.reason = reason;
    }
    
    
}
