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

<div class="text-center text-white mt-5 py-5" >
    <div class="container">
        <div class="row">
            <div class="mx-auto col-lg-6">
                <h1 class="mt-5" > Choose your product</h1>
                <p class="mb-4">Yet I feel that I never was a greater artist than now. When, while the lovely valley teems with vapour around me, and the meridian sun strikes.</p>
                    <form action="select_product_price" method="get">
                        <div class="form-group mb-2">
                            <select class="custom-select mb-2 custom-select-lg" name="product" required>
                                <option value="" disabled selected>Choose product</option>
                                <option value="Milk">Milk</option>
                                <option value="Eggs">Eggs</option>
                                <option value="Sausage">Sausage</option>
                            </select>
                            <select class="custom-select mb-2 custom-select-lg" name="category" required>
                                <option value="" disabled selected>Choose category</option>
                                <option value="grocery">Artykuły spożywcze</option>
                                <option value="prepared_food">Gotowe jedzenie</option>
                                <option value="prescription_drug">Leki na receptę</option>
                                <option value="non_prescription_drug">Leki bez recepty</option>
                                <option value="clothing">Ciuchy</option>
                                <option value="intangibles">Usługi</option>
                            </select>
                            <div class="btn-group btn-group-toggle mb-2" data-toggle="buttons">
                                <label class="btn btn-default active mb-2">
                                    <input type="radio" name="calculation_type" autocomplete="off" checked value="min_margin"> Minimum margin
                                </label>
                                <label class="btn btn-default mb-2">
                                    <input type="radio" name="calculation_type" autocomplete="off" value="expected_price"> Expected price
                                </label>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-default btn-block w-100 btn-lg mb-2">Apply</button>
                            </div>
                        </div>
                    </form>
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
