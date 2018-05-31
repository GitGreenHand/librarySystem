<%-- 
    Document   : welcome
    Created on : 2017-6-12, 17:37:01
    Author     : pichaojun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
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
       
         <div class = "line">
             <h1><p align="center"><span class="text-red"><%=request.getSession().getAttribute("info1")%></span></p></h1>
        </div>
       
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
                                <li><a href="addmanager.jsp">添加读者</a> </li>                         
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

                <div class="xl12 xs9 xm9 xb9 padding-small-top">
                    <div class="margin-big-left">
                        <h1><p align="center">&nbsp&nbspWelcome 欢迎登陆图书馆  </p></h1>       
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
