public class coche {
    public String marca, modelo;
    public int año;

    public coche(String marca, String modelo, int año) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
    }
        public void mostrarInformacion() {
            System.out.println("Marca: " + marca);
            System.out.println("Modelo: " + modelo);
            System.out.println("Año: " + año);
        }
    public int edadCoche(int añoActual) {
        return añoActual - this.año;
    }
}
