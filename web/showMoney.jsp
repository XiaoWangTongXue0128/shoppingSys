<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <style>
            div {
                width: 33%;
                height: 40%;
                margin-left: 400px;
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
                margin-left: 85px;
                margin-top: 50px;
            }

            input{
                color: black;
                font-size: 32px;
                font-family: 微软雅黑;
            }
            a {
                font-size: 60px;
                font-family: 微软雅黑;
                text-align: center;
            }
        </style>
        <script>
            window.onload = function () {

                var i1 = document.getElementById("i1");
                var form = document.getElementById("form");
                i1.onclick = function () {
                    window.location.href = "index.jsp";
                };
                var i1 = document.getElementById("i2");
                i1.onclick = function () {
                    form.action = "showKind";
                    form.submit();
                };
            };


        </script>
    </head>
    <body>
        <a>尊敬的${sessionScope.aname}先生/女士</a><br>
        <a>您当前可余额为：${requestScope.abalance}元</a><br>
    <div>
        <form id="form" action="" method="post">
            <input class="c1" id="i1" type="button" value="退出登录">
            <input class="c1" id="i2" type="button" value="购买商品">
        </form>
    </div>
    </body>
</html>
