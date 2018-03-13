/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struts2;

import users.UsersDAO;

/**
 *
 * @author nguyenhongphat0
 */
public class DeleteAction {
    private String pk;
    private String lastSearchValue;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getLastSearchValue() {
        return lastSearchValue;
    }

    public void setLastSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }
    
    public DeleteAction() {
    }
    
    public String execute() throws Exception {
        UsersDAO dao = new UsersDAO();
        boolean res = dao.deleteByPk(pk);
        String url = FAIL;
        if (res) {
            url = SUCCESS;
        }
        return url;
    }
    
}
