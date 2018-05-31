/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.dao;

import com.web.util.Pagination;
import com.web.model.Reader;
import java.util.List;

/**
 *
 * @author pichaojun
 */
public interface IsReader {
    public List<Reader> getAllReader(Pagination pagination);
    public List<Reader> searchReaderbyreaderid(String condition,String key);
    public void deleteBook(String readerid);
    public Reader getReader(String readerid);
    public void updateReaderinfo(Reader reader);
    public void addReader(Reader reader);
}
