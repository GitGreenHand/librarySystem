<%-- 
    Document   : addmanager
    Created on : 2017-6-16, 16:19:42
    Author     : pichaojun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-cn">
    <head>
        <title>添加管理员</title>
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
                        <form method="post" action="addmanager">
                            <div class="form-group">
                                <div class="label">
                                    <label for="sno">管理员id</label>
                                </div>
                                <div class="field">
                                    <input type="text" class="input" id="managerid" name="managerid" size="50" placeholder="管理员id" data-validate="required:必填,length#==5:id长度为5,ajax#CheckManagerid?managetid=:管理员已存在"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="label">
                                    <label for="managerpwd">管理员登陆密码</label>
                                </div>
                                <div class="field">
                                    <input type="password" class="input" id="managerpwd" name="managerpwd" size="50" placeholder="管理员登陆密码" data-validate="required:必填,length#==6:id长度为6"/>
                                </div>
                            </div>       
                             <div class="form-group">
                                <div class="label">
                                    <label for="managerpwd">再次输入登陆密码</label>
                                </div>
                                <div class="field">
                                    <input type="password" class="input" id="managerpwd1" name="managerpwd1" size="50" placeholder="再次输入登陆密码" data-validate="required:必填,length#==6:id长度为6"/>
                                </div>
                            </div>   
                            <div>
                                <%
                                    String message = (String) request.getAttribute("message");
                                    if(message != null){
                                %>
                               <script lang="javascript">
                                   alert("密码不一致!");
                               </script>
                                <%
                                    }
                                %>
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
