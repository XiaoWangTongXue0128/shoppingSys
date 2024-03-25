<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
    <head>
        <style>
            div {
                width: 33%;
                height: 40%;
                margin-left: 400px;
                margin-top: 100px;
                padding-top: 30px;
                padding-left: 30px;
                border: 2px #000 solid;
                border-radius: 10px;
                line-height: 60px;
                color: black;
                font-size: 32px;
                font-family: 微软雅黑;
            }
            input{
                margin-left: 95px;
                margin-top: 50px;
                color: black;
                font-size: 32px;
                font-family: 微软雅黑;
            }
            a {
                font-size: 50px;
                font-family: 微软雅黑;
                text-align: center;

            }
        </style>
        <script>
            window.onload = function () {

                var i1 = document.getElementById("i1");
                var form = document.getElementById("form");
                i1.onclick = function () {
                    form.action = "select";
                    form.submit();
                };
                var i2 = document.getElementById("i2");
                i2.onclick = function () {
                    form.action = "showKind";
                    form.submit();
                };
            };


        </script>
    </head>
    <body>
        <a style="text-align: center">欢迎${sessionScope.aname}先生/女士登录小王超市自助购物系统</a>
        <div>
            <form id="form" action="" method="post">
                <input id="i1" type="button" value="查询余额">
                <input id="i2" type="button" value="购买商品">
            </form>
        </div>
    </body>
</html>
