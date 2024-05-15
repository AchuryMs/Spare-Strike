package co.edu.unbosque.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.model.dto.ClienteDTO;
import co.edu.unbosque.model.dto.HorarioDTO;
import co.edu.unbosque.model.exception.InexistenteException;
import co.edu.unbosque.model.exception.RepetidoException;
import co.edu.unbosque.servicios.BuscarPistaServicio;
import co.edu.unbosque.servicios.GestionarTorneo;
import co.edu.unbosque.servicios.RegistroClienteServicio;

/**
 * Servlet implementation class ClienteServlet
 * 
 * Este servlet gestiona las solicitudes relacionadas con los clientes, como el registro, inicio de sesión, actualización de información y búsqueda de horarios disponibles.
 */
public class ClienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final RegistroClienteServicio registroClienteServicio;
    private final BuscarPistaServicio buscarPistaServicio;
    private final GestionarTorneo gestionTorneoServicio;

    /**
     * Constructor por defecto del servlet.
     */
    public ClienteServlet() {
        registroClienteServicio = new RegistroClienteServicio();
        buscarPistaServicio = new BuscarPistaServicio();
        gestionTorneoServicio = new GestionarTorneo();
    }

    /**
     * Maneja las solicitudes GET relacionadas con los clientes, como la búsqueda de horarios disponibles y la lista de reservas.
     * 
     * @param request  la solicitud HTTP
     * @param response la respuesta HTTP
     * @throws ServletException si ocurre un error en el servlet
     * @throws IOException      si ocurre un error de entrada/salida
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String op = request.getParameter("btn");
        
        switch(op) {
        
        case "BuscarHorarios":
            try {
                
                 ArrayList<HorarioDTO> horariosEncontrados = buscarPistaServicio.buscarPistaPorFechayHora(request.getParameterMap());
                 System.out.println("--------------------------------------Horarios Encontrados--------------------------------------"); 
                 for(HorarioDTO horarios: horariosEncontrados ) {
                    System.out.println(horarios.toString());
                 }
                request.setAttribute("fecha",request.getParameter("fecha") );
                request.setAttribute("hora",request.getParameter("hora") );
                request.setAttribute("horarios", horariosEncontrados);
                request.setAttribute("idCliente",request.getParameter("idCliente") );
                request.setAttribute("nombreCliente", request.getParameter("nombreCliente") );
                request.setAttribute("torneos", gestionTorneoServicio.listarTorneos());
                request.getRequestDispatcher("home.jsp").forward(request, response);
            } catch (InexistenteException e) {
                response.sendRedirect("error.jsp");
            }
        break;
        
        case "MisReservas":
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            try {
                registroClienteServicio.listarHistorialReservas(idCliente);
            } catch (InexistenteException e) {
                response.sendRedirect("error.jsp");
            }
        break;
        }
    }
    /**
     * Maneja las solicitudes POST relacionadas con los clientes, como el registro, inicio de sesión y actualización de información.
     * 
     * @param request  la solicitud HTTP
     * @param response la respuesta HTTP
     * @throws ServletException si ocurre un error en el servlet
     * @throws IOException      si ocurre un error de entrada/salida
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String op = request.getParameter("btn");
        
        switch(op) {
        
        case "RegistarCliente":
            
            try {
                registroClienteServicio.registarCliente(request.getParameterMap());
                System.out.println("--------------------------------------Clientes Registrados--------------------------------------"); 
                 for(ClienteDTO clientes: registroClienteServicio.listarClientes()) {
                    System.out.println(clientes.toString()); 
                 }
                request.setAttribute("idCliente", registroClienteServicio.listarClientes().size());
                System.out.println("Id del cliente cuando se registra: "+ request.getAttribute("idCliente"));
                request.setAttribute("nombreCliente", request.getParameter("nombreCliente") );
                request.setAttribute("torneos", gestionTorneoServicio.listarTorneos());
                request.getRequestDispatcher("home.jsp").forward(request, response);
            } catch (RepetidoException e) {                
                response.sendRedirect("error.jsp");
            }
            
        break;
        
        case "IniciarSesionCliente":
            try {
                ClienteDTO cliente = registroClienteServicio.buscarCliente(request.getParameterMap());
                request.setAttribute("idCliente", cliente.getId());
                System.out.println("Id del CLiente cuando inicia sesion: "+ request.getAttribute("idCliente"));
                request.setAttribute("nombreCliente", request.getParameter("nombreCliente") );
                request.setAttribute("torneos", gestionTorneoServicio.listarTorneos());
                request.getRequestDispatcher("home.jsp").forward(request, response);
            } catch (InexistenteException e) {
                response.sendRedirect("error.jsp");
            }
        break;
        
        case "ActualizarCliente":
            
            try {
                String res = registroClienteServicio.actualizarCliente(request.getParameterMap());
                System.out.println(res);
                System.out.println("--------------------------------------Clientes Actualizados--------------------------------------"); 
                for(ClienteDTO clientes: registroClienteServicio.listarClientes()) {
                    System.out.println(clientes.toString());
                 }
                request.setAttribute("idCliente",request.getParameter("idCliente") );
                request.setAttribute("nombreCliente", request.getParameter("nombreCliente") );
                request.setAttribute("torneos", gestionTorneoServicio.listarTorneos());
                request.getRequestDispatcher("home.jsp").forward(request, response);
                
            } catch (InexistenteException e) {
                response.sendRedirect("error.jsp");
            }
            
        break;
        }
        
        doGet(request, response);
    }

}
