package co.edu.unbosque.model.dao;

import java.util.ArrayList;

import co.edu.unbosque.model.exception.InexistenteException;
import co.edu.unbosque.model.exception.RepetidoException;

/**
 * La interfaz ClienteDAO define las operaciones que pueden realizarse sobre los objetos Cliente en la base de datos.
 * 
 * @param <T> Tipo de objeto Cliente.
 * @param <K> Tipo de clave para identificar al Cliente en la base de datos.
 */
public interface ClienteDAO<T, K> extends GeneralDAO<T, K> {
    
    /**
     * Metodo para crear un nuevo Cliente en la base de datos.
     * @param entidad Objeto Cliente a crear.
     * @return El Cliente creado.
     * @throws RepetidoException Si el Cliente ya existe en la base de datos.
     */
    T crear(T entidad) throws RepetidoException;
    
    /**
     * Metodo para actualizar un Cliente en la base de datos.
     * @param entidad Objeto Cliente a actualizar.
     * @return Mensaje indicando el resultado de la operación de actualización.
     * @throws InexistenteException Si el Cliente no existe en la base de datos.
     */
    String actualizar(T entidad) throws InexistenteException;

    /**
     * Metodo para consultar un Cliente en la base de datos dado su identificador.
     * @param id Identificador del Cliente a consultar.
     * @return El Cliente consultado.
     * @throws InexistenteException Si el Cliente no existe en la base de datos.
     */
    T consultar(K id) throws InexistenteException;

    /**
     * Metodo para consultar todos los Clientes almacenados en la base de datos.
     * @return Lista de todos los Clientes almacenados en la base de datos.
     */
    ArrayList<T> consultarTodos();
}
