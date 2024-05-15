package co.edu.unbosque.model.exception;

/**
 * RepetidoException represents an exception that is thrown when an attempt is made to create a duplicate entity.
 */
public class RepetidoException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a RepetidoException with the specified error message.
     *
     * @param mensaje The error message.
     */
    public RepetidoException(String mensaje) {
        super(mensaje);
    }
}
