public class producto {
    private String nombre;
    private double precio;
    private int stock;

    public producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void aumentarStock(int cantidad){
        if(cantidad > 0){
            this.stock += cantidad;
        }
        else {
            System.out.println("El aumentar Stock tiene que ser un número entero mayor a 0");
        }
    }
    public void disminuirStock(int cantidad){
        if (cantidad < 0){
            this.stock -= cantidad;
        }
        else {
            System.out.println("El restar Stock tiene que ser un número entero menor a 0");
        }
    }
}