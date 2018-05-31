/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.dao.impl;

import com.web.dao.IsBook;
import com.web.model.Book;
import com.web.util.DatabaseJDBC;
import com.web.util.Pagination;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pichaojun
 */
public class BookDao implements IsBook{
    Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;
            
    @Override
    public List<Book> getAllbook( ) {
        List<Book> books = new ArrayList<Book>();
        try {
            conn = DatabaseJDBC.getConnection();
            psmt = conn.prepareStatement("select * from book ");
            rs = psmt.executeQuery();
            while (rs.next()) {                
                Book book = new Book();
                book.setBookno( rs.getString("bookno"));
                book.setBookname(rs.getString("bookname"));
                book.setAuthor( rs.getString("author"));
                book.setPublish(rs.getString("publish"));
                book.setBookisbn(rs.getString("bookisbn"));
                book.setBookprices(rs.getString("bookprices"));
                book.setBookstatus( rs.getString("bookstatus"));
                books.add(book);
            }
        } catch (SQLException exception) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, exception);
        }finally{
            DatabaseJDBC.Close(rs, psmt, conn);
        }
       return books;
    }

    @Override
    public List<Book> getAllBook(Pagination pagination) {
        List<Book> books = new ArrayList<Book>();
        try {
            conn = DatabaseJDBC.getConnection();
            psmt = conn.prepareStatement("select count(*) as counts from BOOK");
            rs = psmt.executeQuery();
            rs.next();
            //求总记录数
            pagination.setCountSize(rs.getInt("counts"));
            int start = (pagination.getPageNo() - 1) * pagination.getPageSize() + 1;//开始位置
            int end = pagination.getPageNo() * pagination.getPageSize();//结束位置
            psmt = conn.prepareStatement("SELECT * FROM (SELECT ROWNUM NO , s.* FROM (SELECT * FROM BOOK ORDER BY bookno ASC) s WHERE ROWNUM<=?) WHERE NO>=?");
            psmt.setInt(1, end);
            psmt.setInt(2, start);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setBookno( rs.getString("bookno"));
                book.setBookname(rs.getString("bookname"));
                book.setAuthor( rs.getString("author"));
                book.setPublish(rs.getString("publish"));
                book.setBookisbn(rs.getString("bookisbn"));
                book.setBookprices(rs.getString("bookprices"));
                book.setBookstatus( rs.getString("bookstatus"));
                books.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseJDBC.Close(rs, psmt, conn);
        }
        return books;
    }

    @Override
    public void deleteBook(String bookno) {
        try {
            conn = DatabaseJDBC.getConnection();
            psmt = conn.prepareStatement("delete from BOOK where bookno = ?");
            psmt.setString(1, bookno);
            psmt.executeUpdate();         
        } catch (SQLException exception) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, exception);
        }finally{
            DatabaseJDBC.Close(rs, psmt, conn);
        }
    }

    @Override
    public Book getBook(String bookno) {
        Book book = null;
        try {
            conn = DatabaseJDBC.getConnection();
            psmt = conn.prepareStatement("select * from BOOK where bookno=? ");
            psmt.setString(1, bookno);
            rs = psmt.executeQuery();
            while (rs.next()) {
                book = new Book();
                book.setBookno( rs.getString("bookno"));
                book.setBookname(rs.getString("bookname"));
                book.setAuthor( rs.getString("author"));
                book.setPublish(rs.getString("publish"));
                book.setBookisbn(rs.getString("bookisbn"));
                book.setBookprices(rs.getString("bookprices"));
                book.setBookstatus( rs.getString("bookstatus"));  
            }
        } catch (SQLException exception) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, exception);
        }finally{
            DatabaseJDBC.Close(rs, psmt, conn);
        }
        return book;
    }

    @Override
    public void updateBookinfo(Book book) {
        try {
            conn = DatabaseJDBC.getConnection();
            psmt = conn.prepareStatement("update BOOK set bookname=?,author =?,publish=?,bookisbn=?,bookprices=?,bookstatus=? where bookno=?");
            
            psmt.setString(1, book.getBookname());
            psmt.setString(2,book.getAuthor());
            psmt.setString(3, book.getPublish());
            psmt.setString(4, book.getBookisbn());
            psmt.setString(5, book.getBookprices());
            psmt.setString(6, book.getBookstatus());
            psmt.setString(7, book.getBookno());
            
            psmt.executeUpdate();
        } catch (SQLException exception) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null,exception);
        }finally{
            DatabaseJDBC.Close(rs, psmt, conn);
        }
    }

    @Override
    public void addBook(Book book) {
        try {
            conn = DatabaseJDBC.getConnection();
            psmt = conn.prepareStatement("insert into book values(?,?,?,?,?,?,?)");
            psmt.setString(1, book.getBookno());
            psmt.setString(2, book.getBookname());
            psmt.setString(3, book.getAuthor());
            psmt.setString(4, book.getPublish());
            psmt.setString(5, book.getBookisbn());
            psmt.setString(6, book.getBookprices());
            psmt.setString(7, book.getBookstatus());
            psmt.executeQuery();
        } catch (SQLException exception) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null,exception);
        }finally{
            DatabaseJDBC.Close(rs, psmt, conn);
        }
    }

   

    @Override
    public List<Book> getBookinfobyname(Pagination pagination, String bookname) {
        List<Book> books = new ArrayList<Book>();
        try {
            conn = DatabaseJDBC.getConnection();
            psmt = conn.prepareStatement("select count(*) as counts from BOOK where bookname = ?");
            psmt.setString(1, bookname);
            rs = psmt.executeQuery();
            rs.next();
            //求总记录数
            pagination.setCountSize(rs.getInt("counts"));
            int start = (pagination.getPageNo() - 1) * pagination.getPageSize() + 1;//开始位置
            int end = pagination.getPageNo() * pagination.getPageSize();//结束位置
            psmt = conn.prepareStatement("SELECT * FROM (SELECT ROWNUM NO , s.* FROM (SELECT * FROM BOOK where bookname = ? ORDER BY bookno ASC) s WHERE ROWNUM<=?) WHERE NO>=?");
            psmt.setString(1, bookname);
            psmt.setInt(2, end);
            psmt.setInt(3, start);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setBookno( rs.getString("bookno"));
                book.setBookname(rs.getString("bookname"));
                book.setAuthor( rs.getString("author"));
                book.setPublish(rs.getString("publish"));
                book.setBookisbn(rs.getString("bookisbn"));
                book.setBookprices(rs.getString("bookprices"));
                book.setBookstatus( rs.getString("bookstatus"));
                books.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseJDBC.Close(rs, psmt, conn);
        }
        return books;
    }

    
    @Override
    public List<Book> getBookinfobyauthor(Pagination pagination, String author) {
       List<Book> books = new ArrayList<Book>();
        try {
            conn = DatabaseJDBC.getConnection();
            psmt = conn.prepareStatement("select count(*) as counts from BOOK where author = ?");
            psmt.setString(1, author);
            rs = psmt.executeQuery();
            rs.next();
            //求总记录数
            pagination.setCountSize(rs.getInt("counts"));
            int start = (pagination.getPageNo() - 1) * pagination.getPageSize() + 1;//开始位置
            int end = pagination.getPageNo() * pagination.getPageSize();//结束位置
            psmt = conn.prepareStatement("SELECT * FROM (SELECT ROWNUM NO , s.* FROM (SELECT * FROM BOOK where author = ? ORDER BY bookno ASC) s WHERE ROWNUM<=?) WHERE NO>=?");
            psmt.setString(1, author);
            psmt.setInt(2, end);
            psmt.setInt(3, start);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setBookno( rs.getString("bookno"));
                book.setBookname(rs.getString("bookname"));
                book.setAuthor( rs.getString("author"));
                book.setPublish(rs.getString("publish"));
                book.setBookisbn(rs.getString("bookisbn"));
                book.setBookprices(rs.getString("bookprices"));
                book.setBookstatus( rs.getString("bookstatus"));
                books.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseJDBC.Close(rs, psmt, conn);
        }
        return books;
    }

    @Override
    public List<Book> getBookinfobypublish(Pagination pagination, String publish) {
         List<Book> books = new ArrayList<Book>();
        try {
            conn = DatabaseJDBC.getConnection();
            psmt = conn.prepareStatement("select count(*) as counts from BOOK where publish = ?");
            psmt.setString(1, publish);
            rs = psmt.executeQuery();
            rs.next();
            //求总记录数
            pagination.setCountSize(rs.getInt("counts"));
            int start = (pagination.getPageNo() - 1) * pagination.getPageSize() + 1;//开始位置
            int end = pagination.getPageNo() * pagination.getPageSize();//结束位置
            psmt = conn.prepareStatement("SELECT * FROM (SELECT ROWNUM NO , s.* FROM (SELECT * FROM BOOK where publish = ? ORDER BY bookno ASC) s WHERE ROWNUM<=?) WHERE NO>=?");
            psmt.setString(1, publish);
            psmt.setInt(2, end);
            psmt.setInt(3, start);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setBookno( rs.getString("bookno"));
                book.setBookname(rs.getString("bookname"));
                book.setAuthor( rs.getString("author"));
                book.setPublish(rs.getString("publish"));
                book.setBookisbn(rs.getString("bookisbn"));
                book.setBookprices(rs.getString("bookprices"));
                book.setBookstatus( rs.getString("bookstatus"));
                books.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseJDBC.Close(rs, psmt, conn);
        }
        return books;
    }

    @Override
    public void updatabookstatus(String bookno,String status) {
        try {
            conn = DatabaseJDBC.getConnection();
            psmt = conn.prepareStatement("update book set bookstatus = ? where bookno = ?");
            psmt.setString(1, status);
            psmt.setString(2, bookno);
            psmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            DatabaseJDBC.Close(rs, psmt, conn);
        }
    }

  
    
}
