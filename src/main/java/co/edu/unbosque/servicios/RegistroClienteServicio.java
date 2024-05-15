package co.edu.unbosque.servicios;

import java.util.ArrayList;
import java.util.Map;

import co.edu.unbosque.model.Cliente;
import co.edu.unbosque.model.dao.ClienteDAO;
import co.edu.unbosque.model.dao.DataMapper;
import co.edu.unbosque.model.dao.impl.ClienteDAOImpl;
import co.edu.unbosque.model.dto.ClienteDTO;
import co.edu.unbosque.model.dto.ReservaDTO;
import co.edu.unbosque.model.dto.TorneoDTO;
import co.edu.unbosque.model.exception.InexistenteException;
import co.edu.unbosque.model.exception.RepetidoException;

public class RegistroClienteServicio {

	private ClienteDAO<Cliente, Integer> clienteDAO;

	/**
	 * Constructor por defecto de la clase RegistroClienteServicio.
	 * Inicializa el atributo clienteDAO con una instancia de la implementación concreta ClienteDAOImpl.
	 */
	public RegistroClienteServicio() {
		clienteDAO = new ClienteDAOImpl();
	}

	/**
	 * Registra un nuevo cliente utilizando los parámetros proporcionados.
	 * @param parametros Mapa de parámetros que contiene la información necesaria para registrar al cliente.
	 * @return ClienteDTO que representa al cliente registrado.
	 * @throws RepetidoException Si ya existe un cliente con la misma cédula.
	 */
	public ClienteDTO registarCliente(Map<String, String[]> parametros) throws RepetidoException {

		String nombre = getFirstParameterValue("nombreCliente", parametros);
		int cedula = Integer.parseInt(getFirstParameterValue("documentoCliente", parametros));
		int idCliente = generarId();
		ArrayList<ReservaDTO> historialReservas = new ArrayList<ReservaDTO>();
		ArrayList<TorneoDTO> historialTorneos = new ArrayList<TorneoDTO>();

		ClienteDTO cliente = new ClienteDTO(nombre, idCliente, cedula, historialReservas, 0, 0, 0, historialTorneos);

		return DataMapper.clienteToDTO(clienteDAO.crear(DataMapper.DTOToCliente(cliente)));
	}
	
	/**
	 * Busca un cliente por su ID o por su cédula, según los parámetros proporcionados.
	 * @param parametros Mapa de parámetros que contiene la información necesaria para buscar al cliente.
	 * @return ClienteDTO que representa al cliente encontrado.
	 * @throws InexistenteException Si no se encuentra ningún cliente con el ID o la cédula proporcionados.
	 */
	public ClienteDTO buscarCliente(Map<String, String[]> parametros) throws InexistenteException {
		String idString = getFirstParameterValue("idCliente", parametros);
		int idCliente = 0;
		if(!idString.isEmpty())
			 idCliente= Integer.parseInt(idString);
		int cedula = Integer.parseInt(getFirstParameterValue("documentoCliente", parametros));
		if(idCliente + 0 == 0)
			return DataMapper.clienteToDTO(clienteDAO.consultar(cedula));
		return DataMapper.clienteToDTO(clienteDAO.consultar(idCliente));
	}
	
	/**
	 * Lista todos los clientes registrados.
	 * @return ArrayList de ClienteDTO que representa a todos los clientes registrados.
	 */
	public ArrayList<ClienteDTO> listarClientes(){
		return DataMapper.ArrayClientesToDTO(clienteDAO.consultarTodos());
	}
	
	/**
	 * Actualiza la información de un cliente utilizando los parámetros proporcionados.
	 * @param parametros Mapa de parámetros que contiene la información actualizada del cliente.
	 * @return Mensaje indicando el resultado de la actualización.
	 * @throws InexistenteException Si no se encuentra ningún cliente con la cédula proporcionada.
	 */
	public String actualizarCliente(Map<String, String[]> parametros) throws InexistenteException {

		String nombre = getFirstParameterValue("nombreCliente", parametros);
		int cedula = Integer.parseInt(getFirstParameterValue("documentoCliente", parametros));
		System.out.println("El Nuevo cliente es: " + nombre +" cc: "+ cedula);
		ArrayList<ReservaDTO> historialReservas = new ArrayList<>();
		int id = 0;
		for(ClienteDTO guardado: listarClientes()) {
			if(guardado.getCedula() == cedula) {
				id = guardado.getId();
			}
		}		
		ClienteDTO nuevoCliente = new ClienteDTO(nombre, id, cedula, historialReservas);
		String resultado = clienteDAO.actualizar(DataMapper.DTOToCliente(nuevoCliente));

		return resultado;
	}
	
	/**
	 * Agrega una reserva al historial de reservas de un cliente.
	 * @param reserva ReservaDTO que representa la reserva a agregar.
	 * @param idCliente ID del cliente al que se le agrega la reserva.
	 * @return Mensaje indicando el resultado de la operación.
	 * @throws InexistenteException Si no se encuentra ningún cliente con el ID proporcionado.
	 */
	public String crearHistorialReserva(ReservaDTO reserva, int idCliente) throws InexistenteException {
		String resultado = "La reserva no ha sido creada en el historial.";
		ClienteDTO cliente = DataMapper.clienteToDTO(clienteDAO.consultar(idCliente));
		cliente.getHistorialReservas().add(reserva);
		
		clienteDAO.actualizar(DataMapper.DTOToCliente(cliente));

		return resultado;
	}
	
	/**
	 * Crea un historial de torneo para un cliente dado, agregando el torneo proporcionado al historial del cliente.
	 *
	 * @param torneo    El objeto TorneoDTO que se va a agregar al historial del cliente.
	 * @param idCliente El ID del cliente al cual se le va a agregar el torneo al historial.
	 * @return Un mensaje indicando el resultado de la operación.
	 * @throws InexistenteException Si el cliente con el ID especificado no existe en el sistema.
	 */
	public String crearHistorialTorneo(TorneoDTO torneo, int idCliente) throws InexistenteException {
	    String resultado = "El torneo no ha sido creado en el historial.";
	    ClienteDTO cliente = DataMapper.clienteToDTO(clienteDAO.consultar(idCliente));
	    for(TorneoDTO t: cliente.getHistorialTorneos()) {
	    	if(cliente.getHistorialTorneos().contains(torneo))
	    		cliente.getHistorialTorneos().add(torneo);
	    }
	    resultado = clienteDAO.actualizar(DataMapper.DTOToCliente(cliente));
	    System.out.println("--------------------------------------Historial Torneos del Cliente--------------------------------------");
		for(TorneoDTO t: cliente.getHistorialTorneos()) {
			System.out.println(t.toString());
		}
	    System.out.println(resultado);
	    return resultado;
	}
	
	/**
	 * Lista todas las reservas en el historial de un cliente específico.
	 * @param idCliente ID del cliente del que se desean listar las reservas en el historial.
	 * @return ArrayList de ReservaDTO que representa todas las reservas en el historial del cliente.
	 * @throws InexistenteException Si no se encuentra ningún cliente con el ID proporcionado.
	 */
	public ArrayList<ReservaDTO> listarHistorialReservas(int idCliente) throws InexistenteException{
		ArrayList<ReservaDTO> historialReservas = new ArrayList<ReservaDTO>();
		for(ClienteDTO c: DataMapper.ArrayClientesToDTO(clienteDAO.consultarTodos())) {
			for(ReservaDTO r: c.getHistorialReservas()) {
				if(idCliente == r.getIdCliente()  )
				historialReservas.add(r);
			}
		}
		return historialReservas;
	}
	
	/**
	 * Obtiene el primer valor asociado con un nombre de parámetro específico del mapa de parámetros.
	 * @param parameterName Nombre del parámetro a buscar.
	 * @param parameters Mapa de parámetros.
	 * @return El primer valor asociado con el nombre de parámetro proporcionado.
	 */
	public static String getFirstParameterValue(String parameterName, Map<String, String[]> parameters) {
		var parameter = parameters.get(parameterName);
		return parameter[0];
	}

	/**
	 * Genera un nuevo ID para un cliente.
	 * @return Nuevo ID para un cliente.
	 */
	private int generarId() {
		return listarClientes().size() +1;
	}
}
