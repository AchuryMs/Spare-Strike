package co.edu.unbosque.servicios;

import co.edu.unbosque.model.dao.ClienteDAO;
import co.edu.unbosque.model.dao.DataMapper;
import co.edu.unbosque.model.dao.HorarioDAO;
import co.edu.unbosque.model.dao.TorneoDAO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Map;

import co.edu.unbosque.model.Cliente;
import co.edu.unbosque.model.Horario;
import co.edu.unbosque.model.Torneo;
import co.edu.unbosque.model.dao.impl.ClienteDAOImpl;
import co.edu.unbosque.model.dao.impl.HorariosDAOImpl;
import co.edu.unbosque.model.dao.impl.TorneoDAOImpl;
import co.edu.unbosque.model.dto.ClienteDTO;
import co.edu.unbosque.model.dto.HorarioDTO;
import co.edu.unbosque.model.dto.TorneoDTO;
import co.edu.unbosque.model.exception.InexistenteException;
import co.edu.unbosque.model.exception.RepetidoException;
import co.edu.unbosque.model.exception.ReservaExistente;

public class GestionarTorneo {
	
	private TorneoDAO<Torneo, Integer> torneoDAO;
	private HorarioDAO<Horario, Integer, LocalDate, LocalTime> horarioDAO;
	private ClienteDAO<Cliente, Integer> clienteDAO;
	
	/**
	 * Constructor por defecto de la clase GestionarTorneo.
	 * Inicializa los atributos torneoDAO y horarioDAO con instancias de las implementaciones concretas TorneoDAOImpl y HorariosDAOImpl, respectivamente.
	 */
	public GestionarTorneo() {
		torneoDAO = new TorneoDAOImpl();
		horarioDAO = new HorariosDAOImpl();
		clienteDAO = new ClienteDAOImpl();
	}
	
	/**
	 * Crea un torneo nuevo utilizando los parámetros proporcionados.
	 * @param parametros Mapa de parámetros que contiene la información necesaria para crear el torneo.
	 * @return TorneoDTO que representa el torneo creado.
	 * @throws RepetidoException Si ya existe un torneo con el mismo nombre.
	 * @throws InexistenteException Si no se encuentran horarios de pistas disponibles para el torneo.
	 * @throws ReservaExistente 
	 */
	public TorneoDTO crearTorneo(Map<String, String[]> parametros) throws RepetidoException, InexistenteException, ReservaExistente {
		
		int autoIncrementID = generarIdTorneo();
		int idHorario = generarIdHorario();
		LocalDate fecha = LocalDate.parse(getFirstParameterValue("fecha", parametros));
		int numeroPista = Integer.parseInt(getFirstParameterValue("numeroPista", parametros));
		ArrayList<HorarioDTO> horariosFiltrados = DataMapper.ArrayHorariosToDTO(horarioDAO.consultarFecha(fecha, numeroPista));
		
		// Imprimir los horarios filtrados (para depuración)
		System.out.println("--------------------------------------Horarios Filtrados para Torneo--------------------------------------");
		for(HorarioDTO h: horariosFiltrados) {
			System.out.println(h.toString());
		}
		
		HorarioDTO horarioInicial = horariosFiltrados.get(0);
		HorarioDTO horarioFinal = horariosFiltrados.get(horariosFiltrados.size()-1);
		String tipoJuego = horarioInicial.getTipoJuego();
		LocalTime horaInicial = horarioInicial.getHoraInicial();
		LocalTime horaFinal = horarioFinal.getHoraInicial();
		
		String nombreTorneo = getFirstParameterValue("nombreTorneo", parametros);
		String premio = getFirstParameterValue("premio",parametros);
		
		TorneoDTO torneo = new TorneoDTO(idHorario, tipoJuego, horaInicial, horaFinal, fecha, numeroPista, false, autoIncrementID, nombreTorneo, premio, new ArrayList<ClienteDTO>());
		
		// Actualizar los horarios de las pistas ocupadas por el torneo
		for(HorarioDTO horarioFiltrado: horariosFiltrados) {
			System.out.println(horarioDAO.actualizar(DataMapper.DTOToHorario(horarioFiltrado)));
		}
		
		return DataMapper.torneoToDTO(torneoDAO.crear(DataMapper.DTOToTorneo(torneo)));
		
	}
	
	public String agregarParticipante(int idCliente, TorneoDTO torneo) throws InexistenteException {
	    // Obtener el cliente a partir del ID
	    ClienteDTO cliente = DataMapper.clienteToDTO(clienteDAO.consultar(idCliente));
	    
	    // Generar puntajes aleatorios
	    int primeraRonda = (int) (Math.random() * 250);
	    int segundaRonda = (int) (Math.random() * 250);
	    int terceraRonda = (int) (Math.random() * 250);
	    
	    // Establecer los puntajes y el total
	    cliente.setPrimeraRonda(primeraRonda);
	    cliente.setSegundaRonda(segundaRonda);
	    cliente.setTerceraRonda(terceraRonda);
	    cliente.setTotalRonda(primeraRonda + segundaRonda + terceraRonda);
	    
	    // Actualizar el cliente en la base de datos
	    clienteDAO.actualizar(DataMapper.DTOToCliente(cliente));
	    
	    // Agregar el cliente al torneo
	    torneo.getParticipantes().add(cliente);
	    
	    // Actualizar el torneo en la base de datos
	    return torneoDAO.actualizar(DataMapper.DTOToTorneo(torneo));
	}

	
	public TorneoDTO buscarTorneo(int idTorneo) throws InexistenteException {
		System.out.println("id en servicioTorneo: " +idTorneo);
		return DataMapper.torneoToDTO(torneoDAO.consultar(idTorneo));
	}
	
	/**
	 * Lista todos los torneos existentes.
	 * @return ArrayList de TorneoDTO que representa todos los torneos existentes.
	 */
	public ArrayList<TorneoDTO> listarTorneos(){
		return DataMapper.ArrayTorneosToDTO(torneoDAO.consultarTodos());
	}
	
	/**
	 * Lista todos los horarios de pistas existentes.
	 * @return ArrayList de HorarioDTO que representa todos los horarios de pistas existentes.
	 */
	public ArrayList<HorarioDTO> listarHorarios(){
		return DataMapper.ArrayHorariosToDTO(horarioDAO.consultarTodos());
	}
	
	/**
	 * Obtiene el primer valor asociado con un nombre de parámetro específico del mapa de parámetros.
	 * @param parameterName Nombre del parámetro a buscar.
	 * @param parameters Mapa de parámetros.
	 * @return El primer valor asociado con el nombre de parámetro proporcionado.
	 */
	private static String getFirstParameterValue(String parameterName, Map<String, String[]> parameters) {
        var parameter = parameters.get(parameterName);
        return parameter != null && parameter.length > 0 ? parameter[0] : null; 
    }
	
	/**
	 * Genera un nuevo ID para un torneo.
	 * @return Nuevo ID para un torneo.
	 */
	private int generarIdTorneo() {
		return listarTorneos().size() + 1;
	}
	
	/**
	 * Genera un nuevo ID para un horario de pista.
	 * @return Nuevo ID para un horario de pista.
	 */
	private int generarIdHorario() {
		return listarHorarios().size() + 1000 + generarIdTorneo();
	}

}
