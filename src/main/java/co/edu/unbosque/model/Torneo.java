package co.edu.unbosque.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * La clase Torneo representa un torneo que se realiza en una pista de juego en un determinado horario.
 * Contiene información como el identificador del torneo, el nombre del torneo, el premio, y la lista de participantes.
 * Hereda atributos de la clase Horario.
 */
public class Torneo extends Horario {
    private int idTorneo; // Identificador del torneo
    private String nombreTorneo; // Nombre del torneo
    private String premio; // Premio del torneo
    private ArrayList<Cliente> participantes; // Lista de participantes del torneo

    /**
     * Constructor de la clase Torneo.
     * @param id Identificador del torneo.
     * @param tipoJuego Tipo de juego del torneo.
     * @param horaInicial Hora de inicio del torneo.
     * @param horaFinal Hora de finalización del torneo.
     * @param fecha Fecha en la que se realiza el torneo.
     * @param numeroPista Número de la pista en la que se realiza el torneo.
     * @param estado Estado del torneo.
     * @param idTorneo Identificador del torneo.
     * @param nombreTorneo Nombre del torneo.
     * @param premio Premio del torneo.
     * @param participantes Lista de participantes del torneo.
     */
    public Torneo(int id, String tipoJuego, LocalTime horaInicial, LocalTime horaFinal, LocalDate fecha,
                  int numeroPista, boolean estado, int idTorneo, String nombreTorneo, String premio,
                  ArrayList<Cliente> participantes) {
        super(id, tipoJuego, horaInicial, horaFinal, fecha, numeroPista, estado);
        this.idTorneo = idTorneo;
        this.nombreTorneo = nombreTorneo;
        this.premio = premio;
        this.participantes = participantes;
    }

    // Métodos getters y setters

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public String getNombreTorneo() {
        return nombreTorneo;
    }

    public void setNombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }

    public String getPremio() {
        return premio;
    }

    public void setPremio(String premio) {
        this.premio = premio;
    }

    public ArrayList<Cliente> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(ArrayList<Cliente> participantes) {
        this.participantes = participantes;
    }

    @Override
    public String toString() {
        return "Torneo [idTorneo=" + idTorneo + ", nombreTorneo=" + nombreTorneo + ", premio=" + premio
                + ", participantes=" + participantes + ", toString()=" + super.toString() + "]";
    }
}
