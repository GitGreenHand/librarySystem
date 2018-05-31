/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.manager.servlet;

import com.web.test.DaoFactory;
import com.web.model.Manager;
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
@WebServlet(name = "displaymanager", urlPatterns = {"/displaymanager"})
public class displaymanager extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
        String pageNo = request.getParameter("pageNo");
        int page = 1;
        if(pageNo != null) {
            page = Integer.parseInt(pageNo);
        }
        
        Pagination pagination = new Pagination();
        pagination.setPageNo(page);
        pagination.setUrl("displaymanager?");
        
        List<Manager> managers = DaoFactory.getManagerDao().getAllManager(pagination);
        request.setAttribute("managers", managers);
        request.setAttribute("pagination", pagination);
        
        //第一种方式:转发 携带数据 地址栏不发生变化
        request.getRequestDispatcher("DisplayManager.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
   
    
}
