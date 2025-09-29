import java.util.Scanner;

public class potenciaInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa un numero entero: ");
        int numero = scanner.nextInt();

        int cuadrado = numero * numero;     
        int cubo = numero * numero * numero;

        System.out.println("El número ingresado es: " + numero);
        System.out.println("El cuadrado del número ingresado es: " + cuadrado);
        System.out.println("El cubo del número ingresado es: " + cubo);

        scanner.close();

    }
    
}
