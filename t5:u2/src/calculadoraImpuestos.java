import java.util.Scanner;
public class calculadoraImpuestos {
    public double calcularImpuestos(int ingresos) {
        return ingresos + 0.15;
    }

    public double calcularImpuestos(int ingresos, double porcentajeImpuestos) {
        return ingresos * (porcentajeImpuestos / 100);
    }

    public double calcularImpuestos(double dividendos, double porcentajeImpuestos, double exencion) {

        double impuestos = dividendos * (porcentajeImpuestos / 100);

        if (impuestos > exencion) {
            return impuestos - exencion;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        calculadoraImpuestos calculadora = new calculadoraImpuestos();

        System.out.print("Ingresa los ingresos: ");
        int ingresos = scanner.nextInt();

        System.out.print("¿Deseas agregar porcentaje de impuestos? (s/n): ");
        char agregarPorcentaje = scanner.next().charAt(0);

        if (agregarPorcentaje == 's' || agregarPorcentaje == 'S') {
            System.out.print("Ingresa el porcentaje de impuestos: ");
            double porcentajeImpuestos = scanner.nextDouble();

            System.out.print("¿Deseas agregar dividendos? (s/n): ");
            char agregarDividendos = scanner.next().charAt(0);

            if (agregarDividendos == 's' || agregarDividendos == 'S') {
                System.out.print("Ingresa los dividendos: ");
                double dividendos = scanner.nextDouble();

                System.out.print("Ingresa la exención: ");
                double exencion = scanner.nextDouble();

                double impuestos = calculadora.calcularImpuestos(dividendos, porcentajeImpuestos, exencion);
                System.out.println("Impuestos calculados: " + impuestos);
            } else {

                double impuestos = calculadora.calcularImpuestos(ingresos, porcentajeImpuestos);
                System.out.println("Impuestos calculados: " + impuestos);
            }
        } else {

            double impuestos = calculadora.calcularImpuestos(ingresos);
            System.out.println("Impuestos calculados: " + impuestos);
        }
    }
}
