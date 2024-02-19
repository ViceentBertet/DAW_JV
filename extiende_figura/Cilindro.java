package extiende_figura;

public class Cilindro extends Figura implements IFigura3D {

    //ATRIBUTOS
    private Circulo circle;
    private double height;
    private final static String name = "CILINDRO";
    //CONSTRUCTOR

    public Cilindro(Circulo circle, double height) {
        super(name);
        this.circle = circle;
        this.height = height;
    }

    public double getRadius() {
        return circle.getRadius();
    }
    public double getHeight() {
        return height;
    }
    public void setCircle(Circulo circle) {
        this.circle = circle;
    }
    public void setHeight(double height) {
        this.height = height;
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
}
