package objetos_clases.persona_estudiante;

public class Estudiante extends Persona {
    private int creditos;
    public Estudiante(String nombre, int edad, int creditos) {
        super(nombre, edad);
        this.creditos = creditos;
    }
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.print( " creditos: " + this.creditos);
    }
}
