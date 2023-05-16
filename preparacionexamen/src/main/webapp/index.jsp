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
	<table class="table table-hover table-striped m-auto mt-3 w-75">
		<tr class="bg-dark">
			<td class="text-light">ID del producto</td>
			<td class="text-light">Codigo del producto</td>
			<td class="text-light">Nombre prod.</td>
			<td class="text-light">Cantidad</td>
			<td class="text-light">Precio</td>
			<td class="text-light">Caducidad</td>
			<td class="text-light">Seccion</td>
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
			</tr>
		</c:forEach>
	</table>
	<div class="w-75 m-auto text-center">
		<a class="btn btn-info m-2" href="InsertarProducto">Insertar</a>
	</div>
</body>
</html>