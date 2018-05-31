/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.dao.impl;

import com.web.dao.IsReader;
import com.web.util.DatabaseJDBC;
import com.web.util.Pagination;
import com.web.model.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pichaojun
 */
public class ReaderDao implements IsReader{
    Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;

    @Override
    public List<Reader> getAllReader(Pagination pagination) {
        List<Reader> readers = new ArrayList<Reader>();
        try {
            conn = DatabaseJDBC.getConnection();
            psmt = conn.prepareStatement("select count(*) as counts from reader");
            rs = psmt.executeQuery();
            rs.next();
            //求总记录数
            pagination.setCountSize(rs.getInt("counts"));
            int start = (pagination.getPageNo() - 1) * pagination.getPageSize() + 1;//开始位置
            int end = pagination.getPageNo() * pagination.getPageSize();//结束位置
            psmt = conn.prepareStatement("SELECT * FROM (SELECT ROWNUM NO , s.* FROM (SELECT * FROM reader ORDER BY readerid ASC) s WHERE ROWNUM<=?) WHERE NO>=?");
            psmt.setInt(1, end);
            psmt.setInt(2, start);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Reader reader = new Reader();
                reader.setReaderid(rs.getString("readerid"));
                reader.setReadername(rs.getString("readername"));
                reader.setReadersex(rs.getString("readersex"));
                reader.setReaderage(rs.getInt("readerage"));
                reader.setReaderclass(rs.getString("readerclass"));
                reader.setReaderdept(rs.getString("readerdept"));
                reader.setReaderpermitted(rs.getString("readerpermitted"));
                readers.add(reader);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReaderDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseJDBC.Close(rs, psmt, conn);
        }
        return readers;
    }

    @Override
    public List<Reader> searchReaderbyreaderid(String condition, String key) {
         List<Reader> readers = new ArrayList<Reader>();
         String sql = null;
         if(condition.equals("readerid")){
             sql = "SELECT * FROM reader where readerid = ?";
         }
         if(condition.equals("readername")){
             sql = "SELECT * FROM reader where readername = ?";
         }
         if(condition.equals("readerclass")){
             sql = "SELECT * FROM reader where readerclass = ?";
         }
          if(condition.equals("readerdept")){
             sql = "SELECT * FROM reader where readerdept = ?";
         }
        try {
            conn = DatabaseJDBC.getConnection(); 
            //求总记录数
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, key);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Reader reader = new Reader();
                reader.setReaderid(rs.getString("readerid"));
                reader.setReadername(rs.getString("readername"));
                reader.setReadersex(rs.getString("readersex"));
                reader.setReaderage(rs.getInt("readerage"));
                reader.setReaderclass(rs.getString("readerclass"));
                reader.setReaderdept(rs.getString("readerdept"));
                reader.setReaderpermitted(rs.getString("readerpermitted"));
                readers.add(reader);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseJDBC.Close(rs, psmt, conn);
        }
        return readers;
    }

    @Override
    public void deleteBook(String readerid) {
        try {
            conn = DatabaseJDBC.getConnection();
            psmt = conn.prepareStatement("delete from reader where readerid = ?");
            psmt.setString(1, readerid);
            psmt.executeUpdate();         
        } catch (SQLException exception) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, exception);
        }finally{
            DatabaseJDBC.Close(rs, psmt, conn);
        }
    }

    @Override
    public Reader getReader(String readerid) {
       Reader reader = null;
        try {
            conn = DatabaseJDBC.getConnection();
            psmt = conn.prepareStatement("select * from reader where readerid=? ");
            psmt.setString(1, readerid);
            rs = psmt.executeQuery();
            while (rs.next()) {
                reader = new Reader();
                reader.setReaderid(rs.getString("readerid"));
                reader.setReadername(rs.getString("readername"));
                reader.setReadersex(rs.getString("readersex"));
                reader.setReaderage(rs.getInt("readerage"));
                reader.setReaderclass(rs.getString("readerclass"));
                reader.setReaderdept(rs.getString("readerdept"));
                reader.setReaderpermitted(rs.getString("readerpermitted"));  
            }
        } catch (SQLException exception) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, exception);
        }finally{
            DatabaseJDBC.Close(rs, psmt, conn);
        }
        return reader;
    }

    @Override
    public void updateReaderinfo(Reader reader) {
        try {
            conn = DatabaseJDBC.getConnection();
            psmt = conn.prepareStatement("update reader set readername=?,readersex =?,readerage=?,readerclass=?,readerdept=?,readerpermitted=? where readerid=?");
            
            psmt.setString(1, reader.getReadername());
            psmt.setString(2,reader.getReadersex());
            psmt.setInt(3, reader.getReaderage());
            psmt.setString(4, reader.getReaderclass());
            psmt.setString(5, reader.getReaderdept());
            psmt.setString(6, reader.getReaderpermitted());
            psmt.setString(7, reader.getReaderid());
            
            psmt.executeUpdate();
        } catch (SQLException exception) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null,exception);
        }finally{
            DatabaseJDBC.Close(rs, psmt, conn);
        }
    }

    @Override
    public void addReader(Reader reader) {
        try {
            conn = DatabaseJDBC.getConnection();
            psmt = conn.prepareStatement("insert into reader values(?,?,?,?,?,?,?)");
            psmt.setString(1, reader.getReaderid());
            psmt.setString(2, reader.getReadername());
            psmt.setString(3, reader.getReadersex());
            psmt.setInt(4, reader.getReaderage());
            psmt.setString(5, reader.getReaderclass());
            psmt.setString(6, reader.getReaderdept());
            psmt.setString(7, reader.getReaderpermitted());
            psmt.executeQuery();
        } catch (SQLException exception) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null,exception);
        }finally{
            DatabaseJDBC.Close(rs, psmt, conn);
        }
    }


}
