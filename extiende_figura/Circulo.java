package extiende_figura;

public class Circulo extends FiguraAbstracta {

    //ATRIBUTOS
    private double radio;
    private final static String nombre = "CIRCULO";

    //CONSTRUCTOR
    public Circulo(double radio) {
        super(nombre);
        this.radio = radio;
    }

    //METODOS INDEPENDENTES
    public double diametro(){
        return getRadio() * 2;
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
