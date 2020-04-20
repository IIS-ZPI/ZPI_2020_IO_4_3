<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ServletExample</title>
    <link href="//stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
    <h1 class="text-center">Przeliczanie wartości towaru</h1>

    <form class="form col-lg-4 col-md-8 col-sm-12 mx-auto" action="margin_calculator" method="post">
        <button class="btn btn-primary btn-lg btn-block" name="act" value="margin">Wylicz marżę</button>
        <button class="btn btn-primary btn-lg btn-block" name="act" value="products">Pokaż produkty</button>
        <button class="btn btn-primary btn-lg btn-block" name="act" value="dd">Wylicz marżę</button>
    </form>
</div>

</body>
</html>
