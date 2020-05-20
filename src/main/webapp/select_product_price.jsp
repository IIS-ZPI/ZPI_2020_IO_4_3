<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>TaxCalculator</title>
    <link href="//stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="//stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="//cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.16.0/css/mdb.min.css" rel="stylesheet">
    <link rel="stylesheet" href="//cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css">
    <link href="css/style.css" rel="stylesheet">
    <!-- JQuery -->
    <script type="text/javascript" src="//code.jquery.com/jquery-3.4.1.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="//stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.16.0/js/mdb.min.js"></script>
    <!-- DataTables -->
    <script type="text/javascript" src="//cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="//cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
    <script type="text/javascript" src="js/script.js"></script>
</head>

<body>
<div id="nav-placeholder" class="fixed-top">

</div>

<div class="mt-5 pt-5">
    <div class="container shadow mb-2 border border-default rounded mt-5 pt-5">
        <div class="row">
            <div class="col-md-12">
                <h1 class="text-center">Twój produkt to:</h1>

            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <h2 class="text-center"> ${product}, ${category.mapToPolishName()}</h2>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6"><img class="img-fluid d-block rounded-circle mx-auto my-2 w-50" src="https://static.pingendo.com/img-placeholder-3.svg"></div>
            <div class="col-md-6 mt-5">
                <form action="margin_calculator" method="get">
                    <input type="hidden" name="product" value="${product}">
                    <input type="hidden" name="category" value="${category}">
                    <input type="hidden" name="calculation_type" value="${calculation_type}">
                    <div class="form-group row">
                        <div class="col-10 col-md-12" style="">
                            <c:choose>
                                <c:when test="${calculation_type == 'min_margin'}">
                                    <input type="text" pattern="\d+(\.\d{1,2})?" class="form-control mb-2 form-control-lg"  name="value_calc" required placeholder="Minimalna marża (np. 2.3)">
                                </c:when>
                                <c:otherwise>
                                    <input type="text" pattern="\d+(\.\d{1,2})?" class="form-control mb-2 form-control-lg"  name="value_calc" required placeholder="Maksymalna cena (np. 20.4)">
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-10 col-md-12" style="">
                            <input type="text" pattern="\d+(\.\d{1,2})?" class="form-control mb-2 form-control-lg" name="wholesale_price" required placeholder="Cena hurtowa (np. 14.23)">
                        </div>
                    </div>
                    <button type="submit"  class="btn btn-default btn-block w-100 btn-lg">Przelicz</button>
                </form>
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
