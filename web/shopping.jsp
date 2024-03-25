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
            select,option,input{
                color: black;
                font-size: 32px;
                font-family: 微软雅黑;
            }
        </style>
        <script>
            window.onload = function () {
                var checkBoxAll = document.getElementById("checkBoxAll");

                checkBoxAll.onclick = function () {
                    var checkBoxs = document.getElementsByClassName("choose");
                    //alert(checkBoxAll.checked);
                    for (var i = 1; i < checkBoxs.length; i++) {
                        var checkBox = checkBoxs[i];
                        checkBox.checked = checkBoxAll.checked;
                    }
                };

                var buttons = document.getElementsByClassName("button");
                for (var i=0;i<buttons.length;i++){
                    var button = buttons[i];
                    button.onclick = function () {
                        var results=document.getElementsByName("hidden");
                        results[0].value = this.value;
                        var form = document.getElementById("form");
                        form.submit();
                    };
                }

                var quantitys = document.getElementsByClassName("Quantity");
                for (var i = 0; i < quantitys.length; i++) {
                    var checkBoxs = document.getElementsByClassName("choose");
                    var quantity = quantitys[i];
                    quantity.onchange = function () {
                        var left = this.value.indexOf("-");
                        var right=this.value.indexOf(":");
                        var value1 = this.value.substring(0, left);
                        var value2 = this.value.substring(right + 1);
                        var checkBox = checkBoxs[new Number(value1) + 1];
                        if (value2 != 0) {
                            checkBox.checked = true;
                        } else {
                            checkBox.checked = false;
                        }
                    };


                };

            };

        </script>
    </head>
    <body>
        <form id="form" action="save" method="post">
            <input type="hidden" name="hidden" value="">
            <table>

                <tr>
                    <th>
                        <input type="checkbox" class="choose" id="checkBoxAll">
                    </th>
                    <th>商品名称</th>
                    <th>商品单价</th>
                    <th>商品数量</th>
                </tr>

                <c:forEach begin="0" end="${requestScope.goodsArrayList.size()}" step="1" items="${requestScope.goodsArrayList}" var="goods" varStatus="x">
                    <tr>
                        <td>
                            <input type="checkbox" class="choose" name="cid" value="${goods.cid}">
                        </td>
                        <td>${goods.cname}</td>
                        <td>${goods.cprice}</td>
                        <td>
                            <select name="cidQuantity" class="Quantity">
                                <c:forEach begin="0" end="${goods.inventory}" step="1" varStatus="y">
                                    <option value="${x.index}-${goods.cid}:${y.index}">${y.index}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="4">
                        <input class="button" type="button" value="继续购物">
                        &nbsp;&nbsp;||&nbsp;&nbsp;
                        <input class="button" type="button" value="结算清单">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
