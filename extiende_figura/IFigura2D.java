package extiende_figura;

public interface IFigura2D {
    double perimetro();
    double area();
    default boolean mayorQue(IFigura2D otra) {
        return this.area() > otra.area();
    }
}
