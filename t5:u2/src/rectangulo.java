import java.util.Scanner;

public class rectangulo {
    public static int areaInt(int a, int b) {
        return a*b;
    }

    public static int perimetroInt(int a, int b) {
        return (a+b) * 2;
    }

    public static double areaDouble(double a, double b) {
        return  a*b;
    }

    public static double perimetroDouble(double a, double b) {
        return (a+b) * 2;
    }

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingresar el lado menor lado del rectangulo");
        String lMenor = leer.next();
        System.out.println("Ingresar el lado mayor del rectangulo");
        String lMayor = leer.next();

        try {
            int A= Integer.parseInt(lMayor);
            int B= Integer.parseInt(lMenor);
            System.out.println("El area del rectangulo es: " + areaInt(A,B));
            System.out.println("El perimetro es: " + perimetroInt(A,B));
        } catch (NumberFormatException e1) {
            try {
                double A = Double.parseDouble(lMayor);
                double B = Double.parseDouble(lMenor);
                System.out.println("El area del rectangulo es: " + areaDouble(A,B));
                System.out.println("El perimetro del rectangulo es: " + perimetroDouble(A,B));
            } catch (NumberFormatException e2) {
                System.out.println("Error: Los valores ingresados no son válidos");
            }
        }
    }
}