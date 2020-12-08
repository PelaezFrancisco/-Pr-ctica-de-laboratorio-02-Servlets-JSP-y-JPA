<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ModificarProductos</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="/assets/img/favicon.ico" />
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
            <img class="masthead-avatar mb-5" src="assets/img/portfolio/update.png" alt="" />
            <!-- Masthead Heading-->
            <h1 class="masthead-heading text-uppercase mb-0">Buscar Pedidos</h1>
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
                     <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/Practica1_DT_FP/CompraController?id=${empresa.persona.get(0).id}">Compra de Productos</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/Practica1_DT_FP/ListarPedidosController?id=${empresa.persona.get(0).id}">Listar Pedidos</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/Practica1_DT_FP/BuscarPedidoController?id=${empresa.persona.get(0).id}">Buscar Pedidos</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/Practica1_DT_FP/ModificarPedidoController?id=${empresa.persona.get(0).id}">Modificar Pedidos</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/Practica1_DT_FP/EliminarPedidoController?id=${empresa.persona.get(0).id}">Eliminar Pedidos</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/Practica1_DT_FP/CerrarSesionController">Cerrar Sesion</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <section>
        <div class="form">
            <div class="datos">
                <form id="formulario01" method="POST" action="/Practica1_DT_FP/Buscar">
                    <label>Codigo Cabecera a Buscar</label><br><br>
                    <input type="text" id="idcab" name="idcab" value="" placeholder="Ingrese el Codigo de Cabecera..." />
                    <br><br>
                    <input type="submit" id="login" name="login" value="Actualizar" />
                    <input type="reset" value="Cancelar" />
                </form>
            </div>
        </div>
    </section>

</body>
</html>