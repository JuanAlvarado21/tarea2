import java.util.Scanner;
public class empleado {
    public double calcularSalario(double sueldoBase) {
        return sueldoBase;
    }

    public double calcularSalario(double sueldoBase, double bonificacion) {
        return sueldoBase + bonificacion;
    }

    public double calcularSalario(double sueldoBase, double bonificacion, int horasExtras) {
        return sueldoBase + bonificacion + (horasExtras * 20);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        empleado empleado = new empleado();

        System.out.print("Ingresa el sueldo base: ");
        double sueldoBase = scanner.nextDouble();

        System.out.print("¿Deseas agregar bonificación? (s/n): ");
        char agregarBonificacion = scanner.next().charAt(0);

        double bonificacion = 0;
        int horasExtras = 0;

        if (agregarBonificacion == 's' || agregarBonificacion == 'S') {
            System.out.print("Ingresa la bonificación: ");
            bonificacion = scanner.nextDouble();

            System.out.print("¿Deseas agregar horas extras? (s/n): ");
            char agregarHoras = scanner.next().charAt(0);

            if (agregarHoras == 's' || agregarHoras == 'S') {
                System.out.print("Ingresa el número de horas extras: ");
                horasExtras = scanner.nextInt();
            }
        }

        double salario;

        if (bonificacion == 0) {
            salario = empleado.calcularSalario(sueldoBase);
        } else if (horasExtras == 0) {
            salario = empleado.calcularSalario(sueldoBase, bonificacion);
        } else {
            salario = empleado.calcularSalario(sueldoBase, bonificacion, horasExtras);
        }

        System.out.println("El salario calculado es: " + salario);
    }
}
