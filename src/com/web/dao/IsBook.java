/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.dao;

import com.web.model.Book;
import com.web.util.Pagination;
import java.util.List;

/**
 *
 * @author pichaojun
 */
public interface IsBook {
    public List<Book> getAllbook();
    public List<Book>getAllBook(Pagination pagination);
    public void deleteBook(String bookno);
    public Book getBook(String bookno);
    public void updateBookinfo(Book book);
    public void addBook(Book book);
    public List<Book> getBookinfobyname(Pagination pagination,String bookname);
    public List<Book> getBookinfobyauthor(Pagination pagination,String author);
    public List<Book> getBookinfobypublish(Pagination pagination,String publish);
    public void updatabookstatus(String bookno,String status);
}
