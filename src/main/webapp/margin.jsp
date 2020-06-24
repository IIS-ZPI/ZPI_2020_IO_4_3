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

<div class="text-center text-white mt-5 py-5" >
    <div class="container">
        <div class="row">
            <div class="mx-auto col-lg-6">
                <h1 class="">Margin table for goods</h1>
                <h3>${product.getDisplayName()}, ${category.mapToEnglishName()}</h3>
            </div>
        </div>

        <div class="py-5" >
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <img class="img-fluid d-block rounded-circle mx-auto my-5 w-25" src="${product.getImg()}" style="	box-shadow: 0px 0px 15px  lightblue;" >
                    </div>
                </div>
            </div>
        </div>
        <div class="mx-auto p-4 col-md-10 w-100" style="">
                <div class="table-striped table-hover">
                    <table class="table table-dark table-fixed table-bordered" id="scrollableTable" >
                        <thead class="default-color-dark white-text" >
                        <tr>
                            <td>State</td>
                            <td>Wholesale price (USD)</td>
                            <td>Quantity</td>
                            <td>Wholesale value (USD)</td>
                            <td>Margin (USD)</td>
                            <td>Value excluding tax (USD)</td>
                            <td>Tax value (USD)</td>
                            <td>Tax (%)</td>
                            <td>Value including tax (USD)</td>
                        </tr>
                        </thead>
                        <tbody class="default-color white-text">
                            <c:forEach items="${entries}" var="entry">
                                <c:choose>
                                    <c:when test="${entry.margin / 1.0 < 0}">
                                        <tr class="danger-color">
                                    </c:when>
                                    <c:otherwise>
                                        <tr>
                                    </c:otherwise>
                                </c:choose>
                                    <td>${entry.stateName}</td>
                                    <td>${entry.wholesalePrice}</td>
                                    <td>${entry.quantity}</td>
                                    <td>${entry.wholesaleValue}</td>
                                    <td>${entry.margin}</td>
                                    <td>${entry.valueExcludingTax}</td>
                                    <td>${entry.taxValue}</td>
                                    <td>${entry.tax}</td>
                                    <td>${entry.valueIncludingTax}</td>
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
