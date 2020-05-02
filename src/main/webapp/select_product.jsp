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

<div class="container-fluid mt-5 pt-5">
    <div class="text-center mt-5 pt-5" style="">
        <div class="container">
            <div class="row shadow-lg border rounded border-default">
                <div class="mx-auto p-4 col-md-7 h-50" >
                    <h1 class="text-center mb-3">Przeliczanie wartości towaru</h1>
                    <form action="select_product_price" method="get">
                        <div class="form-group">
                            <select class="custom-select mb-2 custom-select-lg" name="product" required>
                                <option value="" disabled selected>Wybierz produkt</option>
                                <option value="Milk">Milk</option>
                                <option value="Eggs">Eggs</option>
                                <option value="Sausage">Sausage</option>
                            </select>
                            <div class="form-group">
                                <button type="submit" class="btn btn-default btn-block w-100 btn-lg">Wybierz</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<script>
    $(function () {
        $("#nav-placeholder").load("nav.html");
    });
</script>


</body>
</html>
