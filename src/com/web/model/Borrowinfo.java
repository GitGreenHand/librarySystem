/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.model;

/**
 *
 * @author pichaojun
 */
public class Borrowinfo {
    private String readerid;
    private String readername;
    private String bookno;
    private String bookname;
    private String starttime;
    private String endtime;
    public Borrowinfo(){
    }
    public Borrowinfo(String readerid,String readername,String bookno,String bookname,String starttime,String endtime){
        this.readerid = readerid;
        this.readername = readername;
        this.bookno = bookno;
        this.bookname = bookname;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    /**
     * @return the readerid
     */
    public String getReaderid() {
        return readerid;
    }

    /**
     * @param readerid the readerid to set
     */
    public void setReaderid(String readerid) {
        this.readerid = readerid;
    }

    /**
     * @return the readername
     */
    public String getReadername() {
        return readername;
    }

    /**
     * @param readername the readername to set
     */
    public void setReadername(String readername) {
        this.readername = readername;
    }

    /**
     * @return the boonno
     */
    public String getBookno() {
        return bookno;
    }

    /**
     * @param boonno the boonno to set
     */
    public void setBookno(String bookno) {
        this.bookno = bookno;
    }

    /**
     * @return the bookname
     */
    public String getBookname() {
        return bookname;
    }

    /**
     * @param bookname the bookname to set
     */
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    /**
     * @return the starttime
     */
    public String getStarttime() {
        return starttime;
    }

    /**
     * @param starttime the starttime to set
     */
    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    /**
     * @return the endtime
     */
    public String getEndtime() {
        return endtime;
    }

    /**
     * @param endtime the endtime to set
     */
    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }
    
}
