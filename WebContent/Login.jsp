
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
    <head>
         <title>登陆图书馆</title>
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
        <div  align ="center" class="padding-big-top padding-big-bottom">	 
            <form action="Login" method="get">
                <div class="panel padding" style="width: 450px;text-align: left;">
                    <div class="text-center">
                        <br>
                        <h2><strong>欢迎登陆图书馆</strong></h2></div>
                    <div class="" style="padding:30px; ">
                        <!--<div class="padding-big-bottom">
                        <select name = "select" >
                        <option>管理员登陆</option>
                        <option>读者登陆</option>
                        </select>
                        </div>-->
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="text" class="input" name="managerid" placeholder="用户名" data-validate="required:请填写用户名 "/>
                                       <span class="icon icon-mobile"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="password" class="input" name="managerpwd"  placeholder="登录密码" data-validate="required:请填写密码 "/>
                                       <span class="icon icon-key"></span>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="field">
                                <button class="button button-block bg-main text-big">立即登陆</button>
                            </div>
                        </div>   
                        <div>
                            <% String message = (String) request.getAttribute("message");
                               if (message != null) {%>
                            <p align="center"><%=message%></p>        
                            <%
                                }
                            %>               
                        </div>
                    </div>
                </div>            
            </form>
        </div>
        <!--内容结束-->
        <!--底部开始-->
         <%@include file = "WEB-INF/jspf/footer.jspf" %>
        <!--底部结束-->
                                        

    </body>
</html>
