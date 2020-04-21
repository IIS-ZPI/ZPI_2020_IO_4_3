<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ServletExample</title>
    <link href="//stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="//stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="//cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.16.0/css/mdb.min.css" rel="stylesheet">
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
<div id="nav-placeholder">

</div>
<script>
    $(function() {
        $("#nav-placeholder").load("nav.html");
    });
</script>
<div class="container-fluid">
    <h1 class="text-center">Przeliczanie wartości towaru</h1>

    <form class="form col-lg-4 col-md-8 col-sm-12 mx-auto" action="margin_calculator" method="post">
        <button class="btn btn-default btn-lg my-3 btn-block" name="act" value="margin">Wylicz marżę</button>
        <button class="btn btn-default btn-lg my-3 btn-block" name="act" value="products">Pokaż produkty</button>
        <button class="btn btn-default btn-lg my-3 btn-block" name="act" value="dd">Wylicz marżę</button>
    </form>
</div>

</body>
</html>