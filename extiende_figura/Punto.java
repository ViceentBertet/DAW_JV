package extiende_figura;

import java.util.Objects;

public class Punto implements Cloneable{
    private double x;
    private double y;
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double distancia(Punto a, Punto b){
        double dist = ((a.getY() - b.getY()) * 2 + (a.getX() - b.getY()) * 2)  * 1/2;
        return dist;
    }
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    @Override
    public String toString() {
        return "Punto{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Punto punto = (Punto) o;
        return Double.compare(x, punto.x) == 0 && Double.compare(y, punto.y) == 0;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
