package polimorfismo;

public class Gestion {
    public static void main(String[] args) {
        Persona p1 = new Secundaria("Juan", "15", "jugar al futbol", "mates", false, "informatica");
        Estudiante e1 = new Universidad("Alex", "veinticinco", "jugar al padel", "el patio", true, 60);
        Universidad u1 =new Universidad("Ricardo", "diecinueve", "jugar al ajedrez", "historia", false, 42);
        Secundaria s1 = (Secundaria) new Persona("Arturo", "32", "la musica");
        s1.setAsignaturaFav("ee");


        System.out.println("Secundaria: ");
        s1.mostrarInformacion();
        System.out.println("Persona 1: ");
        p1.mostrarInformacion();
        System.out.println("\nPersona 2: ");
        System.out.println("\nEstudiante: ");
        e1.mostrarInformacion();
        System.out.println("\nUniversitario: ");
        u1.mostrarInformacion();
    }
}
