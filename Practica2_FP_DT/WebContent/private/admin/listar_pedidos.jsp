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

                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="IndexController">Pagina Principal</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/Practica1_DT_FP/private/admin/CrearProducto.html">Agregar Productos</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/Practica1_DT_FP/ActualizarProducto">Modificar Productos</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/Practica1_DT_FP/private/admin/buscar_producto.html">Buscar Productos</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#">Listar Productos</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/Practica1_DT_FP/private/admin/eliminar_producto.html">Eliminar Productos</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/Practica1_DT_FP/CerrarSesionController">Cerrar Sesion</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <c:set var="lista" scope="request" value="${pedidosC}" />

    <table>
        <tr>
            <td><strong>Nro</strong></td>
            <td><strong>Subtotal</strong></td>
            <td><strong>Iva</strong></td>
            <td><strong>Desc</strong></td>
            <td><strong>Total</strong></td>
            <td><strong>Estado</strong></td>
            <td><strong>Cliente</strong></td>
            <td><strong>Detalle</strong></td>
        </tr>
        <c:forEach var="ped" items="${lista}">
            <tr>
						            		
                <td>${ped.pedidoCabeceraNumero}</td>
                <td>${ped.pedidoCabeceraSubtotal}</td>
                <td>${ped.pedidoCabeceraIva}</td>
                <td>${ped.pedidoCabeceraDescuento}</td>
                <td>${ped.pedidoCabeceraTotal}</td>
                <td>${ped.pedidoCabeceraEstado}</td>
                <td>${ped.pedidoCabeceraPerI}</td>
                <td> <a href="/Practica1_DT_FP/PedidoDetalleController?idPedido=${ped.pedidoCabeceraNumero}">Detalle</a> </td>
				
            </tr>
        </c:forEach>
    </table>

</body>
</html>