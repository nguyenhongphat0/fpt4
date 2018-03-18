/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnh.struts2;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.DoubleRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import java.util.List;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import phatnh.mobile.MobileDAO;
import phatnh.mobile.MobileDTO;

/**
 *
 * @author nguyenhongphat0
 */
@ResultPath("/")
@Results({
    @Result(location = "user.jsp"),
    @Result(name = "input", location = "user.jsp")
})
public class SearchPriceAction extends ActionSupport {
    private float min;
    private float max;
    private List<MobileDTO> list;

    public float getMin() {
        return min;
    }

    @DoubleRangeFieldValidator(minInclusive = "0", maxInclusive = "999999999", message = "Price from ${minInclusive} - ${maxInclusive}")
    public void setMin(float min) {
        this.min = min;
    }

    public float getMax() {
        return max;
    }

    @DoubleRangeFieldValidator(minExclusive = "0", maxExclusive = "999999999", message = "Price from ${minExclusive} - ${maxExclusive}")
    public void setMax(float max) {
        this.max = max;
    }

    public List<MobileDTO> getList() {
        return list;
    }

    public void setList(List<MobileDTO> list) {
        this.list = list;
    }
    
    public SearchPriceAction() {
    }
    
    @Action("searchPrice")
    public String execute() throws Exception {
        if (max == 0) {
            max = 999999999;
        }
        MobileDAO dao = new MobileDAO();
        dao.searchPriceInRange(min, max);
        this.list = dao.getList();
        return "success";
    }
    
}
