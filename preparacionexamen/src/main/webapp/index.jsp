<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Super mercados</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body>
	<form action="Inicio" method="get" class="w-75 p-4 m-auto">
		<input type="text" name="precio_minimo"
			placeholder="Precio minimo 00.00" class="m-auto" required="required">
		<input type="text" name="precio_maximo"
			placeholder="Precio maximo 00.00" class="m-auto"> <input
			type="submit" value="Filtrar" class="m-auto" name="filtro"
			required="required">
	</form>
	<form action="Inicio" method="get" class="w-75 p-4 m-auto">
		<input type="text" name="busqueda"
			placeholder="Introduzca caracteres a buscar" class="m-auto">
		<input type="submit" value="Buscar" class="m-auto" name="filtro">
	</form>
	<table class="table table-hover table-striped m-auto mt-3 w-75">
		<tr class="bg-dark">
			<td class="text-light">ID del producto</td>
			<td class="text-light">Codigo del producto <br>
			<!----> <a href="Inicio?filtro=codasc">asc </a>
			<!----> <a href="Inicio?filtro=coddesc"> desc</a>
			<!----> <!---->
			</td>
			<td class="text-light">Nombre prod.</td>
			<td class="text-light">Cantidad</td>
			<td class="text-light">Precio</td>
			<td class="text-light">Caducidad</td>
			<td class="text-light">Seccion</td>
			<td class="text-light">Modificar</td>
			<td class="text-light">Eliminar</td>

		</tr>
		<c:forEach items="${productos}" var="producto">
			<tr>
				<td>${producto.id}</td>
				<td>${producto.codigo}</td>
				<td>${producto.nombre}</td>
				<td>${producto.cantidad}</td>
				<td>${producto.precio}€</td>
				<td>${producto.caducidad}</td>
				<td>${producto.seccion.nombre}</td>
				<td><a href="Modificar?id=${producto.id}" class="btn btn-info">Modificar</a></td>
				<td><a href="Eliminar?id=${producto.id}" class="btn btn-danger">Eliminar</a></td>
			</tr>
		</c:forEach>
	</table>
	<div class="w-75 m-auto text-center">
		<a class="btn btn-info m-2" href="InsertarProducto">Insertar</a>
	</div>
</body>
</html>