package poo.desafio.dominio;

public class Mision {
    private int numero;
    private int puntaje;

    public Mision (int numero, int puntaje){
        this.numero = numero;
        this.puntaje = puntaje;

    
        
        
    }

    public int getNumero() {
        return numero;
    }

    public int getPuntaje() {
        return puntaje;
    }
    
    //Método para evaluar si la mision es fallid //Se hace en esta clase porque es la que maneja los puntajes
    
    public boolean esFallida(){
        return this.getPuntaje() == 0;
    }

}
