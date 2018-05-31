<%-- 
    Document   : displayreader
    Created on : 2017-6-19, 16:53:29
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
                var tips = "你确定要删除该读者吗?";
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
                    <form action="searchreader" method="post">
                    <div class="margin-big-left">
                        <table class="table table-striped">
                            <tr>
                                <th>请选择搜索条件</th>   
                                <th>
                                    <select name="condition">
                                        <option value="readerid" selected>读者id</option>
                                        <option value="readername" >读者姓名</option>
                                        <option value="readerclass" >读者班级</option>
                                        <option value="readerdept">读者系别</option>
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
                                <th>读者id</th>                         
                                <th>读者姓名</th>                         
                                <th>读者性别</th>
                                <th>读者年龄</th>
                                <th>读者班级</th>
                                <th>读者系别</th>
                                <th>读者权限</th>
                                <th>功能操作</th>
                            </tr>
                            <c:forEach var="reader" items="${readers}">
                                <tr>
                                    <td>${reader.readerid}</td>     
                                    <td>${reader.readername}</td> 
                                    <td>${reader.readersex}</td> 
                                    <td>${reader.readerage}</td> 
                                    <td>${reader.readerclass}</td> 
                                    <td>${reader.readerdept}</td> 
                                    <td>${reader.readerpermitted}</td>    
                                    <td>
                                        <a href="deletereader?readerid=${reader.readerid}" class="button button-small border-red" onclick="return ConfDel();"><span class="icon-trash-o"></span> 删除</a>|
                                        <a href="changereaderinfo?readerid=${reader.readerid}" class="button button-small border-main"><span class="icon-edit"></span>修改</a>
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
