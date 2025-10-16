package poo.principios.herencia;

public class Mensajero {
    private String destino;

    public Mensajero (String destino){
        this.destino = destino;
    }

    public String getDestino() {
        return destino;
    }


    public void setDestino(String destino) {
        this.destino = destino;
    }


    public void enviarMensaje(String contenido) {
            System.out.println("Mensaje base: "+ contenido +
                               " Hacia destino: "+ this.destino);
        }
}


 

    
