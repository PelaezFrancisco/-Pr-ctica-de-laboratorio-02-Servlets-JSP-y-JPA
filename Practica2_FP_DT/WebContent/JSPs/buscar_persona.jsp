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
	<c:set var="p" scope="request" value="${persona}" />
	<h1>Persona encontrada</h1>		
		
	<p>Id: ${p.codigo}</p>	
	<p>Nombre: ${p.nombre}</p>
	<p>Apellid: ${p.apellido}</p>
	<p>Fecha Nacimiento: ${p.fechaNacimiento}</p>
	
	<a href="/EjemploPersonaWebJPA/index.html">Regresar al index</a>
	
</body>
</html>

