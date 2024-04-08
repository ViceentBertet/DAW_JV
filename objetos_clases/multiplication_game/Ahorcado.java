package objetos_clases.multiplication_game;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Ahorcado {
    private static Logger LOGGER = LogManager.getRootLogger();
    private Scanner sc = new Scanner(System.in);
    private final Incognita[] incognitas = new Incognita[7];
    private Incognita adivinar;
    private StringBuilder palabra = new StringBuilder();
    public Ahorcado() {
        Pelicula[] peliculas = cargarPeliculas();
        Libro[] libros = cargarLibros();
        Grupo[] grupos = cargarGrupos();
        int n;

        Random rnd = new Random();
        if (peliculas != null && libros != null && grupos != null) {
            for (int i = 0; i < incognitas.length; i++) {
                n = rnd.nextInt(3);
                if (n == 0) {
                    n = rnd.nextInt(10);
                    incognitas[i] = peliculas[n];

                } else if (n == 1) {
                    n = rnd.nextInt(10);
                    incognitas[i] = libros[n];

                } else {
                    n = rnd.nextInt(10);
                    incognitas[i] = grupos[n];
                }
            }
        } else {
            System.out.println("ERROR: No se han podido cargar los datos");
        }
    }
    public static Pelicula[] cargarPeliculas(){
        File fich = new File("Peliculas.txt");
        String linea;
        int i = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fich));
            Pelicula[] pelis = new Pelicula[10];
            while ((linea = br.readLine()) != null) {
                pelis[i] = new Pelicula(linea);
                i++;
            }
            br.close();
            return pelis;
        } catch (IOException e) {
            LOGGER.error(e.getStackTrace());
        }
        return null;
    }
    public static Libro[] cargarLibros(){
        File fich = new File("Libros.txt");
        String linea;
        int i = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fich));
            Libro[] libros = new Libro[10];
            while ((linea = br.readLine()) != null) {
                libros[i] = new Libro(linea);
                i++;
            }
            br.close();
            return libros;
        } catch (IOException e) {
            LOGGER.error(e.getStackTrace());
        }
        return null;
    }
    public static Grupo[] cargarGrupos(){
        File fich = new File("Grupos.txt");
        String linea;
        int i = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fich));
            Grupo[] grupos = new Grupo[10];
            while ((linea = br.readLine()) != null) {
                grupos[i] = new Grupo(linea);
                i++;
            }
            br.close();
            return grupos;
        } catch (IOException e) {
            LOGGER.error(e.getStackTrace());
        }
        return null;
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
}
