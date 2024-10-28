package hospital;

import consultas.Consulta;
import consultorios.Consultorio;
import medicos.Medico;
import pacientes.Paciente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Hospital {
    public ArrayList<Paciente> listaPacientes = new ArrayList<>();
    public ArrayList<Medico> listaMedicos = new ArrayList<>();
    public ArrayList<Consultorio> listaConsultorios = new ArrayList<>();
    public ArrayList<Consulta> listaConsultas = new ArrayList<>();
    private ValidadorHospital validador = new ValidadorHospital();

    public void registrarPaciente(Paciente paciente) {
        this.listaPacientes.add(paciente);
    }

    public void registrarMedico(Medico medico) {
        this.listaMedicos.add(medico);
    }

    public void registrarConsultorio(Consultorio consultorio) {
        this.listaConsultorios.add(consultorio);
    }

    public void registrarConsulta(Consulta consulta) {
        if (!validador.validarDisponibilidadEnFechaConsulta(consulta.getFechaHora(), consulta.getConsultorio().getNumeroConsultorio(), this.listaConsultas)) {
            System.out.println("Ya existe una consulta registrada para esa fecha.");
            return;
        }

        if (!validador.validarDisponibilidadMedico(consulta.getFechaHora(), consulta.getMedico().getId(), this.listaConsultas)) {
            System.out.println("El medico no tiene disponibilidad para esa fecha.");
            return;
        }

        this.listaConsultas.add(consulta);
    }

    public void mostrarPaciente() {
        if (listaPacientes.size() == 0) {
            System.out.println("No hay pacientes registrados");
        }

        for (Paciente paciente : this.listaPacientes) {
            System.out.println(paciente.mostrarDatos());
        }
    }

    public void mostrarMedico() {
        if (listaMedicos.size() == 0) {
            System.out.println("No hay medicos registrados");
        }

        for (Medico medico : this.listaMedicos) {
            System.out.println(medico.mostrarDatos());
        }
    }

    public void mostrarConsultorio() {
        if (listaConsultorios.size() == 0) {
            System.out.println("No hay consultorios registrados");
        }

        for (Consultorio consultorio : this.listaConsultorios) {
            System.out.println(consultorio.mostrarDatos());
        }
    }

    public void mostrarConsulta() {
        if (listaConsultas.size() == 0) {
            System.out.println("No hay consultas registradas");
        }

        for (Consulta consulta : this.listaConsultas) {
            System.out.println(consulta.mostrarDatos());
        }
    }

    public String generarIdPaciente() {
        Random random = new Random();
        LocalDate fecha = LocalDate.now();
        int anoActual = fecha.getYear();
        int mesActual = fecha.getMonthValue();
        int longitudPacientesMasUno = this.listaPacientes.size() + 1;
        int numeroAleatorio = random.nextInt(1, 100000);

        String id = String.format("P%d%d%d%d", anoActual, mesActual, longitudPacientesMasUno, numeroAleatorio);
        return id;
    }

    public String generarIdMedico(String apellido, LocalDate fechaNacimiento) {
        Random random = new Random();
        LocalDate fecha = LocalDate.now();
        String primerasLetrasApellido = apellido.substring(0, 2).toUpperCase();

        String anioEnCadena = String.valueOf(fechaNacimiento);
        anioEnCadena = anioEnCadena.substring(anioEnCadena.length() - 1).toUpperCase();
        int anoActual = fecha.getYear();
        int numeroAleatorio = random.nextInt(50, 700000);
        int longitudMedicosMasUno = this.listaMedicos.size() + 1;


        String id = String.format("M%s%s%d%d%d", primerasLetrasApellido, anioEnCadena, anoActual, numeroAleatorio, longitudMedicosMasUno);
        return id;
    }

    public String generarIdConsultorio() {
        Random random = new Random();
        LocalDate fecha = LocalDate.now();
        int longitudConsultorioMasUno = this.listaConsultas.size() + 1;
        int diaActual = fecha.getDayOfMonth();
        int anoActual = fecha.getYear();
        int numeroAleatorio = random.nextInt(1, 500000);
        String id = String.format("C%d%d%d%d", longitudConsultorioMasUno, diaActual, anoActual, numeroAleatorio);
        return id;
    }

    public String generarIdConsulta() {
        int diaActual = LocalDate.now().getDayOfMonth();
        int numeroAleatrorio = new Random().nextInt(100000 - 50) + 50;

        return String.format("CO-%d-%d", listaConsultas.size() + 1, numeroAleatrorio, diaActual);
    }

    public Paciente obtenerPacientePorId(String id) {
        return this.listaPacientes.stream().filter(paciente -> paciente.getId().equals(id)).findFirst().orElse(null);
    }

    public Medico obtenerMedicoPorId(String id) {
        return this.listaMedicos.stream().filter(medico -> medico.getId().equals(id)).findFirst().orElse(null);
    }

    public Consultorio obtenerConsultorioPorId(String id) {
        return this.listaConsultorios.stream().filter(consultorio -> consultorio.getId().equals(id)).findFirst().orElse(null);
    }

    public void mostrarPacientePorId(String id) {
        Paciente paciente = this.obtenerPacientePorId(id);

        if (paciente != null) {
            System.out.println(paciente.mostrarDatos());
        } else {
            System.out.println("No se encontro el paciente con el id " + id);
        }
    }

    public void mostrarMedicoPorId(String id) {
        Medico medico = this.obtenerMedicoPorId(id);

        if (medico != null) {
            System.out.println(medico.mostrarDatos());
        } else {
            System.out.println("No se encontro el medico con el id " + id);
        }
    }

    public void mostrarConsultorioPorId(String id) {
        Consultorio consultorio = this.obtenerConsultorioPorId(id);

        if (consultorio != null) {
            System.out.println(consultorio.mostrarDatos());
        } else {
            System.out.println("No se encontro el consultorio con el id " + id);
        }
    }

    public boolean validarFechaConsulta(LocalDateTime fechaDeseada) {
        return this.validador.validarFechaCorrecta(fechaDeseada);
    }

    public boolean validarTelefoPacienteYaExiste(String telefoPaciente) {
        for (Paciente paciente : this.listaPacientes) {
            if (paciente.getTelefono().equals(telefoPaciente)) {
                return true;
            }
        }
        return false;
    }

    public boolean validarTelefoMedicoYaExiste(String telefoMedico) {
        for (Medico medico : this.listaMedicos) {
            if (medico.getTelefono().equals(telefoMedico)) {
                return true;
            }
        }
        return false;
    }

    public boolean validarRfcMedicoYaExiste(String rfcMedico) {
        for (Medico medico : this.listaMedicos) {
            if (medico.getRfc().equals(rfcMedico)) {
                return true;
            }
        }
        return false;
    }
}