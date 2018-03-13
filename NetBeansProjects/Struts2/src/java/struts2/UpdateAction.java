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
public class UpdateAction {
    private String username;
    private String password;
    private String lastSearchValue;
    private boolean role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastSearchValue() {
        return lastSearchValue;
    }

    public void setLastSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public UpdateAction() {
    }
    
    public String execute() throws Exception {
        UsersDAO dao = new UsersDAO();
        boolean res = dao.updatePasswordRole(username, password, role);
        String url = "fail";
        if (res) {
            url = "success";
        }
        return url;
    }
    
}
