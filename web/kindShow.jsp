<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
    <head>
        <style>
            div,option{
                color: black;
                font-size: 32px;
                font-family: 微软雅黑;
                text-align: center;
            }
            select{
                line-height: 40px;
                color: black;
                font-size: 32px;
                font-family: 微软雅黑;
            }
        </style>
        <script>
            window.onload = function () {
                var kind = document.getElementById('kind');
                kind.onchange = function () {
                    window.location.href="shopping?bid="+this.value;
                };
            };
        </script>
    </head>
    <body>
        <div>请从如下商品种类中选择您需要的商品，请选择：</div><br>
        <select id="kind" name="kind">
            <option>==商品种类==</option>

            <c:if test="${sessionScope.kindArrayList!=null}">
                <c:forEach var="kindArrayList" items="${sessionScope.kindArrayList}">
                    <option value="${kindArrayList.bid}">${kindArrayList.bname}</option>
                </c:forEach>
            </c:if>
        </select>
    </body>
</html>
