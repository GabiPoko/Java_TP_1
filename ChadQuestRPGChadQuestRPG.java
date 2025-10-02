public class ChadQuestRPGChadQuestRPG {

    public static void main(String[] args) {
        int[] puntosPorMision = new int[5]; 
        int total = 0; 

        puntosPorMision[0] = 50;
        puntosPorMision[1] = 80;
        puntosPorMision[2] = 60;
        puntosPorMision[3] = 80;
        puntosPorMision[4] = 70;
        

    
    for (int i = 0; i < puntosPorMision.length; i++) { 
        total += puntosPorMision[i];
        
    }

    System.out.println("Puntos acumulados hasta ahora: " + total);
}
}
