<%-- 
    Document   : addbook
    Created on : 2017-6-17, 22:49:05
    Author     : pichaojun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mybooktag" uri="/WEB-INF/tlds/mybooktag" %>
<!DOCTYPE html>
<html>
    <head>
        <title>湖北汽车工业学院图书馆</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/pintuer.css">
        <script src="js/jquery.js"></script>
        <script src="js/pintuer.js"></script>
    </head>
    <body class = "bg-green-light"> 
        <!--头部开始-->
        <%@include file = "WEB-INF/jspf/header.jspf" %>
        <!--头部结束-->
        <!--内容开始--> 
        <div class="container padding-big-top padding-big-bottom ">
            <div class="line">
                <div class="xl12 xs3 xm3 xb1">
                    <ul class="nav nav-menu nav-navicon" >
                        <li class = "active"><a href="displaymanager">管理员管理<span class = "arrow"></span></a>
                            <ul class = "drop-menu">       
                                <li><a href="addmanager.jsp">添加管理员</a></li>
                            </ul>
                        </li>

                        <li class="active"><a href="displaybook">图书管理<span class="arrow"></span></a>
                            <ul class="drop-meun">
                                <li><a href="addbook.jsp">添加图书</a> </li>                         
                            </ul>
                        </li>      
                        
                        <li class="active"><a href="diaplayreader">读者管理<span class="arrow"></span></a>
                            <ul class="drop-meun">
                                <li><a href="addreader.jsp">添加读者</a> </li>                         
                            </ul>
                        </li> 
                        <li class="active"><a href="borrowinfo">借阅列表<span class="arrow"></span></a>
                            <ul class="drop-meun">
                                <li><a href="borrowbook.jsp">图书借阅</a> </li>  
                                <li><a href="returnbook.jsp">图书归还</a> </li>
                            </ul>
                        </li> 
                    </ul>
                </div>
                
                <div class="xl12 xs1-left xm9 xb9 padding-small-top">
                    <div class="margin-big-left padding-big">
                        <form method="post" action="addbook">
                            <div class="form-group">
                                <div class="label">
                                    <label for="bookno">图书编号</label>
                                </div>
                                <div class="field">
                                    <input type="text" class="input" id="bookno" name="bookno" size="50" placeholder="图书编号" data-validate="required:必填,length#==8:id长度为8,ajax#Checkbookno?bookno=:图书编号已存在"/>
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <div class="label">
                                    <label for="bookname">图书名称</label>
                                </div>
                                <div class="field">
                                    <input type="text" class="input" id="bookname" name="bookname" size="50" placeholder="图书名称" data-validate="required:必填"/>
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <div class="label">
                                    <label for="author">图书作者</label>
                                </div>
                                <div class="field">
                                    <input type="text" class="input" id="author" name="author" size="50" placeholder="图书作者" data-validate="required:必填"/>
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <div class="label">
                                    <label for="publish">图书出版社</label>
                                </div>
                                <div class="field">
                                    <select class="input" name="publish">
                                        <mybooktag:publishtag publish="${book.publish}" />
                                    </select>
                                </div>
                            </div>
                                    
                            <div class="form-group">
                                <div class="label">
                                    <label for="bookisbn">图书ISBN编号</label>
                                </div>
                                <div class="field">
                                    <input type="text"  class="input" id="bookisbn" name="bookisbn" size="50" placeholder="图书ISBN编号" data-validate="required:必填,length#==10:id长度为10"/>
                                </div>
                            </div>
                                    
                            <div class="form-group">
                                <div class="label">
                                    <label for="bookprices">图书价格</label>
                                </div>
                                <div class="field">
                                    <input type="text" class="input" id="bookprices" name="bookprices" size="50" placeholder="图书价格" data-validate="required:必填"/>
                                </div>
                            </div>
                                    
                           <div class="form-group">
                                <div class="label">
                                    <label for="bookstatus">是否可借</label>
                                </div>
                                <div class="field">
                                    <div class="button-group radio">
                                        
                                            <label class="button active">
                                                <input name="bookstatus" value="可借" checked="checked" type="radio"><span class="icon icon-check-circle"></span> 可借
                                            </label>
                                            <label class="button">
                                                <input name="bookstatus" value="非可借" type="radio"><span class="icon icon-times-circle"></span> 非可借
                                            </label>                                    
                                    </div>
                                </div>
                            </div>  
                                              
                            <div class="form-button">
                                <button class="button" type="submit">提交</button>
                            </div>
                                    
                        </form>

                    </div>
                </div>       
            </div>
        </div>
        <!--内容结束-->
        <!--底部开始-->
        <%@include file = "WEB-INF/jspf/footer.jspf" %>
        <!--底部结束-->
    </body>
</html>
