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
import javax.naming.ldap.ManageReferralControl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pichaojun
 */
@WebServlet(name = "addmanager", urlPatterns = {"/addmanager"})
public class addmanager extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); 
        String message = null;
        String managerid = request.getParameter("managerid");
        String managerpwd = request.getParameter("managerpwd");
        String managerpwd1 = request.getParameter("managerpwd1");
        if (managerpwd.equals(managerpwd1)) { 
            Manager manager = new Manager();
            manager.setManagerid(managerid);
            manager.setManagerpwd(managerpwd);
            DaoFactory.getManagerDao().AddManager(manager);
            response.sendRedirect(request.getContextPath() + "/displaymanager");
            
        } else {
            message = "密码不一致";
            request.setAttribute("message", message);
            request.getRequestDispatcher("addmanager.jsp").forward(request, response);
        }
        
       
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
    
}
