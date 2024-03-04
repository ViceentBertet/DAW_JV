package almacen;
import java.util.Objects;

public class Producto implements Cloneable{
    private String nombre;
    private String fechaCad;
    private int nLote;
    public Producto(String nombre, String fechaCad, int nLote) {
        this.nombre = nombre;
        this.fechaCad = fechaCad;
        this.nLote = nLote;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getFechaCad() {
        return fechaCad;
    }
    public void setFechaCad(String fechaCad) {
        this.fechaCad = fechaCad;
    }
    public int getnLote() {
        return nLote;
    }
    public void setnLote(int nLote) {
        this.nLote = nLote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return nLote == producto.nLote && Objects.equals(nombre, producto.nombre) && Objects.equals(fechaCad, producto.fechaCad);
    }
    @Override
    public int hashCode() {
        return Objects.hash(nombre, fechaCad, nLote);
    }
    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre +
                ", fechaCad='" + fechaCad +
                ", nLote=" + nLote +
                '}';
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Producto p = (Producto) super.clone();
        return p;
    }
}
