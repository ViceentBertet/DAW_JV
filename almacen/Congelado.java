package almacen;

public class Congelado extends Producto {
    private int temp;
    public Congelado(String nombre, String fechaCad, int nLote, double stock, double precio) {
        super(nombre, fechaCad, nLote);
    }
    public Congelado(String nombre, String fechaCad, int nLote, double stock, double precio, int temp) {
        super(nombre, fechaCad, nLote);
        this.temp = temp;
    }
    public int getTemp() {
        return temp;
    }
    public void setTemp(int temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "Congelado{" +
                "temp=" + temp +
                '}';
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Congelado c = (Congelado) super.clone();
        return c;
    }
}
