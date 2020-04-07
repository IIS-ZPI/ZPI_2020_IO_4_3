<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>ServletExample</title>
    <link rel="stylesheet" href="https://yarnpkg.com/en/package/normalize.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<div id="loginModal" class="modal show" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="text-center">Przeliczanie wartości towaru</h1>
            </div>
            <div class="modal-body">
                <h1>${product}</h1>
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
                        <c:forEach items="${states}" var="state">
                            <c:set var="margin" value="${max_price / (1 + state.baseTax) - stock_price}" />
                            <c:set var="price" value="${(stock_price + margin) * (1 + state.baseTax)}" />
                            <c:set var="base_tax" value="${state.baseTax * 100}" />
                            <fmt:formatNumber var="margin" value="${margin}" maxFractionDigits="2" />
                            <fmt:formatNumber var="price" value="${price}" maxFractionDigits="2" />
                            <fmt:formatNumber var="base_tax" value="${base_tax}" maxFractionDigits="2" />
                            <tr>
                                <td>${state.stateName}</td>
                                <td>${stock_price}</td>
                                <td>${margin}</td>
                                <td>${price}</td>
                                <td>${base_tax}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="modal-footer">

            </div>
        </div>
    </div>
</div>
</body>
</html>
