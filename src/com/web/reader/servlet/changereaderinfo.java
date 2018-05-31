/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.reader.servlet;

import com.web.test.ReaderDaoFactory;
import java.io.IOException;
import java.util.List;
import com.web.model.Reader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pichaojun
 */
@WebServlet(name = "changereaderinfo",urlPatterns = {"/changereaderinfo"})
public class changereaderinfo extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset = UTF-8 ");
        String readerid = request.getParameter("readerid");  
        Reader reader = ReaderDaoFactory.getReaderDao().getReader(readerid);
        
        request.setAttribute("reader", reader);
        request.getRequestDispatcher("changereader.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
