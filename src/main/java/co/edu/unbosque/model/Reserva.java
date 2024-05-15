package co.edu.unbosque.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * La clase Reserva extiende de la clase Horario y representa una reserva realizada por un cliente.
 * Contiene información adicional como el identificador del cliente, el número de jugadores y el identificador del snack adicional.
 */
public class Reserva extends Horario {
    private int idCliente; // Identificador del cliente que realizó la reserva
    private int numeroJugadores; // Número de jugadores en la reserva
    private int idSnackAdicional; // Identificador del snack adicional en la reserva

    /**
     * Constructor de la clase Reserva.
     * @param id Identificador de la reserva.
     * @param tipoJuego Tipo de juego de la reserva.
     * @param horaInicial Hora de inicio de la reserva.
     * @param horaFinal Hora de fin de la reserva.
     * @param fecha Fecha de la reserva.
     * @param numeroPista Número de pista de la reserva.
     * @param estado Estado de la reserva.
     * @param idCliente Identificador del cliente que realizó la reserva.
     * @param numeroJugadores Número de jugadores en la reserva.
     * @param idSnackAdicional Identificador del snack adicional en la reserva.
     */
    public Reserva(int id, String tipoJuego, LocalTime horaInicial, LocalTime horaFinal, LocalDate fecha,
            int numeroPista, boolean estado, int idCliente, int numeroJugadores, int idSnackAdicional) {
        super(id, tipoJuego, horaInicial, horaFinal, fecha, numeroPista, estado);
        this.idCliente = idCliente;
        this.numeroJugadores = numeroJugadores;
        this.idSnackAdicional = idSnackAdicional;
    }

    // Métodos getters y setters

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getNumeroJugadores() {
        return numeroJugadores;
    }

    public void setNumeroJugadores(int numeroJugadores) {
        this.numeroJugadores = numeroJugadores;
    }

    public int getIdSnackAdicional() {
        return idSnackAdicional;
    }

    public void setIdSnackAdicional(int idSnackAdicional) {
        this.idSnackAdicional = idSnackAdicional;
    }

	@Override
	public String toString() {
		return "Reserva [idCliente=" + idCliente + ", numeroJugadores=" + numeroJugadores + ", idSnackAdicional="
				+ idSnackAdicional + "]";
	}
    
}
