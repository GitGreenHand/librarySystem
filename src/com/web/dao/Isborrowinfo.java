/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.dao;

import com.web.model.Borrowinfo;
import com.web.util.Pagination;
import java.util.List;

/**
 *
 * @author pichaojun
 */
public interface Isborrowinfo {
    public List<Borrowinfo> getAllborrowinfo(Pagination pagination);
    public List<Borrowinfo> getAllborrowinfo();
    public void Borrowbook(Borrowinfo borrowinfo);
    public void returnbook(String bookno);
}
