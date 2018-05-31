/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.dao;

import com.web.model.Manager;
import com.web.util.Pagination;
import java.util.List;

/**
 *
 * @author pichaojun
 */
public interface IsManager {
    public List<Manager> getAllManager();
    public List<Manager>getAllManager(Pagination pagination);
    public void DeleteManager(String managerid); 
    public void AddManager(Manager manager);
    public Manager getManager(String managerid);
}
