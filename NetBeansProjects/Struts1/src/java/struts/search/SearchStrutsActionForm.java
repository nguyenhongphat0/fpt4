package struts.search;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import users.UsersDAO;
import users.UsersDTO;

/**
 *
 * @author nguyenhongphat0
 */
public class SearchStrutsActionForm extends org.apache.struts.action.ActionForm {
    private String searchvalue;
    private List<UsersDTO> list;

    public List<UsersDTO> getList() {
        return list;
    }
    
    public SearchStrutsActionForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getSearchvalue() {
        return searchvalue;
    }

    public void setSearchvalue(String searchvalue) {
        this.searchvalue = searchvalue;
    }
    
    public void search() {
        try {
            UsersDAO dao = new UsersDAO();
            dao.searchLastname(searchvalue);
            this.list = dao.getUsersList();
        } catch (SQLException ex) {
            Logger.getLogger(SearchStrutsActionForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(SearchStrutsActionForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
