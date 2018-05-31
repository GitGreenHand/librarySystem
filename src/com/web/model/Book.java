/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.model;

/**
 *
 * @author pichaojun
 */
public class Book {
    private String bookno;
    private String bookname;
    private String author;
    private String publish;
    private String bookisbn;
    private String bookprices;
    private String bookstatus;
    
    public Book(){
    }
    public Book( String bookno,String bookname,String author,String publish,String bookisbn,String bookprices, String bookstatus){
        this.bookno = bookno;
        this.bookname = bookname;
        this.author = author;
        this.publish = publish;
        this.bookisbn = bookisbn;
        this.bookprices = bookprices;
        this.bookstatus = bookstatus;
    }

    /**
     * @return the bookno
     */
    public String getBookno() {
        return bookno;
    }

    /**
     * @param bookno the bookno to set
     */
    public void setBookno(String bookno) {
        this.bookno = bookno;
    }

    /**
     * @return the bookname
     */
    public String getBookname() {
        return bookname;
    }

    /**
     * @param bookname the bookname to set
     */
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the publish
     */
    public String getPublish() {
        return publish;
    }

    /**
     * @param publish the publish to set
     */
    public void setPublish(String publish) {
        this.publish = publish;
    }

    /**
     * @return the bookisbn
     */
    public String getBookisbn() {
        return bookisbn;
    }

    /**
     * @param bookisbn the bookisbn to set
     */
    public void setBookisbn(String bookisbn) {
        this.bookisbn = bookisbn;
    }

    /**
     * @return the bookprices
     */
    public String getBookprices() {
        return bookprices;
    }

    /**
     * @param bookprices the bookprices to set
     */
    public void setBookprices(String bookprices) {
        this.bookprices = bookprices;
    }
     /**
     * @return the bookstatus
     */
    public String getBookstatus() {
        return bookstatus;
    }

    /**
     * @param bookstatus the bookprices to set
     */
    public void setBookstatus(String bookstatus) {
        this.bookstatus = bookstatus;
    }
    
}
