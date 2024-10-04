package consultas;

import medicos.medico;
import pacientes.paciente;
import consultorio.Consultorio;

public class consulta {
    public int id;
    public String fechaHora;
    public paciente paciente;
    public medico medico;
    public Consultorio consultorio;

    public int getId() {
        return id;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public paciente getPaciente() {
        return paciente;
    }

    public medico getMedico() {
        return medico;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }
}