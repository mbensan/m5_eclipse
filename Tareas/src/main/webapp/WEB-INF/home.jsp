<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList" import="models.Tarea"
    import="models.Categoria" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
  
  </head>
  <body>
  <%
  	ArrayList<Tarea> tareas = (ArrayList<Tarea>)request.getAttribute("tareas");
  	ArrayList<Categoria> cats = (ArrayList<Categoria>)request.getAttribute("cats");
  %>
  <div class="container">
  	<nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">TasksList</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="home.html">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="categorias.html">Categorías</a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <h1>Lista de Tareas</h1>
      <div class="row">
        <div class="col-4">
          <form action="/Tareas/Home" method="post">
            <div class="mb-3">
              <label for="exampleInputEmail1" class="form-label">Texto</label>
              <input name="texto" class="form-control" required>
            </div>
            <div class="mb-3">
              <label for="exampleInputPassword1" class="form-label">Categoría</label>
              <select class="form-select" name="categoria_id" required>
                <option selected value>Selecciona 1</option>
                <% for (Categoria c: cats) { %>
                	<option value="<%=c.id %>"><%=c.nombre %></option>
                <% } %>
              </select>
            </div>
            <button type="submit" class="btn btn-primary">Agregar</button>
          </form>
        </div>
        <div class="col-6 offset-2">
          <ul class="list-group">
          	<% for (Tarea t: tareas) { %>
	            <li class="list-group-item <% if (t.completada){ %>text-decoration-line-through<% } %>">
	              <div class="row px-3 align-items-center todo-item rounded">
	                <div class="col-7">
	                  <h5><%=t.texto %></h5>
	                  <p>Categoría: Hogar</p>
	                </div>
	                <div class="col-5">
	                	<!-- Los enlaces sin href no son clickeables. por lo tanto, una tarea ya completada no debería tener el atributo href -->
	                  <a <% if (! t.completada){ %>href="/Tareas/CheckearTarea?id=<%=t.id %>"<% } %>">
	                    <i class="fs-3 bi bi-bookmark-check"></i>
	                  </a>
	                  <a href="/Tareas/GestionTarea?id=<%=t.id %>">
	                    <i class="fs-3 bi bi-trash-fill"></i>
	                  </a>
	                </div>
	              </div>
	            </li>
            <%} %>

          </ul>
        </div>
      </div>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>