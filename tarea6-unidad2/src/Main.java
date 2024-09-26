public class Main {
    public static void main(String[] args) {
        curso c1 = new curso("Programación Orientada a Objetos","P00", "Eder");
        curso c2= new curso("Contabilidad Fianciera","C0NTA", "Conrado");
        curso c3 =new curso("Química", "CR15TAL", "Judith");

        estudiante e1 = new estudiante("Alvarado", "24120359");
        e1.agregarCurso(c1);
        e1.agregarCurso(c2);

        estudiante e2 = new estudiante("David", "20120982");
        e2.agregarCurso(c2);
        e2.agregarCurso(c3);

        estudiante e3 = new estudiante("Iran", "21122354");
        e3.agregarCurso(c1);
        e3.agregarCurso(c3);

        e1.mostrarInformacion();
        e2.mostrarInformacion();
        e3.mostrarInformacion();
    }
}
