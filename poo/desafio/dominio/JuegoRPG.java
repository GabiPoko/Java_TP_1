package poo.desafio.dominio;

public class JuegoRPG {

    private Jugador jugador;

    public JuegoRPG(Jugador jugador) {
        this.jugador = jugador;
    }
 
    //metodo evaluar
    public void evaluar(){
    
        int total = jugador.calcularTotal();
        Mision mejor = jugador.misionConMayorPuntaje();

        String mensajeChad = ( total > 300 ) ? "¡Felicidades! Sos un verdadero Chad del RPG ": "Te falta entrenamiento, joven aprendiz...";
        System.out.println(mensajeChad);

        System.out.println("Puntos acumulados: " + total);
        System.out.println("La mision que mejor rendimiento tuvo es en la mision numero : " + mejor.getNumero() +
            " con " + mejor.getPuntaje() + " puntos.");

        if(jugador.tieneMisionFallida()){
            System.out.println("Fallaste al menos una mision. Que el backend te tenga piedad...");
        }

        if(jugador.esConstante()){
            System.out.println("¡Ejecución constante! Sos el sueño de un arquitecto de software.");
        }

    }
}
