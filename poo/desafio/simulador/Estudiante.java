package poo.desafio.simulador;

import java.util.List;

public class Estudiante {
    private String nombre;
    private List<Examen> examenes;

    public Estudiante(String nombre, List<Examen> examenes) {
        this.examenes = examenes;
        this.nombre = nombre;
    }

    
    public String getNombre() {
        return nombre;
    }



    public List<Examen> getExamenes() {
        return examenes;
    }


    public int aprobadas() {
        int total = 0;
        for (Examen e : examenes){
            if (e.getPuntaje() >= 60){
                total = total + 1;
            }
        }
        return total;
    }

    public void mayorVariacion (){   // 
        int diferenciaMayor = 0;
        int posicionDiferencia = 0;

        for (int i = 0; i < examenes.size() - 1; i++) {
            int actual = examenes.get(i).getPuntaje();
            int siguiente = examenes.get(i + 1).getPuntaje();

            int diferencia = siguiente - actual;

            if (diferencia > diferenciaMayor) {
                diferenciaMayor = diferencia;
                posicionDiferencia = i + 1;
        }
    }
    int examenA = examenes.get(posicionDiferencia).getNumero();
    int examenB = examenes.get(posicionDiferencia + 1).getNumero();

    System.out.printf("Mayor salto fue de %d puntos entre la prueba %d y la prueba %d.%n",
                      diferenciaMayor, examenA, examenB);
    }

    public boolean nivelProgresivo(){  //ver como se muestra por pantalla esto
    boolean difeMayor = true;
    
        for (int i = 0; i < examenes.size() - 1; i++) {
            int actual = examenes.get(i).getPuntaje();
            int siguiente = examenes.get(i + 1).getPuntaje();

            if ( examenes.get(i + 1).getPuntaje()<= examenes.get(i).getPuntaje()) {
                difeMayor = false;
            }
        }

        return difeMayor;
}

    public void notasOrdenadas() {
        for (int i = 0; i < examenes.size() - 1; i++) {
            for (int j = i + 1; j < examenes.size(); j++) {
                int puntajeI = examenes.get(i).getPuntaje();
                int puntajeJ = examenes.get(j).getPuntaje();

                if (puntajeJ > puntajeI) {        
                Examen temp = examenes.get(i);
                examenes.set(i, examenes.get(j));
                examenes.set(j, temp);
            }
         }
        }
    }

    public int calcularTotal() {  //Mostrar por pantalla en academia
    int acumulado = 0;

    for (Examen ex : examenes) {
        acumulado += ex.getPuntaje();
    }
    return acumulado;  
}

    public double calcularPromedio() {
        int total = 0;
        for (Examen ex : examenes) {
            total += ex.getPuntaje();
        }
        return (double) total / examenes.size();
    }


  

    }



