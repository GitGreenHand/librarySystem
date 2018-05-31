<%-- 
    Document   : borrowbook
    Created on : 2017-6-20, 17:00:06
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
                        <form method="post" action="borrowbook">
                            <div class="form-group">
                                <div class="label">
                                    <label for="readerid">读者id</label>
                                </div>
                                <div class="field">
                                    <input type="text" class="input" id="readerid" name="readerid" size="50" placeholder="读者id" data-validate="required:必填,length#==9:id长度为9,ajax#checkreader?readerid=:读者id不存在"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="label">
                                    <label for="bookno">图书编号</label>
                                </div>
                                <div class="field">
                                    <input type="text" class="input" id="bookno" name="bookno" size="50" placeholder="图书编号" data-validate="required:必填,length#==8:id长度为8,ajax#checkbook?bookno=:图书编号不存在"/>
                                </div>
                            </div>  
                            
                            <div class="form-group">
                                <div class="label">
                                    <label for="days">借阅天数</label>
                                </div>
                                <div class="field">
                                    <input type="text" class="input" id="days" name="days" size="50" placeholder="借阅天数" data-validate="required:必须填入一个整数"/>
                                </div>
                            </div>  
                                                      
                            <div class="form-button">
                                <button class="button" type="submit">提交</button>
                            </div>
                            <% String flag = (String) request.getAttribute("flag");
                                if (flag != null) {
                                    if (flag.equals("11")) {
                            %>
                            <script lang="javascript">
                                alert("该读者没有借书权限!");
                            </script>
                            <%      }
                                   if (flag.equals("22")) {%>
                                        <script lang="javascript">
                                            alert("该书不可借!");
                                         </script>
                            <%       }
                                }%>

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

