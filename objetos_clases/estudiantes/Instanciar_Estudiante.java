package objetos_clases.estudiantes;

public class Instanciar_Estudiante {
    public static void main(String[] args) {
        Estudiante e1 = new Estudiante("Juan", 17, "Informatica");
        Estudiante e2 = new Estudiante("", 0, "");
        e2.setNombre("Carlos");
        e2.setEdad(21);
        e2.setGrado("Electricidad");

        System.out.println("Datos del estudiante:");
        System.out.print(e1.getNombre() + "\n" + e1.getEdad() + "\n" + e1.getGrado());


    }
}
