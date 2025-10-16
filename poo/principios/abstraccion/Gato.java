package poo.principios.abstraccion;

public class Gato extends Animal{

    public Gato (String nombre, int cantidadDePatas, boolean esDomestico){
        super(nombre, cantidadDePatas, esDomestico);   
    }

    @Override
    public void emitirSonido(){
        System.out.println("MIAUU MIAUU");
    }

    @Override
    public void dormir(){
        System.out.println("El gato duerme");
    }

}
