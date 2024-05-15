package co.edu.unbosque.model.dao;

import java.util.ArrayList;

import co.edu.unbosque.model.Cliente;
import co.edu.unbosque.model.Horario;
import co.edu.unbosque.model.Reserva;
import co.edu.unbosque.model.SnackAdicional;
import co.edu.unbosque.model.Torneo;
import co.edu.unbosque.model.dto.ClienteDTO;
import co.edu.unbosque.model.dto.HorarioDTO;
import co.edu.unbosque.model.dto.ReservaDTO;
import co.edu.unbosque.model.dto.SnackAdicionalDTO;
import co.edu.unbosque.model.dto.TorneoDTO;

/**
 * La clase DataMapper proporciona métodos para mapear objetos de dominio a DTOs y viceversa.
 */
public class DataMapper {

    /**
     * Convierte un objeto Horario en un objeto HorarioDTO.
     * 
     * @param horario El objeto Horario a convertir.
     * @return Un objeto HorarioDTO.
     */
    public static HorarioDTO horarioToDTO(Horario horario) {
        return new HorarioDTO(horario.getId(), horario.getTipoJuego(), horario.getHoraInicial(), horario.getHoraFinal(),
                horario.getFecha(), horario.getNumeroPista(), horario.isEstado());
    }

    /**
     * Convierte una lista de objetos Horario en una lista de objetos HorarioDTO.
     * 
     * @param horarios La lista de objetos Horario a convertir.
     * @return Una lista de objetos HorarioDTO.
     */
    public static ArrayList<HorarioDTO> ArrayHorariosToDTO(ArrayList<Horario> horarios) {
        ArrayList<HorarioDTO> horariosDTO = new ArrayList<HorarioDTO>();
        for (Horario horario : horarios) {
            horariosDTO.add(horarioToDTO(horario));
        }
        return horariosDTO;
    }

    /**
     * Convierte un objeto HorarioDTO en un objeto Horario.
     * 
     * @param horarioDTO El objeto HorarioDTO a convertir.
     * @return Un objeto Horario.
     */
    public static Horario DTOToHorario(HorarioDTO horarioDTO) {
        return new Horario(horarioDTO.getId(), horarioDTO.getTipoJuego(), horarioDTO.getHoraInicial(),
                horarioDTO.getHoraFinal(), horarioDTO.getFecha(), horarioDTO.getNumeroPista(), horarioDTO.isEstado());
    }

    /**
     * Convierte un objeto Reserva en un objeto ReservaDTO.
     * 
     * @param reserva El objeto Reserva a convertir.
     * @return Un objeto ReservaDTO.
     */
    public static ReservaDTO reservaToDTO(Reserva reserva) {
        return new ReservaDTO(reserva.getId(), reserva.getTipoJuego(), reserva.getHoraInicial(), reserva.getHoraFinal(),
                reserva.getFecha(), reserva.getNumeroPista(), reserva.isEstado(), reserva.getIdCliente(),
                reserva.getNumeroJugadores(), reserva.getIdSnackAdicional());
    }

    /**
     * Convierte un objeto ReservaDTO en un objeto Reserva.
     * 
     * @param reservaDTO El objeto ReservaDTO a convertir.
     * @return Un objeto Reserva.
     */
    public static Reserva DTOToReserva(ReservaDTO reservaDTO) {
        return new Reserva(reservaDTO.getId(), reservaDTO.getTipoJuego(), reservaDTO.getHoraInicial(),
                reservaDTO.getHoraFinal(), reservaDTO.getFecha(), reservaDTO.getNumeroPista(), reservaDTO.isEstado(),
                reservaDTO.getIdCliente(), reservaDTO.getNumeroJugadores(), reservaDTO.getIdSnackAdicional());
    }
    
    /**
     * Convierte una lista de objetos Reserva en una lista de objetos ReservaDTO.
     * 
     * @param reservas La lista de objetos Reserva a convertir.
     * @return Una lista de objetos ReservaDTO.
     */
    public static ArrayList<ReservaDTO> ArrayReservasToDTO(ArrayList<Reserva> reservas){
        ArrayList<ReservaDTO> reservasDTO = new ArrayList<ReservaDTO>();
        for (Reserva reserva: reservas) {
            reservasDTO.add(reservaToDTO(reserva));
        }
        return  reservasDTO;
    }

    /**
     * Convierte un objeto SnackAdicional en un objeto SnackAdicionalDTO.
     * 
     * @param snackAdicional El objeto SnackAdicional a convertir.
     * @return Un objeto SnackAdicionalDTO.
     */
    public static SnackAdicionalDTO snackAdicionalToDTO(SnackAdicional snackAdicional) {
        return new SnackAdicionalDTO(snackAdicional.getId(), snackAdicional.getNombre(), snackAdicional.getCantidad(),
                snackAdicional.getPrecio());
    }

    /**
     * Convierte un objeto SnackAdicionalDTO en un objeto SnackAdicional.
     * 
     * @param snackAdicionalDTO El objeto SnackAdicionalDTO a convertir.
     * @return Un objeto SnackAdicional.
     */
    public static SnackAdicional DTOToSnackAdicional(SnackAdicionalDTO snackAdicionalDTO) {
        return new SnackAdicional(snackAdicionalDTO.getId(), snackAdicionalDTO.getNombre(),
                snackAdicionalDTO.getCantidad(), snackAdicionalDTO.getPrecio());
    }
    
    

    /**
     * Convierte un objeto Torneo en un objeto TorneoDTO.
     * 
     * @param torneo El objeto Torneo a convertir.
     * @return Un objeto TorneoDTO.
     */
    public static TorneoDTO torneoToDTO(Torneo torneo) {
    	ArrayList<ClienteDTO> participantes = new ArrayList<ClienteDTO>();
    	for(Cliente participante: torneo.getParticipantes()) {
    		participantes.add(DataMapper.clienteToDTO(participante));
    	}
        return new TorneoDTO(torneo.getId(), torneo.getTipoJuego(), torneo.getHoraInicial(), torneo.getHoraFinal(),
                torneo.getFecha(), torneo.getNumeroPista(), torneo.isEstado(), torneo.getIdTorneo(), torneo.getNombreTorneo(),
                torneo.getPremio(), participantes);
    }

    /**
     * Convierte un objeto TorneoDTO en un objeto Torneo.
     * 
     * @param torneoDTO El objeto TorneoDTO a convertir.
     * @return Un objeto Torneo.
     */
    public static Torneo DTOToTorneo(TorneoDTO torneoDTO) {
    	ArrayList<Cliente> participantes = new ArrayList<Cliente>();
    	for(ClienteDTO participante: torneoDTO.getParticipantes()) {
    		participantes.add(DataMapper.DTOToCliente(participante));
    	}
        return new Torneo(torneoDTO.getId(), torneoDTO.getTipoJuego(), torneoDTO.getHoraInicial(),
                torneoDTO.getHoraFinal(), torneoDTO.getFecha(), torneoDTO.getNumeroPista(), torneoDTO.isEstado(),
                torneoDTO.getIdTorneo(), torneoDTO.getNombreTorneo(), torneoDTO.getPremio(), participantes);
    }

    /**
     * Convierte una lista de objetos Torneo en una lista de objetos TorneoDTO.
     * 
     * @param torneos La lista de objetos Torneo a convertir.
     * @return Una lista de objetos TorneoDTO.
     */
    public static ArrayList<TorneoDTO> ArrayTorneosToDTO(ArrayList<Torneo> torneos) {
        ArrayList<TorneoDTO> torneosDTO = new ArrayList<TorneoDTO>();
        for (Torneo torneo: torneos) {
            torneosDTO.add(DataMapper.torneoToDTO(torneo));
        }
        return torneosDTO;
    }

    /**
     * Convierte un objeto Cliente en un objeto ClienteDTO.
     * 
     * @param cliente El objeto Cliente a convertir.
     * @return Un objeto ClienteDTO.
     */
    public static ClienteDTO clienteToDTO(Cliente cliente) {
        ArrayList<ReservaDTO> historialReservasDTO = new ArrayList<>();
        for (Reserva reserva : cliente.getHistorialReservas()) {
            historialReservasDTO.add(reservaToDTO(reserva));
        }
        ArrayList<TorneoDTO> historialTorneosDTO = new ArrayList<>();
        for (Torneo torneo : cliente.getHistorialTorneos()) {
        	historialTorneosDTO.add(torneoToDTO(torneo));
        }

        return new ClienteDTO(cliente.getNombre(), cliente.getId(), cliente.getCedula(), historialReservasDTO, cliente.getPrimeraRonda(), cliente.getSegundaRonda(), cliente.getTerceraRonda(), historialTorneosDTO);
    }

    /**
     * Convierte un objeto ClienteDTO en un objeto Cliente.
     * 
     * @param clienteDTO El objeto ClienteDTO a convertir.
     * @return Un objeto Cliente.
     */
    public static Cliente DTOToCliente(ClienteDTO clienteDTO) {
        ArrayList<Reserva> historialReservas = new ArrayList<>();
        for (ReservaDTO reservaDTO : clienteDTO.getHistorialReservas()) {
            historialReservas.add(DTOToReserva(reservaDTO));
        }
        ArrayList<Torneo> historialTorneos = new ArrayList<>();
        for (TorneoDTO torneoDTO : clienteDTO.getHistorialTorneos()) {
        	historialTorneos.add(DTOToTorneo(torneoDTO));
        }

        return new Cliente(clienteDTO.getNombre(), clienteDTO.getId(), clienteDTO.getCedula(), historialReservas, clienteDTO.getPrimeraRonda(), clienteDTO.getSegundaRonda(), clienteDTO.getTerceraRonda(), historialTorneos);

    }

    /**
     * Convierte una lista de objetos Cliente en una lista de objetos ClienteDTO.
     * 
     * @param clientes La lista de objetos Cliente a convertir.
     * @return Una lista de objetos ClienteDTO.
     */
    public static ArrayList<ClienteDTO> ArrayClientesToDTO(ArrayList<Cliente> clientes){
        ArrayList<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();
        for (Cliente cliente: clientes) {
            clientesDTO.add(DataMapper.clienteToDTO(cliente));
        }
        return  clientesDTO;
    }


	
}