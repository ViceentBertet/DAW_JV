package extiende_figura;

import java.util.Objects;

public class Rectangulo extends Figura implements IFigura2D, Printable, Cloneable{
    private double base;
    private double height;
    private final static String NAME = "RECTANGULO";

    public Rectangulo(double altura, double base) {
        super(NAME);
        this.base = base;
        this.height = altura;
    }
    public double getBase() {
        return base;
    }
    public void setBase(double base) {
        this.base = base;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    @Override
    public double area() {
        return this.base * this.height;
    }
    @Override
    public double perimetro() {
        return (getBase() * 2) + (getHeight() * 2);
    }
    @Override
    public void print() {
        final char CARACTER = '*';
        for (int i = 0; i < getBase(); i++) {
            System.out.println(" ");
            for (int x = 0; x < getHeight(); x++) {
                System.out.print(" ");
                System.out.print(CARACTER);
            }
        }

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangulo that = (Rectangulo) o;
        return Double.compare(base, that.base) == 0 && Double.compare(height, that.height) == 0;
    }
    @Override
    public int hashCode() {
        return Objects.hash(base, height);
    }

    @Override
    public String toString() {
        return  NAME + "{" +
                "base=" + base +
                ", height=" + height +
                '}';
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}