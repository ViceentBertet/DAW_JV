package objetos_clases.trabajadores;

public class Trabajador {
    private String nombre;
    private String edad;
    private String sueldo;

    public Trabajador(String nombre, String edad, String sueldo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sueldo = sueldo;
    }
    public String getNombre() {
        return nombre;
    }
    public String getEdad() {
        return edad;
    }
    public String getSueldo() {
        return sueldo;
    }
}
