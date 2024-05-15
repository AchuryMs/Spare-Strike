package co.edu.unbosque.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import co.edu.unbosque.model.dto.TorneoDTO;
import co.edu.unbosque.model.exception.InexistenteException;
import co.edu.unbosque.model.exception.RepetidoException;
import co.edu.unbosque.model.exception.ReservaExistente;
import co.edu.unbosque.servicios.GestionarTorneo;
import co.edu.unbosque.servicios.RegistroClienteServicio;
import co.edu.unbosque.servicios.RegistroReservaServicio;

/**
 * Servlet implementation class TorneoServlet
 */
public class TorneoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final GestionarTorneo gestionTorneoServicio;
    private final RegistroReservaServicio registroReservaServicio;
    private final RegistroClienteServicio registroClienteServicio;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TorneoServlet() {
    	
    	registroReservaServicio = new RegistroReservaServicio();
        gestionTorneoServicio = new GestionarTorneo();
        registroClienteServicio = new RegistroClienteServicio();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("nombreAdmin").equals("Mario") &&  request.getParameter("documentoAdmin").equals("76543")) {
			
			request.setAttribute("nombreAdmin", request.getParameter("nombreAdmin"));
			request.setAttribute("torneos", gestionTorneoServicio.listarTorneos());	
			request.setAttribute("reservas", registroReservaServicio.listarReservas());
			request.getRequestDispatcher("admin-home.jsp").forward(request, response);
			
		}
		else {
			request.setAttribute("mensaje", "El usuario no existe, por favor intente nuevamente");	
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op = request.getParameter("btn");
		
		switch(op) {
		
		case "CrearTorneo":
			try {
				gestionTorneoServicio.crearTorneo(request.getParameterMap());
				System.out.println("--------------------------------------Torneos Creados--------------------------------------");
				for(TorneoDTO torneo: gestionTorneoServicio.listarTorneos()) {
					System.out.println(torneo.toString());
				}
				request.setAttribute("idAdmin",request.getParameter("idAdmin"));
				request.setAttribute("nombreAdmin", request.getParameter("nombreAdmin") );
				request.setAttribute("torneos", gestionTorneoServicio.listarTorneos());
				request.getRequestDispatcher("admin-home.jsp").forward(request, response);
			} catch (RepetidoException | InexistenteException | ReservaExistente e) {
				response.sendRedirect("error.jsp");
			}
			
		break;
		
		case "InscribirseTorneo":
			int idCliente = Integer.parseInt(request.getParameter("idCliente"));
			int idTorneo = Integer.parseInt(request.getParameter("idTorneo"));
			try {
				
				TorneoDTO torneo = gestionTorneoServicio.buscarTorneo(idTorneo);
				String resultado = gestionTorneoServicio.agregarParticipante(idCliente, torneo);
				System.out.println("hasta aca llega 1");
				gestionTorneoServicio.agregarParticipante(idCliente, torneo);
				System.out.println("--------------------------------------Clientes Agregados al Torneo--------------------------------------");
				System.out.println("hasta aca llega 5");
				torneo.getParticipantes().forEach(c -> System.out.println(c.toString()));


				registroClienteServicio.crearHistorialTorneo(torneo, idCliente);				
				request.setAttribute("idCliente",request.getParameter("idCliente") );
				request.setAttribute("nombreCliente", request.getParameter("nombreCliente"));
				request.setAttribute("torneos" , gestionTorneoServicio.listarTorneos());
				request.getRequestDispatcher("home.jsp").forward(request, response);
			} catch (InexistenteException e) {
				response.sendRedirect("error.jsp");
			}
		break;

		}
	}

}
