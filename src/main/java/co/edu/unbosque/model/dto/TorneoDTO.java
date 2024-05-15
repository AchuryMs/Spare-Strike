package co.edu.unbosque.model.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import co.edu.unbosque.model.Cliente;

/**
 * TorneoDTO represents a data transfer object for tournaments.
 */
public class TorneoDTO extends HorarioDTO {
    private int idTorneo;
    private String nombreTorneo;
    private String premio;
    private ArrayList<ClienteDTO> participantes;

    /**
     * Constructs a TorneoDTO object with the specified attributes.
     *
     * @param id            The identifier of the tournament.
     * @param tipoJuego     The type of game for the tournament.
     * @param horaInicial   The start time of the tournament.
     * @param horaFinal     The end time of the tournament.
     * @param fecha         The date of the tournament.
     * @param numeroPista   The number of the court for the tournament.
     * @param estado        The status of the tournament.
     * @param idTorneo      The identifier of the tournament.
     * @param nombreTorneo  The name of the tournament.
     * @param premio        The prize of the tournament.
     * @param participantes The list of participants in the tournament.
     */
    public TorneoDTO(int id, String tipoJuego, LocalTime horaInicial, LocalTime horaFinal, LocalDate fecha,
                     int numeroPista, boolean estado, int idTorneo, String nombreTorneo, String premio,
                     ArrayList<ClienteDTO> participantes) {
        super(id, tipoJuego, horaInicial, horaFinal, fecha, numeroPista, estado);
        this.idTorneo = idTorneo;
        this.nombreTorneo = nombreTorneo;
        this.premio = premio;
        this.participantes = participantes;
    }

    /**
     * Retrieves the name of the tournament.
     *
     * @return The name of the tournament.
     */
    public String getNombreTorneo() {
        return nombreTorneo;
    }

    /**
     * Sets the name of the tournament.
     *
     * @param nombreTorneo The name of the tournament.
     */
    public void setNombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }

    /**
     * Retrieves the identifier of the tournament.
     *
     * @return The identifier of the tournament.
     */
    public int getIdTorneo() {
        return idTorneo;
    }

    /**
     * Sets the identifier of the tournament.
     *
     * @param idTorneo The identifier of the tournament.
     */
    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    /**
     * Retrieves the prize of the tournament.
     *
     * @return The prize of the tournament.
     */
    public String getPremio() {
        return premio;
    }

    /**
     * Sets the prize of the tournament.
     *
     * @param premio The prize of the tournament.
     */
    public void setPremio(String premio) {
        this.premio = premio;
    }

    /**
     * Retrieves the list of participants in the tournament.
     *
     * @return The list of participants in the tournament.
     */
    public ArrayList<ClienteDTO> getParticipantes() {
        return participantes;
    }

    /**
     * Sets the list of participants in the tournament.
     *
     * @param participantes The list of participants in the tournament.
     */
    public void setParticipantes(ArrayList<ClienteDTO> participantes) {
        this.participantes = participantes;
    }

    /**
     * Returns a string representation of the tournament DTO.
     *
     * @return A string representation of the tournament DTO.
     */
    @Override
    public String toString() {
        return "TorneoDTO [idTorneo=" + idTorneo + ", nombreTorneo=" + nombreTorneo + ", premio=" + premio + ", participantes=" + participantes
                + ", toString()=" + super.toString() + "]";
    }
}

