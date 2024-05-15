package co.edu.unbosque.model.exception;

/**
 * Excepción que indica que ya existe una reserva.
 */
public class ReservaExistente extends Exception {

    /**
     * Crea una nueva instancia de ReservaExistente con el mensaje especificado.
     *
     * @param mensaje El mensaje que describe la excepción.
     */
    public ReservaExistente(String mensaje) {
        super(mensaje);
    }
}
