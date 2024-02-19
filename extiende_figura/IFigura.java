package extiende_figura;

public interface IFigura {
    double area();
    static boolean mayorQue(IFigura uno, IFigura dos) {
        return uno.area() > dos.area();
    }
}
