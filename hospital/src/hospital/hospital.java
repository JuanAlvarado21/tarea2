package hospital;

import consultas.consulta;
import consultorio.Consultorio;
import medicos.medico;
import pacientes.paciente;

import java.util.ArrayList;

public class hospital {
    public ArrayList<paciente> listaPacientes = new ArrayList<>();
    public ArrayList<medico> listaMedicos= new ArrayList<>();
    public ArrayList<Consultorio> listaConsultorios = new ArrayList<>();
    public ArrayList<consulta> listaConsultas = new ArrayList<>();

    public void registrarPaciente(paciente paciente){
        this.listaPacientes.add(paciente);
    }

    public void registrarMedico(medico medico){
        this.listaMedicos.add(medico);
    }

    public void registrarConsultorio(Consultorio consultorio){
        this.listaConsultorios.add(consultorio);
    }

    public void registrarConsulta(consulta consulta){

        if (!validarDisponibilidadEnFechaConsulta(consulta.getFechaHora(), consulta.getConsultorio().getNumeroConsultorio())){
            System.out.println("Ya existe una consulta registrada para esa fecha.");
            return;
        }else{

        }
        this.listaConsultas.add(consulta);
    }

    private boolean validarDisponibilidadEnFechaConsulta(String fechaDeseada, int numeroConsultorio){
        for (consulta consulta: this.listaConsultas){
            if (consulta.getFechaHora().equals(fechaDeseada)&& numeroConsultorio == consulta.getConsultorio().getNumeroConsultorio()){
                return false;
            }
        }
        return true;
    }

}