<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="co.edu.unbosque.servicios.GestionarTorneo"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="co.edu.unbosque.model.dto.TorneoDTO"%>
<%@ page import="co.edu.unbosque.model.Cliente"%>
<%@ page import="co.edu.unbosque.model.dto.ReservaDTO"%>
<%@ page import="co.edu.unbosque.model.exception.RepetidoException"%>
<%@ page import="co.edu.unbosque.model.exception.InexistenteException"%>
<%@ page import="co.edu.unbosque.servicios.BuscarPistaServicio"%>
<%@ page import="co.edu.unbosque.model.dao.impl.ClienteDAOImpl"%>
<!DOCTYPE html>
<html lang="en">

<head>
<style>
/* Estilos para el modal */
.modal {
	display: none; /* Ocultar el modal por defecto */
	position: fixed; /* Posición fija para cubrir toda la ventana */
	z-index: 1; /* Hacer que el modal esté por encima del contenido */
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	overflow: auto; /* Habilitar el desplazamiento si es necesario */
	background-color: rgba(0, 0, 0, 0.4); /* Fondo semitransparente */
}

/* Estilos para el contenido del modal */
.modal-content {
	background-color: #1a1a1a; /* Fondo blanco */
	margin: 5% auto;
	/* Margen superior e inferior para centrar verticalmente */
	padding: 20px;
	border: 1px solid #888;
	width: 80%; /* Ancho del contenido del modal */
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19); /* Sombra */
}

/* Estilos para el botón de cerrar */
.close {
	color: #aaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

/* Estilos para el botón de cerrar en hover */
.close:hover, .close:focus {
	color: black;
	text-decoration: none;
	cursor: pointer;
}
</style>
<meta charset="utf-8">
<title>Home | Administrador</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">

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
							<%=request.getAttribute("nombreAdmin")%></h6>
						<span>Administrador</span>
					</div>
				</div>
				<div class="navbar-nav w-100">
					<a href="home.jsp" class="nav-item nav-link active"><i
						class="fa fa-tachometer-alt me-2"></i>General</a>
					<div class="nav-item dropdown"></div>
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
							class="d-none d-lg-inline-flex"><%=request.getAttribute("nombreAdmin")%></span>
						</a>
						<div
							class="dropdown-menu dropdown-menu-end bg-secondary border-0 rounded-0 rounded-bottom m-0">
							<a href="index.jsp" class="dropdown-item">Cerrar Sesion</a>
						</div>
					</div>
				</div>
			</nav>
			<!-- Navbar End -->
			<%
			ArrayList<ReservaDTO> reservas = (ArrayList<ReservaDTO>) request.getAttribute("reservas");
			ArrayList<TorneoDTO> torneos = (ArrayList<TorneoDTO>) request.getAttribute("torneos");
			%>
			<!-- Mini widgets start -->
			<div class="container-fluid pt-4 px-4">
				<div class="row g-4">
					<div class="col-sm-6 col-xl-3">
						<div
							class="bg-secondary rounded d-flex align-items-center justify-content-between p-4">
							<i class="fa fa-trophy fa-3x text-primary"></i>
							<div class="ms-3">
								<p class="mb-2">Torneos activos</p>
								<%
								if (torneos != null) {
								%>
								<h6 class="mb-0"><%=torneos.size()%></h6>
								<%
								}
								%>
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-xl-3">
						<div
							class="bg-secondary rounded d-flex align-items-center justify-content-between p-4">
							<i class="fa fa-chart-bar fa-3x text-primary"></i>
							<div class="ms-3">
								<p class="mb-2">Total Reservas</p>
								<%
								if (reservas != null) {
								%>
								<h6 class="mb-0"><%=reservas.size()%></h6>
								<%
								}
								%>
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-xl-3">
						<div
							class="bg-secondary rounded d-flex align-items-center justify-content-between p-4">
							<i class="fa fa-user fa-3x text-primary"></i>
							<div class="ms-3">
								<p class="mb-2">Total Usuarios</p>
								<h6 class="mb-0">2</h6>
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-xl-3">
						<div
							class="bg-secondary rounded d-flex align-items-center justify-content-between p-4">
							<i class="fa fa-receipt fa-3x text-primary"></i>
							<div class="ms-3">
								<p class="mb-2">En torneo</p>
								<h6 class="mb-0">1</h6>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Mini widgets end -->

			<!-- Form torneo start -->
			<div class="container-fluid pt-4 px-4">
				<div class="row g-4">
					<div class="col-sm-12 col-xl-6">
						<div class="bg-secondary rounded h-100 p-4">
							<h6 class="mb-4">Crear un Torneo</h6>
							<form action="TorneoServlet" method="post">


								<div class="mb-3">
									<label class="form-check-label" for="horaInicial">Nombre
										Torneo:</label> <input type="text" class="form-control"
										id="nombreTorneo" name="nombreTorneo" required>
								</div>
								<div class="mb-3">
									<label class="form-check-label" for="fecha">Fecha:</label> <input
										type="date" class="form-control" id="fecha" name="fecha">
								</div>
								<div class="mb-3">
									<label class="form-check-label" for="numeroPista">Numero
										de Pista:</label> <input type="number" class="form-control"
										id="numeroPista" name="numeroPista" min="1" max="12" required>
									<div class="invalid-feedback">Por favor, introduce un
										número entre 1 y 12.</div>
								</div>

								<div class="mb-3">
									<label class="form-check-label" for="premio">Premio:</label> <input
										type="text" class="form-control" id="premio" name="premio">
								</div>


								<!-- manteniendo id y nombre Cliente -->
								<input type="hidden" class="form-control" name="idCliente"
									value="<%=request.getAttribute("idAdmin")%>"> <input
									type="hidden" class="form-control" name="nombreAdmin"
									value="<%=request.getAttribute("nombreAdmin")%>">
								<button type="submit" class="btn btn-primary"
									value="CrearTorneo" name="btn">Crear Torneo</button>
							</form>
						</div>
					</div>
				</div>
			</div>
			<!-- modal and scrip -->



			<!-- All reservations Start -->
			<div class="container-fluid pt-4 px-4">
				<div class="bg-secondary text-center rounded p-4">
					<div class="d-flex align-items-center justify-content-between mb-4">
						<h6 class="mb-0">Todos los torneos disponibles</h6>
					</div>
					<div class="container-fluid pt-4 px-4">
						<div class="bg-secondary text-center rounded p-4">

							<%
							ArrayList<TorneoDTO> torneosDisponibles = (ArrayList<TorneoDTO>) request.getAttribute("torneos");
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
			</div>







			<!-- All Reservations End -->
			<div class="container-fluid pt-4 px-4">
				<div class="bg-secondary text-center rounded p-4">
					<div class="d-flex align-items-center justify-content-between mb-4">
						<h6 class="mb-0">Genera certificado</h6>
					</div>
					<div class="container-fluid pt-4 px-4">
						<div class="bg-secondary text-center rounded p-4">

							<%
							// Crear una instancia del DAO de Cliente
							ClienteDAOImpl clienteDAO = new ClienteDAOImpl();

							// Obtener la lista de todos los clientes
							ArrayList<Cliente> listaClientes = clienteDAO.consultarTodos();

							// Filtrar los clientes con puntajes mayores a 250
							ArrayList<Cliente> clientesFiltrados = new ArrayList<>();
							for (Cliente cliente : listaClientes) {
								int totalRonda = cliente.getPrimeraRonda() + cliente.getSegundaRonda() + cliente.getTerceraRonda();
								if (totalRonda > 250) {
									clientesFiltrados.add(cliente);
								}
							}

							// Ordenar los clientes por totalRonda de mayor a menor
							clientesFiltrados.sort((c1, c2) -> {
								int totalRondaC1 = c1.getPrimeraRonda() + c1.getSegundaRonda() + c1.getTerceraRonda();
								int totalRondaC2 = c2.getPrimeraRonda() + c2.getSegundaRonda() + c2.getTerceraRonda();
								return Integer.compare(totalRondaC2, totalRondaC1);
							});
							%>

							<div class="table-responsive">


								<table class="table">
									<thead>
										<tr>
											<th>Nombre</th>
											<th>Primera Ronda</th>
											<th>Segunda Ronda</th>
											<th>Tercera Ronda</th>
											<th>Total Ronda</th>
											<th>Generar Certificado</th>
										</tr>
									</thead>
									<tbody>
										<%
										if (!clientesFiltrados.isEmpty()) {
											for (Cliente cliente : clientesFiltrados) {
												int totalRonda = cliente.getPrimeraRonda() + cliente.getSegundaRonda() + cliente.getTerceraRonda();
										%>
										<tr>
											<td><%=cliente.getNombre()%></td>
											<td><%=cliente.getPrimeraRonda()%></td>
											<td><%=cliente.getSegundaRonda()%></td>
											<td><%=cliente.getTerceraRonda()%></td>
											<td><%=totalRonda%></td>
											<td><button class="btn btn-primary"
													onclick="openModal('<%=cliente.getNombre()%>', <%=cliente.getPrimeraRonda()%>, <%=cliente.getSegundaRonda()%>, <%=cliente.getTerceraRonda()%>, <%=totalRonda%>)">Generar certificado</button></td>
										</tr>
										<%
										}
										} else {
										%>
										<tr>
											<td colspan="6">No se encontraron clientes con puntajes
												mayores a 250</td>
										</tr>
										<%
										}
										%>
									</tbody>
								</table>




							</div>
						</div>
					</div>
				</div>
			</div>

			<div id="myModal" class="modal">
				<!-- Contenido del modal -->
				<div class="modal-content" style="background-color: black;">
					<span class="close" onclick="closeModal()">&times;</span>
					<p>
						<div class="container-fluid pt-4 px-4">
                    <div class="bg-secondary text-center rounded p-4">
                        <div
								class="d-flex align-items-center justify-content-between mb-4">
								<img height="100px" width="130px" src="img/icon.png">
                            <h6 class="mb-0">Certificado de Participación</h6>
                        </div>
                        <div class="container-fluid pt-4 px-4">
                            <div
									class="bg-secondary text-center rounded p-4">
                                <p id="clienteNombre"></p>
                                <p id="primeraRonda"></p>
                                <p id="segundaRonda"></p>
                                <p id="terceraRonda"></p>
                                <p id="totalRonda"></p>
                                <button class="btn btn-primary" onclick="imprimirDiv('myModal')">Imprimir</button>
                            </div>
                        </div>
                    </div>
                </div>
            </p>
        </div>
    </div>

    <script>

	    function imprimirDiv(idDiv) {
	        var contenido = document.getElementById(idDiv).innerHTML;
	        var contenidoOriginal = document.body.innerHTML;
	
	        document.body.innerHTML = contenido;
	
	        window.print();
	
	        document.body.innerHTML = contenidoOriginal;
	    }
        // Función para abrir el modal y mostrar los datos del cliente
        function openModal(nombre, primeraRonda, segundaRonda, terceraRonda, totalRonda) {
            document.getElementById("clienteNombre").innerText = "Nombre del Cliente: " + nombre;
            document.getElementById("primeraRonda").innerText = "Primera Ronda: " + primeraRonda;
            document.getElementById("segundaRonda").innerText = "Segunda Ronda: " + segundaRonda;
            document.getElementById("terceraRonda").innerText = "Tercera Ronda: " + terceraRonda;
            document.getElementById("totalRonda").innerText = "Total Ronda su puntaje total: " + totalRonda;
            document.getElementById("myModal").style.display = "block";
        }

        // Función para cerrar el modal
        function closeModal() {
            document.getElementById("myModal").style.display = "none";
        }
    </script>
			<!-- Footer Start --><div class="container-fluid pt-4 px-4">
				<div class="bg-secondary rounded-top p-4">
					<div class="row">
						<div class="col-12 col-sm-6 text-center text-sm-start">
							&copy; <a href="#">Spare&Strike, Unbosque</a>, Todos los derechos
							reservados.
						</div>
						<div class="col-12 col-sm-6 text-center text-sm-end"></div>
					</div>
				</div>
			</div>
			<!-- Footer End -->


			<!-- Back to Top -->
			<a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i
				class="bi bi-arrow-up"></i></a>
		</div>
		<!-- Content End -->

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