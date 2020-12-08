<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ListarPedidos</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/" />
    <!-- Font Awesome icons (free version)-->
    <script src="https://use.fontawesome.com/releases/v5.15.1/js/all.js" crossorigin="anonymous"></script>
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet" />
    <link href="css/listar.css" rel="stylesheet" type="text/css" />

</head>

<body>
    <header class="masthead bg-primary text-white text-center">
        <div class="container d-flex align-items-center flex-column">
            <!-- Masthead Avatar Image-->
            <img class="masthead-avatar mb-5" src="assets/img/portfolio/lista.png" alt="" />
            <!-- Masthead Heading-->
            <h1 class="masthead-heading text-uppercase mb-0">Listar Pedidos</h1>
            <!-- Icon Divider-->
            <!-- Masthead Subheading-->
            <p class="masthead-subheading font-weight-light mb-0">Perfil de Administrador de ${empresa.empresaNombre}</p>
        </div>
    </header>
    <nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
        <div class="container">
            <button class="navbar-toggler navbar-toggler-right text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars"></i>
                </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">

                <ul class="navbar-nav ml-auto">

                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#">Pagina Principal</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/Practica1_DT_FP/private/admin/CrearProducto.html">Agregar Productos</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/Practica1_DT_FP/ActualizarProducto">Modificar Productos</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/Practica1_DT_FP/private/admin/buscar_producto.html">Buscar Productos</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#">Listar Productos</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/Practica1_DT_FP/private/admin/eliminar_producto.html">Eliminar Productos</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/Practica1_DT_FP/ListaPedidosController">Listado Pedidos</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/Practica1_DT_FP/public/IniciarSesion.html">Cerrar Sesion</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- Portfolio Section-->
    <section class="page-section portfolio" id="portfolio">
        <div class="container">
            <!-- Portfolio Section Heading-->
      
            <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">Lista de Productos </h2>
            <!-- Icon Divider-->
            <div class="divider-custom">
                <div class="divider-custom-line"></div>
                <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                <div class="divider-custom-line"></div>
            </div>
	<c:set var="lista" scope="request" value="${pedidos}" />
	<table>
		<tr>
			<td><strong>Codigo</strong></td>
			<td><strong>Fecha</strong></td>
			<td><strong>Subtotal</strong></td>
			<td><strong>Iva</strong></td>
			<td><strong>Descuento</strong></td>
			<td><strong>Total</strong></td>
			<td><strong>Estado</strong></td>
		</tr>
		<c:forEach var="p" items="${lista}">
			<tr>
				<td>${p.ped_numeroP}</td>				
				<td>${p.ped_fecha}</td>
				<td>${p.ped_subtotal}</td>
				<td>${p.ped_iva}</td>
				<td>${p.ped_descuento}</td>
				<td>${p.ped_total}</td>
				<td>${p.ped_estado}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="/Practica2_FP_DT/index.html">Regresar al index</a>
</div>
	</section>
</body>
</html>

