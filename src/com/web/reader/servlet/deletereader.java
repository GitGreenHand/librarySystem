/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.reader.servlet;

import com.web.test.ReaderDaoFactory;
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
@WebServlet(name = "deletereader",urlPatterns = {"/deletereader"})
public class deletereader extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html ; charset = UTF-8");
       String readerid = request.getParameter("readerid");
        //BookDaoFactory.getBookDao().deleteBook(bookno);
        ReaderDaoFactory.getReaderDao().deleteBook(readerid);
        response.sendRedirect(request.getContextPath()+"/diaplayreader");
 
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response); //To change body of generated methods, choose Tools | Templates.
    }
    
}
