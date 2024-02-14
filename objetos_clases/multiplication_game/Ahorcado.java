package objetos_clases.multiplication_game;

import java.util.Random;
import java.util.Scanner;

public class Ahorcado implements IJuego{
    private final Incognita[] incognitas = new Incognita[6];
    private Incognita adivinar;
    private String palabra;

    public Ahorcado() {
        Incognita[] peliculas = new Incognita[5];
        Incognita[] libros = new Incognita[5];
        Incognita[] grupos = new Incognita[5];
        int n;

        peliculas[0] = new Incognita("Pelicula", "Avengers");
        peliculas[1] = new Incognita("Pelicula", "1917");
        peliculas[2] = new Incognita("Pelicula", "Her");
        peliculas[3] = new Incognita("Pelicula", "Titanic");
        peliculas[4] = new Incognita("Pelicula", "Cars");

        libros[0] = new Incognita("Libro", "El principito");
        libros[1] = new Incognita("Libro", "Hamlet");
        libros[2] = new Incognita("Libro", "El Quijote");
        libros[3] = new Incognita("Libro", "Harry Potter");
        libros[4] = new Incognita("Libro", "Peter Pan");

        grupos[0] = new Incognita("Grupo Musical", "ACDC");
        grupos[1] = new Incognita("Grupo Musical", "One Direction");
        grupos[2] = new Incognita("Grupo Musical", "Los Beatles");
        grupos[3] = new Incognita("Grupo Musical", "Los Jackson");
        grupos[4] = new Incognita("Grupo Musical", "Black Eyed Peas");

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
    @Override
    public void jugar() {
        Scanner sc = new Scanner(System.in);
        final int INTENTOS = 12;
        for (int i = 0; i < incognitas.length; i++) {
            int nPalabra = i + 1;
            adivinar = incognitas[i];

            System.out.println("\nPALABRA " + nPalabra);

            for(int j = 0; j < INTENTOS; j++) {
                int nIntento = j + 1;

                System.out.println("INTENTO " + nIntento);

                if (j == 5){
                    System.out.println("El tema es " + adivinar.getTipo());
                }

                if (j == 0) {
                    System.out.print("\nIntentalo: ");
                } else {
                    System.out.print("\nHas fallado. Vuelvelo a intentar: ");
                }

                palabra = sc.nextLine();
                if (palabra.equals(adivinar.getTexto())) {
                    System.out.println("¡Has acertado! La palabra era " + adivinar.getTexto());
                    break;
                }
            }
            if (!palabra.equals(adivinar.getTexto())){
                System.out.println("¡Has fallado! La palabra era " + adivinar.getTexto());
            }
        }
    }
}
