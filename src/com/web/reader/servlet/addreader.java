/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.reader.servlet;

import com.web.test.ReaderDaoFactory;
import com.web.model.Reader;
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
@WebServlet(name = "addreader",urlPatterns = {"/addreader"})
public class addreader extends HttpServlet{
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;cgarset = UTF-8");
        String readerid = request.getParameter("readerid");
        String readername = request.getParameter("readername");
        String readersex = request.getParameter("readersex");
        String readerage = request.getParameter("readerage");
        String readerclass = request.getParameter("readerclass");
        String readerdept = request.getParameter("readerdept");
        String readerpermitted = request.getParameter("readerpermitted");
        
        Reader reader = new Reader();
        reader.setReaderid(readerid);
        reader.setReadername(readername);
        reader.setReadersex(readersex);
        reader.setReaderage(Integer.parseInt(readerage));
        reader.setReaderclass(readerclass);
        reader.setReaderdept(readerdept);
        reader.setReaderpermitted(readerpermitted);
        
         ReaderDaoFactory.getReaderDao().addReader(reader);
        response.sendRedirect(request.getContextPath() + "/diaplayreader");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
}
