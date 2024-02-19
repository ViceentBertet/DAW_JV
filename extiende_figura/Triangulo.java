package extiende_figura;

public class Triangulo extends Figura implements IFigura2D, Printable{
    private final double base;
    private final double height;
    private final int type;
    private final static String nombre = "TRIANGULO";

    public Triangulo(double base, double altura, int type) {
        super(nombre);
        this.base = base;
        this.height = altura;
        this.type = type;
    }
    public double getBase() {
        return base;
    }
    public double getHeight() {
        return height;
    }
    public int getType() {
        return type;
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
    public String toString() {
        return nombre +
                tipoTriangulo() +
                "BASE: " + getBase() +
                "ALTURA " + getHeight() +
                "PERIMETRO: " + perimetro();
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

}
