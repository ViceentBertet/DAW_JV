package extiende_figura;

public abstract class Figura {
    private final String NAME;
    public Figura(String nombre) {
        this.NAME = nombre;
    }
    public String toString() {
        return this.NAME;
    }
    abstract double area();
    static boolean mayorQue(Figura uno, Figura dos) {
        return uno.area() > dos.area();
    }
}
