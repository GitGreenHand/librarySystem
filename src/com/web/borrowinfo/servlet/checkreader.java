/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.borrowinfo.servlet;

import com.web.test.BookDaoFactory;
import com.web.test.ReaderDaoFactory;
import com.web.model.Book;
import com.web.model.Reader;
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
@WebServlet(name = "checkreader",urlPatterns = {"/checkreader"})
public class checkreader extends  HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset = UTF-8");
        PrintWriter out = response.getWriter();
        String readerid = request.getParameter("readerid");
        Reader reader = ReaderDaoFactory.getReaderDao().getReader(readerid);
       
         if(reader != null){
            //图书编号存在
            out.println("{\"getdata\":\"true\"}");
        }else{
            //图书编号不存在
            out.println("{\"getdata\":\"flase\"}");
        }
        out.close();  
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
}
