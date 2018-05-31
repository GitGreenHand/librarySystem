/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.book.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author pichaojun
 */
public class PublishTag extends SimpleTagSupport{
    public static final String[] BOOK_PUBLISH = {"电子工业出版社", "外语教学与研究出版社", "清华大学出版社","北京邮电大学出版社",
                                                  "科学出版社","高等教育出版社","机械工业出版社"};
    
    private String publish;

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        StringBuilder str = new StringBuilder();
        for (String s : BOOK_PUBLISH) {
            if (s.equals(publish)) {
                str.append("<option value='").append(s).append("' selected>").append(s).append("</option>");
            } else {
                str.append("<option value='").append(s).append("'>").append(s).append("</option>");
            }
        }
        out.print(str.toString());
    }
}
