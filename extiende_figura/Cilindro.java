package extiende_figura;

public class Cilindro extends Figura implements IFigura3D {

    //ATRIBUTOS
    private double radius;
    private double height;
    private final static String nombre = "CILINDRO";
    private Caja centro;
    //CONSTRUCTOR

    public Cilindro(double radius, double height, Caja centro) {
        super(nombre);
        this.radius = radius;
        this.height = height;
        this.centro = centro;
    }

    //GETTERS AND SETTERS
    public double getRadius() {
        return radius;
    }
    public double getHeight() {
        return height;
    }
    //METODOS
    @Override
    public double area() {
        return (Math.PI * 2 * getRadius() * getHeight()) + (Math.PI * 2 * Math.pow(getRadius(), 2));
    }
    @Override
    public double volumen() {
        return Math.round((Math.PI * Math.pow(getRadius(), 2) * getHeight()) * 100) / 100;
    }



}
