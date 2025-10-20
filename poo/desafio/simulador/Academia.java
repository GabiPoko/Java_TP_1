package poo.desafio.simulador;

import java.util.List;

public class Academia {

    private List<Estudiante> estudiantes;

   

    public Academia(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }


    public void agregarEstudiante(Estudiante e) {
        estudiantes.add(e);
    }

    public void mostrarAprobados() {
    for (Estudiante e : estudiantes) {
        int aprobadas = e.aprobadas();
        int totalExamenes = e.getExamenes().size();

        System.out.print(e.getNombre() + " : ");

        if (aprobadas == 0) {
            System.out.println("Resultado: No aprobaste ninguna. ¡Sos un clon de frontend!");
        } 
        else if (aprobadas > 0 && aprobadas != totalExamenes) {
            System.out.println("Resultado: Algunas aprobadas. Sos un refactor en progreso.");
        } 
        else {
            System.out.println("Resultado: Aprobaste todas. ¡Backend Sensei!");
        }
    }
}

    public void mostrarNivelesProgresivos() {
    for (Estudiante e : estudiantes) {
        String mensaje = e.nivelProgresivo()
            ? "¡Nivel PROGRESIVO! Sos un Stone Chad en crecimiento 📈"
            : "Sos un Stone Chad estancado 😴";

        System.out.println(e.getNombre() + ": " + mensaje);
    }
}

 public void mostrarNotasOrdenadas() {
    for (Estudiante e : estudiantes) {
        e.notasOrdenadas(); 
        System.out.println("Notas ordenadas del estudiante " + e.getNombre() + ":");
        for (Examen ex : e.getExamenes()) {
            System.out.println("Examen " + ex.getNumero() + ": " + ex.getPuntaje());
        }
        System.out.println("-------------------------");
    }
}

public void mostrarEvaluacionFinal() {
    for (Estudiante e : estudiantes) {
        int acumulado = e.calcularTotal(); 
        String mensaje;

        if (acumulado < 250) {
            mensaje = "Normie total 😢";
        } else if (acumulado <= 349) {
            mensaje = "Soft Chad";
        } else if (acumulado <= 449) {
            mensaje = "Chad";
        } else {
            mensaje = "Stone Chad definitivo 💪";
        }

        System.out.println(e.getNombre() + " : " + mensaje + " (" + acumulado + " puntos)");
    }
}
    public void mostrarMejorPromedio() {
    if (estudiantes.isEmpty()) {
        System.out.println("No hay estudiantes cargados.");
        return;
    }

    Estudiante mejor = estudiantes.get(0);
    double promMaximo = mejor.calcularPromedio();

    for (Estudiante e : estudiantes) {
        double promedio = e.calcularPromedio();
        if (promedio > promMaximo) {
            promMaximo = promedio;
            mejor = e;
        }
    }

    System.out.printf("El estudiante con mejor promedio es %s con un promedio de %.2f%n",
            mejor.getNombre(), promMaximo);
}

    public void mostrarPeorEnTercera() {
    if (estudiantes.isEmpty()) {
        System.out.println("No hay estudiantes cargados.");
        return;
    }

    Estudiante peor = estudiantes.get(0);
    int notaMinima = peor.getExamenes().get(2).getPuntaje(); // prueba 3 → índice 2

    for (Estudiante e : estudiantes) {
        int notaActual = e.getExamenes().get(2).getPuntaje();
        if (notaActual < notaMinima) {
            notaMinima = notaActual;
            peor = e;
        }
    }

    System.out.printf("El peor rendimiento en la prueba 3 fue de %s con una nota de %d.%n",
            peor.getNombre(), notaMinima);
}

}
