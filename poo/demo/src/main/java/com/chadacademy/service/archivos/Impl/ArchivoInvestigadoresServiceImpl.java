package com.chadacademy.service.archivos.Impl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.chadacademy.dominio.Investigador;
import com.chadacademy.service.archivos.ArchivoInvestigadoresService;
import com.chadacademy.service.investigador.IInvestigadorService;
import com.opencsv.CSVWriter;

public class ArchivoInvestigadoresServiceImpl implements ArchivoInvestigadoresService  {

    private final String UBICACION_ARCHIVO = "\\exportadoCSV\\";

    CSVWriter csvWriter; 

    @Override
    public void exportarInvestigadoresCSV(IInvestigadorService investigadorService) {
        List<Investigador> investigadores = investigadorService.buscarTodos();

        if (investigadores == null || investigadores.isEmpty()) { 
             System.out.println("No hay investigadores registrados para exportar.");
             return;
        }

        String ruta = System.getProperty("user.dir").concat(UBICACION_ARCHIVO).concat("investigadores.csv");
        try {
            this.csvWriter = new CSVWriter(new FileWriter(ruta));

            
            String[] encabezado = {"NOMBRE", "EDAD", "CANTIDAD_EXPERIMENTOS"};
            this.csvWriter.writeNext(encabezado);

            
            for (Investigador inv : investigadores) {
                String[] datos = {
                        inv.getNombre(),
                        String.valueOf(inv.getEdad()),
                        String.valueOf(inv.getExperimentos().size())
                };
                this.csvWriter.writeNext(datos);
            }

            System.out.println("Exportación de investigadores exitosa!");
            System.out.println("Archivo guardado en: " + ruta);

        } catch (IOException ioException) {
            System.out.println("Error al exportar archivo. Motivo: " + ioException.getMessage());
            System.out.println("Ruta del archivo: " + ruta);
        } finally {
            
            this.cerrarWriter(); 
        }
    }

    private void cerrarWriter() {
        if (this.csvWriter != null) {
            try {
                this.csvWriter.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el escritor CSV: " + e.getMessage());
            }
        }
    }
}



    
