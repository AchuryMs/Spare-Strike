package co.edu.unbosque.model.exception;

/**
 * InexistenteException represents an exception that is thrown when an entity does not exist.
 */
public class InexistenteException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Constructs an InexistenteException with the specified error message.
     *
     * @param mensaje The error message.
     */
    public InexistenteException(String mensaje) {
        super(mensaje);
    }
}
