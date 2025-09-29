import java.util.Scanner;

public class acumulador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el primer número: ");
        int numero1 = scanner.nextInt();

        System.out.print("Ingrese el segundo número: ");
        int numero2 = scanner.nextInt();

        // Variable acumuladora (empieza en 0)
        double acumulador = 0;

        // Bucle desde 1 hasta 15
        for (int i = 1; i <= 15; i++) {
            acumulador += (double)(numero1 * numero2) / i;
        }

        // Mostramos el resultado final
        System.out.println("El resultado de la acumulación es: " + acumulador);

        scanner.close();
    }
    
}
