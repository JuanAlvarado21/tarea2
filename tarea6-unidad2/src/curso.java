public class curso {
    public String nombreCurso;
    public String codigoCurso;
    public String instructor;

    public curso(String nombreCurso, String codigoCurso, String instructor) {
        this.nombreCurso = nombreCurso;
        this.codigoCurso = codigoCurso;
        this.instructor = instructor;
    }
    public void mostrarInfoCurso() {
        System.out.println("Nombre Curso: " + this.nombreCurso);
        System.out.println("Codigo Curso: " + this.codigoCurso);
        System.out.println("Instructor: " + this.instructor);
    }
}
