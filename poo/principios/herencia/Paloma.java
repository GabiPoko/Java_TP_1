package poo.principios.herencia;

public class Paloma extends Mensajero {

    public Paloma (String destino){
        super(destino);
    }


    @Override
    public void enviarMensaje(String contenido) {
            System.out.println("Vuela la paloma hacia: "+ super.getDestino() +
                               " con el mensaje: "+ contenido);
        }

    
}
