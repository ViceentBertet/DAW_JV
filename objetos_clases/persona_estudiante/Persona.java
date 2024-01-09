package objetos_clases.persona_estudiante;

public class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public String getNombre() {
        return this.nombre;
    }
    public int getEdad() {
        return this.edad;
    }
    public void mostrarInfo() {
        System.out.print("Nombre: " + this.nombre + " Edad: " + this.edad);
    }
}
