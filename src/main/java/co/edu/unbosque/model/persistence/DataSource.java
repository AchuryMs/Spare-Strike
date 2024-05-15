package co.edu.unbosque.model.persistence;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import co.edu.unbosque.model.Cliente;
import co.edu.unbosque.model.Horario;
import co.edu.unbosque.model.Reserva;
import co.edu.unbosque.model.SnackAdicional;
import co.edu.unbosque.model.Torneo;
import co.edu.unbosque.model.exception.InexistenteException;
import co.edu.unbosque.model.exception.RepetidoException;
import co.edu.unbosque.model.exception.ReservaExistente;


/**
 * The DataSource class provides mock data and methods to interact with it.
 */

/**
 * La clase DataSource proporciona datos simulados y métodos para interactuar con ellos.
 */
public class DataSource {
    private static ArrayList<Cliente> clientes;
    private static ArrayList<Horario> horarios;
    private static ArrayList<Reserva> reservas;
    private static ArrayList<Torneo> torneos;
    private static ArrayList<SnackAdicional> snacks;

    // Inicialización de las listas
    static {
        clientes = new ArrayList<Cliente>();
        horarios = new ArrayList<Horario>();
        reservas = new ArrayList<Reserva>();
        torneos = new ArrayList<Torneo>();
        snacks = new ArrayList<SnackAdicional>();

        // Generación de franjas horarias
        generarHorariosPistas(LocalDate.now(), LocalDate.now().plusDays(6));
        // Agregar un cliente de muestra
        clientes.add(new Cliente("Fernando", 1, 8765432, new ArrayList<Reserva>(), 125, 135, 145, new ArrayList<Torneo>()));

        // Agregar snacks de muestra
        snacks.add(new SnackAdicional(1, "Combo 1 - 6 Cerveza Corona - Picada Mediana", 1, 87000));
        snacks.add(new SnackAdicional(2, "Combo 2 - Coca Cola 1.5L - Picada Familiar", 1, 123000));
        snacks.add(new SnackAdicional(3, "Combo 3 - Colombiana 1.5L - Pizza Mediana", 1, 94000));
    }

    /**
     * Genera franjas horarias para bolera desde una fecha de inicio hasta una fecha de fin.
     *
     * @param fechaInicio La fecha de inicio.
     * @param fechaFin    La fecha de fin.
     */
    private static void generarHorariosPistas(LocalDate fechaInicio, LocalDate fechaFin) {
        int idTemporal = 0;
        for (LocalDate fecha = fechaInicio; !fecha.isAfter(fechaFin); fecha = fecha.plusDays(1)) {
            for (int i = 17; i <= 21; i += 2) { // Genera franjas horarias de 5pm a 9pm
                LocalTime horaInicial = LocalTime.of(i, 0);
                LocalTime horaFinal = LocalTime.of(i + 2, 0);
                for (int j = 1; j <= 12; j++) { // Para las 12 pistas
                    idTemporal = horarios.size() + 1;
                    Horario horario = new Horario(idTemporal, "Bolera", horaInicial, horaFinal, fecha, j, true);
                    horarios.add(horario);
                }
            }
        }
    }

    // Métodos para interactuar con los clientes

    /**
     * Crea un nuevo cliente.
     *
     * @param cliente El cliente a crear.
     * @return El cliente creado.
     * @throws RepetidoException si el cliente con el mismo número de identificación ya existe.
     */
    public static Cliente crearCliente(Cliente cliente) throws RepetidoException {
        if (clientes.isEmpty()) {
            clientes.add(cliente);
        } else {
            boolean cedulaRepetida = false;
            for (Cliente c : clientes) {
                if (c.getCedula() == cliente.getCedula()) {
                    cedulaRepetida = true;
                    break;
                }
            }
            if (!cedulaRepetida) {
                clientes.add(cliente);
            } else {
                throw new RepetidoException("El cliente con cedula: " + cliente.getCedula() + " ya está registrado");
            }
        }
        return cliente;
    }

    /**
     * Obtiene todos los clientes.
     *
     * @return La lista de todos los clientes.
     */
    public static ArrayList<Cliente> consultarClientes() {
        return clientes;
    }

    /**
     * Obtiene un cliente por su ID.
     *
     * @param id El ID del cliente a recuperar.
     * @return El cliente con el ID especificado.
     * @throws InexistenteException si no existe el cliente con el ID especificado.
     */
    public static Cliente consultarClientePorId(int id) throws InexistenteException {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id || cliente.getCedula() == id) {
                return cliente;
            }
        }
        throw new InexistenteException("ERROR | No se encontró el cliente con id: " + id);
    }   
    
    /**
     * Actualiza un cliente existente con la información proporcionada.
     *
     * @param cliente El cliente con los datos actualizados.
     * @return Un mensaje indicando el resultado de la operación.
     * @throws InexistenteException Si el cliente a actualizar no existe.
     */
    public static String actualizarCliente(Cliente cliente) throws InexistenteException {
        Cliente newCliente = consultarClientePorId(cliente.getId());
        if (newCliente != null) {
            newCliente.setNombre(cliente.getNombre());
            newCliente.setCedula(cliente.getCedula());
            for (Reserva r : cliente.getHistorialReservas()) {
                newCliente.getHistorialReservas().add(r);
            }
            newCliente.setPrimeraRonda(cliente.getPrimeraRonda());
            newCliente.setSegundaRonda(cliente.getSegundaRonda());
            newCliente.setTerceraRonda(cliente.getTerceraRonda());
            for(Torneo t: cliente.getHistorialTorneos()) {
            	newCliente.getHistorialTorneos().add(t);
            }
            return "El cliente ha sido actualizado correctamente";
        } else {
            return "ERROR | El cliente no pudo ser actualizado";
        }
    }

    /**
     * Crea un nuevo horario si no existe uno con el mismo ID.
     *
     * @param horario El horario a crear.
     * @return El horario creado.
     * @throws RepetidoException Si ya existe un horario con el mismo ID.
     */
    public static Horario crearHorario(Horario horario) throws RepetidoException {
        if (!horarios.contains(horario)) {
            horarios.add(horario);
        } else {
            throw new RepetidoException("El horario con id: " + horario.getId() + " ya está registrado");
        }
        return horario;
    }

    /**
     * Obtiene todos los horarios disponibles.
     *
     * @return La lista de todos los horarios.
     */
    public static ArrayList<Horario> consultarHorarios() {
        return horarios;
    }

    /**
     * Obtiene un cliente por su ID.
     *
     * @param id El ID del cliente a obtener.
     * @return El cliente con el ID especificado.
     * @throws InexistenteException Si no se encuentra un cliente con el ID proporcionado.
     */
    public static Cliente obtenerClientePorId(int id) throws InexistenteException {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        throw new InexistenteException("ERROR | No se encontró el cliente con ID: " + id);
    }

    /**
     * Consulta un horario por su ID.
     *
     * @param id El ID del horario a consultar.
     * @return El horario con el ID especificado.
     * @throws InexistenteException Si no se encuentra un horario con el ID proporcionado.
     */
    public static Horario consultarHorarioPorId(int id) throws InexistenteException {
        for (Horario horario : horarios) {
            if (horario.getId() == id) {
                return horario;
            }
        }
        throw new InexistenteException("ERROR | No se encontró el horario con id: " + id);
    }

    /**
     * Consulta los horarios disponibles para una fecha y hora específicas.
     *
     * @param fecha La fecha para la cual se buscan los horarios.
     * @param hora  La hora para la cual se buscan los horarios.
     * @return La lista de horarios disponibles para la fecha y hora especificadas.
     * @throws InexistenteException Si no se encuentra ningún horario disponible para la fecha y hora proporcionadas.
     */
    public static ArrayList<Horario> consultarporFechayHora(LocalDate fecha, LocalTime hora) throws InexistenteException {
        ArrayList<Horario> horariosEncontrados = new ArrayList<>();
        for (Horario horario : horarios) {
            if (horario.getFecha().equals(fecha) && horario.getHoraInicial().equals(hora)) {
                horariosEncontrados.add(horario);
            }
        }

        if (horariosEncontrados.isEmpty())
            throw new InexistenteException("ERROR | No se encontró ningún horario que coincida con la fecha y/o hora proporcionadas.");
        return horariosEncontrados;
    }

    /**
     * Consulta los horarios disponibles para una fecha y número de pista específicos.
     *
     * @param fecha       La fecha para la cual se buscan los horarios.
     * @param numeroPista El número de pista para el cual se buscan los horarios.
     * @return La lista de horarios disponibles para la fecha y número de pista especificados.
     * @throws InexistenteException Si no se encuentra ningún horario disponible para la fecha y pista proporcionadas.
     */
    public static ArrayList<Horario> consultarporFecha(LocalDate fecha, int numeroPista) throws InexistenteException, ReservaExistente{
    	 ArrayList<Horario> horariosEncontrados = new ArrayList<>();
         for (Horario horario : horarios) {
         	if(horario.getFecha().equals(fecha) && horario.isEstado() == false) {
         		throw new ReservaExistente("ERROR | Ya hay una reserva existente con este horario.");

        	}
         	else if (horario.getFecha().equals(fecha) && horario.getNumeroPista() == numeroPista && horario.isEstado() == true) {
                horariosEncontrados.add(horario);

            }
        }
        if (horariosEncontrados.isEmpty())
            throw new InexistenteException("ERROR | No se encontr� ning�n horario disponible para la fecha proporcionada.");
        return horariosEncontrados;
    }

    /**
     * Actualiza el estado de un horario a no disponible.
     *
     * @param horario El horario a actualizar.
     * @return Un mensaje indicando el resultado de la operación.
     * @throws InexistenteException Si el horario a actualizar no existe.
     */
    public static String actualizarHorario(Horario horario) throws InexistenteException {
        Horario newHorario = consultarHorarioPorId(horario.getId());
        if (newHorario != null) {
            newHorario.setEstado(false);
            return "El horario ha sido actualizado correctamente";
        } else {
            return "ERROR | El horario no pudo ser actualizado";
        }
    }

    /**
     * Crea una nueva reserva si no existe una con el mismo ID.
     *
     * @param reserva La reserva a crear.
     * @return La reserva creada.
     * @throws RepetidoException Si ya existe una reserva con el mismo ID.
     */
    public static Reserva crearReserva(Reserva reserva) throws RepetidoException{
        if(!reservas.contains(reserva)) {
            reservas.add(reserva);
        } else {
            throw new RepetidoException("La Reserva con id: "+ reserva.getId() + " ya está registrada");
        }
        return reserva;
    }

    /**
     * Obtiene todas las reservas existentes.
     *
     * @return La lista de todas las reservas.
     */
    public static ArrayList<Reserva> consultarReservas() {
        return reservas;
    }

    /**
     * Consulta una reserva por su ID.
     *
     * @param id El ID de la reserva a consultar.
     * @return La reserva con el ID especificado.
     * @throws InexistenteException Si no se encuentra una reserva con el ID proporcionado.
     */
    public static Reserva consultarReservaPorId(int id) throws InexistenteException {
        for (Reserva reserva : reservas) {
            if (reserva.getId() == id) {
                return reserva;
            }
        }
        throw new InexistenteException("ERROR | No se encontró la reserva con id: " + id);
    }

    /**
     * Actualiza una reserva existente con la información proporcionada.
     *
     * @param reserva La reserva con los datos actualizados.
     * @return Un mensaje indicando el resultado de la operación.
     * @throws InexistenteException Si la reserva a actualizar no existe.
     */
    public static String actualizarReserva(Reserva reserva) throws InexistenteException {
        Reserva newReserva = consultarReservaPorId(reserva.getId());
        if(newReserva != null) {
            newReserva.setId(reserva.getId());
            newReserva.setIdCliente(reserva.getIdCliente());
            newReserva.setNumeroJugadores(reserva.getNumeroJugadores());
            newReserva.setIdSnackAdicional(reserva.getIdSnackAdicional());
            return "La Reserva ha sido actualizada correctamente";
        } else {
            return "ERROR | La Reserva no pudo ser actualizada";
        }
    }

    /**
     * Crea un nuevo torneo si no existe uno con el mismo ID.
     *
     * @param torneo El torneo a crear.
     * @return El torneo creado.
     * @throws RepetidoException Si ya existe un torneo con el mismo ID.
     */
	    public static Torneo crearTorneo(Torneo torneo) throws RepetidoException{
	    	if (torneos.isEmpty()) {
	    		torneos.add(torneo);
	        } else {
	            boolean TorneoRepetido = false;
	            for (Torneo t : torneos) {
	                if (torneo.isEstado() == false || t.getNombreTorneo().equals(torneo.getNombreTorneo())) {
	                	TorneoRepetido = true;
	                    break;
	                }
	            }
	            if (!TorneoRepetido) {
	            	torneos.add(torneo);
	            } else {
	                throw new RepetidoException("El torneo con id: " + torneo.getIdTorneo() + " ya está registrado");
	            }
	        }
	        return torneo;
	    }

    /**
     * Obtiene todos los torneos existentes.
     *
     * @return La lista de todos los torneos.
     */
    public static ArrayList<Torneo> consultarTorneos() {
        return torneos;
    }

    /**
     * Consulta un torneo por su ID.
     *
     * @param id El ID del torneo a consultar.
     * @return El torneo con el ID especificado.
     * @throws InexistenteException Si no se encuentra un torneo con el ID proporcionado.
     */
    public static Torneo consultarTorneoPorId(int id) throws InexistenteException {
        for (Torneo torneo : torneos) {
            if (torneo.getIdTorneo() == id) {
                return torneo;
            }
        }
        throw new InexistenteException("ERROR | No se encontró el torneo con id: " + id);
    }

    /**
     * Actualiza un torneo existente con la información proporcionada.
     *
     * @param torneo El torneo con los datos actualizados.
     * @return Un mensaje indicando el resultado de la operación.
     * @throws InexistenteException Si el torneo a actualizar no existe.
     */
    public static String actualizarTorneo(Torneo torneo) throws InexistenteException {
        Torneo newTorneo = consultarTorneoPorId(torneo.getIdTorneo());
        if(newTorneo != null) {
        	newTorneo.setNombreTorneo(torneo.getNombreTorneo());
            newTorneo.setPremio(torneo.getPremio());
            for(Cliente c: torneo.getParticipantes()) {
            	newTorneo.getParticipantes().add(c);
            }
            return "El Torneo ha sido actualizado correctamente";
        } else {
            return "ERROR | El Torneo no pudo ser actualizado";
        }
    }
    /**
     * Elimina una reserva existente.
     *
     * @param reserva La reserva a eliminar.
     * @return Un mensaje indicando el resultado de la operación.
     * @throws InexistenteException Si la reserva a eliminar no existe.
     */
    public static String eliminarReserva(Reserva reserva) throws InexistenteException {
        Reserva reservaB = consultarReservaPorId(reserva.getId());
        if(reservaB != null) {
            reservas.remove(reserva);
            return "La Reserva ha sido cancelada correctamente";
        } else {
            return "ERROR | La Reserva no pudo ser cancelada";
        }
    }

    /**
     * Obtiene la lista de clientes.
     *
     * @return La lista de clientes.
     */
    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    /**
     * Establece la lista de clientes.
     *
     * @param clientes La lista de clientes a establecer.
     */
    public static void setClientes(ArrayList<Cliente> clientes) {
        DataSource.clientes = clientes;
    }

    /**
     * Obtiene la lista de horarios.
     *
     * @return La lista de horarios.
     */
    public static ArrayList<Horario> getHorarios() {
        return horarios;
    }

    /**
     * Establece la lista de horarios.
     *
     * @param horarios La lista de horarios a establecer.
     */
    public static void setHorarios(ArrayList<Horario> horarios) {
        DataSource.horarios = horarios;
    }

    /**
     * Obtiene la lista de reservas.
     *
     * @return La lista de reservas.
     */
    public static ArrayList<Reserva> getReservas() {
        return reservas;
    }

    /**
     * Establece la lista de reservas.
     *
     * @param reservas La lista de reservas a establecer.
     */
    public static void setReservas(ArrayList<Reserva> reservas) {
        DataSource.reservas = reservas;
    }

    /**
     * Obtiene la lista de torneos.
     *
     * @return La lista de torneos.
     */
    public static ArrayList<Torneo> getTorneos() {
        return torneos;
    }

    /**
     * Establece la lista de torneos.
     *
     * @param torneos La lista de torneos a establecer.
     */
    public static void setTorneos(ArrayList<Torneo> torneos) {
        DataSource.torneos = torneos;
    }

    /**
     * Obtiene la lista de snacks adicionales.
     *
     * @return La lista de snacks adicionales.
     */
    public static ArrayList<SnackAdicional> getSnacks() {
        return snacks;
    }

    /**
     * Establece la lista de snacks adicionales.
     *
     * @param snacks La lista de snacks adicionales a establecer.
     */
    public static void setSnacks(ArrayList<SnackAdicional> snacks) {
        DataSource.snacks = snacks;
    }

	

}