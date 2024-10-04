import java.util.ArrayList;
import java.util.Random;

public class Categoria {
    public int id;
    public String nombre;
    public ArrayList<Producto> listaP = new ArrayList<Producto>();
    public Random random = new Random();

    public Categoria(String nombre) {
        this.id = this.random.nextInt(1,1001);
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    public void registrarP(Producto producto) {
        listaP.add(producto);
    }

    public String mostrarDatos() {
        return String.format("CATEGORIA: %s, ID Categoria: %d", this.nombre, this.id);
    }
}