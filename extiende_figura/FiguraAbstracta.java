package extiende_figura;

public abstract class FiguraAbstracta {
    //ATRIBUTOS
    private final String nombre;


    //CONSTRUCTOR
    public FiguraAbstracta(String nombreFigura) {
        this.nombre = nombreFigura;
    }
    //METODOS DECLARADOS
    final public boolean mayorQue(FiguraAbstracta otra) {
        return this.area() > otra.area();
    }

    public String toString() {
        return this.nombre + " con area " + this.area();
    }
    //METODOS ABSTRACTOS
    abstract public double area();
    abstract public double perimetro();




}