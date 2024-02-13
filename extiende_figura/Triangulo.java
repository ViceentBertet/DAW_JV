package extiende_figura;

public class Triangulo extends Figura implements IFigura2D, Printable{
    
    //ATRIBUTOS
    private final double base;
    private final double altura;
    private final int type;
    private final static String nombre = "TRIANGULO";


    //CONSTRUCTOR
    /**
     * Base from the triangle, height and the number of equal sides
     */
    public Triangulo(double base, double altura, int type) {
        super(nombre);
        this.base = base;
        this.altura = altura;
        this.type = type;
    }

    //METODOS INDEPENDIANTES

    /**
     * Determine triengle type information
     * */
    public String tipoTriangulo() {
        String tipo = " EQUILATERO";
        if (getType() == 1){
            tipo = "ESCALENO";
        } else if (getType() == 2) {
            tipo = "ISOSCELES";
        }
        return tipo;
    }

    
    //METODOS SOBRESCRITOS
    @Override
    public double area() {
        return (base * altura)/2;
    }

    @Override
    public double perimetro() {
        double perimetro;
        switch (getType()) {
                //ESCALENO
            case 1:
                perimetro = Math.pow(getBase(), 2) + Math.pow(getAltura(), 2);
                break;

                //ISOSCELES
            case 2:
                perimetro = getBase() + Math.cbrt((Math.pow((getBase() / 2), 2) + Math.pow(getAltura(), 2))) * 2;
                break;

                //EQUILATERO
            case 3:
                perimetro = getBase() * 3;
                break;

            default: perimetro = -1;
        }
        return perimetro;
    }

    @Override
    public String toString() {
        return nombre +
                tipoTriangulo() +
                "BASE: " + getBase() +
                "ALTURA " + getAltura() +
                "PERIMETRO: " + perimetro();
    }
    @Override
    public void print() {
        final char CARACTER = '*';
        int contador = 0;
        for (int i = 0; i < getAltura(); i++) {
            System.out.println("");
            for (int x = 0; x < i; x++) {
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
    public int getType() {
        return type;
    }
}
