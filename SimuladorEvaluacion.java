public class SimuladorEvaluacion {
    public static void main(String[] args) {
        
        

        int[] estudianteNotas = new int[5]; //5 notas
        

        //3 primeras misiones y su puntaje
        estudianteNotas[0] = 70;
        estudianteNotas[1] = 50;
        estudianteNotas[2] = 45;

    System.out.println("\n\t ----PUNTO 1----"); // PUNTO 1----------------

    if (estudianteNotas[1] < 60){
        estudianteNotas[3] = 100;
    }

    estudianteNotas[4] = (estudianteNotas[0] + estudianteNotas[2] > 150) ? 95 : 70;
    for (int i=0; i<estudianteNotas.length; i++){
        System.out.println(estudianteNotas[i]);
    }
    
        
    int aprobadas = 0;
    for (int i=0; i<estudianteNotas.length; i++){
        if (estudianteNotas[i]>=60){
            aprobadas = aprobadas + 1;
        } 
    }
        if (aprobadas == 0){
            System.out.println("Resultado: No aprobaste ninguna. ¡Sos un clon de frontend!");
        }
        else if (aprobadas > 0 && aprobadas != 5){
            System.out.println("Resultado: Algunas aprobadas. Sos un refactor en progreso.");
        }
        else {
            System.out.println("Resultado: Aprobaste todas. ¡Backend Sensei!");
        }

    System.out.println("\n\t ----PUNTO 2----"); // PUNTO 2 --------------
    int diferenciaMayor = 0;
    int posicionDiferencia = 0;

    for (int i=0; i<estudianteNotas.length - 1; i++){
       int diferencia = (estudianteNotas[i+1] - estudianteNotas[i]);

       if (diferencia > diferenciaMayor){
           diferenciaMayor = diferencia;
           posicionDiferencia = i + 1; 
       }
       
    }
    System.out.printf("El salto de nota mayor fue de %d y el salto se dió en el examen número %d.%n", 
                  diferenciaMayor, posicionDiferencia+1);
    
    
  
    System.out.println("\n\t ----PUNTO 3----"); // PUNTO 3 --------------

    boolean difeMayor = true;
    int i = 0;

    while (i < estudianteNotas.length -1){
        if (estudianteNotas[i+1] <= estudianteNotas[i]){
            difeMayor = false;
        }
        i ++;
    }
    if (difeMayor){
        System.out.println("¡Nivel PROGRESIVO! Sos un Stone Chad en crecimiento 📈");
    
    }

    System.out.println("\n\t ----PUNTO 4----"); // PUNTO 4 --------------

    }

    
}
