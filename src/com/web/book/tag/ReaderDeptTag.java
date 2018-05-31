/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.book.tag;

/**
 *
 * @author pichaojun
 */
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author pichaojun
 */
public class ReaderDeptTag extends SimpleTagSupport{
    public static final String[] Reader_Dept = {"计算机系", "自动化系", "外语系"};
    
    private String readerdept;

    public String getReaderdept() {
        return readerdept;
    }

    public void setReaderdept(String readerdept) {
        this.readerdept = readerdept;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        StringBuilder str = new StringBuilder();
        for (String s : Reader_Dept) {
            if (s.equals(readerdept)) {
                str.append("<option value='").append(s).append("' selected>").append(s).append("</option>");
            } else {
                str.append("<option value='").append(s).append("'>").append(s).append("</option>");
            }
        }
        out.print(str.toString());
    }
}

