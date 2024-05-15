package co.edu.unbosque.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import co.edu.unbosque.model.dto.ReservaDTO;
import co.edu.unbosque.model.exception.InexistenteException;
import co.edu.unbosque.model.exception.RepetidoException;
import co.edu.unbosque.servicios.GestionarTorneo;
import co.edu.unbosque.servicios.RegistroClienteServicio;
import co.edu.unbosque.servicios.RegistroReservaServicio;

/**
 * Servlet implementation class ReservaServlet
 * 
 * Este servlet se encarga de gestionar las reservas de los clientes.
 */
public class ReservaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final RegistroReservaServicio registroReservaServicio;
    private final RegistroClienteServicio registroClienteServicio;
    private final GestionarTorneo gestionTorneoServicio;

    public ReservaServlet() {
        registroReservaServicio = new RegistroReservaServicio();
        registroClienteServicio = new RegistroClienteServicio();
        gestionTorneoServicio = new GestionarTorneo();
    }

    /**
     * Maneja las solicitudes GET relacionadas con las reservas.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String op = request.getParameter("btn");
        
        switch(op) {
        
        case "":
            
        break;
        }
    }
    /**
     * Maneja las solicitudes POST relacionadas con las reservas.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String op = request.getParameter("btn");
        
        switch(op) {
        
        case "CompletarReservar":
            try {
                int idHorario = Integer.parseInt(request.getParameter("idHorario"));
                int idCliente = Integer.parseInt(request.getParameter("idCliente"));
                
                ReservaDTO reserva = registroReservaServicio.registarReserva(request.getParameterMap(), idCliente, idHorario );
                registroClienteServicio.crearHistorialReserva(reserva, idCliente);
                System.out.println("--------------------------------------Reservas Registradas--------------------------------------"); 
                for(ReservaDTO reservas: registroReservaServicio.listarReservas()) {
                    System.out.println(reservas.toString());
                }
                
                request.setAttribute("idCliente",request.getParameter("idCliente") );
                request.setAttribute("reservas" ,registroClienteServicio.listarHistorialReservas(idCliente));
                request.setAttribute("nombreCliente", request.getParameter("nombreCliente") );
                request.setAttribute("torneos", gestionTorneoServicio.listarTorneos());
                request.getRequestDispatcher("home-reservas.jsp").forward(request, response);
            } catch (RepetidoException | InexistenteException e) {
                response.sendRedirect("error.jsp");
            }
        break;
        }

        doGet(request, response);
    }
}
