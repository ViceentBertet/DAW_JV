package extiende_figura;

public class Circulo extends Figura implements IFigura2D, Printable{
    //ATRIBUTOS
    private double radius;
    private final static String name = "CIRCULO";
    private Punto center;

    //CONSTRUCTOR
    public Circulo(double radio) {
        super(name);
        this.radius = radio;
    }

    public Circulo(double radio, Punto centro) {
        super(name);
        this.radius = radio;
        this.center = centro;
    }

    //METODOS INDEPENDENTES
    public double diametro(){
        return getRadius() * 2;
    }

    public Punto getCenter() {
        return this.center;
    }

    //METODOS SOBRESCRITOS
    @Override
    public double area() {
        return Math.PI * Math.pow(getRadius(), 2);
    }
    @Override
    public String toString() {

        return  name +
                "Radio: " + getRadius() +
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


        for(int i = 0; i < (int) getRadius(); i += 2) {
            System.out.println(" ");
            for (int x = 0; x <= i; x += 2) {
                System.out.print(CARACTER + " " + CARACTER);
                System.out.print(" ");
            }
        }
        for(int i = (int) getRadius(); i > 0; i -= 2) {
            System.out.println(" ");

            for (int j = 0; j <= i; j += 2) {
                System.out.print(CARACTER + " " + CARACTER);
                System.out.print(" ");
            }
        }
    }
    //GETTERS Y SETTERS
    public double getRadius() {
        return radius;
    }

}
