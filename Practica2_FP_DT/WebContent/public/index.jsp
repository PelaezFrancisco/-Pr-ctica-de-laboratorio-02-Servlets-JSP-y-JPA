<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Practica 1 Juan Francisco Pelaez y Diana Tixi </title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
    <!-- Font Awesome icons (free version)-->
    <script src="https://use.fontawesome.com/releases/v5.15.1/js/all.js" crossorigin="anonymous"></script>
    <script src="js/index.js"></script>
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet" /> 
    <!-- <link href="../css/styles.css" rel="stylesheet" />-->
</head>

<body id="page-top">
    <!-- Navigation-->
    <nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
        <div class="container">
            <a class="navbar-brand js-scroll-trigger" href="#page-top">Start Bootstrap</a>
            <button class="navbar-toggler navbar-toggler-right text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars"></i>
                </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="public/IniciarSesion.html">Iniciar Sesion</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#empresas">Empresas</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#about">Acerca De</a></li>
                    
                </ul>
            </div>
        </div>
    </nav>
    <!-- Masthead-->
    <header class="masthead bg-primary text-white text-center">
        <div class="container d-flex align-items-center flex-column">
            <!-- Masthead Avatar Image-->
            <img class="masthead-avatar mb-5" src="assets/img/avataaars.svg" alt="" />
            <!-- Masthead Heading-->
            <h1 class="masthead-heading text-uppercase mb-0">Bienvenido a TiPe!</h1>
            <!-- Icon Divider-->
            <div class="divider-custom divider-light">
                <div class="divider-custom-line"></div>
                <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                <div class="divider-custom-line"></div>
            </div>
        </div>
    </header>
    <!-- Portfolio Section-->
    <section class="page-section portfolio" id="empresas">
        <div class="container">
            <!-- Portfolio Section Heading-->
            <h2 class="titulo_empresa">Empresas Disponibles</h2>
            <div class="formulario">
	            <div class="datos">
		                <select class="select_empresa" id="items" name="emp" onchange="sendpage()">
		                	<option value="1" class="opcion_empresa">-- Seleccione --</option>
	                        <option value="1" class="opcion_empresa">Norma</option>
	                        <option value="2" class="opcion_empresa">Nestle</option>
	                        <option value="3" class="opcion_empresa">Coca Cola</option>
	                        <option value="4" class="opcion_empresa">Colgate</option>
	                        <option value="5" class="opcion_empresa">L-Oreal</option>
	                        <option value="6" class="opcion_empresa">Samsung</option>
	                        <option value="7" class="opcion_empresa">Apple Inc</option>
	                        <option value="8" class="opcion_empresa">TVentas</option>
	                        <option value="9" class="opcion_empresa">Jugeton</option>
	                    </select><br><br>
		        </div>
            </div>
            
            <!-- Icon Divider-->
            <c:set var="obj_empresa" scope="request" value="${empresa}" />
            <div class="divider-custom">
                <div class="divider-custom-line"></div>
                <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                <div class="divider-custom-line"></div>
            </div>
            <h3 class="nombre_empresa">Empresa: ${obj_empresa.empresaNombre}</h3>
            <!-- Icon Divider-->
           <!-- Icon Divider-->
            <div class="divider-custom" style="margin-bottom: -40px">
                <div class="divider-custom-line" style="position: relative; top: -40px"></div>
                <div class="divider-custom-icon" style="position: relative; top: -40px"><i class="fas fa-star"></i></div>
                <div class="divider-custom-line" style="position: relative; top: -40px"></div>
            </div>
            <h2 class="titulo_productos">Productos</h2>
            <hr>
            <!-- Portfolio Grid Items-->
            <!-- 
            
            PRODUCTOS
            
             -->
            <div class="row justify-content-center">
			<c:set var="list_productos" scope="request" value="${empresa.producto}" />
			<script type="text/javascript">
			function redirectSignIn(){
				console.log("Entro a redirreccion");
				document.location.href = 'public/IniciarSesion.html';
				
			}
			</script>
			
			<c:forEach var="pro" items="${list_productos}">
       			<!-- Portfolio Item 1-->
	                <div class="col-md-6 col-lg-4 mb-5" onclick="redirectSignIn()">
	                    <div class="portfolio-item mx-auto" data-toggle="modal" >
	                            <div class="portfolio-item-caption-content text-center text-white"></div>
	                        <img class="img-fluid" style="width: 400px; height: 280px" src="${pro.productoImagen}" alt="" />
	                        <h3 style="text-align: center">${pro.productoNombre}</h3>
	                        <p style="text-align: center">${pro.productoDescripcion}</p>
	                    </div>
	                </div>  
        	</c:forEach>
        	</div>
        </div>
    </section>
    <!-- About Section-->
    <section class="page-section bg-primary text-white mb-0" id="about">
        <div class="container">
            <!-- About Section Heading-->
            <h2 class="page-section-heading text-center text-uppercase text-white">Acerca de Nosotros</h2>
            <!-- Icon Divider-->
            <div class="divider-custom divider-light">
                <div class="divider-custom-line"></div>
                <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                <div class="divider-custom-line"></div>
            </div>
            <!-- About Section Content-->
            <div class="row">
                <div class="col-lg-4 ml-auto">
                    <p class="lead">Somos una pequeña empresa encargada de Gestionar la Funciones de pedidos de las empresas.</p>
                </div>
                <div class="col-lg-4 mr-auto">
                    <p class="lead">Nuestro trabajo es siempre garantizar el profesionalismo y seguridad de nuestra plataforma</p>
                </div>
            </div>
            <!-- About Section Button-->
        </div>
    </section>
    <!-- Footer-->
    <footer class="footer text-center">
        <div class="container">
            <div class="row">
                <!-- Footer Location-->
                <div class="col-lg-4 mb-5 mb-lg-0">
                    <h4 class="text-uppercase mb-4">Localizacion</h4>
                    <p class="lead mb-0">
                        Cuenca, Ecuador
                        <br /> Universidad Politecnica Salesiana
                    </p>
                </div>
                <!-- Footer Social Icons-->
                <div class="col-lg-4 mb-5 mb-lg-0">
                    <h4 class="text-uppercase mb-4">Around the Web</h4>
                    <a class="btn btn-outline-light btn-social mx-1" href="https://www.youtube.com/watch?v=WTWyosdkx44"><i class="fab fa-fw fa-facebook-f"></i></a>
                    <a class="btn btn-outline-light btn-social mx-1" href="https://www.youtube.com/watch?v=WTWyosdkx44"><i class="fab fa-fw fa-twitter"></i></a>
                    <a class="btn btn-outline-light btn-social mx-1" href="https://www.youtube.com/watch?v=WTWyosdkx44"><i class="fab fa-fw fa-linkedin-in"></i></a>
                    <a class="btn btn-outline-light btn-social mx-1" href="https://www.youtube.com/watch?v=WTWyosdkx44"><i class="fab fa-fw fa-dribbble"></i></a>
                </div>
                <!-- Footer About Text-->
                <div class="col-lg-4">
                    <h4 class="text-uppercase mb-4">About Freelancer</h4>
                    <p class="lead mb-0">
                        Freelance is a free to use, MIT licensed Bootstrap theme created by
                        <a href="http://startbootstrap.com">Start Bootstrap</a> .
                    </p>
                </div>
            </div>
        </div>
    </footer>
    <!-- Copyright Section-->
    <div class="copyright py-4 text-center text-white">
        <div class="container"><small>Copyright © Your Website 2020</small></div>
    </div>
    <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes)-->
    <div class="scroll-to-top d-lg-none position-fixed">
        <a class="js-scroll-trigger d-block text-center text-white rounded" href="#page-top"><i class="fa fa-chevron-up"></i></a>
    </div>

    <!-- Bootstrap core JS-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Third party plugin JS-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
    <!-- Contact form JS-->
    <script src="assets/mail/jqBootstrapValidation.js"></script>
    <script src="assets/mail/contact_me.js"></script>
    <!-- Core theme JS-->
    <script src="js/scripts.js"></script>

</body>

</html>