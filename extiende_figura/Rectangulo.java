package extiende_figura;

public class Rectangulo extends Figura implements IFigura2D, Printable{


    //ATRIBUTOS
    private final double base;
    private final double altura;
    private final static String nombre = "RECTANGULO";


    //CONTRUCTOR
    public Rectangulo(double altura, double base) {
        super(nombre);
        this.base = base;
        this.altura = altura;
    }

    //METODOS SOBRESCRITOS
    /**
     * Method implementation to calculate the area
     */
    @Override
    public double area() {
        return this.base * this.altura;
    }
    @Override
    public double perimetro() {
        return (getBase() * 2) + (getAltura() * 2);
    }
    /**
     * Returns a representative string of the square.
     */
    @Override
    public String toString() {
        return nombre +
                "Perimetro: " + perimetro();
    }
    @Override
    public void print() {
        final char CARACTER = '*';
        for (int i = 0; i < getBase(); i++) {
            System.out.println("");
            for (int x = 0; x < getAltura(); x++) {
                System.out.print(" ");
                System.out.print(CARACTER);
            }
        }

    }

    //GETTERS Y SETTERS
    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }
}