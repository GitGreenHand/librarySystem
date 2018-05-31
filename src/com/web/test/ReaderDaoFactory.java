/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.test;

import com.web.dao.IsReader;
import com.web.dao.impl.ReaderDao;

/**
 *
 * @author pichaojun
 */
public class ReaderDaoFactory {
    public static IsReader getReaderDao(){
        return new ReaderDao();     
    }  
}
