package extiende_figura;

import java.util.Objects;

public class Circulo extends Figura implements IFigura2D, Printable, Cloneable{
    //ATRIBUTOS
    private double radius;
    private Punto center;
    private final static String NAME = "CIRCULO";
    //CONSTRUCTOR
    public Circulo(double radio) {
        super(NAME);
        this.radius = radio;
    }
    public Circulo(double radio, Punto centro) {
        super(NAME);
        this.radius = radio;
        this.center = centro;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public Punto getCenter() {
        return center;
    }
    public void setCenter(Punto center) {
        this.center = center;
    }
    public double diametro(){
        return getRadius() * 2;
    }
    @Override
    public double area() {
        return Math.PI * Math.pow(getRadius(), 2);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circulo circulo = (Circulo) o;
        return Double.compare(radius, circulo.radius) == 0 && Objects.equals(center, circulo.center);
    }
    @Override
    public int hashCode() {
        return Objects.hash(radius, center);
    }
    @Override
    public String toString() {
        return NAME + "{" +
                "radius=" + radius +
                ", center=" + center +
                '}';
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
