package encriptacion;

import java.io.File;
import java.util.Scanner;

public class prueba {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        SistemaEncriptado se = new SistemaEncriptado(sc, 1);

        File fich = new File("ficheroPrint.crip");
        SistemaEncriptado.desencriptarPorValor(fich);

    }
}
