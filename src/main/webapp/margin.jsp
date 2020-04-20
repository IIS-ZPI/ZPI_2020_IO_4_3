<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>ServletExample</title>
    <link href="//stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
    <h1 class="text-center">Tabela marży dla towaru</h1>
    <div class="row col-lg-4 col-md-8 col-sm-12 mx-auto">
        <h1>${productName}</h1>
        <table class="table">
            <thead>
            <tr>
                <td>Stan</td>
                <td>Cena hurtowa</td>
                <td>Marża</td>
                <td>Cena wyjściowa</td>
                <td>Podatek (%)</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${entries}" var="entry">
                <fmt:formatNumber var="margin" value="${entry.margin}" maxFractionDigits="2"/>
                <fmt:formatNumber var="price" value="${entry.price}" maxFractionDigits="2"/>
                <fmt:formatNumber var="base_tax" value="${entry.baseTax}" maxFractionDigits="2"/>
                <tr>
                    <td>${entry.stateName}</td>
                    <td>${entry.wholesalePrice}</td>
                    <td>${margin}</td>
                    <td>${price}</td>
                    <td>${base_tax}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
