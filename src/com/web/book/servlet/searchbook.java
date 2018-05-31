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
@WebServlet(name = "searchbook", urlPatterns = {"/searchbook"})
public class searchbook extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text.html ; charset = UTF-8");
        String flag = null;
        String condition = request.getParameter("condition");
        String key = request.getParameter("key");
        //String str = condition + " " + key;
        //request.setAttribute("str", str);
        //request.getRequestDispatcher("search.jsp").forward(request, response);
        if (condition.equals("bookno")) {
            flag = "11";
            Book book = BookDaoFactory.getBookDao().getBook(key);    
            request.setAttribute("flag", flag);
            request.setAttribute("book", book);
            request.getRequestDispatcher("search.jsp").forward(request, response);
        }
        
        if (condition.equals("bookname")) {
            flag = null;
            String pageNo = request.getParameter("pageNo");
            int page = 1;
            if (pageNo != null) {
                page = Integer.parseInt(pageNo);
            }

            Pagination pagination = new Pagination();
            pagination.setPageNo(page);
            pagination.setUrl("displaybook?");

            List<Book> books = BookDaoFactory.getBookDao().getBookinfobyname(pagination, key);

            request.setAttribute("flag", flag);
            request.setAttribute("books", books);
            request.setAttribute("pagination", pagination);

            //第一种方式:转发 携带数据 地址栏不发生变化
            request.getRequestDispatcher("search.jsp").forward(request, response);
        }
        
        if(condition.equals("author")){
            flag = null;
            String pageNo = request.getParameter("pageNo");
            int page = 1;
            if (pageNo != null) {
                page = Integer.parseInt(pageNo);
            }

            Pagination pagination = new Pagination();
            pagination.setPageNo(page);
            pagination.setUrl("displaybook?");

            List<Book> books = BookDaoFactory.getBookDao().getBookinfobyauthor(pagination, key);

            request.setAttribute("flag", flag);
            request.setAttribute("books", books);
            request.setAttribute("pagination", pagination);

            //第一种方式:转发 携带数据 地址栏不发生变化
            request.getRequestDispatcher("search.jsp").forward(request, response);
        }
        if(condition.equals("publish")){
            flag = null;
            String pageNo = request.getParameter("pageNo");
            int page = 1;
            if (pageNo != null) {
                page = Integer.parseInt(pageNo);
            }

            Pagination pagination = new Pagination();
            pagination.setPageNo(page);
            pagination.setUrl("displaybook?");

            List<Book> books = BookDaoFactory.getBookDao().getBookinfobypublish(pagination, key);

            request.setAttribute("flag", flag);
            request.setAttribute("books", books);
            request.setAttribute("pagination", pagination);

            //第一种方式:转发 携带数据 地址栏不发生变化
            request.getRequestDispatcher("search.jsp").forward(request, response);
        }    
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
