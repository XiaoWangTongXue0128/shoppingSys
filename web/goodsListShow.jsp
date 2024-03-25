<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
    <head>
        <style>
            table {
                align-content: center;
                width: 75%;
                height: 75%;
                margin-left: 150px;
                margin-top: 75px;
                border: 2px #000000 solid;
                border-collapse: collapse;
                color: black;
                font-size: 32px;
                font-family: 微软雅黑;
                overflow: auto;

            }

            td,th {
                border: black 2px solid;
                text-align: center;
            }
            input{
                color: black;
                font-size: 32px;
                font-family: 微软雅黑;
            }
        </style>
        <script>
            window.onload = function () {

                var button1 = document.getElementById("button1");
                button1.onclick = function () {
                    window.location.href = "kindShow.jsp";
                };
                var button2 = document.getElementById("button2");
                button2.onclick = function () {
                    var form = document.getElementById("form");
                    form.action = "checkout";
                    form.submit();
                };

            };

        </script>
    </head>
    <body>
        <form id="form" action="" method="post">
            <input type="hidden" name="money" value="${sessionScope.money}">
            <table>

                <tr>
                    <th>商品类别</th>
                    <th>商品名称</th>
                    <th>商品单价</th>
                    <th>商品数量</th>
                </tr>

                <c:forEach var="goodsList" items="${sessionScope.goodsLists}">
                    <tr>
                        <th>${goodsList.bname}</th>
                        <th>${goodsList.cname}</th>
                        <th>${goodsList.cprice}</th>
                        <th>${goodsList.quantity}</th>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="2" style="padding-right: 50px">
                        总金额：
                    </td>
                    <td colspan="2">
                        <input disabled="disabled" value="${sessionScope.money}" style="text-align: center;border:none">
                    </td>
                </tr>
                <tr>
                    <td colspan="4">
                        <input id="button1" type="button" value="继续购物">
                        &nbsp;&nbsp;||&nbsp;&nbsp;
                        <input id="button2" type="button" value="确认结算">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>

