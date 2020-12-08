<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AgregarProductos</title>
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
            <img class="masthead-avatar mb-5" src="assets/img/portfolio/p.png" alt="" />
            <!-- Masthead Heading-->
            <h1 class="masthead-heading text-uppercase mb-0">Agregar Productos</h1>
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

                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/Practica1_DT_FP/inicio_admin.jsp">Pagina Principal</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/Practica1_DT_FP/private/admin/CrearProducto.html">Agregar Productos</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/Practica1_DT_FP/ActualizarProducto">Modificar Productos</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/Practica1_DT_FP/private/admin/buscar_producto.html">Buscar Productos</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/Practica1_DT_FP/ListarProductoController">Listar Productos</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/Practica1_DT_FP/private/admin/eliminar_producto.html">Eliminar Productos</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/Practica1_DT_FP/ListaPedidosController">Listado Pedidos</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/Practica1_DT_FP/CerrarSesionController">Cerrar Sesion</a></li>
                </ul>
            </div>
        </div>
    </nav>
        <div class="form">
            <div class="datos">
                <form id="formulario01" method="GET" action="/Practica1_DT_FP/CrearProductoController">
                    <label>Nombre del Producto</label><br><br>
                    <input type="text" id="nombre" name="nombre" value="" placeholder="Ingrese el Nombre ..." />
                    <br><br>
                    <label>Descripcion del Producto</label><br><br>
                    <input type="text" id="descrip" name="descrip" value="" placeholder="Ingrese un abreve descripcion del producto ..." />
                    <br><br>
                    <label>Cantidad de Productos en Stock</label><br><br>
                    <input type="text" id="stock" name="stock" value="" placeholder="Ingrese el Stock Producto..." />
                    <br><br>
                    <label>Precio Venta al Publico</label><br><br>
                    <input type="text" id="precioV" name="precioV" value="" placeholder="Precio Venta Publico ..." />
                    <br><br>
                    <label>Categoria del Producto</label><br><br>
                    <input type="text" list="items" name="categ" id="categ" />
                    <!-- Lista de opciones -->
                    <datalist id="items" name="categ">
                        <option value="1">Electronicos</option>
                        <option value="2">Limpieza</option>
                        <option value="3">Papeleria</option>
                        <option value="4">Hogar y Cocina</option>
                        <option value="5">Jugetes</option>
                    </datalist><br><br>
                    <label>Empresa a la que Pertenece</label><br><br>
                    <input type="text" list="items1" name="emp" id="emp" />
                    <!-- Lista de opciones -->
                    <datalist id="items1" name="emp">
                        <option value="1">Norma</option>
                        <option value="2">Nestle</option>
                        <option value="3">Coco Cola</option>
                        <option value="4">Colgate</option>
                        <option value="5">L'oreal</option>
                        <option value="6">Samsung</option>
                        <option value="7">Apple In</option>
                        <option value="8">TVentas</option>
                        <option value="9">Jugueton</option>
                    </datalist><br><br>
                    <!--  
                    <label>Categoria del Producto</label><br><br>
                    <input type="text" id="categ" name="categ" value="" placeholder="Precio Venta Publico ..." />
                    <br><br>
                    <label>empresa del Producto</label><br><br>
                    <input type="text" id="emp" name="emp" value="" placeholder="Precio Venta Publico ..." />
                    <br><br>-->
                    <input type="submit" id="login" name="login" value="Actualizar" />
                    <input type="reset" value="Cancelar" />
                </form>
            </div>
        </div>
    </section>

</body>
</html>