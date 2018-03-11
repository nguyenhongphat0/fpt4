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
    private String orderID;
    private Timestamp orderDate;
    private String custID;
    private float total;
    private boolean isDeliver;
    private String Reason;

    public OrderDTO() {
    }

    public OrderDTO(String orderID, Timestamp orderDate, String custID, float total, boolean isDeliver, String Reason) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.custID = custID;
        this.total = total;
        this.isDeliver = isDeliver;
        this.Reason = Reason;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
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
        return Reason;
    }

    public void setReason(String Reason) {
        this.Reason = Reason;
    }
    
    
}
