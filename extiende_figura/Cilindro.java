package extiende_figura;

import java.util.Objects;

public class Cilindro extends Figura implements IFigura3D, Cloneable{

    //ATRIBUTOS
    private Circulo circle;
    private double height;
    private final static String NAME = "CILINDRO";
    //CONSTRUCTOR
    public Cilindro(Circulo circle, double height) {
        super(NAME);
        this.circle = circle;
        this.height = height;
    }

    public Circulo getCircle() {
        return circle;
    }
    public void setCircle(Circulo circle) {
        this.circle = circle;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getRadius() {
        return circle.getRadius();
    }
    @Override
    public String toString() {
        return NAME + "{" +
                "circle=" + circle +
                ", height=" + height +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cilindro cilindro = (Cilindro) o;
        return Double.compare(height, cilindro.height) == 0 && Objects.equals(circle, cilindro.circle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(circle, height);
    }

    //METODOS
    @Override
    public double area() {
        return (Math.PI * 2 * getRadius() * getHeight()) + (Math.PI * 2 * Math.pow(getRadius(), 2));
    }
    @Override
    public double volumen() {
        return (double) Math.round((Math.PI * Math.pow(getRadius(), 2) * getHeight()) * 100) / 100;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
