<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  	<style type="text/css">
  		.resultado  {
  			background-color: #D9D9D9;
    		text-align: center;
    		padding: 20px;
    	}
    	.tablero {
    		padding: 3rem;
    		background-color: #333;
    		color: white;
    	}
  	</style>
  </head>
  <body>
    <h1>Calculadora</h1>
    <div class="row">
    	<div class="col-4 offset-4">
    		<div class="resultado"><%=(String) session.getAttribute("resultado") %></div>
    	</div>
    </div>
    <form class="tablero" action="/Calculadora/Calc" method="post">
    	<div class="row">
    		<div class="col-3">
    			<div class="mb-3">
				    <label class="form-label">Numero 1</label>
				    <input type="number" name="num1" class="form-control" required>
				  </div>
    		</div>
    		<div class="col-3">
    			<div class="mb-3">
				    <label class="form-label">Operación</label>
				    <select name="op" class="form-control" >
				    	<option value="+">+</option>
				    	<option value="-">-</option>
				    	<option value="x">x</option>
				    	<option value="/">÷</option>
				    </select>
				  </div>
    		</div>
    		<div class="col-3">
    			<div class="mb-3">
				    <label class="form-label">Número 2</label>
				    <input type="number" name="num2" class="form-control" required>
				  </div>
    		</div>
    		<div class="col-3">
    			<div class="mb-3">
				    <input type="submit"  class="form-control btn btn-success" value="Calcular" >
				  </div>
    		</div>
    	</div>
    </form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>