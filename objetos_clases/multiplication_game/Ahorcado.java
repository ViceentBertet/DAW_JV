package objetos_clases.multiplication_game;

import java.util.Random;
import java.util.Scanner;

public class Ahorcado {
    private Scanner sc = new Scanner(System.in);
    private final Incognita[] incognitas = new Incognita[6];
    private Incognita adivinar;
    private StringBuilder palabra = new StringBuilder();

    public Ahorcado() {
        Incognita[] peliculas = new Incognita[5];
        Incognita[] libros = new Incognita[5];
        Incognita[] grupos = new Incognita[5];
        int n;

        peliculas[0] = new Incognita("Pelicula", "AVENGERS");
        peliculas[1] = new Incognita("Pelicula", "ORIGEN");
        peliculas[2] = new Incognita("Pelicula", "HER");
        peliculas[3] = new Incognita("Pelicula", "TITANIC");
        peliculas[4] = new Incognita("Pelicula", "CARS");

        libros[0] = new Incognita("Libro", "EL PRINCIPITO");
        libros[1] = new Incognita("Libro", "HAMLET");
        libros[2] = new Incognita("Libro", "EL QUIJOTE");
        libros[3] = new Incognita("Libro", "HARRY POTTER");
        libros[4] = new Incognita("Libro", "PETER PAN");

        grupos[0] = new Incognita("Grupo Musical", "ACDC");
        grupos[1] = new Incognita("Grupo Musical", "ONE DIRECTION");
        grupos[2] = new Incognita("Grupo Musical", "LOS BEATLES");
        grupos[3] = new Incognita("Grupo Musical", "LOS JACKSON");
        grupos[4] = new Incognita("Grupo Musical", "BLACK EYED PEAS");

        Random rnd = new Random();

        for (int i = 0; i < incognitas.length; i++) {
            n = rnd.nextInt(3);
            if (n == 0) {
                n = rnd.nextInt(5);
                incognitas[i] = peliculas[n];

            } else if (n == 1) {
                n = rnd.nextInt(5);
                incognitas[i] = libros[n];

            } else {
                n = rnd.nextInt(5);
                incognitas[i] = grupos[n];
            }
        }
    }
    public void setAdivinar(Incognita adivinar) {
        this.adivinar = adivinar;
    }
    public void setPalabra(StringBuilder palabra) {
        this.palabra = palabra;
    }
    public Incognita[] getIncognitas() {
        return incognitas;
    }
    public Incognita getAdivinar() {
        return adivinar;
    }
    public StringBuilder getPalabra() {
        return palabra;
    }
    public void crearPalabra(){
        palabra.append("-".repeat(adivinar.getTexto().length()));
    }
    public static boolean esLetra(String letra) {
        if (letra.length() == 1) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
    public int encontrarLetra(char letra) {
        int encontrado = 0;
        for (int i = 0; i < adivinar.getTexto().length(); i++) {
            if (adivinar.getTexto().charAt(i) == letra) {
                palabra.deleteCharAt(i);
                palabra.insert(i, letra);
                encontrado++;
            }
        }
        return encontrado;
    }
    public void intento(String frase) {
        if(Ahorcado.esLetra(frase)) {
            char letra = frase.charAt(0);
            int encontrada = encontrarLetra(letra);

            if (encontrada == 0) {
                System.out.println("La letra no esta en la palabra :(");
                System.out.println("La palabra contiene " + getPalabra().toString());
            } else {
                System.out.println("Enhorabuena la palabra si contenia la letra :)");
                System.out.println("La palabra contiene " + getPalabra().toString());
            }
        } else {
            System.out.println("El dato introducido debe ser una letra. Has perdido el turno");
        }
    }
    public void resolver() {
        String letra;
        String respuesta;

        for (int i = 1; i <= 3; i++) {
            System.out.println("\nJUGADOR " + i);

            System.out.print("¿Quieres resolver? (s/n) ");
            respuesta = sc.nextLine().toLowerCase();


            if (respuesta.equals("n")) {
                System.out.print("Introduce tu respuesta: ");
                letra = sc.nextLine().toUpperCase();
                intento(letra);

            } else if (respuesta.equals("s")) {
                System.out.print("Introduce tu respuesta: ");
                respuesta = sc.nextLine().toUpperCase();

                if (getAdivinar().getTexto().equals(respuesta)) {
                    getPalabra().delete(0, getPalabra().toString().length());
                    getPalabra().append(getAdivinar().getTexto());
                    System.out.printf("¡El jugador %d ha ganado!\n", i);
                    break;
                }
            } else {
                System.out.println("El dato introducido debe ser s o n. Has perdido el turno");
            }
        }
    }
}
