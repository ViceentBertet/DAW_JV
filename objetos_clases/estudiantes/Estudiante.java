package objetos_clases.estudiantes;

public class Estudiante {
    private String nombre;
    private int edad;
    private String grado;
    public Estudiante(String nombre, int edad, String grado){
        this.nombre = nombre;
        this.edad = edad;
        this.grado = grado;
    }
    public void setNombre(String nombre) {this.nombre = nombre;}

    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setGrado(String grado) {
        this.grado = grado;
    }
    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }
    public String getGrado() {
        return grado;
    }
}
