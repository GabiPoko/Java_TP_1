import java.util.Scanner;

public class promedioEdad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresar tu nobre: ");
        String nombre1 = scanner.nextLine();
        System.out.println("Ingresar tu edad: ");
        int edad1 = scanner.nextInt();
        scanner.nextLine();


        System.out.println("Ingresar tu nombre: ");
        String nombre2 = scanner.nextLine();
        System.out.println("Ingresar tu edad: ");
        int edad2 = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingresar tu nobre: ");
        String nombre3 = scanner.nextLine();
        System.out.println("Ingresar tu edad: ");
        int edad3 = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingresar tu nobre: ");
        String nombre4 = scanner.nextLine();
        System.out.println("Ingresar tu edad: ");
        int edad4 = scanner.nextInt();
        scanner.nextLine();

        scanner.close();

        System.out.println("--------------------------------------");

        System.out.println(nombre1+" : " + edad1 + " años. " +
                           "\n" + nombre2+" : " + edad2 + " años. " + "\n"
                           + nombre3+" : " + edad3 + " años. " + "\n"
                           + nombre4+" : " + edad4 + " años. ");

        System.out.println("El promedio de edad para estas personas es de: " + ((edad1+edad2+edad3+edad4) / 4));
    }
    
}
