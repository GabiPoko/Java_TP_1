package poo.principios;

import poo.principios.herencia.*;
import poo.principios.abstraccion.*;

import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        //HErencia
        Celular celular = new Celular ("Mama", false);
        Telegrafo telegrafo = new Telegrafo ("Abuela");
        Paloma paloma = new Paloma ("Hermana"); 


        celular.enviarMensaje("Hola mama");
        telegrafo.enviarMensaje("Hola perdida");
        paloma.enviarMensaje("Junta la ropa que va a llover!!!!");


        //Abstracción

        Gato gato = new Gato ("Michi", 4, true);
        Perro perro = new Perro ("Panchi", 4, true);

        gato.emitirSonido();
        perro.emitirSonido();

        perro.moverLaCola();
        perro.traerPalito();

        //gracias a la abstracción puedo crear arrays con clases ej:
        
        List<Animal> animals = new ArrayList<>();
        animals.add (perro);
        animals.add (gato);

        System.out.println("PRINT ARRAY---------------");

        for (int i=0; i < animals.size(); i++){
            animals.get(i).dormir();
            animals.get(i).emitirSonido();
        }



        IComportamientoPerro InterfazImplementada = new Perro ("pancho", 4, true);
        InterfazImplementada.moverLaCola();
        InterfazImplementada.traerPalito();
        

    }

    

}
