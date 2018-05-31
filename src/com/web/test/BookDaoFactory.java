/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.test;

import com.web.dao.IsBook;
import com.web.dao.impl.BookDao;

/**
 *
 * @author pichaojun
 */
public class BookDaoFactory {
    public static IsBook getBookDao(){
        return new BookDao();
    }
    
}
