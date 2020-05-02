<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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

<div class="mt-5 pt-5">
    <div class="container shadow mb-2 border border-default rounded mt-5 pt-5">
        <div class="row">
            <div class="col-md-12">
                <h1 class="text-center">Twój produkt to:</h1>

            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <h2 class="text-center"> ${product} </h2>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6"><img class="img-fluid d-block rounded-circle mx-auto my-2 w-50" src="https://static.pingendo.com/img-placeholder-3.svg"></div>
            <div class="col-md-6 mt-5">
                <form action="margin_calculator" method="get">
                    <input type="hidden" name="product" value="${product}">
                    <div class="form-group row">
                        <div class="col-10 col-md-12" style="">
                            <input type="text" pattern="\d+(\.\d{1,2})?" class="form-control mb-2 form-control-lg"  name="margin" required placeholder="Minimalna marża (np. 11.4)">
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-10 col-md-12" style="">
                            <input type="text" pattern="\d+(\.\d{1,2})?" class="form-control mb-2 form-control-lg" name="wholesale_price" required placeholder="Cena hurtowa (np. 140.23)">
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
