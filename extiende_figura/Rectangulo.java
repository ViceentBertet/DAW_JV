package extiende_figura;

public class Rectangulo extends Figura implements IFigura2D {


    //ATRIBUTOS
    private final double base;
    private final double altura;
    private final static String nombre = "RECTANGULO";


    //CONTRUCTOR
    public Rectangulo(double largo, double ancho) {
        super(nombre);
        this.base = largo;
        this.altura = ancho;
    }



    //METODOS INDEPENDIENTES




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

    //GETTERS Y SETTERS
    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }
}