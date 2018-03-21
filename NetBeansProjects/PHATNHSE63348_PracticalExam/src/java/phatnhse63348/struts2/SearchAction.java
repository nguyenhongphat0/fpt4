/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnhse63348.struts2;

import java.util.List;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import phatnhse63348.book.BookDAO;
import phatnhse63348.book.BookDTO;

/**
 *
 * @author nguyenhongphat0
 */
@ResultPath("/")
@Results({
    @Result(location = "search.jsp")
})
public class SearchAction {
    private String bookTitle;
    private List<BookDTO> list;
    
    private static final String success = "success";

    public List<BookDTO> getList() {
        return list;
    }
    
    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    
    public SearchAction() {
    }
    
    public String execute() throws Exception {
        if (bookTitle.trim().length() > 0) {
            BookDAO dao = new BookDAO();
            dao.searchTitle(bookTitle);
            this.list = dao.getBooksList();
        }
        return success;
    }
    
}
