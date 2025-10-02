public class SimuladorEvaluacion {
    public static void main(String[] args) {
        
        

        int[] estudianteNotas = new int[5]; //5 notas
        

        //3 primeras misiones y su puntaje
        estudianteNotas[0] = 75;
        estudianteNotas[1] = 50;
        estudianteNotas[2] = 45;

    System.out.println("\n\t ----PUNTO 1----"); // PUNTO 1----------------

    if (estudianteNotas[1] < 60){
        estudianteNotas[3] = 100;
    }

    estudianteNotas[4] = (estudianteNotas[0] + estudianteNotas[2] > 150) ? 95 : 70;
        
    int aprobadas = 0;
    int acumulado = 0; // para el punto 5

    for (int i=0; i<estudianteNotas.length; i++){
        acumulado += estudianteNotas[i];  //Para punto 5
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
    int cont = 0;

    while (cont < estudianteNotas.length -1){
        if (estudianteNotas[cont+1] <= estudianteNotas[cont]){
            difeMayor = false;
        }
        cont ++;
    }
    if (difeMayor){
        System.out.println("¡Nivel PROGRESIVO! Sos un Stone Chad en crecimiento 📈");
    
    }

    System.out.println("\n\t ----PUNTO 4----"); // PUNTO 4 --------------
    
    for (int i = 0; i < estudianteNotas.length - 1; i++) {
        for (int j = i + 1; j < estudianteNotas.length; j++) {
            if (estudianteNotas[j] > estudianteNotas[i]) {
            
            int temp = estudianteNotas[i];
            estudianteNotas[i] = estudianteNotas[j];
            estudianteNotas[j] = temp;
        }
    }
}
    System.out.println("Notas ordenadas de mayor a menor:");
    for (int i = 0; i < estudianteNotas.length; i++) {
        System.out.println(estudianteNotas[i]);
}


    System.out.println("\n\t ----PUNTO 5----"); // PUNTO 5 --------------
    
    if (acumulado < 250) {
        System.out.println("Normie total 😢");
    } else if (acumulado <= 349) {
        System.out.println("Soft Chad");
    } else if (acumulado <= 449) { 
        System.out.println("Chad");
    } else {
        System.out.println("Stone Chad definitivo 💪");
    }

    System.out.println("\n\t ----PUNTO 6----"); // PUNTO 6 -------------

    int[][] notas = {
            {70, 50, 45, 100, 70},   
            {80, 85, 78,  90, 88},   
            {60, 62, 61,  63, 59},   
            {40, 55, 30,  45, 50}    

        };

    int numEstudiantes = notas.length;
    int numNotas = notas[0].length;


    int[] suma = new int[numEstudiantes];
    double[] promedio = new double[numEstudiantes];

    //Promedio

    for (int i = 0; i < numEstudiantes; i++) {
            int sum = 0;
            for (int j = 0; j < numNotas; j++) {
                sum += notas[i][j];
            }
             
        suma[i] = sum;
        promedio[i] = (double) sum / numNotas;
    }
    double promMaximo = promedio[0];
    int posicion = 0;

    for (int i = 1; i < numEstudiantes; i++) {
        if (promedio[i] > promMaximo) {
        promMaximo = promedio[i];
        posicion = i;
    }
  }

    String[] nombreEstudiantes = {"Ramon", "Gabriel", "Nacho", "Pedro"};

    System.out.printf("El estudiante con mejor promedio es %s con un promedio de %.2f%n", 
                  nombreEstudiantes[posicion], promMaximo);


    //PEOR RENDIMIENTO PRUEBA 3-
    int notaMinima3 = notas[0][2];
        for (int i = 1; i < numEstudiantes; i++) {
            if (notas[i][2] < notaMinima3) {
                notaMinima3= notas[i][2];
                posicion = i;
        }
    }
    System.err.printf("El alumno que sacó la peor nota es %s con una nota de %d."
                      ,nombreEstudiantes[posicion],notaMinima3 );



    }
    
}
