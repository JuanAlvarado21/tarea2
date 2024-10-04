import consultas.Consulta;
import consultorios.Consultorio;
import hospital.Hospital;
import medicos.Medico;
import pacientes.Paciente;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Hospital hospital = new Hospital();

        System.out.println("**HOSPITAL**");

        int opcion = 0;
        while (opcion != 12) {
            System.out.println("\n**BIENVENIDO**");
            System.out.println("1. Registrar Paciente. ");
            System.out.println("2. Registrar Medico.");
            System.out.println("3. Registrar Consultorio.");
            System.out.println("4. Registrar Consulta.");
            System.out.println("5. Mostrar Pacientes.");
            System.out.println("6. Mostrar Medicos.");
            System.out.println("7. Mostrar Consultorios.");
            System.out.println("8. Mostrar Consultas.");
            System.out.println("9. Mostrar Paciente por ID.");
            System.out.println("10. Mostrar Medico por ID");
            System.out.println("11. Mostrar Consultorio por ID");
            System.out.println("12. SALIR");

            System.out.print("\nSelecciona una opción: ");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("REGISTRAR PACIENTE\n");
                    String id = hospital.generarIdPaciente();
                    leer.nextLine();
                    System.out.println("Primeros nombres: ");
                    String nombre = leer.nextLine();
                    System.out.println("Apellidos: ");
                    String apellidos = leer.nextLine();
                    System.out.println("Fecha de nacimiento: ");
                    String fechaNacimiento = leer.nextLine();
                    System.out.println("Tipo de sangre: ");
                    String tipoSangre = leer.nextLine();
                    System.out.println("Sexo: H/M");
                    Character sexo = leer.next().charAt(0);
                    leer.nextLine();
                    System.out.println("Número de teléfono: ");
                    String telefono = leer.nextLine();

                    Paciente paciente = new Paciente(id, nombre, apellidos, fechaNacimiento, tipoSangre, sexo, telefono);
                    hospital.registrarPaciente(paciente);
                    break;
                case 2:
                    System.out.println("REGISTRAR MEDICO\n");

                    leer.nextLine();
                    System.out.println("Primeros nombres: ");
                    String nombreMedico = leer.nextLine();
                    System.out.println("Apellidos: ");
                    String apellidosMedico = leer.nextLine();
                    System.out.println("Fecha de nacimiento: ");
                    String fechaNacimientoMedico = leer.nextLine();
                    String idMedico = hospital.generarIdMedico(apellidosMedico, fechaNacimientoMedico);
                    System.out.println("Número de teléfono: ");
                    String telefonoMedico = leer.nextLine();
                    System.out.println("RFC: ");
                    String rfc = leer.nextLine();

                    Medico medico = new Medico(idMedico,nombreMedico, apellidosMedico, fechaNacimientoMedico, telefonoMedico, rfc);
                    hospital.registrarMedico(medico);
                    break;
                case 3:
                    System.out.println("REGISTRAR CONSULTORIO\n");
                    String idConsultorio = hospital.generarIdConsultorio();
                    leer.nextLine();
                    System.out.println("Piso del Consultorio: ");
                    int piso = leer.nextInt();
                    System.out.println("Numero de Consultorio: ");
                    int numeroConsultorio = leer.nextInt();

                    Consultorio consultorio = new Consultorio(idConsultorio, piso, numeroConsultorio);
                    hospital.registrarConsultorio(consultorio);
                    break;
                case 4:
                    System.out.println("REGISTRAR CONSULTA\n");

                    break;
                case 5:
                    System.out.println("MOSTRAR PACIENTES\n");
                    hospital.mostrarPaciente();
                    break;
                case 6:
                    System.out.println("MOSTRAR MEDICOS\n");
                    hospital.mostrarMedico();
                    break;
                case 7:
                    System.out.println("MOSTRAR CONSULTORIOS\n");
                    hospital.mostrarConsultorio();
                    break;
                case 8:
                    System.out.println("MOSTRAR CONSULTAS\n");
                    hospital.mostrarConsulta();
                    break;
                case 9:
                    System.out.println("MOSTRAR PACIENTE POR ID\n");
                    leer.nextLine();
                    System.out.println("Ingresa el id del paciente a buscar");
                    String idPaciente = leer.nextLine();
                    hospital.mostrarPacientePorId(idPaciente);
                    break;
                case 10:
                    System.out.println("MOSTRAR MEDICO POR ID\n");
                    leer.nextLine();
                    System.out.println("Ingresa el id del medico a buscar");
                    String idM = leer.nextLine();
                    hospital.mostrarMedicoPorId(idM);
                    break;
                case 11:
                    System.out.println("MOSTRAR CONSULTORIO POR ID\n");
                    leer.nextLine();
                    System.out.println("Ingresa el id del consultorio a buscar");
                    String id_Consultorio = leer.nextLine();
                    hospital.mostrarConsultorioPorId(id_Consultorio);
                    break;
                case 12:
                    System.out.println("SALIR");
                    break;
                default:
                    System.out.println("OPCIÓN NO VALIDA");
                    break;
            }
        }
    }
}