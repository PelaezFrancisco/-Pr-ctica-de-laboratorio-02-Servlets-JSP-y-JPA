<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Persona Encontrada</title>
</head>
<body>
	<c:set var="lista" scope="request" value="${personas}" />
	<h1>Lista de personas</h1>

	<table>
		<tr>
			<td><strong>Codigo</strong></td>
			<td><strong>Cedula</strong></td>
			<td><strong>Nombre</strong></td>
			<td><strong>Fecha Nacimiento</strong></td>
		</tr>
		<c:forEach var="p" items="${lista}">
			<tr>
				<td>${p.codigo}</td>				
				<td>${p.nombre}</td>
				<td>${p.apellido}</td>
				<td>${p.cedula}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="/EjemploPersonaWebJPA/index.html">Regresar al index</a>

</body>
</html>

