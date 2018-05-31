/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.dao.impl;

import com.web.dao.IsManager;
import com.web.util.DatabaseJDBC;
import com.web.model.Manager;
import com.web.util.Pagination;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.jasper.compiler.JspUtil;

/**
 *
 * @author pichaojun
 */
public class ManagerDao implements IsManager {

    Connection connection = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;

    @Override
    public List<Manager> getAllManager() {
        List<Manager> managers = new ArrayList<Manager>();
        try {
            connection = DatabaseJDBC.getConnection();
            psmt = connection.prepareStatement("select * from managers");
            rs = psmt.executeQuery();
            while (rs.next()) {
                Manager manager = new Manager();
                manager.setManagerid(rs.getString("managerid"));
                manager.setManagerpwd(rs.getString("managerpwd"));         
                managers.add(manager);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagerDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            DatabaseJDBC.Close(rs, psmt, connection);
        }
        return managers;
    }

    @Override
    public List<Manager> getAllManager(Pagination pagination) {
         List<Manager> managers = new ArrayList<Manager>();
        try {
            connection = DatabaseJDBC.getConnection();
            psmt = connection.prepareStatement("select count(*) as counts from managers");
            rs = psmt.executeQuery();
            rs.next();
            //求总记录数
            pagination.setCountSize(rs.getInt("counts"));
            int start = (pagination.getPageNo() - 1) * pagination.getPageSize() + 1;//开始位置
            int end = pagination.getPageNo() * pagination.getPageSize();//结束位置
            psmt = connection.prepareStatement("SELECT * FROM (SELECT ROWNUM NO , s.* FROM (SELECT * FROM managers ORDER BY managerid ASC) s WHERE ROWNUM<=?) WHERE NO>=?");
            psmt.setInt(1, end);
            psmt.setInt(2, start);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Manager manager = new Manager();
                manager.setManagerid(rs.getString("managerid"));
                manager.setManagerpwd(rs.getString("managerpwd"));
                managers.add(manager);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseJDBC.Close(rs, psmt, connection);
        }
        return managers;
    }

    @Override
    public void DeleteManager(String managerid) {
        try {
        connection = DatabaseJDBC.getConnection();
        psmt = connection.prepareStatement("delete from managers where managerid = ?");
        psmt.setString(1, managerid);
        psmt.executeUpdate();     
        } catch (SQLException exception) {
            Logger.getLogger(ManagerDao.class.getName()).log(Level.SEVERE,null,exception);
        }finally{
            DatabaseJDBC.Close(rs, psmt, connection);
        }
    }

    @Override
    public void AddManager(Manager manager) {
        try {
            connection = DatabaseJDBC.getConnection();
            psmt = connection.prepareStatement("insert into managers values(?,?)");
            psmt.setString(1,manager.getManagerid());
            psmt.setString(2,manager.getManagerpwd());
            psmt.executeUpdate();

        } catch (SQLException exception) {
            Logger.getLogger(ManagerDao.class.getName()).log(Level.SEVERE, null, exception);
        } finally {
            DatabaseJDBC.Close(rs, psmt, connection);
        }
    }

    @Override
    public Manager getManager(String managerid) {
        Manager manager = null;
        try {
            connection = DatabaseJDBC.getConnection();
            psmt = connection.prepareStatement("select * from managers where managerid = ?");
            psmt.setString(1, managerid);
            rs = psmt.executeQuery();
            while(rs.next()){
                manager = new Manager();
                manager.setManagerid(rs.getString("managerid"));
                manager.setManagerpwd(rs.getString("managerpwd"));
               }
            
        } catch (SQLException exception) {
            Logger.getLogger(ManagerDao.class.getName()).log(Level.SEVERE, null, exception);
        }finally{
            DatabaseJDBC.Close(rs, psmt, connection);
        }
        return manager;
    }
 

}
