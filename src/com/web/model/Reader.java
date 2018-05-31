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
public class Reader {
    private String readerid;
    private String readername;
    private String readersex;
    private int  readerage;
    private String readerclass;
    private String readerdept;
    private String readerpermitted;
    
    public Reader(){
    
    }
    
    public Reader(String readerid,String readername,String readersex,int  readerage,String readerclass,String readerdept,String readerpermitted){
        this.readerid = readerid;
        this.readername = readername;
        this.readersex = readersex;
        this.readerage = readerage;
        this.readerclass = readerclass;
        this.readerdept = readerdept;
        this.readerpermitted = readerpermitted;    
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
     * @return the readersex
     */
    public String getReadersex() {
        return readersex;
    }

    /**
     * @param readersex the readersex to set
     */
    public void setReadersex(String readersex) {
        this.readersex = readersex;
    }

    /**
     * @return the readerage
     */
    public int getReaderage() {
        return readerage;
    }

    /**
     * @param readerage the readerage to set
     */
    public void setReaderage(int readerage) {
        this.readerage = readerage;
    }

    /**
     * @return the readerclass
     */
    public String getReaderclass() {
        return readerclass;
    }

    /**
     * @param readerclass the readerclass to set
     */
    public void setReaderclass(String readerclass) {
        this.readerclass = readerclass;
    }

    /**
     * @return the readerdept
     */
    public String getReaderdept() {
        return readerdept;
    }

    /**
     * @param readerdept the readerdept to set
     */
    public void setReaderdept(String readerdept) {
        this.readerdept = readerdept;
    }

    /**
     * @return the readerpermitted
     */
    public String getReaderpermitted() {
        return readerpermitted;
    }

    /**
     * @param readerpermitted the readerpermitted to set
     */
    public void setReaderpermitted(String readerpermitted) {
        this.readerpermitted = readerpermitted;
    }
}
