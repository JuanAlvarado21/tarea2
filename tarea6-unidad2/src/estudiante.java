import java.util.ArrayList;

public class estudiante {
    public String nombre;
    public String idEstudiante;

    public ArrayList<curso> cursos = new ArrayList<curso>();

    public estudiante(String nombre, String idEstudiante) {
        this.nombre = nombre;
        this.idEstudiante = idEstudiante;
    }
    public void agregarCurso(curso c) {
        this.cursos.add(c);
    }
    public void mostrarInformacion() {
        System.out.println("Estudiante: " + this.nombre);
        System.out.println("Número de control: " + this.idEstudiante);
        System.out.println("En curso: ");
        for (curso c : cursos) {
            c.mostrarInfoCurso();
        }
    }
}
