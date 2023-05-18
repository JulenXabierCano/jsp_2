<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<body>
	<c:if test="${error ne null}">
		<h1 class="alert alert-danger">${error}</h1>
	</c:if>
	<form action="Modificar" method="Post" class="m-3">
		<input type="text" name="codigo" placeholder="Codigo del producto"
			class="d-block m-2" value="${p.codigo}" readonly="readonly">
		<!--  -->
		<input type="text" name="nombre" placeholder="Nombre del producto"
			class="d-block m-2" value="${p.nombre}">
		<!--  -->
		<input type="text" name="cantidad" placeholder="Unidades del producto"
			class="d-block m-2" value="${p.cantidad}">
		<!--  -->
		<input type="text" name="precio" placeholder="Precio (XX.XX)"
			class="d-block m-2" value="${p.precio}">
		<!--  -->
		<input type="date" name="caducidad" placeholder="Fecha Caducidad"
			class="d-block m-2" value="${p.caducidad}">
		<!--  -->
		<input type="text" name="seccion" placeholder="ID de la seccion"
			class="d-block m-2" value="${p.seccion.id}">
		<!--  -->
		<input type="submit">
	</form>
</body>
</html>