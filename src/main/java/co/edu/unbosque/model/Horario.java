package co.edu.unbosque.model;

import java.time.LocalTime;
import java.time.LocalDate;

/**
 * La clase Horario representa un horario de juego en el establecimiento.
 * Contiene información como el identificador, el tipo de juego, la hora de inicio y fin, la fecha,
 * el número de pista y el estado del horario.
 */
public class Horario {
    private int id; // Identificador del horario
    private String tipoJuego; // Tipo de juego
    private LocalTime horaInicial; // Hora de inicio del horario
    private LocalTime horaFinal; // Hora de fin del horario
    private LocalDate fecha; // Fecha del horario
    private int numeroPista; // Número de pista
    private boolean estado; // Estado del horario (disponible u ocupado)

    /**
     * Constructor de la clase Horario.
     * @param id Identificador del horario.
     * @param tipoJuego Tipo de juego del horario.
     * @param horaInicial Hora de inicio del horario.
     * @param horaFinal Hora de fin del horario.
     * @param fecha Fecha del horario.
     * @param numeroPista Número de pista del horario.
     * @param estado Estado del horario.
     */
    public Horario(int id, String tipoJuego, LocalTime horaInicial, LocalTime horaFinal, LocalDate fecha,
            int numeroPista, boolean estado) {
        this.id = id;
        this.tipoJuego = tipoJuego;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.fecha = fecha;
        this.numeroPista = numeroPista;
        this.estado = estado;
    }

    // Métodos getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoJuego() {
        return tipoJuego;
    }

    public void setTipoJuego(String tipoJuego) {
        this.tipoJuego = tipoJuego;
    }

    public LocalTime getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(LocalTime horaInicial) {
        this.horaInicial = horaInicial;
    }

    public LocalTime getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(LocalTime horaFinal) {
        this.horaFinal = horaFinal;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getNumeroPista() {
        return numeroPista;
    }

    public void setNumeroPista(int numeroPista) {
        this.numeroPista = numeroPista;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Horario [id=" + id + ", tipoJuego=" + tipoJuego + ", horaInicial=" + horaInicial + ", horaFinal="
                + horaFinal + ", fecha=" + fecha + ", numeroPista=" + numeroPista + ", estado=" + estado + "]";
    }
}
