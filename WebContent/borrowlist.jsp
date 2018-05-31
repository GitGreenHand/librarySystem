<%-- 
    Document   : borrowlist
    Created on : 2017-6-20, 15:38:28
    Author     : pichaojun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <div class="margin-big-left">
                    <table class="table table-striped">     
                            <tr>
                                <th>读者id</th> 
                                <th>读者姓名</th> 
                                <th>图书编号</th>                         
                                <th>图书名称</th>                         
                                <th>借阅时间</th>
                                <th>归还时间</th>       
                            </tr>
                            <c:forEach var="borrowinfo" items="${borrowinfos}">
                                <tr>
                                    <td>${borrowinfo.readerid}</td>     
                                    <td>${borrowinfo.readername}</td>     
                                    <td>${borrowinfo.bookno}</td> 
                                    <td>${borrowinfo.bookname}</td> 
                                    <td>${borrowinfo.starttime}</td> 
                                    <td>${borrowinfo.endtime}</td>         
                                </tr>
                            </c:forEach>
                        </table>
                         <div class="margin-big-top text-center height-big">
                            ${pagination.pageBar} ${pagination.numPageBar}
                        </div>
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
