package extiende_figura;

public class Punto {
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
    public double getY() {
        return y;
    }
}
