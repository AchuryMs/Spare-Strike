package co.edu.unbosque.model.dto;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Data Transfer Object (DTO) for representing a reservation.
 */
public class ReservaDTO extends HorarioDTO {
    private int idCliente;
    private int numeroJugadores;
    private int idSnackAdicional;

    /**
     * Constructs a new ReservaDTO object.
     *
     * @param id               The ID of the reservation.
     * @param tipoJuego        The type of game for the reservation.
     * @param horaInicial      The start time of the reservation.
     * @param horaFinal        The end time of the reservation.
     * @param fecha            The date of the reservation.
     * @param numeroPista      The number of the court for the reservation.
     * @param estado           The state of the reservation.
     * @param idCliente        The ID of the client associated with the reservation.
     * @param numeroJugadores  The number of players for the reservation.
     * @param idSnackAdicional The ID of any additional snack associated with the reservation.
     */
    public ReservaDTO(int id, String tipoJuego, LocalTime horaInicial, LocalTime horaFinal, LocalDate fecha, int numeroPista, boolean estado, int idCliente, int numeroJugadores, int idSnackAdicional) {
        super(id, tipoJuego, horaInicial, horaFinal, fecha, numeroPista, estado);
        this.idCliente = idCliente;
        this.numeroJugadores = numeroJugadores;
        this.idSnackAdicional = idSnackAdicional;
    }
    
    /**
     * Retrieves the ID of the client associated with the reservation.
     *
     * @return The ID of the client associated with the reservation.
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Sets the ID of the client associated with the reservation.
     *
     * @param idCliente The ID of the client to set.
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Retrieves the number of players for the reservation.
     *
     * @return The number of players for the reservation.
     */
    public int getNumeroJugadores() {
        return numeroJugadores;
    }

    /**
     * Sets the number of players for the reservation.
     *
     * @param numeroJugadores The number of players to set.
     */
    public void setNumeroJugadores(int numeroJugadores) {
        this.numeroJugadores = numeroJugadores;
    }

    /**
     * Retrieves the ID of any additional snack associated with the reservation.
     *
     * @return The ID of any additional snack associated with the reservation.
     */
    public int getIdSnackAdicional() {
        return idSnackAdicional;
    }

    /**
     * Sets the ID of any additional snack associated with the reservation.
     *
     * @param idSnackAdicional The ID of the snack to set.
     */
    public void setIdSnackAdicional(int idSnackAdicional) {
        this.idSnackAdicional = idSnackAdicional;
    }

    /**
     * Returns a string representation of the ReservaDTO object.
     *
     * @return A string representation of the ReservaDTO object.
     */
    @Override
    public String toString() {
        return "ReservaDTO [idCliente=" + idCliente + ", numeroJugadores=" + numeroJugadores + ", idSnackAdicional="
                + idSnackAdicional + ", idHorario=" + getId() + ", getTipoJuego()=" + getTipoJuego()
                + ", getHoraInicial()=" + getHoraInicial() + ", getHoraFinal()=" + getHoraFinal() + ", getFecha()="
                + getFecha() + ", getNumeroPista()=" + getNumeroPista() + ", isEstado()=" + isEstado() + "]";
    }

}
