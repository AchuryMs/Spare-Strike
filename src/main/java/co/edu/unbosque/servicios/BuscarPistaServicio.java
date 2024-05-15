
package co.edu.unbosque.servicios;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Map;

import co.edu.unbosque.model.Horario;
import co.edu.unbosque.model.dao.DataMapper;
import co.edu.unbosque.model.dao.HorarioDAO;
import co.edu.unbosque.model.dao.impl.HorariosDAOImpl;
import co.edu.unbosque.model.dto.HorarioDTO;
import co.edu.unbosque.model.exception.InexistenteException;
import co.edu.unbosque.model.exception.ReservaExistente;

public class BuscarPistaServicio {
	
	private HorarioDAO horarioDAO;
	
	/**
	 * Constructor por defecto de la clase BuscarPistaServicio.
	 * Inicializa el atributo horarioDAO con una instancia de la implementación concreta HorariosDAOImpl.
	 */
	public BuscarPistaServicio() {
		horarioDAO = new HorariosDAOImpl();
	}
	
	/**
	 * Busca horarios de pistas basados en una fecha y una hora específicas.
	 * @param parametros Mapa de parámetros que contiene la fecha y la hora de búsqueda.
	 * @return ArrayList de HorarioDTO que representa los horarios de pistas encontrados.
	 * @throws InexistenteException Si no se encuentran horarios de pistas para la fecha y hora especificadas.
	 */
	public ArrayList<HorarioDTO> buscarPistaPorFechayHora(Map<String, String[]> parametros) throws  InexistenteException {

		String fecha = getFirstParameterValue("fecha", parametros);
		String hora = getFirstParameterValue("hora", parametros);
		return DataMapper.ArrayHorariosToDTO(horarioDAO.consultarFechayHora(LocalDate.parse(fecha), LocalTime.parse(hora)));
	}
	
	/**
	 * Busca horarios de pistas basados en una fecha específica y un número de pista.
	 * @param parametros Mapa de parámetros que contiene la fecha y el número de pista de búsqueda.
	 * @return ArrayList de HorarioDTO que representa los horarios de pistas encontrados.
	 * @throws InexistenteException Si no se encuentran horarios de pistas para la fecha y número de pista especificados.
	 * @throws ReservaExistente 
	 */
	public ArrayList<HorarioDTO> buscarPistaPorFecha(Map<String, String[]> parametros) throws  InexistenteException, ReservaExistente {

		String fecha = getFirstParameterValue("fecha", parametros);
		int numeroPista = Integer.parseInt(getFirstParameterValue("numeroPista", parametros));
		return DataMapper.ArrayHorariosToDTO(horarioDAO.consultarFecha(LocalDate.parse(fecha), numeroPista));
	}

	/**
	 * Obtiene el primer valor asociado con un nombre de parámetro específico del mapa de parámetros.
	 * @param parameterName Nombre del parámetro a buscar.
	 * @param parameters Mapa de parámetros.
	 * @return El primer valor asociado con el nombre de parámetro proporcionado.
	 */
	private static String getFirstParameterValue(String parameterName, Map<String, String[]> parameters) {
		var parameter = parameters.get(parameterName);
		return parameter[0];
	}
}
