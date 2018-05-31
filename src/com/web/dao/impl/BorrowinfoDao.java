/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.dao.impl;

import com.web.dao.Isborrowinfo;
import com.web.model.Borrowinfo;
import com.web.util.DatabaseJDBC;
import com.web.util.Pagination;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;

/**
 *
 * @author pichaojun
 */
public class BorrowinfoDao implements Isborrowinfo{
    Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;
    @Override
    public List<Borrowinfo> getAllborrowinfo(Pagination pagination) {
        List<Borrowinfo> borrowinfos = new ArrayList<Borrowinfo>();
       try {
            conn = DatabaseJDBC.getConnection();
            psmt = conn.prepareStatement("select count(*) as counts from borrowinfo");
            rs = psmt.executeQuery();
            rs.next();
            //求总记录数
            pagination.setCountSize(rs.getInt("counts"));
            int start = (pagination.getPageNo() - 1) * pagination.getPageSize() + 1;//开始位置
            int end = pagination.getPageNo() * pagination.getPageSize();//结束位置
            psmt = conn.prepareStatement("SELECT * FROM (SELECT ROWNUM NO , s.* FROM (select reader.readerid,reader.readername,book.bookno,book.bookname, borrowinfo.starttime,borrowinfo.endtime from reader,book,borrowinfo where reader.readerid=borrowinfo.readerid and book.bookno = borrowinfo.bookno) s WHERE ROWNUM<=?) WHERE NO>=?");
            psmt.setInt(1, end);
            psmt.setInt(2, start);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Borrowinfo borrowinfo = new Borrowinfo();
                borrowinfo.setReaderid(rs.getString("readerid"));
                borrowinfo.setReadername(rs.getString("readername"));
                borrowinfo.setBookno(rs.getString("bookno"));
                borrowinfo.setBookname(rs.getString("bookname"));
                borrowinfo.setStarttime(rs.getString("starttime"));
                borrowinfo.setEndtime(rs.getString("endtime"));
                borrowinfos.add(borrowinfo);
            }
        }catch (SQLException ex) {
            Logger.getLogger(BorrowinfoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseJDBC.Close(rs, psmt, conn);
        }
        return borrowinfos;
    }

    @Override
    public List<Borrowinfo> getAllborrowinfo() {
         List<Borrowinfo> borrowinfos = new ArrayList<Borrowinfo>();
       try {
            conn = DatabaseJDBC.getConnection();
            psmt = conn.prepareStatement("SELECT * FROM (SELECT ROWNUM NO , s.* FROM (select reader.readername,book.bookname, borrowinfo.starttime,borrowinfo.endtime from reader,book,borrowinfo where reader.readerid=borrowinfo.readerid and book.bookno = borrowinfo.bookno) s WHERE ROWNUM<=?) WHERE NO>=?");
            rs = psmt.executeQuery();
            while (rs.next()) {
                Borrowinfo borrowinfo = new Borrowinfo();
                borrowinfo.setReaderid(rs.getString("readerid"));
                borrowinfo.setReadername(rs.getString("readername"));
                borrowinfo.setBookno(rs.getString("bookno"));
                borrowinfo.setBookname(rs.getString("bookname"));
                borrowinfo.setStarttime(rs.getString("starttime"));
                borrowinfo.setEndtime(rs.getString("endtime"));
                borrowinfos.add(borrowinfo);
            }
        }catch (SQLException ex) {
            Logger.getLogger(BorrowinfoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseJDBC.Close(rs, psmt, conn);
        }
        return borrowinfos;
    }

    @Override
    public void Borrowbook(Borrowinfo borrowinfo) {
        try {
            conn = DatabaseJDBC.getConnection();
            psmt = conn.prepareStatement("insert into  borrowinfo values (?,?,?,?) ");
            psmt.setString(1, borrowinfo.getReaderid());
            psmt.setString(2, borrowinfo.getBookno());
            psmt.setString(3, borrowinfo.getStarttime());
            psmt.setString(4, borrowinfo.getEndtime());
            psmt.executeQuery();
        } catch (SQLException e) {
            Logger.getLogger(BorrowinfoDao.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            DatabaseJDBC.Close(rs, psmt, conn);
        }
    }

    @Override
    public void returnbook(String bookno) {
        try {
            conn = DatabaseJDBC.getConnection();
            psmt = conn.prepareStatement("delete from borrowinfo where bookno = ?");
            psmt.setString(1, bookno);
            psmt.executeQuery();
        } catch (SQLException e) {
            Logger.getLogger(BorrowinfoDao.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            DatabaseJDBC.Close(rs, psmt, conn);
        }
    }

}
