package co.edu.unbosque.model.dao.impl;

import java.util.ArrayList;

import co.edu.unbosque.model.Torneo;
import co.edu.unbosque.model.dao.TorneoDAO;
import co.edu.unbosque.model.exception.InexistenteException;
import co.edu.unbosque.model.exception.RepetidoException;
import co.edu.unbosque.model.persistence.DataSource;
/**
 * Implementation of the TorneoDAO interface for handling tournament data access operations.
 */
public class TorneoDAOImpl implements TorneoDAO<Torneo, Integer> {

    /**
     * Creates a new tournament.
     *
     * @param torneo The tournament to be created.
     * @return The created tournament.
     * @throws RepetidoException if the tournament already exists.
     */
    @Override
    public Torneo crear(Torneo torneo) throws RepetidoException {
        return DataSource.crearTorneo(torneo);
    }

    /**
     * Updates an existing tournament.
     *
     * @param torneo The tournament to be updated.
     * @return A message indicating the result of the update operation.
     * @throws InexistenteException if the tournament does not exist.
     */
    @Override
    public String actualizar(Torneo torneo) throws InexistenteException {
        return DataSource.actualizarTorneo(torneo);
    }

    /**
     * Retrieves a tournament by its ID.
     *
     * @param id The ID of the tournament to retrieve.
     * @return The tournament with the specified ID.
     * @throws InexistenteException if the tournament does not exist.
     */
    @Override
    public Torneo consultar(Integer id) throws InexistenteException {
        return DataSource.consultarTorneoPorId(id);
    }

    /**
     * Retrieves all tournaments.
     *
     * @return A list containing all tournaments.
     */
    @Override
    public ArrayList<Torneo> consultarTodos() {
        return DataSource.consultarTorneos();
    }
}
