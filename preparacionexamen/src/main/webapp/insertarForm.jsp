<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="InsertarProducto" method="Post">
		<input type="text" name="codigo" placeholder="Codigo del producto">
		<input type="text" name="nombre" placeholder="Nombre del producto">
		<input type="text" name="cantidad" placeholder="Unidades del producto">
		<input type="text" name="precio" placeholder="Precio (XX.XX)">
		<input type="date" name="caducidad" placeholder="Fecha Caducidad">
		<select name="seccion">
			<option selected="selected">Seleccione una seccion</option>
			<c:forEach items="${secciones}" var="seccion">
				<option value ="${seccion.id}">${seccion.nombre}</option>
			</c:forEach>
		</select>
		<input type="submit">
	</form>
</body>
</html>