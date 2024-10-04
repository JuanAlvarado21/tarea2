import consultas.Consulta;
import consultorios.Consultorio;
import hospital.Hospital;
import medicos.Medico;
import pacientes.Paciente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
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
                    System.out.println("Año de nacimiento: ");
                    int anio = leer.nextInt();
                    System.out.println("Mes de nacimiento: ");
                    int mes = leer.nextInt();
                    System.out.println("Dia de nacimiento: ");
                    int dia = leer.nextInt();
                    LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);

                    leer.nextLine();
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
                    System.out.println("Año de nacimiento: ");
                    int anioMedico = leer.nextInt();
                    System.out.println("Mes de nacimiento: ");
                    int mesMedico = leer.nextInt();
                    System.out.println("Dia de nacimiento: ");
                    int diaMedico = leer.nextInt();
                    LocalDate fechaNacimientoMedico = LocalDate.of(anioMedico, mesMedico, diaMedico);

                    String idMedico = hospital.generarIdMedico(apellidosMedico, fechaNacimientoMedico);
                    leer.nextLine();
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
                    System.out.println("Piso del consultorio: ");
                    int piso = leer.nextInt();
                    System.out.println("Número del consultorio: ");
                    int numeroConsultorio = leer.nextInt();

                    Consultorio consultorio = new Consultorio(idConsultorio, piso, numeroConsultorio);
                    hospital.registrarConsultorio(consultorio);
                    break;
                case 4:
                    System.out.println("REGISTRAR CONSULTA\n");

                    int id_consulta = new Random().nextInt(1,10000);//id temporal hasta que de el formato que le debemos dar

                    System.out.println("Dia de consulta: ");
                    int diaConsulta = leer.nextInt();

                    System.out.println("Mes de consulta: ");
                    int mesConsulta =leer.nextInt();

                    System.out.println("Año de consulta: ");
                    int anioConsulta = leer.nextInt();

                    System.out.println("Hora de consulta: ");
                    int horaConsulta = leer.nextInt();

                    System.out.println("Minuto de consulta: ");
                    int minutosConsulta = leer.nextInt();
                    LocalDateTime fechaConsulta = LocalDateTime.of(anioConsulta, mesConsulta, diaConsulta, horaConsulta, minutosConsulta);

                    leer.nextLine();
                    System.out.println("ID del Paciente: ");
                    String pacienteId = leer.nextLine();
                    Paciente pacienteConsulta = hospital.obtenerPacientePorId(pacienteId);

                    System.out.println("ID del Medico: ");
                    String medicoId = leer.nextLine();
                    Medico medicoConsulta = hospital.obtenerMedicoPorId(medicoId);

                    System.out.println("ID del Consultorio: ");
                    String idConsultorioDeseado = leer.nextLine();

                    Consultorio consultorioConsulta = hospital.obtenerConsultorioPorId(idConsultorioDeseado);

                    Consulta consulta = new Consulta(id_consulta, fechaConsulta, pacienteConsulta, medicoConsulta, consultorioConsulta);
                    hospital.registrarConsulta(consulta);

                    break;
                case 5:
                    System.out.println("Mostrar lista de Pacientes\n");
                    hospital.mostrarPaciente();
                    break;
                case 6:
                    System.out.println("Mostrar lista de Medicos\n");
                    hospital.mostrarMedico();
                    break;
                case 7:
                    System.out.println("Mostrar lista de Consultorios\n");
                    hospital.mostrarConsultorio();
                    break;
                case 8:
                    System.out.println("Mostrar lista de Consultas\n");
                    hospital.mostrarConsulta();
                    break;
                case 9:
                    System.out.println("Mostrar Paciente por ID\n");
                    leer.nextLine();
                    System.out.println("Ingresa el ID del paciente: ");
                    String idPaciente = leer.nextLine();
                    hospital.mostrarPacientePorId(idPaciente);
                    break;
                case 10:
                    System.out.println("Mostrar Medico por ID\n");
                    leer.nextLine();
                    System.out.println("Ingresa el ID del medico: ");
                    String idM = leer.nextLine();
                    hospital.mostrarMedicoPorId(idM);
                    break;
                case 11:
                    System.out.println("Mostrar Consultorio por ID\n");
                    leer.nextLine();
                    System.out.println("Ingresa el ID del consultorio:");
                    String id_Consultorio = leer.nextLine();
                    hospital.mostrarConsultorioPorId(id_Consultorio);
                    break;
                case 12:
                    System.out.println("SALISTE");
                    break;
                default:
                    System.out.println("OPCIÓN INVALIDA \n");
                    break;
            }
        }
    }
}