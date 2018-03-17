/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnh.struts2;

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
    @Result(location = "staff.jsp")
})
public class SearchNameAction {
    private String mobileName;
    private List<MobileDTO> list;
    
    private static final String success = "success";

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public List<MobileDTO> getList() {
        return list;
    }
    
    public SearchNameAction() {
    }
    
    @Action("searchName")
    public String execute() throws Exception {
        if (mobileName.trim().length() > 0) {
            MobileDAO dao = new MobileDAO();
            dao.searchByName(mobileName);
            this.list = dao.getList();
        }
        return success;
    }
    
}
