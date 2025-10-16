package poo.primera_clase;

public class App {

    public static void main(String[] args) {
        Auto auto = new Auto();
        auto.setCantidadDeRuedas(4);
        auto.setColor("negro");
        auto.setMarca("Renault");
        auto.setModelo("2019");

        System.out.println(auto.getCantidadDeRuedas());
        System.out.println(auto.getColor());
        System.out.println(auto.getMarca());
        System.out.println(auto.getModelo());
        System.out.println(auto.getesElectrico());

           // cambiar estado de atributo

        auto.setColor("Azul");

        System.out.println(auto.getColor());

        //Instanciamos el objeto

        Auto auto2 = new Auto(4, "Chevrolet", true, "2022");
        auto2.setColor("Crema");

        Auto auto3 = new Auto(4, "blanco", "Peugeot");
        auto3.setModelo("2012");

    /* auto.mostrarInfo();
    auto2.mostrarInfo();
    auto3.mostrarInfo(); */

        // Creamos un array para hacer un for e imprimir todos los autos

        Auto [] autitos = new Auto[3];
        autitos[0] = auto;
        autitos[1] = auto2;
        autitos[2] = auto3;

        for (int i=0; i < autitos.length; i++){
            autitos[i].mostrarInfo();
            System.out.println("\n");
        }



    }

}
