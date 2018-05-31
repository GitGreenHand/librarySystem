 <%-- 
    Document   : addreader
    Created on : 2017-6-20, 13:48:45
    Author     : pichaojun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="readerdepttag" uri="/WEB-INF/tlds/readerdepttag" %>
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
                
                 <div class="xl12 xs9 xm9 xb9 padding-small-top">
                    <div class="margin-big-left padding-big">
                        <form method="post" action="addreader">
                            <div class="form-group">
                                <div class="label">
                                    <label for="readerid">读者编号</label>
                                </div>
                                <div class="field">
                                    <input type="text" class="input" id="readerid" name="readerid" size="50" placeholder="读者编号" data-validate="required:必填,length#==9:id长度为9,ajax#checkreaderid?readerid=:读者id已存在" />
                                </div>
                            </div>
                                
                            <div class="form-group">
                                <div class="label">
                                    <label for="readername">读者姓名</label>
                                </div>
                                <div class="field">
                                    <input type="text" class="input" id="readername" name="readername" size="50" placeholder="读者姓名" data-validate="required:必填"/>
                                </div>
                            </div>
                                
                             <div class="form-group">
                                <div class="label">
                                    <label for="readersex">性别</label>
                                </div>
                                <div class="field">
                                    <div class="button-group radio">
                                        <label class="button active">
                                            <input name="readersex" value="男" checked="checked" type="radio"><span class="icon icon-male"></span> 男
                                        </label>
                                        <label class="button">
                                            <input name="readersex" value="女" type="radio"><span class="icon icon-female"></span> 女
                                        </label>
                                    </div>
                                </div>
                            </div>  
                                
                            <div class="form-group">
                                <div class="label">
                                    <label for="readerage">读者年龄</label>
                                </div>
                                <div class="field">
                                    <input type="text"  class="input" id="readerage" name="readerage" size="50" placeholder="读者年龄" data-validate="required:必填,plusinteger:必须是数字,compare#>15:年龄必须大于15岁"/>
                                </div>
                            </div> 
                                
                            <div class="form-group">
                                <div class="label">
                                    <label for="readerclass">读者班级</label>
                                </div>
                                <div class="field">
                                    <input type="text"  class="input" id="readerclass" name="readerclass" size="50" placeholder="读者姓名" data-validate="required:必填"/>
                                </div>
                            </div>
 
                            <div class="form-group">
                                <div class="label">
                                    <label for="readerdept">读者系别</label>
                                </div>
                                <div class="field">
                                    <select class="input" name="readerdept">
                                        <readerdepttag:readerdepttag readerdept="${reader.readerdept}" />
                                    </select>
                                </div>
                            </div>
                                   
                            
                           <div class="form-group">
                                <div class="label">
                                    <label for="readerpermitted">读者权限</label>
                                </div>
                                <div class="field">
                                    <div class="button-group radio">
                                       
                                            <label class="button active">
                                                <input name="readerpermitted" value="可以借书" checked="checked" type="radio"><span class="icon icon-check-circle"></span> 可以借书
                                            </label>
                                            <label class="button">
                                                <input name="readerpermitted" value="不可借书" type="radio"><span class="icon icon-times-circle"></span> 不可借书
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

