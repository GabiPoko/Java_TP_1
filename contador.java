public class contador {

    public static void main(String[] args) {

        System.out.println("Incremento---");
        
        int numero;
        numero = 0;

        for (int i=1; i<=20; i++){
            numero++;
        }
        System.out.println("El valor de numero es: " + numero);

        System.out.println("Decremento---");

        int numero1;
        numero1 = 35;

        for (int i = 20; i >0; i--){
        numero1 --;
        }

        System.out.println("El valor del número es: " + numero1);


    }
}


