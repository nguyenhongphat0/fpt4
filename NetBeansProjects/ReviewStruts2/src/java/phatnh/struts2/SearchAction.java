/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnh.struts2;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.ExpressionValidator;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import java.sql.Timestamp;
import java.util.List;
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
    @Result(location = "search.jsp"),
    @Result(name = "error", location = "errorPage.jsp")
})
@ExceptionMappings({
    @ExceptionMapping(exception = "java.lang.IllegalArgumentException", result = "error")
})
public class SearchAction extends ActionSupport {
    private List<OrderDTO> list;
    private String fromdate;
    private String todate;
    private boolean isDeliver;

    public boolean isIsDeliver() {
        return isDeliver;
    }

    public void setIsDeliver(boolean isDeliver) {
        this.isDeliver = isDeliver;
    }

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

    public List<OrderDTO> getList() {
        return list;
    }

    public SearchAction() {
    }
    
    public String execute() throws Exception {
        OrderDAO dao = new OrderDAO();
        Timestamp from = Timestamp.valueOf(fromdate + " 00:00:00");
        Timestamp to = Timestamp.valueOf(todate + " 23:59:59");
        dao.search(from, to, isDeliver);
        this.list = dao.getOrdersList();
        return "success";
    }
    
}
