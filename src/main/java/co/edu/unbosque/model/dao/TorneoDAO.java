package co.edu.unbosque.model.dao;

import java.util.ArrayList;

import co.edu.unbosque.model.exception.InexistenteException;
import co.edu.unbosque.model.exception.RepetidoException;

/**
 * La interfaz TorneoDAO define las operaciones de acceso a datos específicas para la entidad de Torneo.
 * @param <T> El tipo de objeto de la entidad Torneo.
 * @param <K> El tipo de identificador de la entidad Torneo.
 */
public interface TorneoDAO<T, K> extends GeneralDAO<T, K>{
	 
    /**
     * Crea un nuevo objeto de la entidad Torneo.
     * @param entidad El objeto de la entidad Torneo a crear.
     * @return El objeto de la entidad Torneo creado.
     * @throws RepetidoException Si ya existe un objeto de la entidad Torneo con la misma clave primaria.
     */
	T crear(T entidad) throws RepetidoException;
	
    /**
     * Actualiza un objeto de la entidad Torneo existente.
     * @param entidad El objeto de la entidad Torneo a actualizar.
     * @return El mensaje de confirmación de la operación de actualización.
     * @throws InexistenteException Si el objeto de la entidad Torneo no existe en el sistema.
     */
	String actualizar(T entidad) throws InexistenteException;

    /**
     * Consulta un objeto de la entidad Torneo por su identificador.
     * @param id El identificador del objeto de la entidad Torneo a consultar.
     * @return El objeto de la entidad Torneo consultado.
     * @throws InexistenteException Si el objeto de la entidad Torneo no existe en el sistema.
     */
	T consultar(K id) throws InexistenteException;

    /**
     * Consulta todos los objetos de la entidad Torneo existentes en el sistema.
     * @return Una lista de todos los objetos de la entidad Torneo.
     */
	ArrayList<T> consultarTodos();

}