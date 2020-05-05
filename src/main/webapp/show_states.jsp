<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<div class="container-fluid mt-5 pt-5">
    <div class="container">
        <div class="row shadow-lg border rounded border-default mb-3">
            <div class="mx-auto p-4 col-md-7 h-50" >
                <h1 class="text-center">Tabele stanów</h1>
            </div>
        </div>
    </div>
    <div class="row col-xl-6 col-lg-8 col-md-12 col-sm-12 mx-auto">
        <h1>${productName}</h1>
        <table class="table table-bordered table-striped table-hover" id="scrollableTable">
            <thead class="default-color-dark white-text">
            <tr>
                <td>Stan</td>
                <td>Podatek (%)</td>
                <td>Podatek od artykułów spożywczych (%)</td>
                <td>Podatek od gotowego jedzenia (%)</td>
                <td>Podatek od leków na receptę (%)</td>
                <td>Podatek od leków bez recepty (%)</td>
                <td>Podatek od ciuchów (%)</td>
                <td>Podatek od usług (%)</td>
            </tr>
            </thead>
            <tbody class="default-color white-text">
            <c:forEach items="${entries}" var="entry">
                <tr>
                    <td>${entry.stateName}</td>
                    <td>${entry.baseTax}</td>
                    <td>${entry.groceryTax}</td>
                    <td>${entry.preparedFoodTax}</td>
                    <td>${entry.prescriptionDrugTax}</td>
                    <td>${entry.nonPrescriptionDrugTax}</td>
                    <td>${entry.clothingTax}</td>
                    <td>${entry.intangiblesTax}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<script>
    $(function() {
        $("#nav-placeholder").load("nav.html");
    });
</script>

</body>
</html>
