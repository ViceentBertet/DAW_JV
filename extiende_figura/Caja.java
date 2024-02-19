package extiende_figura;

public class Caja implements IFigura3D{
    private Rectangulo rectangle;
    private double profundity;
    public Caja(Rectangulo rectangle, double profundity) {
        this.rectangle = rectangle;
        this.profundity = profundity;
        if (profundity < 0) profundity = 1;
    }
    public void setRectangle(Rectangulo rectangle) {
        this.rectangle = rectangle;
    }
    public void setProfundity(double profundity) {
        this.profundity = profundity;
    }
    public Rectangulo getRectangle() {
        return rectangle;
    }
    public double getProfundity() {
        return profundity;
    }
    @Override
    public double area() {
        return rectangle.area();
    }
    @Override
    public double volumen() {
        return rectangle.area() * getProfundity();
    }
}
