/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnhse63348.book;

import java.io.Serializable;

/**
 *
 * @author nguyenhongphat0
 */
public class BookDTO implements Serializable {
    private String bookId;
    private String bookTitle;
    private String description;
    private String author;
    private String publisher;
    private float price;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public BookDTO() {
    }

    public BookDTO(String bookId, String bookTitle, String description, String author, String publisher, float price) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.description = description;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }
    
    
}
