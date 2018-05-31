/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.test;

import com.web.dao.IsManager;
import com.web.dao.impl.ManagerDao;

/**
 *
 * @author pichaojun
 */
public class DaoFactory {
    public static IsManager getManagerDao() {
        return new ManagerDao();
    }
    
}
