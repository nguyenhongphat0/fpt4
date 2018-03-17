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
public class DeleteAction {
    private String pk;
    private String lst;
    private String lsv;
    private String msg;
    
    private static final String success = "success";
    private static final String fail = "fail";

    public String getMsg() {
        return msg;
    }

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
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

    public DeleteAction() {
    }
    
    public String execute() throws Exception {
        MobileDAO dao = new MobileDAO();
        boolean res = dao.deleteById(pk);
        if (!res) {
            this.msg = "Error deleting " + pk;
        }
        return success;
    }
    
}
