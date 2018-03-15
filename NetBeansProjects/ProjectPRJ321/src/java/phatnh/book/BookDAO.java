/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnh.book;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import phatnh.utils.DatabaseUtils;

/**
 *
 * @author nguyenhongphat0
 */
public class BookDAO implements Serializable {
    private List<BookDTO> bookList;

    public List<BookDTO> getBookList() {
        return bookList;
    }

    public void getAllBooks() throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        try {
            con = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM tbl_book";
            pre = con.prepareStatement(sql);
            res = pre.executeQuery();
            while (res.next()) {                
                if (this.bookList == null) {
                    this.bookList = new ArrayList<>();
                }
                BookDTO dto = new BookDTO();
                dto.setBookID(res.getString(1));
                dto.setTitle(res.getString(2));
                dto.setPrice(res.getFloat(3));
                dto.setQuantity(res.getInt(4));
                bookList.add(dto);
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
    
    public boolean takeBookAway(Connection con, String bookID, int quantity) throws NamingException, SQLException {
        PreparedStatement pre = null;
        try {
            String sql = "UPDATE tbl_book SET quantity = quantity - ? WHERE bookID = ?";
            pre = con.prepareStatement(sql);
            pre.setInt(1, quantity);
            pre.setString(2, bookID);
            int res = pre.executeUpdate();
            return res > 0;
        } finally {
            if (pre != null) {
                pre.close();
            }
        }
    }
}
