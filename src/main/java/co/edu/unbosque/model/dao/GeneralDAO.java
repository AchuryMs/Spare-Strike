package co.edu.unbosque.model.dao;

import java.util.ArrayList;

import co.edu.unbosque.model.exception.InexistenteException;
import co.edu.unbosque.model.exception.RepetidoException;

/**
 * La interfaz GeneralDAO define las operaciones básicas de acceso a datos para una entidad específica.
 * 
 * @param <T> El tipo de entidad.
 * @param <K> El tipo de clave primaria.
 */
public interface GeneralDAO<T, K> {

    /**
     * Crea una nueva entidad en el repositorio de datos.
     * 
     * @param entidad La entidad a crear.
     * @return La entidad creada.
     * @throws RepetidoException Si la entidad ya existe en el repositorio.
     */
    default T crear(T entidad) throws RepetidoException {
        return null;
    }

    /**
     * Actualiza una entidad existente en el repositorio de datos.
     * 
     * @param entidad La entidad a actualizar.
     * @return Un mensaje indicando el resultado de la operación.
     * @throws InexistenteException Si la entidad no existe en el repositorio.
     */
    default String actualizar(T entidad) throws InexistenteException {
        return null;
    }

    /**
     * Consulta una entidad en el repositorio de datos por su clave primaria.
     * 
     * @param id La clave primaria de la entidad a consultar.
     * @return La entidad consultada.
     * @throws InexistenteException Si la entidad no existe en el repositorio.
     */
    default T consultar(K id) throws InexistenteException {
        return null;
    }

    /**
     * Consulta todas las entidades de un tipo específico en el repositorio de datos.
     * 
     * @return Una lista de todas las entidades consultadas.
     */
    default ArrayList<T> consultarTodos() {
        return null;
    }

    /**
     * Elimina una entidad del repositorio de datos por su clave primaria.
     * 
     * @param id La clave primaria de la entidad a eliminar.
     * @return Un mensaje indicando el resultado de la operación.
     * @throws InexistenteException Si la entidad no existe en el repositorio.
     */
    default String eliminar(K id) throws InexistenteException {
        return null;
    }
}
