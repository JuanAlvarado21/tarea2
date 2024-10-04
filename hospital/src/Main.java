import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("**HOSPITAL**");

        int opcion = 0;
        while (opcion != 5) {
            System.out.println("\n      BIENVENIDO\n" +
                    "1. Registrar Consultorio\n" +
                    "2. Registrar Consulta\n" +
                    "3. Registrar Paciente\n" +
                    "4. Registrar Medico\n" +
                    "5. Salir\n" +
                    "\n" +
                    "Seleccione una opción: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Registrar Consultorio");
                    break;
                case 2:
                    System.out.println("Registrar Consulta");
                    break;
                case 3:
                    System.out.println("Registrar Paciente");
                    break;
                case 4:
                    System.out.println("Registrar Medico");
                    break;
                case 5:
                    System.out.println("SALISTE");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }
}