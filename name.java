public class name {
    public static void main(String[] args) {
        String nombre = "Gabriel";

        System.out.println("Mi nombre es:");
        for (int i = 0; i < nombre.length(); i++) {
            char letra = nombre.charAt(i);  
            System.out.print(letra);
        }

         System.out.println("\n\nCódigos Unicode de cada letra:");

         for (int i = 0; i < nombre.length(); i++) {
            char letra = nombre.charAt(i);
            System.out.println(letra + " => " + (int) letra);
        }

    }
}
