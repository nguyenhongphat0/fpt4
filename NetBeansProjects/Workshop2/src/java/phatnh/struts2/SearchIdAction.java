/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnh.struts2;

import java.util.List;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
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
    @Result(location = "staff.jsp")
})
public class SearchIdAction {
    private String mobileId;
    private List<MobileDTO> list;

    public List<MobileDTO> getList() {
        return list;
    }
    
    private static final String success = "success";
    private static final String fail = "fail";
    
    public String getMobileId() {
        return mobileId;
    }

    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }
    
    public SearchIdAction() {
    }
    
    @Action("searchId")
    public String execute() throws Exception {
        if (mobileId.trim().length() > 0) {
            MobileDAO dao = new MobileDAO();
            dao.searchById(mobileId);
            this.list = dao.getList();
        }
        return success;
    }
    
}
