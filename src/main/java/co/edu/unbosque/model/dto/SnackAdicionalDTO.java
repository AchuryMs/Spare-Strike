package co.edu.unbosque.model.dto;

/**
 * SnackAdicionalDTO represents a data transfer object for additional snacks.
 */
public class SnackAdicionalDTO {
    private int id;
    private String nombre;
    private int cantidad;
    private double precio;

    /**
     * Constructs a SnackAdicionalDTO object with the specified attributes.
     *
     * @param id       The identifier of the snack.
     * @param nombre   The name of the snack.
     * @param cantidad The quantity of the snack.
     * @param precio   The price of the snack.
     */
    public SnackAdicionalDTO(int id, String nombre, int cantidad, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    /**
     * Retrieves the identifier of the snack.
     *
     * @return The identifier of the snack.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the identifier of the snack.
     *
     * @param id The identifier of the snack.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the snack.
     *
     * @return The name of the snack.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the name of the snack.
     *
     * @param nombre The name of the snack.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retrieves the quantity of the snack.
     *
     * @return The quantity of the snack.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Sets the quantity of the snack.
     *
     * @param cantidad The quantity of the snack.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Retrieves the price of the snack.
     *
     * @return The price of the snack.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Sets the price of the snack.
     *
     * @param precio The price of the snack.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
