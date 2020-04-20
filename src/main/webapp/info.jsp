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
        <div class="form-group">
            <select class="custom-select" name="product" required>
                <option value="" disabled selected>Wybierz produkt</option>
                <option value="Milk">Milk</option>
                <option value="Eggs">Eggs</option>
                <option value="Sausage">Sausage</option>
            </select>
            <input type="text" class="form-control input-lg" name="margin" required placeholder="Minimalna marża"/>
            <input type="text" class="form-control input-lg" name="wholesale_price" required placeholder="Cena hurtowa"/>
        </div>
        <div class="form-group">
            <button class="btn btn-primary btn-lg btn-block" name="act" value="margin_calculate">Przelicz</button>
        </div>
    </form>
</div>
</body>
</html>
