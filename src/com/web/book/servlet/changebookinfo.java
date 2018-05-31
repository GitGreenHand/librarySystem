/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.book.servlet;

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
@WebServlet(name = "changebookinfo",urlPatterns = {"/changebookinfo"})
public class changebookinfo extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset = UTF-8 ");
        String bookno = request.getParameter("bookno");
        
        Book book = BookDaoFactory.getBookDao().getBook(bookno);
        
        request.setAttribute("book", book);     
        request.getRequestDispatcher("changebookinfo.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
