package co.edu.unbosque.model.dao.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import co.edu.unbosque.model.Horario;
import co.edu.unbosque.model.dao.HorarioDAO;
import co.edu.unbosque.model.exception.InexistenteException;
import co.edu.unbosque.model.exception.RepetidoException;
import co.edu.unbosque.model.exception.ReservaExistente;
import co.edu.unbosque.model.persistence.DataSource;

/**
 * Implementación de la interfaz HorarioDAO para el acceso a datos de la entidad Horario.
 */
public class HorariosDAOImpl implements HorarioDAO<Horario, Integer, LocalDate, LocalTime>{

    /**
     * Crea un nuevo horario en la base de datos.
     * @param horario El horario a crear.
     * @return El horario creado.
     * @throws RepetidoException Si el horario ya existe en la base de datos.
     */
    @Override
    public Horario crear(Horario horario) throws RepetidoException {
        return DataSource.crearHorario(horario);
    }

    /**
     * Consulta un horario por su ID.
     * @param id El ID del horario a consultar.
     * @return El horario consultado.
     * @throws InexistenteException Si el horario no existe en la base de datos.
     */
    @Override
    public Horario consultar(Integer id) throws InexistenteException {
        return DataSource.consultarHorarioPorId(id);
    }

    /**
     * Consulta todos los horarios disponibles para una fecha y hora específicas.
     * @param fecha La fecha para la cual se desea consultar los horarios.
     * @param hora La hora para la cual se desea consultar los horarios.
     * @return Una lista de horarios disponibles para la fecha y hora especificadas.
     * @throws InexistenteException Si no hay horarios disponibles para la fecha y hora especificadas.
     */
    @Override
    public ArrayList<Horario> consultarFechayHora(LocalDate fecha, LocalTime hora) throws InexistenteException {
        return DataSource.consultarporFechayHora(fecha, hora);
    }

    /**
     * Consulta todos los horarios disponibles para una fecha y número de pista específicos.
     * @param fecha La fecha para la cual se desea consultar los horarios.
     * @param numeroPista El número de pista para la cual se desea consultar los horarios.
     * @return Una lista de horarios disponibles para la fecha y número de pista especificados.
     * @throws InexistenteException Si no hay horarios disponibles para la fecha y número de pista especificados.
     * @throws ReservaExistente 
     */
    @Override
    public ArrayList<Horario> consultarFecha(LocalDate fecha, Integer numeroPista) throws InexistenteException, ReservaExistente {
        return DataSource.consultarporFecha(fecha, numeroPista);
    }

    /**
     * Consulta todos los horarios almacenados en la base de datos.
     * @return Una lista de todos los horarios.
     */
    @Override
    public ArrayList<Horario> consultarTodos() {
        return DataSource.consultarHorarios();
    }

    /**
     * Actualiza la información de un horario en la base de datos.
     * @param horario El horario con la información actualizada.
     * @return El mensaje de confirmación de la actualización.
     * @throws InexistenteException Si el horario no existe en la base de datos.
     */
    @Override
    public String actualizar(Horario horario) throws InexistenteException {
        return DataSource.actualizarHorario(horario);
    }

}
