package encriptacion;

import java.io.File;
import java.util.Scanner;

public class SistemaEncriptado implements IEncriptar{
    private static final String CIFRADO = "crip";
    private Scanner sc;
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
    @Override
    public void encriptar(File fich, String palabra) {

    }
    @Override
    public void desencriptar(File fich, String palabra) {
        //TODO quitar palabra magica y pedirla en el main

        //DESENCRIPTAR
    }
}
