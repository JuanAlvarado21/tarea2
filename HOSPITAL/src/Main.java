import consultas.Consulta;
import consultorios.Consultorio;
import hospital.Hospital;
import medicos.Medico;
import pacientes.Paciente;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
            System.out.println("10. Mostrar Medico por ID.");
            System.out.println("11. Mostrar Consultorio por ID.");
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

                    if (!hospital.listaPacientes.isEmpty()) {
                        while (hospital.validarTelefoPacienteYaExiste(telefono)) {
                            System.out.println("Ya esta registrado ese número de teléfono.\n");
                            System.out.println("Vuelve a ingresar otro número de teléfono:  ");
                            telefono = leer.nextLine();
                        }
                    }

                    Paciente paciente = new Paciente(id, nombre, apellidos, fechaNacimiento, tipoSangre, sexo, telefono);
                    hospital.registrarPaciente(paciente);
                    break;
                case 2:
                    System.out.println("REGISTRAR MEDICO\n");

                    leer.nextLine();
                    System.out.println("Primeros Nombres: ");
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

                    if (!hospital.listaMedicos.isEmpty()) {
                        while (hospital.validarTelefoMedicoYaExiste(telefonoMedico)) {
                            System.out.println("Ya está registrado este número de teléfono.\n");
                            System.out.println("Vuelve a ingresar otro número de teléfono: ");
                            telefonoMedico = leer.nextLine();
                        }
                    }

                    System.out.println("RFC: ");
                    String rfc = leer.nextLine();

                    if (!hospital.listaMedicos.isEmpty()) {
                        while (hospital.validarRfcMedicoYaExiste(rfc)) {
                            System.out.println("Ya estaba previamente registrado ese RFC.\n");
                            System.out.println("Intenta con otro RFC: ");
                            rfc = leer.nextLine();
                        }
                    }

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

                    System.out.println("Dia de la consulta: ");
                    int diaConsulta = leer.nextInt();
                    System.out.println("Mes de la consulta: ");
                    int mesConsulta = leer.nextInt();
                    System.out.println("Año de la consulta: ");
                    int anioConsulta = leer.nextInt();
                    System.out.println("Hora de la consulta: ");
                    int horaConsulta = leer.nextInt();
                    System.out.println("Minuto de la consulta: ");
                    int minutosConsulta = leer.nextInt();
                    LocalDateTime fechaConsulta = LocalDateTime.of(anioConsulta, mesConsulta, diaConsulta, horaConsulta, minutosConsulta);

                    while (!hospital.validarFechaConsulta(fechaConsulta)){

                        if (!hospital.validarFechaConsulta(fechaConsulta)) {
                            System.out.println("Esta fecha es pasada.");
                        }

                        System.out.println("Dia de la consulta: ");
                        diaConsulta = leer.nextInt();
                        System.out.println("Mes de la consulta: ");
                        mesConsulta = leer.nextInt();
                        System.out.println("Año de la consulta: ");
                        anioConsulta = leer.nextInt();
                        System.out.println("Hora de la consulta: ");
                        horaConsulta = leer.nextInt();
                        System.out.println("Minuto de la consulta: ");
                        minutosConsulta = leer.nextInt();
                        fechaConsulta = LocalDateTime.of(anioConsulta, mesConsulta, diaConsulta, horaConsulta, minutosConsulta);
                    }

                    leer.nextLine();
                    Paciente pacienteConsulta = null;

                    while (pacienteConsulta == null) {
                        System.out.println("ID del Paciente: ");
                        String pacienteId = leer.nextLine();

                        pacienteConsulta = hospital.obtenerPacientePorId(pacienteId);

                        if (pacienteConsulta == null) {
                            System.out.println("No existe el paciente.\n ");
                        }
                    }

                    Medico medicoConsulta = null;

                    while (medicoConsulta == null) {
                        System.out.println("ID del medico: ");
                        String medicoId = leer.nextLine();

                        medicoConsulta = hospital.obtenerMedicoPorId(medicoId);

                        if (medicoConsulta == null) {
                            System.out.println("No existe el medico\n ");
                        }
                    }

                    Consultorio consultorioConsulta = null;

                    while (consultorioConsulta == null) {
                        System.out.println("ID del consultorio: ");
                        String idConsultorioDeseado = leer.nextLine();

                        consultorioConsulta = hospital.obtenerConsultorioPorId(idConsultorioDeseado);

                        if (consultorioConsulta == null) {
                            System.out.println("No existe el consultorio..\n ");
                        }
                    }

                    String id_consulta = hospital.generarIdConsulta();

                    Consulta consulta = new Consulta(id_consulta, fechaConsulta, pacienteConsulta, medicoConsulta, consultorioConsulta);
                    hospital.registrarConsulta(consulta);

                    break;
                case 5:
                    System.out.println("Mostrar lista de Pacientes:\n");
                    hospital.mostrarPaciente();
                    break;
                case 6:
                    System.out.println("Mostrar lista de Medicos:\n");
                    hospital.mostrarMedico();
                    break;
                case 7:
                    System.out.println("Mostrar lista de Consultorios: \n");
                    hospital.mostrarConsultorio();
                    break;
                case 8:
                    System.out.println("Mostrar lista Consultas: \n");
                    hospital.mostrarConsulta();
                    break;
                case 9:
                    System.out.println("Mostrar Paciente por ID:\n");
                    leer.nextLine();
                    System.out.println("Ingresa el id del paciente a buscar: ");
                    String idPaciente = leer.nextLine();
                    hospital.mostrarPacientePorId(idPaciente);
                    break;
                case 10:
                    System.out.println("Mostrar medico por ID\n");
                    leer.nextLine();
                    System.out.println("Ingresa el id del medico: ");
                    String idM = leer.nextLine();
                    hospital.mostrarMedicoPorId(idM);
                    break;
                case 11:
                    System.out.println("Mostrar consultorio por ID\n");
                    leer.nextLine();
                    System.out.println("Ingresa el id del consultorio:");
                    String id_Consultorio = leer.nextLine();
                    hospital.mostrarConsultorioPorId(id_Consultorio);
                    break;
                case 12:
                    System.out.println("SALISTE.");
                    break;
                default:
                    System.out.println("OPCION INVALIDA\n");
                    break;
            }
        }
    }
}