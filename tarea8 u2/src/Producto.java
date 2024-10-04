import java.util.Random;

public class Producto {
    public int id;
    public String nombre;
    public Double precio;
    public String descripcion;
    public int idCategoria;
    public int stock;
    public Random random = new Random();

    public Producto(String nombre, Double precio, String descripcion, int idCategoria, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.idCategoria = idCategoria;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public int getStock() {
        return stock;
    }

    public Random getRandom() {
        return random;
    }

    public String mostrarProducto() {
        return String.format("Id: %d, Nombre: %s, Precio: %.2f, Descripcion: %s, idCategoria: %d, Stock: %d",
                this.id, this.nombre, this.precio, this.descripcion, this.idCategoria, this.stock);
    }
}