import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Scanner leer = new Scanner(System.in);

        int opcion = 0;
        while (opcion != 7) {
            System.out.println("TIENDA:");
            System.out.println("1. REGISTRAR PRODUCTO");
            System.out.println("2. ELIMINAR PRODUCTO");
            System.out.println("3. MOSTRAR PRODUCTO");
            System.out.println("4. MOSTRAR CATEGORIAS EXISTENTES.");
            System.out.println("5. MOSTRAR PRODUCTOS SEGÚN SU CATEGORIA.");
            System.out.println("6. REGISTRAR CATEGORIAS");
            System.out.println("7. SALIR");

            System.out.print("\nSelecciona una opcion: ");
            opcion = leer.nextInt();

            leer.nextLine();
            switch (opcion) {
                case 1:
                    if(!inventario.validarCategoria()){
                        System.out.println("\n No existen categorias en el Sistema");
                        break;
                    }

                    System.out.println("\nIngresa el nombre del producto: ");
                    String nombre = leer.next();

                    leer.nextLine();
                    System.out.println("Ingresa el precio del producto: ");
                    double precio = leer.nextDouble();

                    leer.nextLine();
                    System.out.println("Ingresa el descripcion del producto: ");
                    String descripcion = leer.next();

                    leer.nextLine();
                    System.out.println("Ingresa el stock del producto: ");
                    int stock = leer.nextInt();

                    leer.nextLine();
                    System.out.println("Ingresa el id de la categoria en donde registraras el producto: ");
                    int idCategoria = leer.nextInt();

                    Producto producto = new Producto(nombre, precio, descripcion, idCategoria, stock);
                    inventario.registrarProducto(producto, idCategoria);
                    break;
                case 2:
                    System.out.println("\nELIMINAR PRODUCTO");
                    System.out.println("Ingresa el ID del producto: ");

                    int id = leer.nextInt();
                    inventario.eliminarProducto(id);
                    break;
                case 3:
                    inventario.mostrarProductos();
                    break;
                case 4:
                    inventario.mostrarCategorias();
                    break;
                case 5:
                    inventario.mostrarCategoriasConProductos();
                    break;
                case 6:
                    System.out.println("\nSELECCIONASTE LA OPCIÓN PARA AGREGAR CATEGORIAS.");

                    System.out.println("Ingresa el nombre de la categoria: ");
                    String nombreCategoria = leer.next();

                    Categoria c = new Categoria(nombreCategoria);
                    inventario.registrarCategoria(c);
                    break;
                    case 7:
                        System.out.println("SALISTE.");
                    return;
            }

        }
    }
}