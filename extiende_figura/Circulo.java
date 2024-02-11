package extiende_figura;

public class Circulo extends Figura implements IFigura2D{
    //ATRIBUTOS
    private double radio;
    private final static String nombre = "CIRCULO";
    private Punto centro;
    //CONSTRUCTOR
    public Circulo(double radio, Punto centro) {
        super(nombre);
        this.radio = radio;
        this.centro = centro;
    }
    //METODOS INDEPENDENTES
    public double diametro(){
        return getRadio() * 2;
    }

    public Punto getCentro() {
        return this.centro;
    }

    //METODOS SOBRESCRITOS
    @Override
    public double area() {
        return Math.PI * Math.pow(getRadio(), 2);
    }
    @Override
    public String toString() {

        return  nombre +
                "Radio: " + getRadio() +
                "Area: " + area() +
                "Diametro: " + diametro() +
                "Perimetro: " + perimetro();
    }

    @Override
    public double perimetro() {
        return Math.PI * diametro();
    }

    //GETTERS Y SETTERS
    public double getRadio() {
        return radio;
    }
}
