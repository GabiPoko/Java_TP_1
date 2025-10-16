package poo.principios.herencia;

public class Telegrafo extends Mensajero {
    

    public Telegrafo (String destino){
        super(destino);
    }

    @Override
    public void enviarMensaje(String contenido) {
            System.out.println("Contenido de telegrafo: "+ contenido +
                               " Hacia destino: "+ super.getDestino());
        }


}
