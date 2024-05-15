package co.edu.unbosque.model.dto;

import java.time.LocalTime;
import java.time.LocalDate;
/**
 * Data Transfer Object (DTO) for representing a schedule.
 */
public class HorarioDTO {

    private int id;
    private String tipoJuego;
    private LocalTime horaInicial;
    private LocalTime horaFinal;
    private LocalDate fecha;
    private int numeroPista;
    private boolean estado;

    /**
     * Constructs a new HorarioDTO object.
     *
     * @param id           The ID of the schedule.
     * @param tipoJuego    The type of game for the schedule.
     * @param horaInicial  The start time of the schedule.
     * @param horaFinal    The end time of the schedule.
     * @param fecha        The date of the schedule.
     * @param numeroPista  The track number for the schedule.
     * @param estado       The status of the schedule.
     */
    public HorarioDTO(int id, String tipoJuego, LocalTime horaInicial, LocalTime horaFinal, LocalDate fecha,
                      int numeroPista, boolean estado) {
        this.id = id;
        this.tipoJuego = tipoJuego;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.fecha = fecha;
        this.numeroPista = numeroPista;
        this.estado = estado;
    }

    /**
     * Retrieves the ID of the schedule.
     *
     * @return The ID of the schedule.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the schedule.
     *
     * @param id The ID of the schedule to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the type of game for the schedule.
     *
     * @return The type of game for the schedule.
     */
    public String getTipoJuego() {
        return tipoJuego;
    }

    /**
     * Sets the type of game for the schedule.
     *
     * @param tipoJuego The type of game for the schedule to set.
     */
    public void setTipoJuego(String tipoJuego) {
        this.tipoJuego = tipoJuego;
    }

    /**
     * Retrieves the start time of the schedule.
     *
     * @return The start time of the schedule.
     */
    public LocalTime getHoraInicial() {
        return horaInicial;
    }

    /**
     * Sets the start time of the schedule.
     *
     * @param horaInicial The start time of the schedule to set.
     */
    public void setHoraInicial(LocalTime horaInicial) {
        this.horaInicial = horaInicial;
    }

    /**
     * Retrieves the end time of the schedule.
     *
     * @return The end time of the schedule.
     */
    public LocalTime getHoraFinal() {
        return horaFinal;
    }

    /**
     * Sets the end time of the schedule.
     *
     * @param horaFinal The end time of the schedule to set.
     */
    public void setHoraFinal(LocalTime horaFinal) {
        this.horaFinal = horaFinal;
    }

    /**
     * Retrieves the date of the schedule.
     *
     * @return The date of the schedule.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Sets the date of the schedule.
     *
     * @param fecha The date of the schedule to set.
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Retrieves the track number for the schedule.
     *
     * @return The track number for the schedule.
     */
    public int getNumeroPista() {
        return numeroPista;
    }

    /**
     * Sets the track number for the schedule.
     *
     * @param numeroPista The track number for the schedule to set.
     */
    public void setNumeroPista(int numeroPista) {
        this.numeroPista = numeroPista;
    }

    /**
     * Retrieves the status of the schedule.
     *
     * @return The status of the schedule.
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * Sets the status of the schedule.
     *
     * @param estado The status of the schedule to set.
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Returns a string representation of the HorarioDTO object.
     *
     * @return A string representation of the HorarioDTO object.
     */
    @Override
    public String toString() {
        return "HorarioDTO [id=" + id + ", tipoJuego=" + tipoJuego + ", horaInicial=" + horaInicial + ", horaFinal="
                + horaFinal + ", fecha=" + fecha + ", numeroPista=" + numeroPista + ", estado=" + estado + "]";
    }
}
