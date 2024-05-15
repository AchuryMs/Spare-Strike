package co.edu.unbosque.model.dto;

import java.util.ArrayList;

/**
 * Data Transfer Object (DTO) for representing a client.
 */
public class ClienteDTO {
    
	private String nombre; // Nombre del cliente
    private int id; // Identificador único del cliente
    private int cedula; // Número de cédula del cliente
    private ArrayList<ReservaDTO> historialReservas; // Historial de reservas del cliente
    private int primeraRonda; // Primera ronda de puntaje
    private int segundaRonda; // Segunda ronda de puntaje
    private int terceraRonda; // Tercera ronda de puntaje
    private int totalRonda; // Total de lasumade las tres rondas de puntaje
    private ArrayList<TorneoDTO> historialTorneos; // Historial de torneos del cliente

    /**
     * Constructs a new ClienteDTO object.
     *
     * @param nombre            The name of the client.
     * @param id                The ID of the client.
     * @param cedula            The identification number of the client.
     * @param historialReservas The list of reservation DTOs representing the client's reservation history.
     */
    public ClienteDTO(String nombre, int id, int cedula, ArrayList<ReservaDTO> historialReservas) {
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
    public ClienteDTO(String nombre, int id, int cedula, ArrayList<ReservaDTO> historialReservas, int primeraRonda, int segundaRonda, int terceraRonda, ArrayList<TorneoDTO> historialTorneos) {
        this.nombre = nombre;
        this.id = id;
        this.cedula = cedula;
        this.historialReservas = historialReservas;
        this.primeraRonda = primeraRonda;
        this.segundaRonda = segundaRonda;
        this.terceraRonda = terceraRonda;
        this.totalRonda = this.primeraRonda + this.segundaRonda + this.terceraRonda;
        this.historialTorneos = historialTorneos;
    }

    /**
     * Retrieves the name of the client.
     *
     * @return The name of the client.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the name of the client.
     *
     * @param nombre The name of the client to set.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retrieves the ID of the client.
     *
     * @return The ID of the client.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the client.
     *
     * @param id The ID of the client to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the identification number of the client.
     *
     * @return The identification number of the client.
     */
    public int getCedula() {
        return cedula;
    }

    /**
     * Sets the identification number of the client.
     *
     * @param cedula The identification number of the client to set.
     */
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    /**
     * Retrieves the list of reservation DTOs representing the client's reservation history.
     *
     * @return The list of reservation DTOs representing the client's reservation history.
     */
    public ArrayList<ReservaDTO> getHistorialReservas() {
        return historialReservas;
    }

    /**
     * Sets the list of reservation DTOs representing the client's reservation history.
     *
     * @param historialReservas The list of reservation DTOs representing the client's reservation history to set.
     */
    public void setHistorialReservas(ArrayList<ReservaDTO> historialReservas) {
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
	 * @return the segundaRonda
	 */
	public int getSegundaRonda() {
		return segundaRonda;
	}

	/**
	 * @param segundaRonda the segundaRonda to set
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
	public ArrayList<TorneoDTO> getHistorialTorneos() {
		return historialTorneos;
	}

	/**
	 * @param historialTorneo the historialTorneo to set
	 */
	public void setHistorialTorneos(ArrayList<TorneoDTO> historialTorneos) {
		this.historialTorneos = historialTorneos;
	}
	/**
     * Returns a string representation of the ClienteDTO object.
     *
     * @return A string representation of the ClienteDTO object.
     */
	@Override
	public String toString() {
		return "ClienteDTO [nombre=" + nombre + ", id=" + id + ", cedula=" + cedula + ", historialReservas="
				+ historialReservas + ", primeraRonda=" + primeraRonda + ", segundaRonda=" + segundaRonda
				+ ", terceraRonda=" + terceraRonda + ", totalRonda=" + totalRonda + ", historialTorneos="
				+ historialTorneos + "]";
	}

	

}
