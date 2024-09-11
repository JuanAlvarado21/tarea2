public class prueba {
    public static void main(String[] args) {
        coche c1 = new coche("Toyota", "Supra", 2023);
        coche c2 = new coche("Aston Martin", "Vantage", 2020);
        coche c3 = new coche("Audi", "RS3", 2022);

        System.out.println("Información del coche 1:");
        c1.mostrarInformacion();
        System.out.println("Edad del coche: " + c1.edadCoche(2024) + " años");

        System.out.println("\nInformación del coche 2:");
        c2.mostrarInformacion();
        System.out.println("Edad del coche: " + c2.edadCoche(2024) + " años");

        System.out.println("\nInformación del coche 3:");
        c3.mostrarInformacion();
        System.out.println("Edad del coche: " + c3.edadCoche(2024) + " años");
    }
}