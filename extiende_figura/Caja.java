package extiende_figura;

public class Caja extends Punto {
    //ATRIBUTOS
    private double z;
    //CONSTRUCTOR
    public Caja(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }
    //GETTERS AND SETTERS
    public double getZ() {
        return z;
    }
    public void setZ(double z) {
        this.z = z;
    }
    //METODOS
    public double distancia(Caja a, Caja b){
        double dist = ((a.getY() - b.getY()) * 2 + (a.getX() - b.getY()) * 2 + (a.getZ() - b.getZ()) * 2)  * 1/2;
        return dist;
    }

}
