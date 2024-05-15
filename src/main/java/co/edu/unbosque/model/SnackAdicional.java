package co.edu.unbosque.model;

/**
 * La clase SnackAdicional representa un snack adicional que puede ser agregado a una reserva.
 * Contiene información como el identificador, el nombre, la cantidad disponible y el precio.
 */
public class SnackAdicional {
    private int id; // Identificador del snack adicional
    private String nombre; // Nombre del snack adicional
    private int cantidad; // Cantidad disponible del snack adicional
    private double precio; // Precio del snack adicional

    /**
     * Constructor de la clase SnackAdicional.
     * @param id Identificador del snack adicional.
     * @param nombre Nombre del snack adicional.
     * @param cantidad Cantidad disponible del snack adicional.
     * @param precio Precio del snack adicional.
     */
    public SnackAdicional(int id, String nombre, int cantidad, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Métodos getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
