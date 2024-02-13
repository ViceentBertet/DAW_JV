package extiende_figura;

public interface IFigura3D {
    double volumen();
    double area();
    default boolean mayorQue(IFigura3D otra) {
        return this.area() > otra.area();
    }
}
