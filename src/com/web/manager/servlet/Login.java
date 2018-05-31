/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.manager.servlet;

import com.web.util.DatabaseJDBC;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pichaojun
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");      
            String managerid = request.getParameter("managerid");
            String managerpwd = request.getParameter("managerpwd");
//            if(userid.equals("admin")&&password.equals("123456")){
//               // response.sendRedirect("welcome.jsp");        
//                request.setAttribute("info1", userid);
//                request.getRequestDispatcher("welcome.jsp").forward(request, response);
//            }
            conn = DatabaseJDBC.getConnection();
            psmt = conn.prepareStatement("select * from managers where managerid = ? and managerpwd = ?");
            psmt.setString(1, managerid);
            psmt.setString(2,managerpwd);
            rs = psmt.executeQuery();      
            if(rs.next()){//rs.next时，游标最先是指向第一条记录前的位置，所以第一次rs.next后，游标指向的正好是第一条记录（如果有的话）   
                request.getSession().setAttribute("info1", managerid);
                //request.setAttribute("info1", managerid);
                request.getRequestDispatcher("welcome.jsp").forward(request, response);
//                response.sendRedirect("welcome.jsp"); 
            }else{
                String message = "非法的用户名和密码，请核对后重新登陆";
                request.setAttribute("message",message);
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
