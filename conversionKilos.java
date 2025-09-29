import java.util.Scanner;

public class conversionKilos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingese su peso en libras: ");
        double pesoLibras = scanner.nextInt();
        scanner.nextLine();

        scanner.close(); 


        // COnvertir libras a kilogramos
        final double VALOR_LIBRA = 0.4536; 
        double pesoKg =  pesoLibras * VALOR_LIBRA;


        System.out.printf("El peso en kilogramos es: %.2f kg\n", pesoKg);




    }
}