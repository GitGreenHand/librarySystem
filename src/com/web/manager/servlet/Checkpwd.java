/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.manager.servlet;

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
@WebServlet(name = "Checkpwd",urlPatterns = {"/Checkpwd"})
public class Checkpwd extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html;charset = UTF-8");
       PrintWriter out = response.getWriter();
       String managerpwd = request.getParameter("managerpwd");
       String managerpwd1 = request.getParameter("managerpwd1");
       if (managerpwd.equals("managerpwd1")){
           out.println("{\"getdata\":\"true\"}");
        }else{
           out.println("{\"getdata\":\"false\"}");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
    
    
}
