<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="co.edu.unbosque.model.dto.HorarioDTO"%>
<%@ page import="co.edu.unbosque.model.dto.ReservaDTO"%>
<%@ page import="co.edu.unbosque.model.exception.RepetidoException"%>
<%@ page import="co.edu.unbosque.model.exception.InexistenteException"%>
<%@ page import="co.edu.unbosque.servicios.BuscarPistaServicio"%>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashSet" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>Home | Mis reservas</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Favicon -->
<link href="img/favicon.ico" rel="icon">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Roboto:wght@500;700&display=swap"
	rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css"
	rel="stylesheet" />

<!-- Customized Bootstrap Stylesheet -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<div class="container-fluid position-relative d-flex p-0">
		<!-- Spinner Start -->
		<div id="spinner"
			class="show bg-dark position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
			<div class="spinner-border text-primary"
				style="width: 3rem; height: 3rem;" role="status">
				<span class="sr-only">Loading...</span>
			</div>
		</div>
		<!-- Spinner End -->
		
		
		<%  String clientName;

			ArrayList<ReservaDTO> reservas;
			if(request.getAttribute("reservas") == null){
			 reservas = (ArrayList<ReservaDTO>) application.getAttribute("reservas");
			
			}else{
				reservas = (ArrayList<ReservaDTO>) request.getAttribute("reservas");
				application.setAttribute("reservas", (ArrayList<ReservaDTO>) request.getAttribute("reservas"));
			}
			clientName = (String) request.getParameter("nombreCliente");
			
			%>
			

		<!-- Sidebar Start -->
		<div class="sidebar pe-4 pb-3">
			<nav class="navbar bg-secondary navbar-dark">
				<a href="index.jsp"> <img src="img/linear-icon.png"
					height="100px" width="237px" style="margin: 0;">
				</a>
				<div class="d-flex align-items-center ms-4 mb-4">
					<div class="position-relative">
						<img class="rounded-circle" src="img/user.jpg" alt=""
							style="width: 40px; height: 40px;">
						<div
							class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1"></div>
					</div>
					<div class="ms-3">
						<h6 class="mb-0">
							Bienvenido,
							<%=clientName%></h6>
						<span>Cliente</span>
					</div>
				</div>
				<div class="navbar-nav w-100">
					<a href="home.jsp?nombreCliente=<%=request.getParameter("nombreCliente")%>&idCliente=<%=request.getParameter("idCliente")%>" class="nav-item nav-link "><i
						class="fa fa-tachometer-alt me-2"></i>General</a> <a href="#"
						class="nav-item nav-link active"><i class="fa fa-th me-2"></i>Mis
						Reservas</a>
				</div>
			</nav>
		</div>
		<!-- Sidebar End -->


		<!-- Content Start -->
		<div class="content">
			<!-- Navbar Start -->
			<nav
				class="navbar navbar-expand bg-secondary navbar-dark sticky-top px-4 py-0">
				<a href="index.jsp" class="navbar-brand d-flex d-lg-none me-4">
					<h2 class="text-primary mb-0">
						<i class="fa fa-user-edit"></i>
					</h2>
				</a> <a href="#" class="sidebar-toggler flex-shrink-0"> <i
					class="fa fa-bars"></i>
				</a>
				<div class="navbar-nav align-items-center ms-auto">
					<div class="nav-item dropdown">
						<a href="#" class="nav-link dropdown-toggle"
							data-bs-toggle="dropdown"> <img
							class="rounded-circle me-lg-2" src="img/user.jpg" alt=""
							style="width: 40px; height: 40px;"> <span
							class="d-none d-lg-inline-flex"><%=clientName%></span>
						</a>
						<div
							class="dropdown-menu dropdown-menu-end bg-secondary border-0 rounded-0 rounded-bottom m-0">
							<a href="index.jsp" class="dropdown-item">Cerrar Sesion</a>
						</div>
					</div>
				</div>
			</nav>
			<!-- Navbar End -->

			<!-- Registers tableEnd -->
			<div class="col-sm-12 col-xl-12 bg-secondary">
			    <div class="bg-secondary rounded h-100 p-4">
			        <h6 class="mb-4">Detalles de mis Reservas</h6>
			             <style>
			             
								.cards {
							  display: grid;
							  grid-template-columns: auto auto auto auto ;
							  gap: 15px;
							}
							
							
							.cards .card {
								background-color: #EB1616;
							  display: flex;
							  align-items: center;
							  justify-content: center;
							  flex-direction: column;
							  text-align: center;
							  height: 100px;
							  width: 250px;
							  border-radius: 10px;
							  color: white;
							  cursor: pointer;
							  transition: 400ms;
							}
							
							.cards .card p.tip {
							  font-size: 1em;
							  font-weight: 700;
							}
							
							.cards .card p.second-text {
							  font-size: .7em;
							}
							
							.cards .card:hover {
							  transform: scale(1.1, 1.1);
							}
							
							.cards:hover > .card:not(:hover) {
							  filter: blur(10px);
							  transform: scale(0.9, 0.9);
							}
			                </style>
			                <div class="cards">
			                
			                <% 
			               
			                if (reservas != null && !reservas.isEmpty()) {
			                    Set<Integer> idsProcesados = new HashSet<>();
			                    for (ReservaDTO reserva : reservas) {
			                        if (!idsProcesados.contains(reserva.getId())) {
			                %>
			               
								<div class="card green">
									<p class="tip"><%= reserva.getFecha() %></p>
									<p class="second-text">Jugadores: <%= reserva.getNumeroJugadores() %></p>
									<p class="second-text">Pista: <%= reserva.getNumeroPista() %></p>
									
									
								</div>
			                <% 
			                            idsProcesados.add(reserva.getId());
			                        }
			                    }
			                } else {
			                %>
			                
			        			<h6 class="mb-4">No hay reservas disponibles</h6>
			                   
			                <% } %>
			                
							</div>
							
						
			    </div>
			</div>
			
										<% 
										
									    if (reservas != null && !reservas.isEmpty()) {
									        %>
									        <div class="card-container">
									            <table class="table">
									                <thead>
									                    <tr>
									                        <th>ID</th>
									                        <th>Fecha</th>
									                        <th>Jugadores</th>
									                        <th>Pista</th>
									                        <th>Horario</th>
									                        <th>Tipo de juego</th>
									                    </tr>
									                </thead>
									                <tbody>
									                    <% 
									                    Set<Integer> idsProcesados = new HashSet<>();
									                    for (ReservaDTO reserva : reservas) {
									                        if (!idsProcesados.contains(reserva.getId())) {
									                    %>
									                    <tr>
									                        <td><%= reserva.getId() %></td>
									                        <td><%= reserva.getFecha() %></td>
									                        <td><%= reserva.getNumeroJugadores() %></td>
									                        <td><%= reserva.getNumeroPista() %></td>
									                        <td><%= reserva.getHoraInicial() %> - <%= reserva.getHoraFinal() %></td>
									                        <td><%= reserva.getTipoJuego() %></td>
									                    </tr>
									                    <% 
									                            idsProcesados.add(reserva.getId());
									                        }
									                    }
									                    %>
									                </tbody>
									            </table>
									        </div> <!-- Cierre de div.card-container -->
									        <% 
									    } else {
									    %>
									    <h6 class="mb-4">No hay reservas disponibles</h6>
									    <% 
									    } 
									%>

	

		<!-- Back to Top -->
		<a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i
			class="bi bi-arrow-up"></i></a>
	</div>

	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<script src="lib/chart/chart.min.js"></script>
	<script src="lib/easing/easing.min.js"></script>
	<script src="lib/waypoints/waypoints.min.js"></script>
	<script src="lib/owlcarousel/owl.carousel.min.js"></script>
	<script src="lib/tempusdominus/js/moment.min.js"></script>
	<script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
	<script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

	<!-- Template Javascript -->
	<script src="js/main.js"></script>
</body>

</html>