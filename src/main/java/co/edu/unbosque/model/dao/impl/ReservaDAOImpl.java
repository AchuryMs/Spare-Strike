package co.edu.unbosque.model.dao.impl;

import java.util.ArrayList;

import co.edu.unbosque.model.Reserva;
import co.edu.unbosque.model.dao.ReservaDAO;
import co.edu.unbosque.model.exception.InexistenteException;
import co.edu.unbosque.model.exception.RepetidoException;
import co.edu.unbosque.model.persistence.DataSource;

/**
 * Implementation of the ReservaDAO interface for handling reservation data access operations.
 */
public class ReservaDAOImpl implements ReservaDAO<Reserva, Integer> {

    /**
     * Creates a new reservation.
     *
     * @param reserva The reservation to be created.
     * @return The created reservation.
     * @throws RepetidoException if the reservation already exists.
     */
    @Override
    public Reserva crear(Reserva reserva) throws RepetidoException {
        return DataSource.crearReserva(reserva);
    }

    /**
     * Updates an existing reservation.
     *
     * @param reserva The reservation to be updated.
     * @return A message indicating the result of the update operation.
     * @throws InexistenteException if the reservation does not exist.
     */
    @Override
    public String actualizar(Reserva reserva) throws InexistenteException {
        return DataSource.actualizarReserva(reserva);
    }

    /**
     * Retrieves a reservation by its ID.
     *
     * @param id The ID of the reservation to retrieve.
     * @return The reservation with the specified ID.
     * @throws InexistenteException if the reservation does not exist.
     */
    @Override
    public Reserva consultar(Integer id) throws InexistenteException {
        return DataSource.consultarReservaPorId(id);
    }

    /**
     * Retrieves all reservations.
     *
     * @return A list containing all reservations.
     */
    @Override
    public ArrayList<Reserva> consultarTodos() {
        return DataSource.consultarReservas();
    }

    /**
     * Deletes a reservation by its ID.
     *
     * @param id The ID of the reservation to delete.
     * @return A message indicating the result of the delete operation.
     * @throws InexistenteException if the reservation does not exist.
     */
    @Override
    public String eliminar(Integer id) throws InexistenteException {
        Reserva reserva = consultar(id);
        return DataSource.eliminarReserva(reserva);
    }
}
