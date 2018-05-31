<%-- 
    Document   : displaybook
    Created on : 2017-6-17, 15:24:42
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
        <script type="text/javascript">
            function ConfDel() {
                var tips = "你确定要删除当前图书吗?";
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
                
                <div class = "xl12 xs1-left xm9 xb6 padding-small-top">
                    <form action="searchbook" method="post">
                    <div class="margin-big-left">
                        <table class="table table-striped">
                            <tr>
                                <th>请选择搜索条件</th>   
                                <th>
                                    <select name="condition">
                                        <option value="bookno" selected>图书编号</option>
                                        <option value="bookname" >图书名称</option>
                                        <option value="author" size="5">图书作者</option>
                                        <option value="publish">出版社</option>
                                    </select>
				                </th>
                                <th>请输入关键字</th>
                                <th><input type="text" class ="input" id ="key" name="key"/></th>
                                <th>     
                                    <button class="form-button" type="submit">搜索</button>
                                </th>
                            </tr>       
                        </table>                
                    </div>  
                  </form>
                </div>
                
                       
                <div class="xl12 xs1-left xm9 xb9 padding-small-top">
                    <div class="margin-big-left">
                    <table class="table table-striped">     
                            <tr>
                                <th>图书编号</th>                         
                                <th>图书名称</th>                         
                                <th>图书作者</th>
                                <th>图书出版社</th>
                                <th>图书ISBN号</th>
                                <th>图书价格</th>
                                <th>是否可借</th>
                                <th>功能操作</th>
                            </tr>
                            <c:forEach var="book" items="${books}">
                                <tr>
                                    <td>${book.bookno}</td>     
                                    <td>${book.bookname}</td> 
                                    <td>${book.author}</td> 
                                    <td>${book.publish}</td> 
                                    <td>${book.bookisbn}</td> 
                                    <td>${book.bookprices}</td> 
                                    <td>${book.bookstatus}</td> 
                                    
                                    <td>
                                        <a href="deletebook?bookno=${book.bookno}" class="button button-small border-red" onclick="return ConfDel();"><span class="icon-trash-o"></span> 删除</a>|
                                        <a href="changebookinfo?bookno=${book.bookno}" class="button button-small border-main"><span class="icon-edit"></span>修改</a>
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
        <!--内容结束-->
        <!--底部开始-->
        <%@include file = "WEB-INF/jspf/footer.jspf" %>
        <!--底部结束-->
    </body>
</html>
