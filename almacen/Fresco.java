package almacen;

public class Fresco extends Producto {
    private String fechaEnv;
    private String pais;

    public Fresco(String nombre, String fechaCad, int nLote) {
        super(nombre, fechaCad, nLote);
    }

    public Fresco(String nombre, String fechaCad, int nLote, String fechaEnv, String pais) {
        super(nombre, fechaCad, nLote);
        this.fechaEnv = fechaEnv;
        this.pais = pais;
    }
    public String getFechaEnv() {
        return fechaEnv;
    }
    public void setFechaEnv(String fechaEnv) {
        this.fechaEnv = fechaEnv;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    @Override
    public String toString() {
        return "Fresco {" +
                "fechaEnv='" + fechaEnv +
                ", pais='" + pais +
                '}';
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Fresco f = (Fresco) super.clone();
        return f;
    }
}
