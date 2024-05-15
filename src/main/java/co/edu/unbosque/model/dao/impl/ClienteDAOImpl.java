package co.edu.unbosque.model.dao.impl;

import java.util.ArrayList;

import co.edu.unbosque.model.Cliente;
import co.edu.unbosque.model.dao.ClienteDAO;
import co.edu.unbosque.model.exception.InexistenteException;
import co.edu.unbosque.model.exception.RepetidoException;
import co.edu.unbosque.model.persistence.DataSource;

/**
 * Implementación de la interfaz ClienteDAO para el acceso a datos de la entidad Cliente.
 */
public class ClienteDAOImpl implements ClienteDAO<Cliente, Integer>{

    /**
     * Crea un nuevo cliente en la base de datos.
     * @param cliente El cliente a crear.
     * @return El cliente creado.
     * @throws RepetidoException Si el cliente ya existe en la base de datos.
     */
    @Override
    public Cliente crear(Cliente cliente) throws RepetidoException {
        return DataSource.crearCliente(cliente);
    }

    /**
     * Consulta un cliente por su ID.
     * @param id El ID del cliente a consultar.
     * @return El cliente consultado.
     * @throws InexistenteException Si el cliente no existe en la base de datos.
     */
    @Override
    public Cliente consultar(Integer id) throws InexistenteException {
        return DataSource.consultarClientePorId(id);
    }

    /**
     * Consulta todos los clientes almacenados en la base de datos.
     * @return Una lista de todos los clientes.
     */
    @Override
    public ArrayList<Cliente> consultarTodos() {
        return DataSource.consultarClientes();
    }

    /**
     * Actualiza la información de un cliente en la base de datos.
     * @param cliente El cliente con la información actualizada.
     * @return El mensaje de confirmación de la actualización.
     * @throws InexistenteException Si el cliente no existe en la base de datos.
     */
    @Override
    public String actualizar(Cliente cliente) throws InexistenteException {
        return DataSource.actualizarCliente(cliente);       
    }
    
}
