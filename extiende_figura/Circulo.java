package extiende_figura;

public class Circulo extends Figura implements IFigura2D, Printable{
    //ATRIBUTOS
    private double radio;
    private final static String nombre = "CIRCULO";
    private Punto centro;

    //CONSTRUCTOR

    public Circulo(double radio) {
        super(nombre);
        this.radio = radio;
    }

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

    //Solo hemos podido crear un semicirculo
    @Override
    public void print() {
        final char CARACTER = '*';


        for(int i = 0; i < (int) getRadio(); i += 2) {
            System.out.println(" ");
            for (int x = 0; x <= i; x += 2) {
                System.out.print(CARACTER + " " + CARACTER);
                System.out.print(" ");
            }
        }
        for(int i = (int) getRadio(); i > 0; i -= 2) {
            System.out.println(" ");

            for (int j = 0; j <= i; j += 2) {
                System.out.print(CARACTER + " " + CARACTER);
                System.out.print(" ");
            }
        }
    }
    //GETTERS Y SETTERS
    public double getRadio() {
        return radio;
    }
}
