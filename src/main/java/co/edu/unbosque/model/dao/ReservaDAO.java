package co.edu.unbosque.model.dao;

import java.util.ArrayList;

import co.edu.unbosque.model.exception.InexistenteException;
import co.edu.unbosque.model.exception.RepetidoException;

/**
 * La interfaz ReservaDAO define las operaciones de acceso a datos específicas para la entidad de Reserva.
 *
 * @param <T> El tipo de entidad.
 * @param <K> El tipo de clave primaria.
 */
public interface ReservaDAO<T, K> extends GeneralDAO<T, K> {

    /**
     * Crea una nueva reserva en el repositorio de datos.
     *
     * @param entidad La reserva a crear.
     * @return La reserva creada.
     * @throws RepetidoException Si la reserva ya existe en el repositorio.
     */
    T crear(T entidad) throws RepetidoException;

    /**
     * Actualiza una reserva existente en el repositorio de datos.
     *
     * @param entidad La reserva a actualizar.
     * @return Un mensaje indicando el resultado de la operación.
     * @throws InexistenteException Si la reserva no existe en el repositorio.
     */
    String actualizar(T entidad) throws InexistenteException;

    /**
     * Consulta una reserva en el repositorio de datos por su clave primaria.
     *
     * @param id La clave primaria de la reserva a consultar.
     * @return La reserva consultada.
     * @throws InexistenteException Si la reserva no existe en el repositorio.
     */
    T consultar(K id) throws InexistenteException;

    /**
     * Consulta todas las reservas en el repositorio de datos.
     *
     * @return Una lista de todas las reservas en el repositorio.
     */
    ArrayList<T> consultarTodos();

    /**
     * Elimina una reserva del repositorio de datos por su clave primaria.
     *
     * @param id La clave primaria de la reserva a eliminar.
     * @return Un mensaje indicando el resultado de la operación.
     * @throws InexistenteException Si la reserva no existe en el repositorio.
     */
    String eliminar(K id) throws InexistenteException;
}
