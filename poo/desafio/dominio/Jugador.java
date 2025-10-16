package poo.desafio.dominio;

import java.util.List;

public class Jugador {

    private List <Mision> misiones;

    public Jugador(List<Mision> misiones) {
        this.misiones = misiones;
    }

    public List<Mision> getMisiones() {
        return misiones;
    }

    //método calcular
    public int calcularTotal (){
        int total = 0;
        for (Mision m: misiones ){
            total += m.getPuntaje();
        }
        return total;
    }

    //Método mision con mayor puntaje

    public Mision misionConMayorPuntaje(){
        if (misiones.isEmpty()){
            return null;
        }
        Mision misionConMayorPuntaje = misiones.getFirst();
        for (Mision m: misiones){
            if (m.getPuntaje() > misionConMayorPuntaje.getPuntaje()){
                misionConMayorPuntaje = m;
            }
        }
        return misionConMayorPuntaje;
    }


        // Acá relacionamos el metodo esfallido de Mision y si es true será true tmb en jugador
    public boolean tieneMisionFallida(){
        for (Mision m : misiones) {
             if( m.esFallida() ) {
                 return true;
             }
        }
        return false;
    }

    public Mision misionConMenorPuntaje(){
        if (misiones.isEmpty()) {
            return null;
        }

     Mision misionConMenorPuntaje = misiones.getFirst();
        for (Mision m : misiones) {
            if(m.getPuntaje() < misionConMenorPuntaje.getPuntaje()) {
                misionConMenorPuntaje = m;
            }
        }
        return misionConMenorPuntaje;
    
    }

    public boolean esConstante(){
        return misionConMayorPuntaje().getPuntaje() - misionConMenorPuntaje().getPuntaje() < 20;
    }




}


    