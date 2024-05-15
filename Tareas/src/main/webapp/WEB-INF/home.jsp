<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList" import="models.Tarea" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  </head>
  <body>
    <h1>Ingrese una nueva tarea</h1>
    <form action="/Tareas/Home" method="post">
    	<div>
    		<label>Texto de la tarea</label>
    		<input name="texto" type="text" required minlength="3">
    	</div>
    	<div>
    		<input type="submit" value="Guardar" class="btn btn-primary">
    	</div>
    </form>
    <%
    	ArrayList<Tarea> tareas = (ArrayList<Tarea>)request.getAttribute("tareas");
    %>
    <ul>
    	<% for (Tarea t: tareas) { %>
    		<li><%=t.texto %> (creada en: <%=t.fecha %>)</li>
    	<% } %>
    </ul>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>