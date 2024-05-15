package co.edu.unbosque.model.dao;

import java.util.ArrayList;

import co.edu.unbosque.model.exception.InexistenteException;
import co.edu.unbosque.model.exception.RepetidoException;
import co.edu.unbosque.model.exception.ReservaExistente;

/**
 * La interfaz HorarioDAO define las operaciones de acceso a datos específicas para la entidad de Horario.
 *
 * @param <T> El tipo de entidad.
 * @param <K> El tipo de clave primaria.
 * @param <F> El tipo de dato para la fecha.
 * @param <H> El tipo de dato para la hora.
 */
public interface HorarioDAO<T, K, F, H> extends GeneralDAO<T, K> {

    /**
     * Crea un nuevo horario en el repositorio de datos.
     *
     * @param entidad El horario a crear.
     * @return El horario creado.
     * @throws RepetidoException Si el horario ya existe en el repositorio.
     */
    T crear(T entidad) throws RepetidoException;

    /**
     * Actualiza un horario existente en el repositorio de datos.
     *
     * @param entidad El horario a actualizar.
     * @return Un mensaje indicando el resultado de la operación.
     * @throws InexistenteException Si el horario no existe en el repositorio.
     */
    String actualizar(T entidad) throws InexistenteException;

    /**
     * Consulta un horario en el repositorio de datos por su clave primaria.
     *
     * @param id La clave primaria del horario a consultar.
     * @return El horario consultado.
     * @throws InexistenteException Si el horario no existe en el repositorio.
     */
    T consultar(K id) throws InexistenteException;

    /**
     * Consulta todos los horarios disponibles para una fecha y hora específicas.
     *
     * @param fecha La fecha para la consulta.
     * @param hora  La hora para la consulta.
     * @return Una lista de horarios disponibles para la fecha y hora especificadas.
     * @throws InexistenteException Si no hay horarios disponibles para la fecha y hora especificadas.
     */
    ArrayList<T> consultarFechayHora(F fecha, H hora) throws InexistenteException;

    /**
     * Consulta todos los horarios disponibles para una fecha y número de pista específicos.
     *
     * @param fecha       La fecha para la consulta.
     * @param numeroPista El número de pista para la consulta.
     * @return Una lista de horarios disponibles para la fecha y número de pista especificados.
     * @throws InexistenteException Si no hay horarios disponibles para la fecha y número de pista especificados.
     * @throws ReservaExistente Si ya existe una reserva con el horario seleccionado.
     */
    ArrayList<T> consultarFecha(F fecha, K numeroPista) throws InexistenteException, ReservaExistente;

    /**
     * Consulta todos los horarios en el repositorio de datos.
     *
     * @return Una lista de todos los horarios en el repositorio.
     */
    ArrayList<T> consultarTodos();
}
