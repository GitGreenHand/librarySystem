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
public class Manager {
    private String managerid;
    private String managerpwd;
    
    public Manager() {
    }
     public Manager(String managerid, String managerpwd) {
        this.managerid = managerid;
        this.managerpwd = managerpwd;
    }

    /**
     * @return the managerid
     */
    public String getManagerid() {
        return managerid;
    }

    /**
     * @param managerid the managerid to set
     */
    public void setManagerid(String managerid) {
        this.managerid = managerid;
    }

    /**
     * @return the managerpwd
     */
    public String getManagerpwd() {
        return managerpwd;
    }

    /**
     * @param managerpwd the managerpwd to set
     */
    public void setManagerpwd(String managerpwd) {
        this.managerpwd = managerpwd;
    }
  
}
