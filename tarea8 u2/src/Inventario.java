import java.util.ArrayList;

public class Inventario {
    public ArrayList<Producto> listaP = new ArrayList<Producto>();
    public ArrayList<Categoria> listaC = new ArrayList<Categoria>();

    public void registrarCategoria(Categoria c){
        this.listaC.add(c);
        System.out.println("Categoria registrada");
    }
    public void registrarProducto(Producto p, int idCategoria){
        for (Categoria c : listaC){
            if (c.getId() == idCategoria){
                this.listaP.add(p);
                System.out.println("Producto registrado");
            }
            else {
                System.out.println("No se registró el producto porque no existe la categoria.");
            }
        }
    }

    public void eliminarProducto(int idProductoEliminar) {
        int longitudOriginal = this.listaP.size();
        this.listaP.removeIf((producto) -> producto.getId() == idProductoEliminar);
        if ( longitudOriginal != this.listaP.size()) {
            System.out.printf("Se elimino un producto con el ID: " + idProductoEliminar + ".\n");
        }
        else {
            System.out.println("No existe un producto con el ID: " + idProductoEliminar);
        }
    }

    public void mostrarProductos() {
        System.out.println("\n***PRODUCTOS EN EL SISTEMA***");

        if (this.listaP.size() == 0) {
            System.out.println("No hay productos registrados.");
            return;
        }
        int i = 1;
        for (Producto producto : this.listaP) {
            System.out.println("Este es el producto: " + i  + ".");
            System.out.println(producto.mostrarProducto());
            i++;
        }
    }

    public boolean validarCategoria() {
        return this.listaC.size() > 0;
    }

    public void mostrarCategorias() {
        System.out.println("\n***CATEGORIAS EN EL SISTEMA***");

        if (this.listaC.size() == 0) {
            System.out.println("No hay categorias registrados.\n");
            return;
        }
        for (Categoria categoria : listaC) {
            System.out.println(categoria.mostrarDatos());
        }
    }

    public void mostrarCategoriasConProductos(){
        System.out.println("\n***CATEGORIAS CON PRODUCTOS EN EL SISTEMA***");


        if (this.listaP.size() == 0 && this.listaC.size() == 0) {
            System.out.println("No hay productos ni categorias registrados.\n");
            return;
        }

        for (Categoria categoria : listaC) {
            System.out.println(categoria.mostrarDatos());
            for (Producto producto : this.listaP) {
                if (producto.getIdCategoria() == categoria.getId()) {
                    System.out.println(producto.mostrarProducto());
                }
            }
        }
    }

}