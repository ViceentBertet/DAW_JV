package extiende_figura;

import java.util.Objects;

public class Triangulo extends Figura implements IFigura2D, Printable{
    private double base;
    private double height;
    private int type;
    private final static String NAME = "TRIANGULO";

    public Triangulo(double base, double altura, int type) {
        super(NAME);
        this.base = base;
        this.height = altura;
        this.type = type;
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
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }

    public String tipoTriangulo() {
        String tipo = " EQUILATERO";
        if (getType() == 1){
            tipo = "ESCALENO";
        } else if (getType() == 2) {
            tipo = "ISOSCELES";
        }
        return tipo;
    }
    @Override
    public double area() {
        return (base * height)/2;
    }
    @Override
    public double perimetro() {
        return switch (getType()) {
            //ESCALENO
            case 1 -> Math.pow(getBase(), 2) + Math.pow(getHeight(), 2);
            //ISOSCELES
            case 2 -> getBase() + Math.cbrt((Math.pow((getBase() / 2), 2) + Math.pow(getHeight(), 2))) * 2;
            //EQUILATERO
            case 3 -> getBase() * 3;
            default -> -1;
        };
    }
    @Override
    public void print() {
        final char CARACTER = '*';
        for (int i = 0; i < getHeight(); i++) {
            System.out.println("");
            for (int x = 0; x < i; x++) {
                System.out.print(" ");
                System.out.print(CARACTER);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangulo triangulo = (Triangulo) o;
        return Double.compare(base, triangulo.base) == 0 && Double.compare(height, triangulo.height) == 0 && type == triangulo.type;
    }
    @Override
    public int hashCode() {
        return Objects.hash(base, height, type);
    }
    @Override
    public String toString() {
        return NAME + "{" +
                tipoTriangulo() + ", " +
                "BASE: " + getBase() + ", " +
                "HEIGHT " + getHeight() + ", " +
                "}";
    }
}
