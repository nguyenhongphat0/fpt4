/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnh.struts2;

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
        "actionName", "search${lst}",
        "mobileName", "${lsv}",
        "mobileId", "${lsv}",
        "msg", "${msg}"
    })
})
public class UpdateAction {
    private String mobileId;
    private String description;
    private float price;
    private int quantity;
    private boolean notSale;
    private String msg;
    private String lst;
    private String lsv;
    
    private static final String success = "success";
    private static final String fail = "fail";

    public String getMobileId() {
        return mobileId;
    }

    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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

    public String getLst() {
        return lst;
    }

    public void setLst(String lst) {
        this.lst = lst;
    }

    public String getLsv() {
        return lsv;
    }

    public void setLsv(String lsv) {
        this.lsv = lsv;
    }
    
    public UpdateAction() {
    }
    
    public String execute() throws Exception {
        MobileDAO dao = new MobileDAO();
        boolean res = dao.updateMobile(mobileId, price, description, quantity, notSale);
        if (!res) {
            this.msg = "Error update mobile " + mobileId;
        }
        return success;
    }
    
}
