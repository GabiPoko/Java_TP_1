package poo.principios.abstraccion;

public abstract class Animal { //las clases abstractas NO se instancian
    protected String nombre;
    protected int cantidadDePatas;
    protected boolean esDomestico;

    public Animal (String nombre, int cantidadDePatas, boolean esDomestico){}

    public abstract void emitirSonido ();

    public void dormir(){
        System.out.println("El animal duerme");
    }


}
