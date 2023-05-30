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
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
	<div class="position-absolute start-50">
		Productos en el carro: ${sessionScope.carrito.size()}
	</div>
		
	<form action="Inicio" method="get" class="w-75 p-4 m-auto">
		<input type="text" name="precio_minimo"
			placeholder="Precio minimo 00.00" class="m-auto"> <input
			type="text" name="precio_maximo" placeholder="Precio maximo 00.00"
			class="m-auto"> <input type="submit" value="Filtrar"
			class="m-auto" name="filtro"> <br> <br> <input
			type="text" name="busqueda"
			placeholder="Introduzca caracteres a buscar" class="m-auto">
		<input type="submit" value="Buscar" class="m-auto" name="filtro">
	</form>
	<form action="EliminarVarios" method="get" class="w-75 p-4 m-auto">
		<input type="text" name="codigos"
			placeholder="Escriba codigos para eliminar, ej: '1,6,90'"
			class="w-25"> <input type="submit" value="Eliminar Codigo(s)">
	</form>

	<div class="w-75 m-auto ">
		<!-- Button trigger modal -->
		<button type="button" class="btn btn-primary ms-4"
			data-bs-toggle="modal" data-bs-target="#exampleModal">Launch
			demo modal</button>

		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="exampleModalLabel">Modal
							title</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<form action="EliminarVarios" method="post">
							<c:forEach items="${productos}" var="producto">
								<input type="checkbox" value="${producto.codigo}" name="codigos"> ${producto.nombre} <br>
							</c:forEach>
							<input type="submit" value="Eliminar">
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>


	<form action="EliminarVarios" method="post">
		<table class="table table-hover table-striped m-auto mt-3 w-75">
			<tr class="bg-dark">
				<td class="text-light">ID del producto</td>
				<td class="text-light">Codigo del producto <br> <!----> <a
					href="Inicio?filtro=codasc">asc </a> <!----> <a
					href="Inicio?filtro=coddesc"> desc</a> <!----> <!---->
				</td>
				<td class="text-light">Nombre prod.</td>
				<td class="text-light">Cantidad</td>
				<td class="text-light">Precio</td>
				<td class="text-light">Caducidad</td>
				<td class="text-light">Seccion</td>
				<td class="text-light">Modificar</td>
				<td class="text-light">Eliminar</td>
				<td class="text-light">Compra</td>

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
					<td><a href="Eliminar?id=${producto.id}"
						class="btn btn-danger">Eliminar</a></td>
					<td><a href="Comprar?q=${producto.id}" class="btn btn-info">Comprar</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<div class="w-75 m-auto text-center">
		<a class="btn btn-info m-2" href="InsertarProducto">Insertar</a>
	</div>
</body>
</html>