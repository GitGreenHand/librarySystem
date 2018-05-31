/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.reader.servlet;

import com.web.test.ReaderDaoFactory;
import com.web.util.Pagination;
import com.web.model.Reader;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pichaojun
 */
@WebServlet(name = "searchreader",urlPatterns = {"/searchreader"})
public class searchreader extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset = UTF-8");
        String condition = request.getParameter("condition");
        String key = request.getParameter("key");    
            List<Reader> readers = ReaderDaoFactory.getReaderDao().searchReaderbyreaderid(condition,key); 
            request.setAttribute("readers", readers);
            //第一种方式:转发 携带数据 地址栏不发生变化
            request.getRequestDispatcher("searchreader.jsp").forward(request, response);
        
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
    
}
