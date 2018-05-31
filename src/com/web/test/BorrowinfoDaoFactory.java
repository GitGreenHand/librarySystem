/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.test;

import com.web.dao.Isborrowinfo;
import com.web.dao.impl.BorrowinfoDao;

/**
 *
 * @author pichaojun
 */
public class BorrowinfoDaoFactory {
    public static Isborrowinfo getIsborrowinfoDao(){
        return new BorrowinfoDao();
    }
}
