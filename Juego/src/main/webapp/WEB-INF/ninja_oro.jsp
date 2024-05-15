<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList" import="classes.Mensaje" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  </head>
  <body>
    <h1>Su numero de Oro: <span class="d-inline-block p-2 rounded text-warning bg-dark"><%=session.getAttribute("oro") %></span></h1>
    <div class="container">
	  <div class="row">
	    <div class="col-3">
	      <form action="/Juego/NinjaOro" method="post">
		    <h4>Granja</h4>
		    <p>Puede generar de 10 a 20 oros</p>
		    <input type="hidden" name="lugar" value="granja">
		    <input type="submit" value="Obtener Oro" class="btn btn-warning">
	      </form>
	    </div>
	    <div class="col-3">
	      <form action="/Juego/NinjaOro" method="post">
		    <h4>Cueva</h4>
		    <p>Puede generar de 5 a 10 oros</p>
		    <input type="hidden" name="lugar" value="cueva">
		    <input type="submit" value="Obtener Oro" class="btn btn-warning">
	      </form>
	    </div>
	    <div class="col-3">
	      <form action="/Juego/NinjaOro" method="post">
		    <h4>Casa</h4>
		    <p>Puede generar de 2 a 5 oros</p>
		    <input type="hidden" name="lugar" value="casa">
		    <input type="submit" value="Obtener Oro" class="btn btn-warning">
	      </form>
	    </div>
	    <div class="col-3">
	      <form action="/Juego/NinjaOro" method="post">
		    <h4>Casino</h4>
		    <p>Puede ganar o perder de 0 a 50 oros</p>
		    <input type="hidden" name="lugar" value="casino">
		    <input type="submit" value="Obtener Oro" class="btn btn-warning">
	      </form>
	    </div>
	  </div>
	  <div class="row mt-3">
	  	<div class="col-6 offset-3">
	  		<div class="p-4 rounded bg-light">
	  			<% for (Mensaje mensaje : (ArrayList<Mensaje>) session.getAttribute("mensajes")) { %>
			  			<h5 class="text-<%=mensaje.color %> text-center"><%=mensaje.texto %></h5>			
	  			<% } %>
	  		</div>
	  	</div>
	  </div> 
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>