package prueba;

public class Gestion {
    public static void main(String[] args){
        Persona p1 = new Persona("Pepe");
        Persona p2 = new Persona("Juan");
        Persona p3 = new Persona("Manoli");
        p1.setEdad(18);

        System.out.println(p1.getNombre() + p2.getNombre() + p3.getNombre());
    }
}
