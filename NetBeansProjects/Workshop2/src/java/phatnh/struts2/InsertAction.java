/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnh.struts2;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import phatnh.mobile.MobileDAO;

/**
 *
 * @author nguyenhongphat0
 */
@ResultPath("/")
@Results({
    @Result(type = "redirectAction", params = {
        "actionName", "searchId",
        "mobileId", "${mobileId}",
        "msg", "${msg}"
    }),
    @Result(name = "input", type = "dispatcher", location = "staff.jsp")
})
@ExceptionMappings({
    @ExceptionMapping(exception = "com.microsoft.sqlserver.jdbc.SQLServerException", result = "input")
})
public class InsertAction extends ActionSupport {
    private String mobileId;
    private String description;
    private float price;
    private String mobileName;
    private int yearOfProduction;
    private int quantity;
    private boolean notSale;
    private String msg;
    
    private static final String success = "success";
    
    public InsertAction() {
    }

    public String getMobileId() {
        return mobileId;
    }

    @RequiredStringValidator(message = "Mobile ID must not be null")
    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }

    public String getDescription() {
        return description;
    }

    @RequiredStringValidator(message = "Description must not be null")
    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getMobileName() {
        return mobileName;
    }

    @RequiredStringValidator(message = "Mobile name must not be null")
    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isNotSale() {
        return notSale;
    }

    public void setNotSale(boolean notSale) {
        this.notSale = notSale;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public String execute() throws Exception {
        MobileDAO dao = new MobileDAO();
        boolean res = dao.addMobile(mobileId, description, price, mobileName, yearOfProduction, quantity, notSale);
        if (!res) {
            this.msg = "Error insert new phone " + mobileId;
        }
        return success;
    }
    
}
