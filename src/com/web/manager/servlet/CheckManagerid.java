/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.manager.servlet;

import com.web.test.DaoFactory;
import com.web.model.Manager;
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
@WebServlet(name = "CheckManagerid",urlPatterns = {"/CheckManagerid"})
public class CheckManagerid extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset = UTF-8");
        PrintWriter out = response.getWriter();
        String managerid = request.getParameter("managetid");
        Manager manager = DaoFactory.getManagerDao().getManager(managerid);
        if(manager != null){
            //管理员存在
            out.println("{\"getdata\":\"false\"}");
        }else{
            //管理员不存在
            out.println("{\"getdata\":\"true\"}");
        }
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
    
}
