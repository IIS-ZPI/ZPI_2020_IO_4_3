<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ServletExample</title>
    <link rel="stylesheet" href="https://yarnpkg.com/en/package/normalize.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<div id="loginModal" class="modal show" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="text-center">Przeliczanie wartości towaru</h1>
            </div>
            <div class="modal-body">
                <form class="form col-md-12 center-block" action="margin_calculator" method="post">
                    <div class="form-group">
                        <select class="form-control" name="product">
                            <option value="" disabled selected>Wybierz produkt</option>
                            <option value="Milk">Milk</option>
                            <option value="Eggs">Eggs</option>
                            <option value="Sausage">Sausage</option>
                        </select>
                        <input type="text" class="form-control input-lg" name="margin" placeholder="Minimalna marża"/>
                        <input type="text" class="form-control input-lg" name="stock_price" placeholder="Cena hurtowa"/>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-primary btn-lg btn-block" name="act" value="margin_calculate">Przelicz</button>
                    </div>
                </form>
            </div>
            <div class="modal-footer">

            </div>
        </div>
    </div>
</div>
</body>
</html>
