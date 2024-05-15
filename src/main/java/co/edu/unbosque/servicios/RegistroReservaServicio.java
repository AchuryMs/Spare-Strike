package co.edu.unbosque.servicios;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Map;

import co.edu.unbosque.model.Horario;
import co.edu.unbosque.model.Reserva;
import co.edu.unbosque.model.dao.DataMapper;
import co.edu.unbosque.model.dao.HorarioDAO;
import co.edu.unbosque.model.dao.ReservaDAO;
import co.edu.unbosque.model.dao.impl.HorariosDAOImpl;
import co.edu.unbosque.model.dao.impl.ReservaDAOImpl;
import co.edu.unbosque.model.dto.HorarioDTO;
import co.edu.unbosque.model.dto.ReservaDTO;
import co.edu.unbosque.model.exception.InexistenteException;
import co.edu.unbosque.model.exception.RepetidoException;

public class RegistroReservaServicio {

    private ReservaDAO<Reserva, Integer> reservaDAO;
    private HorarioDAO<Horario, Integer, LocalDate, LocalTime> horarioDAO;

    /**
     * Constructor por defecto de la clase RegistroReservaServicio.
     * Inicializa los atributos reservaDAO y horarioDAO con instancias de las implementaciones concretas ReservaDAOImpl y HorariosDAOImpl, respectivamente.
     */
    public RegistroReservaServicio() {
        reservaDAO = new ReservaDAOImpl();
        horarioDAO = new HorariosDAOImpl();
    }

    /**
     * Registra una nueva reserva utilizando los parámetros proporcionados.
     * @param parametros Mapa de parámetros que contiene la información necesaria para crear la reserva.
     * @param idCliente ID del cliente que realiza la reserva.
     * @param idHorario ID del horario de pista reservado.
     * @return ReservaDTO que representa la reserva creada.
     * @throws RepetidoException Si ya existe una reserva para el mismo cliente en el mismo horario de pista.
     * @throws InexistenteException Si el horario de pista especificado no existe.
     */
    public ReservaDTO registarReserva(Map<String, String[]> parametros, int idCliente, int idHorario) throws RepetidoException, InexistenteException {
        HorarioDTO horario = DataMapper.horarioToDTO(horarioDAO.consultar(idHorario));
        String tipoJuego = horario.getTipoJuego();
        LocalTime horaInicial = horario.getHoraInicial();
        LocalTime horaFinal = horario.getHoraFinal();
        LocalDate fecha = horario.getFecha();
        int numeroJugadores = Integer.parseInt(getFirstParameterValue("numeroJugadores", parametros));
        int numeroPista = horario.getNumeroPista();
        int idSnackAdicional = Integer.parseInt(getFirstParameterValue("idSnackAdicional", parametros));
        ReservaDTO reserva = new ReservaDTO(idHorario, tipoJuego, horaInicial, horaFinal, fecha, numeroPista, false, idCliente, numeroJugadores, idSnackAdicional);
        System.out.println(horarioDAO.actualizar(DataMapper.DTOToHorario(horario)));
        return DataMapper.reservaToDTO(reservaDAO.crear(DataMapper.DTOToReserva(reserva)));
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

    /**
     * Lista todas las reservas existentes.
     * @return ArrayList de ReservaDTO que representa todas las reservas existentes.
     */
    public ArrayList<ReservaDTO> listarReservas(){
        return DataMapper.ArrayReservasToDTO(reservaDAO.consultarTodos());
    }

}
