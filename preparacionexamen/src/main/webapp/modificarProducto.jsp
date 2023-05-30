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
		<select name="seccion" class="d-block m-2">
			<c:forEach items="${secciones}" var="seccion">
				<c:if test="${seccion.id eq p.seccion.id}">
					<option value="${seccion.id}" selected="selected">${seccion.nombre}</option>
				</c:if>
				<c:if test="${seccion.id ne p.seccion.id}">
					<option value="${seccion.id}">${seccion.nombre}</option>
				</c:if>
			</c:forEach>
		</select>
		<!--  -->
		<input type="submit">
	</form>
	
</body>
</html>