<%-- 
    Document   : Displaymanager
    Created on : 2017-6-14, 16:18:06
    Author     : pichaojun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-cn">
     <head>
         <title>管理员管理</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/pintuer.css">
        <script src="js/jquery.js"></script>
        <script src="js/pintuer.js"></script>
        <script type="text/javascript">
            function ConfDel() {
                var tips = "你确定要删除当前管理员吗?";
                if (confirm(tips)) {
                    return true;
                } else {
                    return false;
                }
            }
        </script>
    </head>
    <body class = "bg-green-light">
        <!--头部开始-->
        <%@include file = "WEB-INF/jspf/header.jspf" %>
        <!--头部结束-->
        <!--内容开始--> 
        <div class="container padding-big-top padding-big-bottom ">
            <div class="line">
                <div class="xl12 xs3 xm3 xb1">
                    <button class="button icon-navicon"></button>
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
                 <div class="xl12 xs2-left xm9 xb9 padding-small-top">
                    <div class="margin-big-left">
                        <table class="table table-striped">
                            <tr>
                                <th>管理员名</th>                         
                                <th>管理员密码</th>                                                            
                                <th>功能操作</th>
                            </tr>
                            <c:forEach var="manager" items="${managers}">
                                <tr>
                                    <td>${manager.managerid}</td>     
                                    <td>${manager.managerpwd}</td>   
                                    <td>
                                        <a href="DeleteManager?managerid=${manager.managerid}" class="button button-small border-red" onclick="return ConfDel();"><span class="icon-trash-o"></span> 删除</a> 
                                    </td>   
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
        <!--<p align="center"><//%= request.getAttribute("info1")%>Welcome 欢迎登陆图书馆  </p>--> 
        <!--内容结束-->
        <!--底部开始-->
        <%@include file = "WEB-INF/jspf/footer.jspf" %>
        <!--底部结束-->
    </body>
</html>
