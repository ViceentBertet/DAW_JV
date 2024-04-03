package encriptacion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Scanner;

public class SistemaEncriptado implements IEncriptar{
    private static Logger LOGGER = LogManager.getRootLogger();
    private static final String CIFRADO = "crip";
    private static final String NOCIFRADO = "txt";
    private static Scanner sc;
    private int type;
    public SistemaEncriptado(Scanner sc, int type) throws IllegalArgumentException{
        this.sc = sc;
        if (type < 1 || type > 3) {
            throw new IllegalArgumentException();
        }
        this.type = type;
    }
    public static boolean comprobarExtension(File f){
        String nom = f.getName();
        String ext = nom.substring(nom.length() - 4);
        if (CIFRADO.equals(ext)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
    public static File cambiarExtension(File fich) {
        String nuevo = "";
        String actual = "";
        for (int i = 0; i < fich.getName().length(); i++) {
            if (fich.getName().charAt(i) == '.') {
                nuevo = fich.getName().substring(0, i + 1);
                actual = fich.getName().substring(i + 1);
                break;
            }
        }
        if (actual.equals(CIFRADO)){
            nuevo += NOCIFRADO;
        } else {
            nuevo += CIFRADO;
        }
        return new File(nuevo);
    }
    public static File pedirFichero(){
        System.out.print("Introduce el fichero: ");
        File fich = new File(sc.nextLine());
        if (fich.exists()) {
            return fich;
        }
        return null;
    }
    public static String pedirPalabra() {
        System.out.print("Introduce la palabra mágica: ");
        String magica = sc.nextLine();
        return magica;
    }
    public static int crearValor(String palabra){
        int valor = 0;
        for (int i = 0; i < palabra.length(); i++) {
            if ( i % 2 == 0) {
                valor += palabra.charAt(i);
            } else {
                valor -= palabra.charAt(i);
            }
        }
        return valor;
    }
    public static void encriptarPorValor(File fich) {
        String palabra = pedirPalabra();
        int valor = crearValor(palabra);
        try {
            BufferedReader encR = new BufferedReader(new FileReader(fich));
            BufferedWriter encW = new BufferedWriter(new FileWriter(cambiarExtension(fich)));
            int viejoValor;
            int nuevoValor;
            while ((viejoValor = encR.read()) != -1) {
                nuevoValor = viejoValor - valor;
                encW.write(nuevoValor);
            }

            encR.close();
            encW.close();
        } catch (IOException e) {
            LOGGER.error(e.getStackTrace());
            System.out.println("ERROR: No se ha podido crear el fichero encriptado");
        }
    }
    public static void desencriptarPorValor(File fich) {
        String palabra = pedirPalabra();
        int valor = crearValor(palabra);
        try {
            BufferedReader encR = new BufferedReader(new FileReader(fich));
            BufferedWriter encW = new BufferedWriter(new FileWriter(cambiarExtension(fich)));
            int viejoValor;
            int nuevoValor;
            while ((viejoValor = encR.read()) != -1) {
                nuevoValor = viejoValor + valor;
                encW.write(nuevoValor);
            }

            encR.close();
            encW.close();
        } catch (IOException e) {
            LOGGER.error(e.getStackTrace());
            System.out.println("ERROR: No se ha podido leer el fichero encriptado");
        }
    }
    @Override
    public void encriptar(File fich) {
        switch (this.type) {
            case 1:
                encriptarPorValor(fich);
                break;
            case 2:
                break;

            case 3:
                break;
        }
    }
    @Override
    public void desencriptar(File fich) {
        if (comprobarExtension(fich)) {
            switch (this.type) {
                case 1:
                    desencriptarPorValor(fich);
                    break;
                case 2:
                    break;

                case 3:
                    break;
            }
        } else {
            System.out.println("ERROR: El fichero debe estar encriptado");
        }
    }
}
