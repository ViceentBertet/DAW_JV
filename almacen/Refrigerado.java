package almacen;

public class Refrigerado extends Producto {
    private int codOrg;

    public Refrigerado(String nombre, String fechaCad, int nLote) {
        super(nombre, fechaCad, nLote);
    }
    public Refrigerado(String nombre, String fechaCad, int nLote, int codOrg) {
        super(nombre, fechaCad, nLote);
        this.codOrg = codOrg;
    }
    public int getCodOrg() {
        return codOrg;
    }
    public void setCodOrg(int codOrg) {
        this.codOrg = codOrg;
    }

    @Override
    public String toString() {
        return "Refrigerado{" +
                "codOrg=" + codOrg +
                '}';
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Refrigerado r = (Refrigerado) super.clone();
        return r;
    }
}
