package hospital;

import consultas.Consulta;
import consultorios.Consultorio;
import medicos.Medico;
import pacientes.Paciente;

import java.time.LocalDate;
import java.util.*;

public class Hospital {
    public ArrayList<Paciente> listaPacientes = new ArrayList<>();
    public ArrayList<Medico> listaMedicos= new ArrayList<>();
    public ArrayList<Consultorio> listaConsultorios = new ArrayList<>();
    public ArrayList<Consulta> listaConsultas = new ArrayList<>();
    private ValidadorHospital validador = new ValidadorHospital();

    public void registrarPaciente(Paciente paciente){
        this.listaPacientes.add(paciente);
    }

    public void registrarMedico(Medico medico){
        this.listaMedicos.add(medico);
    }

    public void registrarConsultorio(Consultorio consultorio){
        this.listaConsultorios.add(consultorio);
    }

    public void registrarConsulta(Consulta consulta, int idPaciente){
        if (!validador.validarDisponibilidadEnFechaConsulta(consulta.getFechaHora(), consulta.getConsultorio().getNumeroConsultorio(), this.listaConsultas)){
            System.out.println("Ya existe una consulta registrada para esa fecha.");
            return;
        }

        if (!validador.validarDisponibilidadMedico(consulta.getFechaHora(), consulta.getMedico().getId(), this.listaConsultas)){
            System.out.println("El medico no tiene disponibilidad para esa fecha.");
            return;
        }

        this.listaConsultas.add(consulta);
    }


    public void mostrarPaciente(){
        if (listaPacientes.size() == 0){
            System.out.println("No hay pacientes registrados");
        }

        for (Paciente paciente : this.listaPacientes){
            System.out.println(paciente.mostrarDatos());
        }
    }

    public void mostrarMedico(){
        if (listaMedicos.size() == 0){
            System.out.println("No hay medicos registrados");
        }

        for (Medico medico : this.listaMedicos){
            System.out.println(medico.mostrarDatos());
        }
    }

    public void mostrarConsultorio(){
        if (listaConsultorios.size() == 0){
            System.out.println("No hay consultorios registrados");
        }

        for (Consultorio consultorio : this.listaConsultorios){
            System.out.println(consultorio.mostrarDatos());
        }
    }

    public void mostrarConsulta(){
        if (listaConsultas.size() == 0){
            System.out.println("No hay consultas registradas");
        }

        for (Consulta consulta : this.listaConsultas){
            System.out.println(consulta.mostrarDatos());
        }
    }

    public String generarIdPaciente(){
        Random random = new Random();
        LocalDate fecha = LocalDate.now();
        int anoActual = fecha.getYear();
        int mesActual = fecha.getMonthValue();
        int longitudPacientesMasUno = this.listaPacientes.size() + 1;
        int numeroAleatorio = random.nextInt(1,100000);

        String id = String.format("P%d%d%d%d", anoActual, mesActual, longitudPacientesMasUno, numeroAleatorio);
        return id;
    }

    public String generarIdMedico(String apellido,String fechaNacimiento){
        Random random = new Random();
        LocalDate fecha = LocalDate.now();
        String primerasLetrasApellido = apellido.substring(0, 2).toUpperCase();//para que se vea mejor en mayusculas :)
        String ultimoDigitoAnoNacimiento = fechaNacimiento.substring(fechaNacimiento.length()-1).toUpperCase();
        int anoActual = fecha.getYear();
        int numeroAleatorio = random.nextInt(50,700000);
        int longitudMedicosMasUno = this.listaMedicos.size() + 1;


        String id = String.format("M%s%s%d%d%d", primerasLetrasApellido,ultimoDigitoAnoNacimiento,anoActual,numeroAleatorio,longitudMedicosMasUno);
        return id;
    }

    public String generarIdConsultorio(){
        Random random = new Random();
        LocalDate fecha = LocalDate.now();
        int longitudConsultorioMasUno = this.listaConsultas.size() + 1;
        int diaActual = fecha.getDayOfMonth();
        int anoActual = fecha.getYear();
        int numeroAleatorio = random.nextInt(1,500000);
        String id = String.format("C%d%d%d%d",longitudConsultorioMasUno,diaActual,anoActual,numeroAleatorio);
        return id;
    }

    public void mostrarPacientePorId(String id){
        Optional<Paciente> pacienteEncontrado = this.listaPacientes.stream().filter(paciente -> paciente.getId().equals(id)).findFirst();

        if(pacienteEncontrado.isPresent()){
            System.out.println(pacienteEncontrado.get().mostrarDatos());
        }else{
            System.out.println("No se encontro el paciente con el id " + id);
        }

    }

    public void mostrarMedicoPorId(String id){
        Optional<Medico> medicoEncontrado = this.listaMedicos.stream().filter(medico -> medico.getId().equals(id)).findFirst();

        if(medicoEncontrado.isPresent()){
            System.out.println(medicoEncontrado.get().mostrarDatos());
        }else{
            System.out.println("No se encontro el medico con el id " + id);
        }
    }

    public void mostrarConsultorioPorId(String id){
        Optional<Consultorio> consultorioEncontrado = this.listaConsultorios.stream().filter(consultorio -> consultorio.getId().equals(id)).findFirst();

        if(consultorioEncontrado.isPresent()){
            System.out.println(consultorioEncontrado.get().mostrarDatos());
        }else{
            System.out.println("No se encontro el consultorio con el id " + id);
        }
    }


}