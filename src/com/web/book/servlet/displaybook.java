/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.book.servlet;

import com.web.test.BookDaoFactory;
import com.web.model.Book;
import com.web.util.Pagination;
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
@WebServlet(name = "displaybook",urlPatterns = {"/displaybook"})
public class displaybook extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset = UTFF-8");
        String pageNo = request.getParameter("pageNo");
        int page = 1;
        if(pageNo != null) {
            page = Integer.parseInt(pageNo);
        }
        
        Pagination pagination = new Pagination();
        pagination.setPageNo(page);
        pagination.setUrl("displaybook?");
        
        List<Book> books = BookDaoFactory.getBookDao().getAllBook(pagination);
       
        request.setAttribute("books", books);
        request.setAttribute("pagination", pagination);
        
        //第一种方式:转发 携带数据 地址栏不发生变化
        request.getRequestDispatcher("displaybook.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response); 
    }
    
    
}
