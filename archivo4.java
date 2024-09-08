package arreglos;
import java.util.Scanner;
import java.io.IOException;

public class Arreglos {
    
    public static void main(String[] args) throws IOException {
    Scanner leer=new Scanner(System.in);
    
    String cadena;
    int numero, indice;
    int arreglo[]=new int [15];
    indice=arreglo.length-1;
        System.out.println(Ingresar cadena: );
        cadena=leer.next();
        numero=Integer.parseInt(cadena);
                
        do {
            arreglo [indice]=numero%2;
            indice--;
            numero/=2;
        } while (numero>0 && indice>=0);
    }
    
}
