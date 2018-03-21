/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnhse63348.book;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import phatnhse63348.utils.DatabaseUtils;

/**
 *
 * @author nguyenhongphat0
 */
public class BookDAO implements Serializable {
    private List<BookDTO> booksList;

    public List<BookDTO> getBooksList() {
        return booksList;
    }
    
    public void searchTitle(String bookTitle) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        try {
            con = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM tbl_Book WHERE bookTitle LIKE ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, "%" + bookTitle + "%");
            res = pre.executeQuery();
            while (res.next()) {                
                if (this.booksList == null) {
                    this.booksList = new ArrayList<>();
                }
                BookDTO dto = new BookDTO();
                dto.setBookId(res.getString(1));
                dto.setBookTitle(res.getString(2));
                dto.setDescription(res.getString(3));
                dto.setAuthor(res.getString(4));
                dto.setPublisher(res.getString(5));
                dto.setPrice(res.getFloat(6));
                this.booksList.add(dto);
            }
        } finally {
            if (res != null) {
                res.close();
            }
            if (pre != null) {
                pre.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}
