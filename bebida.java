import java.util.Scanner;

public class bebida {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre de su ultima mascota: ");
        String mascota = scanner.nextLine();

        System.out.print("Ingrese el nombre de la ultima pelicula que vió: ");
        String pelicula = scanner.nextLine();

        System.out.println("El nombre de la próxima debida es: " + mascota + " " + pelicula + ".");
        scanner.close();
    }
    
    
}
