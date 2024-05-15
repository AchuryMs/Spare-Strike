package co.edu.unbosque.model;

import java.util.ArrayList;

/**
 * La clase Cliente representa a un cliente del establecimiento.
 * Contiene información como nombre, identificación, cédula y su historial de reservas.
 */
public class Cliente {
    private String nombre; // Nombre del cliente
    private int id; // Identificador único del cliente
    private int cedula; // Número de cédula del cliente
    private ArrayList<Reserva> historialReservas; // Historial de reservas del cliente
    private int primeraRonda; // Primera ronda de puntaje
    private int segundaRonda; // Segunda ronda de puntaje
    private int terceraRonda; // Tercera ronda de puntaje
    private int totalRonda; // Total de lasumade las tres rondas de puntaje
    private ArrayList<Torneo> historialTorneos; // Historial de torneos del cliente

    /**
     * Constructor de la clase Cliente.
     * @param nombre Nombre del cliente.
     * @param id Identificador único del cliente.
     * @param cedula Número de cédula del cliente.
     * @param historialReservas Lista de reservas del cliente.
     */
    public Cliente(String nombre, int id, int cedula, ArrayList<Reserva> historialReservas) {
        this.nombre = nombre;
        this.id = id;
        this.cedula = cedula;
        this.historialReservas = historialReservas;
    }

    /**
     * Crea un nuevo objeto Cliente con el nombre especificado, el ID, el número de cédula, el historial de reservas,
     * la cantidad de rondas en primera, segunda y tercera ronda, el total de rondas y el historial de torneos proporcionados.
     *
     * @param nombre             El nombre del cliente.
     * @param id                 El ID del cliente.
     * @param cedula             El número de cédula del cliente.
     * @param historialReservas El historial de reservas del cliente.
     * @param primeraRonda       La cantidad de rondas en la primera ronda.
     * @param segundaRonda       La cantidad de rondas en la segunda ronda.
     * @param terceraRonda       La cantidad de rondas en la tercera ronda.
     * @param totalRonda         El total de rondas del cliente.
     * @param historialTorneo    El historial de torneos del cliente.
     */
    public Cliente(String nombre, int id, int cedula, ArrayList<Reserva> historialReservas, int primeraRonda, int segundaRonda, int terceraRonda, ArrayList<Torneo> historialTorneo) {
        this.nombre = nombre;
        this.id = id;
        this.cedula = cedula;
        this.historialReservas = historialReservas;
        this.primeraRonda = primeraRonda;
        this.segundaRonda = segundaRonda;
        this.terceraRonda = terceraRonda;
        this.totalRonda = this.primeraRonda + this.segundaRonda + this.terceraRonda;
        this.historialTorneos = historialTorneo;
    }

    /**
     * Método para obtener el nombre del cliente.
     * @return El nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para establecer el nombre del cliente.
     * @param nombre El nuevo nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener el identificador único del cliente.
     * @return El identificador único del cliente.
     */
    public int getId() {
        return id;
    }

    /**
     * Método para establecer el identificador único del cliente.
     * @param id El nuevo identificador único del cliente.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método para obtener el número de cédula del cliente.
     * @return El número de cédula del cliente.
     */
    public int getCedula() {
        return cedula;
    }

    /**
     * Método para establecer el número de cédula del cliente.
     * @param cedula El nuevo número de cédula del cliente.
     */
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    /**
     * Método para obtener el historial de reservas del cliente.
     * @return El historial de reservas del cliente.
     */
    public ArrayList<Reserva> getHistorialReservas() {
        return historialReservas;
    }

    /**
     * Método para establecer el historial de reservas del cliente.
     * @param historialReservas El nuevo historial de reservas del cliente.
     */
    public void setHistorialReservas(ArrayList<Reserva> historialReservas) {
        this.historialReservas = historialReservas;
    }

	/**
	 * @return the primeraRonda
	 */
	public int getPrimeraRonda() {
		return primeraRonda;
	}

	/**
	 * @param primeraRonda the primeraRonda to set
	 */
	public void setPrimeraRonda(int primeraRonda) {
		this.primeraRonda = primeraRonda;
	}

	/**
	 * @return the segungaRonda
	 */
	public int getSegundaRonda() {
		return segundaRonda;
	}

	/**
	 * @param segungaRonda the segungaRonda to set
	 */
	public void setSegundaRonda(int segundaRonda) {
		this.segundaRonda = segundaRonda;
	}

	/**
	 * @return the terceraRonda
	 */
	public int getTerceraRonda() {
		return terceraRonda;
	}

	/**
	 * @param terceraRonda the terceraRonda to set
	 */
	public void setTerceraRonda(int terceraRonda) {
		this.terceraRonda = terceraRonda;
	}

	/**
	 * @return the totalRonda
	 */
	public int getTotalRonda() {
		return totalRonda;
	}

	/**
	 * @param totalRonda the totalRonda to set
	 */
	public void setTotalRonda(int totalRonda) {
		this.totalRonda = totalRonda;
	}

	/**
	 * @return the historialTorneo
	 */
	public ArrayList<Torneo> getHistorialTorneos() {
		return historialTorneos;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", id=" + id + ", cedula=" + cedula + ", historialReservas="
				+ historialReservas + ", primeraRonda=" + primeraRonda + ", segundaRonda=" + segundaRonda
				+ ", terceraRonda=" + terceraRonda + ", totalRonda=" + totalRonda + ", historialTorneos="
				+ historialTorneos + "]";
	}

	/**
	 * @param historialTorneo the historialTorneo to set
	 */
	public void setHistorialTorneos(ArrayList<Torneo> historialTorneos) {
		this.historialTorneos = historialTorneos;
	}

}
