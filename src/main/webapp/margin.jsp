<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>TaxCalculator</title>
    <link href="//stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="//stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="//cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.16.0/css/mdb.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <!-- JQuery -->
    <script type="text/javascript" src="//code.jquery.com/jquery-3.4.1.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="//stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.16.0/js/mdb.min.js"></script>
</head>

<body>

<div id="nav-placeholder" class="fixed-top">

</div>

<div class="text-center mt-5 pt-5" style="">
    <div class="container">
        <div class="row">
            <div class="col-md-12 shadow mb-2 border border-default rounded">
                <h1 class="">Tabela marży dla towaru:</h1>
                <h3>${product}</h3>
            </div>
        </div>
        <div class="row shadow-lg border rounded border-default">
            <div class="col-md-6" style="">
                <img class="img-fluid d-block rounded my-2 mx-auto mt-4 w-75" src="https://static.pingendo.com/img-placeholder-1.svg">
            </div>
            <div class="mx-auto p-4 col-md-6 w-100" style="">
                <div class="table-responsive">
                    <table class="table table-bordered">
                        <thead class="default-color-dark white-text">
                        <tr>
                            <td>Stan</td>
                            <td>Cena hurtowa</td>
                            <td>Marża</td>
                            <td>Cena bez podatku</td>
                            <td>Podatek (%)</td>
                            <td>Cena z podatkiem</td>
                        </tr>
                        </thead>
                        <tbody class="default-color white-text">
                            <c:forEach items="${entries}" var="entry">
                                <tr>
                                    <td>${entry.stateName}</td>
                                    <td>${entry.wholesalePrice}</td>
                                    <td>${entry.margin}</td>
                                    <td>${entry.priceWithoutTax}</td>
                                    <td>${entry.baseTax}</td>
                                    <td>${entry.price}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $(function() {
        $("#nav-placeholder").load("/nav.html");
    });
</script>

</body>
</html>
