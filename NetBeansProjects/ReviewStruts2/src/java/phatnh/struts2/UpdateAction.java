/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnh.struts2;

import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import java.sql.Timestamp;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import phatnh.order.OrderDAO;
import phatnh.order.OrderDTO;

/**
 *
 * @author nguyenhongphat0
 */
@ResultPath("/")
@Results({
    @Result(type = "redirectAction", params = {
        "actionName", "search",
        "fromdate", "${fromdate}",
        "todate", "${todate}",
        "isDeliver", "${isDeliver}"
    }),
    @Result(name = "fail", location = "errorPage.jsp")
})
@ExceptionMappings({
    @ExceptionMapping(exception = "com.microsoft.sqlserver.jdbc.SQLServerException", result = "fail")
})
public class UpdateAction {
    private int orderID;
    private Timestamp orderDate;
    private String custID;
    private float total;
    private boolean isDeliver;
    private String reason;
    private String fromdate;
    private String todate;

    public String getFromdate() {
        return fromdate;
    }

    @RequiredStringValidator(message = "Fromdate must not be null")
    @RegexFieldValidator(regex = "^\\d{4}-\\d{2}-\\d{2}$", message = "Fromdate must be yyyy-MM-dd")
    public void setFromdate(String fromdate) {
        this.fromdate = fromdate;
    }

    public String getTodate() {
        return todate;
    }

    @RequiredStringValidator(message = "Todate must not be null")
    @RegexFieldValidator(regex = "^\\d{4}-\\d{2}-\\d{2}$", message = "Todate must be yyyy-MM-dd")
    public void setTodate(String todate) {
        this.todate = todate;
    }

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
    
    public UpdateAction() {
    }
    
    public String execute() throws Exception {
        OrderDAO dao = new OrderDAO();
        OrderDTO dto = new OrderDTO(orderID, orderDate, custID, total, isDeliver, reason);
        boolean res = dao.update(dto);
        if (res) {
            return "success";
        } else {
            return "fail";
        }
    }
    
}
