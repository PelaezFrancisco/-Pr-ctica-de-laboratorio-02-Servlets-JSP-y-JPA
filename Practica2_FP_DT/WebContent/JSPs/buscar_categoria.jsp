<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Categoria Encontrada</title>
</head>
<body>
	<c:set var="c" scope="request" value="${categoria}" />
	<h1>Categoria encontrada</h1>		
		
	<p>Id: ${c.cat_id}</p>	
	<p>Nombre: ${c.cat_nombre}</p>]
	
	<a href="/EjemploPersonaWebJPA/index.html">Regresar al index</a>
	
</body>
</html>

