package encriptacion;

import java.io.File;
import java.util.Base64;
import java.util.Scanner;

public class prueba {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String entrada = "Text de prova";
        String cadenaCodificada = Base64.getEncoder().encodeToString(entrada.getBytes());

        System.out.println(cadenaCodificada);

        byte[] bytesDecodificados = Base64.getDecoder().decode(cadenaCodificada);
        String cadenaDecodificada = new String(bytesDecodificados);

        System.out.println(cadenaDecodificada);
    }

}
