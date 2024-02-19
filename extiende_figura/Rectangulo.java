package extiende_figura;

public class Rectangulo extends Figura implements IFigura2D, Printable{
    private final double base;
    private final double height;
    private final static String name = "RECTANGULO";

    public Rectangulo(double altura, double base) {
        super(name);
        this.base = base;
        this.height = altura;
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
    public String toString() {
        return name +
                "Perimetro: " + perimetro();
    }
    @Override
    public void print() {
        final char CARACTER = '*';
        for (int i = 0; i < getBase(); i++) {
            System.out.println("");
            for (int x = 0; x < getHeight(); x++) {
                System.out.print(" ");
                System.out.print(CARACTER);
            }
        }

    }
    public double getBase() {
        return base;
    }
    public double getHeight() {
        return height;
    }
}