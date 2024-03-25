<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
    <head>
        <style>
            div {
                width: 33%;
                height: 45%;
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
            .c1{
                margin-left: 35px;
                margin-top: 30px;
            }
            .c2{
                width: 300px;
            }
            input{
                color: black;
                font-size: 32px;
                font-family: 微软雅黑;
            }
        </style>
        <script>
            window.onload = function () {
                var i2 = document.getElementById("i2");
                i2.onclick = function () {
                    window.location.href="index.jsp";
                };
            };
        </script>
    </head>
    <body>

        <c:if test="${requestScope.registvalue!=null}">
            ${requestScope.registvalue}
        </c:if>
        <div>
            <form action="regist" method="post">
                账号：<input class="c2" type="text" name="aname" value=""><br>
                密码：<input class="c2" type="password" name="apassword" value=""><br>
                余额：<input class="c2" type="number" name="abalance" value=""><br>
                <input class="c1" type="reset" value="重置">
                <input class="c1" id="i2" type="button" value="返回">
                <input class="c1" id="i1" type="submit" value="注册">
            </form>
        </div>
    </body>
</html>

