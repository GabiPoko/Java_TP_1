package poo.principios.abstraccion;

public class Perro extends Animal implements IComportamientoPerro {

    public Perro (String nombre, int cantidadDePatas, boolean esDomestico){
        super(null, cantidadDePatas, esDomestico);
    }

    @Override
    public void emitirSonido (){
        System.out.println("Guau, guau, guau");
    }

    @Override
    public void moverLaCola() {
        System.out.println("Perro moviendo la colita");
    }

    @Override
    public void traerPalito() {
        System.out.println("Perro trayendo palito");
    }


}
