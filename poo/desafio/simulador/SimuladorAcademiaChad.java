package poo.desafio.simulador;

import java.util.Arrays;
import java.util.List;

public class SimuladorAcademiaChad {

    public static void main(String[] args) {
        
    System.out.println(" Bienvenido a Academia Chad ");
    List<Examen> examenesRamon = Arrays.asList(
            new Examen(1, 70),
            new Examen(2, 50),
            new Examen(3, 45),
            new Examen(4, 100),
            new Examen(5, 70)
        );

        List<Examen> examenesGabriel = Arrays.asList(
            new Examen(1, 80),
            new Examen(2, 85),
            new Examen(3, 78),
            new Examen(4, 90),
            new Examen(5, 88)
        );

        List<Examen> examenesNacho = Arrays.asList(
            new Examen(1, 60),
            new Examen(2, 62),
            new Examen(3, 61),
            new Examen(4, 63),
            new Examen(5, 59)
        );

        List<Examen> examenesPedro = Arrays.asList(
            new Examen(1, 40),
            new Examen(2, 55),
            new Examen(3, 30),
            new Examen(4, 45),
            new Examen(5, 50)
        );
        
        Estudiante ramon = new Estudiante("Ramon", examenesRamon);
        Estudiante gabriel = new Estudiante("Gabriel", examenesGabriel);
        Estudiante nacho = new Estudiante("Nacho", examenesNacho);
        Estudiante pedro = new Estudiante("Pedro", examenesPedro);

    List<Estudiante> estudiantes = Arrays.asList(ramon, gabriel, nacho, pedro);
        Academia academia = new Academia(estudiantes);
  

    System.out.println("\n==== RESULTADOS DE APROBACIÓN ====");
    academia.mostrarAprobados();

    System.out.println("\n==== PRUEBA MAS INCONSISTENTE ====");
    academia.mostrarEvaluacionFinal();

    //System.out.println("\n==== NIVELES FINALES ====");
    //academia.mayorVariacion();

    System.out.println("\n==== NIVELES PROGRESIVOS ====");
    academia.mostrarNivelesProgresivos();

    System.out.println("\n==== NOTAS ORDENADAS ====");
    academia.mostrarNotasOrdenadas();

    System.out.println("\n==== EVALUACION FINAL ====");
    academia.mostrarEvaluacionFinal();

    System.out.println("\n==== MEJOR PROMEDIO ====");
    academia.mostrarMejorPromedio();

    System.out.println("\n==== PEOR NOTA EN LA PRUEBA 3 ====");
    academia.mostrarPeorEnTercera();

    

        
    }

}
