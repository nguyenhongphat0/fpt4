/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struts2;

import java.util.List;
import users.UsersDAO;
import users.UsersDTO;

/**
 *
 * @author nguyenhongphat0
 */
public class SearchAction {
    private String searchValue;
    private List<UsersDTO> usersList;
    private final String SUCCESS = "success";

    public List<UsersDTO> getUsersList() {
        return usersList;
    }
    
    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }
    
    public SearchAction() {
    }
    
    public String execute() throws Exception {
        UsersDAO dao = new UsersDAO();
        dao.searchLastname(searchValue);
        this.usersList = dao.getUsersList();
        return SUCCESS;
    }
    
}
