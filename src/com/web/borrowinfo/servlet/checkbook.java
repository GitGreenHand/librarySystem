/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.borrowinfo.servlet;

import com.web.test.BookDaoFactory;
import com.web.model.Book;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pichaojun
 */
@WebServlet(name = "checkbook",urlPatterns = {"/checkbook"})
public class checkbook extends HttpServlet{
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset = UTF-8");
        PrintWriter out = response.getWriter();
        String bookno = request.getParameter("bookno");
        Book book = BookDaoFactory.getBookDao().getBook(bookno);
         if(book != null){
            //图书编号存在
            out.println("{\"getdata\":\"true\"}");
        }else{
            //图书编号不存在
            out.println("{\"getdata\":\"false\"}");
        }
        out.close();  
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
