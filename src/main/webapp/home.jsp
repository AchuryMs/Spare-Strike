<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.time.LocalDate"%>
<%@ page import="co.edu.unbosque.model.dto.HorarioDTO"%>
<%@ page import="co.edu.unbosque.model.dto.ReservaDTO"%>
<%@ page import="co.edu.unbosque.model.dto.TorneoDTO"%>
<%@ page import="co.edu.unbosque.servicios.GestionarTorneo"%>
<%@ page import="co.edu.unbosque.model.dto.TorneoDTO"%>
<%@ page import="co.edu.unbosque.model.dto.ClienteDTO"%>
<%@ page import="co.edu.unbosque.model.exception.RepetidoException"%>
<%@ page import="co.edu.unbosque.model.exception.InexistenteException"%>
<%@ page import="co.edu.unbosque.servicios.BuscarPistaServicio"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.HashSet"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>Home | Usuario</title>
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
	<%
	//variables de sesion
	String nombreCliente;
	int idCliente;
	ArrayList<ReservaDTO> reservas;
	ArrayList<TorneoDTO> torneosDisponibles;
	//ArrayList<ReservaDTO> reservas = (ArrayList<ReservaDTO>) request.getAttribute("reservas");
	ArrayList<HorarioDTO> horarios = (ArrayList<HorarioDTO>) request.getAttribute("horarios");
	
	if (request.getAttribute("nombreCliente") == null) {
		nombreCliente = request.getParameter("nombreCliente");
		idCliente = Integer.parseInt(request.getParameter("idCliente").toString());
		reservas = (ArrayList<ReservaDTO>) application.getAttribute("reservas");
		torneosDisponibles = (ArrayList<TorneoDTO>) application.getAttribute("torneos");

	} else {
		nombreCliente = (String) request.getAttribute("nombreCliente");
		idCliente = Integer.parseInt(request.getAttribute("idCliente").toString());
		application.setAttribute("reservas", (ArrayList<ReservaDTO>) request.getAttribute("reservas"));
		application.setAttribute("torneos", torneosDisponibles = (ArrayList<TorneoDTO>) request.getAttribute("torneos"));
	}
	%>
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
		<!-- Sidebar Start -->
		<div class="sidebar pe-4 pb-3">
			<nav class="navbar bg-secondary navbar-dark">
				<a href="index.jsp"> <img src="img/linear-icon.png"
					height="100px" width="237px" style="margin: 0;">
				</a>
				<div class="d-flex align-items-center ms-4 mb-4">
					<div class="position-relative">
						<img class="rounded-circle" src="img/user.jpg"
							style="width: 40px; height: 40px;">
						<div
							class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1"></div>
					</div>
					<div class="ms-3">
						<h6 class="mb-0">
							Bienvenido,
							<%=//request.getAttribute("nombreCliente")
		nombreCliente%></h6>
						<span>Cliente</span>
					</div>
				</div>
				<div class="navbar-nav w-100">
					<a href="home.jsp" class="nav-item nav-link active"><i
						class="fa fa-calendar-alt me-2"></i>General</a> <a
						href="home-reservas.jsp?nombreCliente=<%=nombreCliente%>&idCliente=<%=idCliente%>"
						class="nav-item nav-link"><i class="fa fa-th me-2"></i>Mis
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
							class="d-none d-lg-inline-flex"><%=idCliente%></span>
						</a>
						<div
							class="dropdown-menu dropdown-menu-end bg-secondary border-0 rounded-0 rounded-bottom m-0">
							<a href="index.jsp" class="dropdown-item">Cerrar Sesion</a>
						</div>
					</div>
				</div>
			</nav>
			<!-- Navbar End -->


			<!-- Form Start -->
			<div class="container-fluid pt-4 px-4">
				<div class="row g-4">
					<div class="col-sm-12 col-xl-6">
						<div class="bg-secondary rounded h-100 p-4">
							<h6 class="mb-4">Reservar</h6>
							<form action="ClienteServlet" method="get">


								<div class="mb-3">
									<label class="form-check-label" for="horaInicial">Hora:</label>
									<input type="time" class="form-control" id="hora" name="hora"
										step="3600" min="17:00" max="23:00" value="17:00">
								</div>
								<div class="mb-3">
									<label class="form-check-label" for="fecha">Fecha:</label> <input
										type="date" class="form-control" id="fecha" name="fecha"
										value="<%=LocalDate.now().plusDays(1)%>">
								</div>
								<!-- manteniendo id y nombre Cliente -->
								<input type="hidden" class="form-control" name="idCliente"
									value="<%=idCliente%>"> <input type="hidden"
									class="form-control" name="nombreCliente"
									value="<%=nombreCliente%>">
								<button type="submit" class="btn btn-primary"
									value="BuscarHorarios" name="btn">Buscar Horarios</button>
							</form>
						</div>
					</div>

					<!-- Form end-->
					<div class="col-sm-12 col-xl-6 bg-secondary"
						style="height: 300px; overflow-y: scroll;">
						<div class="bg-secondary rounded h-100 p-4">
							<h6 class="mb-4">Horarios disponibles</h6>
							<table class="table table-hover">
								<%
								if (horarios != null && !horarios.isEmpty()) {
								%>
								<thead>
									<tr>
										<th scope="col">Juego</th>
										<th scope="col">Inicio</th>
										<th scope="col">Fin</th>
										<th scope="col">Pista</th>
										<th scope="col">Estado</th>
										<th scope="col">Jugadores</th>
										<th scope="col">Snacks</th>
										<th scope="col"></th>
									</tr>
								</thead>

								<tbody>

									<%
									for (HorarioDTO horario : horarios) {
									%>
									<div style="display: none;"><%=horario.isEstado() ? "true" : "false"%></div>
									<tr>
										<td style="text-transform: capitalize;"><%=horario.getTipoJuego()%></td>
										<td><%=horario.getHoraInicial()%></td>
										<td><%=horario.getHoraFinal()%></td>
										<td><%=horario.getNumeroPista()%></td>
										<td><%=horario.isEstado() ? "Disponible" : "Ocupado"%></td>
										<form action="ReservaServlet" method="post">

											<td><select class="form-control" name="numeroJugadores"
												id="numeroJugadores">
													<option value="1" selected="selected">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
											</select></td>
											<td><select class="form-control" name="idSnackAdicional"
												id="idSnackAdicional">
													<option value="1" selected="selected">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
											</select></td>
											<td><input type="hidden" name="idHorario"
												value="<%=horario.getId()%>"> <input type="hidden"
												class="form-control" name="idCliente" value="<%=idCliente%>">
												<input type="hidden" class="form-control"
												name="nombreCliente" value="<%=nombreCliente%>"> <%
 if (horario.isEstado()) {
 %>
												<button class="btn btn-primary" type="submit"
													value="CompletarReservar" name="btn">Reservar</button> <%
 } else {
 %>
												<button class='btn btn-primary' value='Ocupado' name='btn'
													disabled>Ocupado</button> <%
 }
 %>
										</form>
										</td>
									</tr>
									<%
									}
									%>
								</tbody>
								<%
								} else {
								%>
								<tbody>
									<tr>No hay registros disponibles
									</tr>
								</tbody>
								<%
								}
								%>
							</table>
						</div>
					</div>
				</div>
			</div>

			<!-- Registers tableEnd -->

			<!-- Previous Torunamets Start -->
			<div class="container-fluid pt-4 px-4">
				<div class="bg-secondary text-center rounded p-4">
					<div class="d-flex align-items-center justify-content-between mb-4">
						<h6 class="mb-0">Torneo Activo</h6>
						<h7 class="mb-0">Nombre del Torneo</h7>
						<h8 class="mb-0">Participantes</h8>
					</div>
					<%
					%>

					<div class="table-responsive">

						<%
						if (!torneosDisponibles.isEmpty()) {
						%>
						<table class="table">
							<thead>
								<tr>
									<th>ID</th>
									<th>Tipo de Juego</th>
									<th>Fecha</th>
									<th>Hora Inicial</th>
									<th>Hora Final</th>
									<th>Número de Pista</th>
									<th>Premio</th>
									<th>Reserva</th>
								</tr>
							</thead>
							<tbody>
								<%
								for (TorneoDTO torneo : torneosDisponibles) {
								%>
								<tr>
									<td><%=torneo.getIdTorneo()%></td>
									<td><%=torneo.getTipoJuego()%></td>
									<td><%=torneo.getFecha()%></td>
									<td><%=torneo.getHoraInicial()%></td>
									<td><%=torneo.getHoraFinal()%></td>
									<td><%=torneo.getNumeroPista()%></td>
									<td><%=torneo.getPremio()%></td>
									<td>
										<form action="TorneoServlet" method="post">
											<input type="hidden" name="idTorneo"
												value="<%=torneo.getIdTorneo()%>">
											<input type="hidden" name="idCliente"
												value="<%=idCliente%>">
											<button class="btn btn-primary" type="submit" 
											value="InscribirseTorneo" name="btn">Inscribirse
											</button>
										</form>
									</td>
								</tr>
								<%
								}
								%>
							</tbody>
						</table>
						<%
						} else {
						%>
						<p>No hay torneos disponibles.</p>
						<%
						}
						%>

					</div>
				</div>
			</div>
		</div>
		<!-- Previous Torunamets End -->

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