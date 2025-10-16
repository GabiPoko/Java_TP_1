package poo.primera_clase;

public class Auto {

    //Atributos
    private int cantidadDeRuedas;
    private boolean esElectrico = false;
    private String marca;
    private String modelo;
    private String color;

    //cosntructor
    public Auto() {}  //constructor vacío

    public Auto (int cantidadDeRuedas, String marca, boolean esElectrico, String modelo) {
        this.cantidadDeRuedas = cantidadDeRuedas;
        this.marca = marca;
        this.esElectrico = esElectrico;
        this.modelo = modelo;
    }
    public Auto (int cantidadDeRuedas, String color, String marca){
        this.cantidadDeRuedas = cantidadDeRuedas;
        this.marca = marca;
        this.color = color;

    }

    // Setters ----> Guardamos información

    public void setCantidadDeRuedas(int cantidadDeRuedas){
        this.cantidadDeRuedas = cantidadDeRuedas;
    }

    public void setEsElectrico (boolean esElectrico){
        this.esElectrico = esElectrico;
    }
    public void setMarca (String marca){
        this.marca = marca;
    }
    public void setModelo (String modelo){
        this.modelo = modelo;
    }
    public void setColor (String color){
        this.color = color;
    }

    // Getters ----->Devolvemos información
    public int getCantidadDeRuedas(){
        return this.cantidadDeRuedas; //return---> devuelve 'algo' en el método
    }
    public boolean getesElectrico(){
        return this.esElectrico; 
    }
    public String getModelo(){
        return this.modelo; 
    }
    public String getMarca(){
        return this.marca; 
    }
    public String getColor(){
        return this.color; 
    }

    //creamos un metodo que se llama mostrarinfo

    public void mostrarInfo (){
        System.out.println(this.getCantidadDeRuedas());
        System.out.println(this.getColor());
        System.out.println(getMarca());
        System.out.println(getesElectrico());
        System.out.println(getModelo());
    }
}
