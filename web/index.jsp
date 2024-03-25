<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<html>
    <head>
        <title>基于JSP+JSTL+EL的完整购物系统</title>
        <style>
            div {
                width: 33%;
                height: 40%;
                margin-left: 400px;
                margin-top: 200px;
                padding-top: 30px;
                padding-left: 30px;
                border: 2px #000 solid;
                border-radius: 10px;
                line-height: 60px;
                color: black;
                font-size: 32px;
                font-family: 微软雅黑;
            }

            .c1 {
                margin-left: 85px;
                margin-top: 50px;
            }

            .c2 {
                width: 300px;
            }

            input {
                color: black;
                font-size: 32px;
                font-family: 微软雅黑;
            }
        </style>
        <script>
            window.onload = function () {
                var i1 = document.getElementById("i1");
                i1.onclick = function () {
                    window.location.href = "regist.jsp";
                };
            };


        </script>
    </head>
    <body>
            ${requestScope.loginvalue}
            ${requestScope.registvalue}
        <div>
            <form action="login" method="post">
                账号：<input class="c2" type="text" name="aname" value=""><br>
                密码：<input class="c2" type="password" name="apassword" value=""><br>
                <input class="c1" id="i1" type="button" value="注册">
                <input class="c1" id="i2" type="submit" value="登录">
            </form>
        </div>
    </body>
</html>
