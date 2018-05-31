/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.borrowinfo.servlet;

import com.web.test.BookDaoFactory;
import com.web.test.BorrowinfoDaoFactory;
import com.web.test.ReaderDaoFactory;
import com.web.model.Book;
import com.web.model.Borrowinfo;
import com.web.util.DateUtil;
import com.web.model.Reader;
import java.io.IOException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pichaojun
 */
@WebServlet(name = "borrowbook",urlPatterns = {"/borrowbook"})
public class borrowbook extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset = UTF-8");
        String readerid = request.getParameter("readerid");
        String bookno = request.getParameter("bookno");
        String days = request.getParameter("days");
        Book book =BookDaoFactory.getBookDao().getBook(bookno);
        Reader reader = ReaderDaoFactory.getReaderDao().getReader(readerid);
        String bookstatus = book.getBookstatus();
        String readerpermitted = reader.getReaderpermitted();
        String flag = null;
        String starttime = null;
        String endtime = null;
        Borrowinfo borrowinfo = new Borrowinfo();
        if(readerpermitted.equals("可以借书")){
            if(bookstatus.equals("可借")){
                Calendar now = Calendar.getInstance();
                starttime = DateUtil.getDateString(now);
                endtime = DateUtil.addSomeDay(starttime, Integer.parseInt(days));  
                borrowinfo.setReaderid(readerid);
                borrowinfo.setBookno(bookno);
                borrowinfo.setStarttime(starttime);
                borrowinfo.setEndtime(endtime);   
                BorrowinfoDaoFactory.getIsborrowinfoDao().Borrowbook(borrowinfo); 
                BookDaoFactory.getBookDao().updatabookstatus(bookno, "不可借");
                response.sendRedirect(request.getContextPath() + "/borrowinfo");
            }else{
                flag = "22";//该书不可借
                request.setAttribute("flag", flag);
                request.getRequestDispatcher("borrowbook.jsp").forward(request, response); 
            }   
        }else {
           flag = "11"; //该读者没有借书权限
           request.setAttribute("flag", flag);
           request.getRequestDispatcher("borrowbook.jsp").forward(request, response); 
        }
             
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
    
}
