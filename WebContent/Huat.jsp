<%-- 
    Document   : Huat
    Created on : 2017-6-9, 18:53:44
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
        <script language="javascript">
            function realSysTime(clock) {
                var now = new Date(); //创建Date对象 
                var year = now.getFullYear(); //获取年份 
                var month = now.getMonth(); //获取月份 
                var date = now.getDate(); //获取日期 
                var day = now.getDay(); //获取星期 
                var hour = now.getHours(); //获取小时 
                var minu = now.getMinutes(); //获取分钟 
                var sec = now.getSeconds(); //获取秒钟 
                month = month + 1;
                var arr_week = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
                var week = arr_week[day]; //获取中文的星期 
                var time = year + "年" + month + "月" + date + "日 " + week + " " + hour + ":" + minu + ":" + sec; //组合系统时间 
                clock.innerHTML = time; //显示系统时间 
            }
            window.onload = function() {
                window.setInterval("realSysTime(clock)", 1000); //实时获取并显示系统时间 
            }
        </script> 
        
        <div class="container padding-big-top padding-big-bottom">
            <img src="images/01.gif" width = "100%"/>
        </div>
        
        <div class="container padding-small-top padding-small-bottom">
            <div class="nav">
                <div class="x112 xs1-move xm0-move xb8 padding-small-top">
                    <ul class="nav nav-menu nav-inline nav-navicon" id="header-demo1">
                        <li class = "li">
                            <a href="Huat.jsp" >首&nbsp &nbsp页</a> 
                        </li> 
                        <li class = "li">
                            <a href="#" class=" aabg" >本馆介绍<span class="arrow"></span></a>
                            <ul class = "drop-menu">
                                <li><a>本馆概况</a></li>
                                <li><a>规章制度</a></li>
                                <li><a>开放时间</a></li>
                            </ul>         
                        </li>     
                        <li class= "li">
                            <a href="#">读者须知<span class = "arrow"></span></a>
                            <ul class = "drop-menu">
                                <li><a>图书借还须知</a></li>
                                <li><a>赔偿处罚规定</a></li>
                                <li><a>逾期管理规定</a></li>
                            </ul>
                        </li>
                        <li class = "li"><a href="#">读者服务</a> 
                        </li>
                        <li class = "li"><a href="#">读者活动</a> </li>         
                    </ul>  
                </div>
                
                
                <div class="x0 xs0-left xm3-xb8-left padding-small-top text-default text-center">
                    <div class="nav">
                        <ul class="nav nav-menu nav-inline nav-navicon" id="header-demo1">
                            <li><a href="Login.jsp">登录</a></li>
                            <li><a>退出</a></li>
                            <li><div class=" padding-small-top text-default text-center"><h5 id = "clock"></h5></div></li>
                        </ul>
                    </div>
                </div>
            </div>
            <hr/>
        </div>

        <!--头部结束-->
        <!--内容开始-->
         <div class="container padding-big-top padding-big-bottom "> 
            <div class="line">
                <div class="xl12 xs3 xm3 xb3">
                    <div class="panel">
                        <div class="panel-head">友情链接</div>
                        <div class="panel-body">
                            <ul class="list-group">
                                <li>电信学院</li>
                                <li>机械学院</li>
                                <li>汽车学院</li>
                                <li>经管学院</li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="xl12 xs9 xm9 xb9 padding-small-top">
                    <div class="margin-big-left">
                        <div class="banner">
                            <div class="carousel">
                                <div class="item"><img src="images/1.jpg" width="100%" alt="1"/></div>
                                <div class="item"><img src="images/2.jpg" width="100%" alt="2"/></div>
                                <div class="item"><img src="images/3.jpg" width="100%" alt="3"/></div>
                                <div class="item"><img src="images/4.jpg" width="100%" alt="4"/></div>
                                <div class="item"><img src="images/5.jpg" width="100%" alt="5"/></div>
                                <div class="item"><img src="images/6.jpg" width="100%" alt="6"/></div>
                            </div>
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
