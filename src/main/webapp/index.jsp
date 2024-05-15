<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="co.edu.unbosque.model.Cliente"%>
<%@ page import="co.edu.unbosque.model.dao.impl.ClienteDAOImpl"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="co.edu.unbosque.model.dto.HorarioDTO"%>
<%@ page import="co.edu.unbosque.model.dto.ReservaDTO"%>
<%@ page import="co.edu.unbosque.model.exception.RepetidoException"%>
<%@ page import="co.edu.unbosque.model.exception.InexistenteException"%>
<%@ page import="co.edu.unbosque.servicios.BuscarPistaServicio"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.HashSet"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>Inicio | Vive una experiencia unica en nuestra bolera!</title>
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

<div class="container-fluid" style="padding: 0;">
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

		<!-- Navbar Start -->
		<nav class="navbar navbar-expand navbar-dark sticky-top px-4 py-0"
			style="position: absolute; margin-left: 80vh; margin-top: 4vh; background-color: rgba(240, 248, 255, 0.527); border-radius: 20px;">



			<div class="navbar-nav align-items-center ms-auto">
				<div class="nav-item dropdown">
					<a href="nuevo-cliente-form.html" class="nav-link active"><i
						class="fa fa-th me-2"></i>Registrate</a>
				</div>
			</div>
			<a href="index.jsp" class="navbar-brand d-flex d-lg-none me-4"> <i
				class="fa fa-user-edit"></i>
			</a> <a href="#" class="sidebar-toggler flex-shrink-0"
				style="margin-left: 1vh; margin-right: 1vh;"> <i
				class="fa fa-bars"></i> ADMIN
			</a>

			<div class="navbar-nav align-items-center ms-auto">
				<div class="nav-item dropdown">
					<a href="existente-cliente-form.html" class="nav-link">Inicia
						Sesion <i class="fa fa-keyboard me-2"></i>
					</a>
				</div>
			</div>
		</nav>
		<!-- Navbar End -->
		<%
		session.setAttribute("nombreCliente", "");
		%>
		<!-- Sidebar Start -->
		<div class="sidebar pe-4 pb-3 open">
			<nav class="navbar navbar-dark"
				style="background-color: rgba(240, 248, 255, 0);">
				<a href="index.jsp"> <img src="img/linear-icon.png"
					height="100px" width="237px" style="margin: 0;">
				</a>


				<div class="navbar-nav">
					<div class="nav-item dropdown">

						<div class="nav-link" style="margin-left: 2vh;">
							<form action="TorneoServlet" method="get">
								<h6>Iniciar Sesion</h6>
								<div class="form-floating mb-3">
									<input type="text" class="form-control" id="nombreAdmin"
										name="nombreAdmin" placeholder="Mario Andretti" value="Mario"
										required> <label for="floatingInput">Nombre</label>
								</div>
								<div class="form-floating mb-3">
									<input type="password" class="form-control" id="documentoAdmin"
										name="documentoAdmin" placeholder="10000000" value="76543"
										required> <label for="floatingInput">Documento</label>
								</div>

								<button type="submit" class="btn btn-primary py-3 w-100 mb-4"
									value="ValidarAdmin" name="btn">Ingresar</button>
							</form>
						</div>
					</div>
				</div>

			</nav>
		</div>
	</div>
	<!-- Sidebar End -->
	<!-- Content Start -->
	<!-- Header Start -->
	<header class="content open"
		style="display: flex;; min-height: 70vh; background-image: url('img/header-bg.jpg'); background-size: 100%; background-repeat: no-repeat; mask-image: linear-gradient(black 80%, rgb(0, 0, 0));"
		data-stellar-background-ratio="0.5">

		<div class="" style="margin-top: 50vh; margin-left: 3vh;">
			<h1 class="display-5 fw-bold" style="font-weight: 400; color: white;">Alquila
				una pista ahora</h1>
			<p class="fs-4" style="color: white;">Reserva una gran
				experiencia en la mejor pista de bolos de la ciudad</p>
		</div>
	</header>
	<!-- Header end -->
	<div class="content open">


		<h4 class="mb-2" style="margin-left: 4vh;">Nuestros Ultimos
			ganadores</h4>
		<!-- Widget Start -->
		<div class="container-fluid pt-4 px-4">
			<div class="row g-4">

				<div class="col-sm-12 col-md-6 col-xl-4">
					<div class="h-100 bg-secondary rounded p-4"
						style="background-image: url(img/bg-image\ \(1\).jpg); background-size: cover; background-position: center;">

					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-xl-4">
					<div class="h-100 bg-secondary rounded p-4"
						style="background-image: url(img/bg-image\ \(2\).jpg); background-size: cover; background-position: center;">
						<!--<div class="d-flex align-items-center justify-content-between mb-4">
                                <h6 class="mb-0">Calender</h6>
                                <a href="">Show All</a>
                            </div>
                            <div id="calender"></div>-->
					</div>
				</div>
				<div class="col-sm-12 col-md-6 col-xl-4">
					<div class="h-100 bg-secondary rounded p-4"
						style="background-image: url(img/bg-image\ \(3\).jpg); background-size: cover; background-position: center; color: rgba(240, 248, 255, 0);">
						<div
							class="d-flex align-items-center justify-content-between mb-4">
							<h6 class="mb-0" style="color: rgba(240, 248, 255, 0);">x</h6>
						</div>
						<div class="d-flex mb-2">
							<input class="form-control bg-transparent" type="text"
								placeholder="" style="border-color: rgba(240, 248, 255, 0);">
						</div>
						<div class="d-flex align-items-center py-2" style="border: none;">
							<div class="w-100 ms-3">
								<div
									class="d-flex w-100 align-items-center justify-content-between">
									<span>x</span>
									<button class="btn btn-sm">
										<i class="fa fa-times"></i>
									</button>
								</div>
							</div>
						</div>
						<div class="d-flex align-items-center py-2"
							style="border-color: rgba(240, 248, 255, 0);">
							<div class="w-100 ms-3">
								<div
									class="d-flex w-100 align-items-center justify-content-between">
									<span>x</span>
									<button class="btn btn-sm">
										<i class="fa fa-times"></i>
									</button>
								</div>
							</div>
						</div>
						<div class="d-flex align-items-center py-2"
							style="border-color: rgba(240, 248, 255, 0);">
							<div class="w-100 ms-3">
								<div
									class="d-flex w-100 align-items-center justify-content-between">
									<span>x</span>
									<button class="btn btn-sm text-primary">
										<i class="fa fa-times"></i>
									</button>
								</div>
							</div>
						</div>
						<div class="d-flex align-items-center py-2"
							style="border-color: rgba(240, 248, 255, 0);">
							<div class="w-100 ms-3">
								<div
									class="d-flex w-100 align-items-center justify-content-between">
									<span>x</span>
									<button class="btn btn-sm">
										<i class="fa fa-times"></i>
									</button>
								</div>
							</div>
						</div>
						<div class="d-flex align-items-center py-2"
							style="border-color: rgba(240, 248, 255, 0);">
							<div class="w-100 ms-3">
								<div
									class="d-flex w-100 align-items-center justify-content-between">
									<span>x</span>
									<button class="btn btn-sm">
										<i class="fa fa-times"></i>
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-12 col-xl-6">
					<div class="bg-secondary rounded h-100 p-4">
						<h6 class="mb-4">Opiniones</h6>
						<div class="owl-carousel testimonial-carousel">
							<div class="testimonial-item text-center">
								<img class="img-fluid rounded-circle mx-auto mb-4"
									src="img/testimonial-1.jpg"
									style="width: 100px; height: 100px;">
								<h5 class="mb-1">Gabriela Martinez</h5>
								<p>Ganadora torneo 09</p>
								<p class="mb-0">Un espacio comodo, familiar y de facil
									acceso, disfrutamos mucho con mi familia</p>
							</div>
							<div class="testimonial-item text-center">
								<img class="img-fluid rounded-circle mx-auto mb-4"
									src="img/testimonial-2.jpg"
									style="width: 100px; height: 100px;">
								<h5 class="mb-1">Luis Martinez</h5>
								<p>Ganador torneo 03</p>
								<p class="mb-0">Mucho mejor de lo que imagine, hay que
									cambiar el color de los zapatos pero de resto bien</p>
							</div>
							<div class="testimonial-item text-center">
								<img class="img-fluid rounded-circle mx-auto mb-4"
									src="img/testimonial-3.jpg"
									style="width: 100px; height: 100px;">
								<h5 class="mb-1">Esteban Dido</h5>
								<p>Salon de Billar</p>
								<p class="mb-0">La mesa es de muy buena calidad, se nota la
									inversion, 10/10</p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-12 col-xl-6">
					<div class="bg-secondary rounded h-100 p-4">
						<iframe class="position-relative rounded w-100 h-100"
							src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d994.0854428976011!2d-74.0319984584943!3d4.710562100694156!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x8e3f8555d1b06c95%3A0x4610903a0568130b!2sUniversidad%20El%20Bosque!5e0!3m2!1ses!2sco!4v1710829720302!5m2!1ses!2sco"
							aria-hidden="false" tabindex="0"
							style="filter: grayscale(100%) invert(92%) contrast(83%); border: 0;"></iframe>

					</div>
				</div>
			</div>
		</div>
		<!-- Widget End -->
		<!-- Previous Torunamets Start -->
		<div class="container-fluid pt-4 px-4">
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


			<div class="bg-secondary text-center rounded p-4">
				<div class="d-flex align-items-center justify-content-between mb-4">
					<h6 class="mb-0">Torneos anteriores</h6>
					<h7 class="mb-0">TAPITAS Jueves</h7>
					
				</div>
				<div class="table-responsive">
					<table
						class="table text-start align-middle table-bordered table-hover mb-0">
						<thead>
							<tr class="text-white">
								<th scope="col">Nombre</th>
								<th scope="col">Ronda 1</th>
								<th scope="col">Ronda 2</th>
								<th scope="col">Ronda 3</th>
								<th scope="col">Total</th>
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
							</tr>
							<%
							}
							} else {
							%>
							<tr>
								<td colspan="5">No se encontraron clientes con puntajes
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
		<!-- Torneo 2 -->

		<div class="container-fluid pt-4 px-4">
			<div class="bg-secondary text-center rounded p-4">
				<div class="d-flex align-items-center justify-content-between mb-4">
					<h7 class="mb-0">TAPITAS Viernes</h7>
					<h8 class="mb-0">Participantes 1</h8>
				</div>
				<div class="table-responsive">
					<table
						class="table text-start align-middle table-bordered table-hover mb-0">
						<thead>
							<tr class="text-white">
								<th scope="col">Nombre</th>
								<th scope="col">Ronda 1</th>
								<th scope="col">Ronda 2</th>
								<th scope="col">Ronda 3</th>
								<th scope="col">Total</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Luis Martinez</td>
								<td>125</td>
								<td>135</td>
								<td>145</td>
								<td>405</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!-- Previous Torunamets End -->

		<!-- Footer Start -->
		<div class="container-fluid pt-4 px-4">
			<div class="bg-secondary rounded-top p-4">
				<div class="row">
					<div class="col-12 col-sm-6 text-center text-sm-start">
						&copy; <a href="#">SpareAndStrike, Unbosque</a>, Todos los
						derechos reservados.
					</div>
					<div class="col-12 col-sm-6 text-center text-sm-end"></div>
				</div>
			</div>
		</div>
		<!-- Footer End -->
	</div>

	<!-- Content End -->

</div>


<!-- Back to Top -->
<a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i
	class="bi bi-arrow-up"></i></a>


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