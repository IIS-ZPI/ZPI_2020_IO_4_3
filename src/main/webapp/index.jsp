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


<body style="	background-image: linear-gradient(to bottom, rgba(0,0,0,0.2), rgba(0,0,0,0.8));	background-position: top left;	background-size: 100%;	background-repeat: repeat;">
<div id="nav-placeholder" class="fixed-top">

</div>


<div class="py-5 text-white h-50" style="	background-image: linear-gradient(to bottom, rgba(0, 0, 0, .75), rgba(0, 0, 0, .9)), url('/images/homePage.jpg');	background-position: center center, center center;	background-size: cover, cover;	background-repeat: repeat, repeat;" >
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <p class="lead w-100 text-center mt-5 pb-5 pt-5">Sales taxes in the United States are taxes placed on the sale or lease of goods and services in the United States. Sales tax is governed at the state level and no national general sales tax exists.</p>
                <p class="lead w-100 text-center">The definitions of retail sales and taxable items vary among the states. Nearly all jurisdictions provide numerous categories of goods and services that are exempt from sales tax, or taxed at reduced rates. The purchase of goods for further manufacture or for resale is uniformly exempt from sales tax. Most jurisdictions exempt food sold in grocery stores, prescription medications, and many agricultural supplies.</p>
            </div>
        </div>
        <div class="row">
        </div>
    </div>
</div>
<div class="py-5 text-center" style="	background-image: linear-gradient(to bottom, rgba(0, 0, 0, .75), rgba(0, 0, 0, .9)), url('/images/teams.jpg');	background-position: top left;	background-size: 100%;	background-repeat: repeat;" >
    <div class="container">
        <div class="row">
            <div class="mx-auto col-md-12">
                <h1 class="mb-3 text-white text-center">Meet&nbsp;the team</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-3 col-6 p-4 text-white"> <img class="img-fluid d-block mb-3 mx-auto rounded-circle" src="/images/Maciej.jpg" width="100">
                <h4> <b>Maciej</b></h4>
                <p contenteditable="true">Developer<br>TeamLider</p>
            </div>
            <div class="col-lg-3 col-6 p-4 text-white"> <img class="img-fluid d-block mb-3 mx-auto rounded-circle" src="/images/Jacek.jpg" width="100">
                <h4> <b>Jacek</b></h4>
                <p>Developer</p>
            </div>
            <div class="col-lg-3 col-6 p-4 text-white"> <img class="img-fluid d-block mb-3 mx-auto rounded-circle" src="/images/Wojtek.jpg" width="100">
                <h4> <b>Wojciech</b></h4>
                <p>Developer</p>
            </div>
            <div class="col-lg-3 col-6 p-4 text-white"> <img class="img-fluid d-block mb-3 mx-auto rounded-circle" src="/images/Paulina.jpg" width="100">
                <h4> <b>Paulina</b></h4>
                <p>Tester</p>
            </div>
        </div>
    </div>
</div>

<script>
    $(function() {
        $("#nav-placeholder").load("nav.html");
    });
</script>

</body>

</html>
