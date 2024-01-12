package objetos_clases.trabajadores;

public class Proyecto {
    private String nombre;
    private String desc;

    public Proyecto(String nombre, String desc) {
        this.nombre = nombre;
        this.desc = desc;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDesc() {
        return desc;
    }
}
