package poo.desafio.dominio;

import java.util.ArrayList;
import java.util.List;

public class ChatRequestRPG {

        public static void main(String[] args) {

        System.out.println(" Bienvenido a ChadQuest RPG - Carga los puntajes de tus misiones ");
        List<Mision> misiones = new ArrayList<Mision>();

        misiones.add(new Mision(1,100));
        misiones.add(new Mision(2,200));
        misiones.add(new Mision(3,300));
        misiones.add(new Mision(4,400));
        misiones.add(new Mision(5,500));

        Jugador jugador = new Jugador(misiones);
        JuegoRPG juego = new JuegoRPG(jugador);
        juego.evaluar();
            
        }
}
