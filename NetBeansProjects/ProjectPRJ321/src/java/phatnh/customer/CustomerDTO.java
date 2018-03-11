/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnh.customer;

import java.io.Serializable;

/**
 *
 * @author nguyenhongphat0
 */
public class CustomerDTO implements Serializable {
    private String custID;
    private String password;
    private String custName;
    private String lastName;
    private String middleName;
    private String address;
    private String phone;
    private int custLevel;

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(int custLevel) {
        this.custLevel = custLevel;
    }

    public CustomerDTO() {
    }

    public CustomerDTO(String custID, String password, String custName, String lastName, String middleName, String address, String phone, int custLevel) {
        this.custID = custID;
        this.password = password;
        this.custName = custName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.address = address;
        this.phone = phone;
        this.custLevel = custLevel;
    }
}
