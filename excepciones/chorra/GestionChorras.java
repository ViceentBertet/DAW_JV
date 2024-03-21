package excepciones.chorra;

import java.io.IOException;

public class GestionChorras {
    public static void main(String[] args) {
        try {
            Chorra a = new Chorra();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            crearChorras();
        }
    }
    public static void crearChorras() {
        try {
            Chorra b = new Chorra("Hola");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        try {
            Chorra c = new Chorra();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            Chorra d = new Chorra();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
