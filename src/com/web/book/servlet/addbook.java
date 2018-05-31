/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.book.servlet;

import com.web.dao.impl.BookDao;
import com.web.test.BookDaoFactory;
import com.web.model.Book;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pichaojun
 */
@WebServlet(name = "addbook",urlPatterns = {"/addbook"})
public class addbook extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;cgarset = UTF-8");
        String bookno = request.getParameter("bookno");
        String bookname = request.getParameter("bookname");
        String author = request.getParameter("author");
        String publish = request.getParameter("publish");
        String bookisbn = request.getParameter("bookisbn");
        String bookprices = request.getParameter("bookprices");
        String bookstatus = request.getParameter("bookstatus");
        
        Book book = new Book();
        book.setBookno(bookno);
        book.setBookname(bookname);
        book.setAuthor(author);
        book.setPublish(publish);
        book.setBookisbn(bookisbn);
        book.setBookprices(bookprices);
        book.setBookstatus(bookstatus);
        
        BookDaoFactory.getBookDao().addBook(book);
        response.sendRedirect(request.getContextPath() + "/displaybook");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
}
