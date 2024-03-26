package encriptacion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Scanner;

public class Gestion {
    private static Logger LOGGER = LogManager.getRootLogger();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        final String ENCRIPTADO = "crip";
        SistemaEncriptado se = new SistemaEncriptado(sc);
        boolean exit = false;
        File fich;
        do {
            System.out.println("\t**Sistema de encriptación**\n");
            System.out.println("(1) Encriptar fichero");
            System.out.println("(2) Desencriptar fichero");
            System.out.println("(3) Salir");
            System.out.print("Introduce que acción deseas hacer: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Introduce el fichero que deseas encriptar");
                    fich = new File(sc.nextLine());
                    if (fich.exists()) {
                        se.encriptar(fich);
                    } else {
                        System.out.println("ERROR: El fichero no existe");
                    }
                    break;
                case 2:
                    System.out.println("Introduce el fichero que deseas desencriptar");
                    String f = sc.nextLine();
                    String ext = f.substring(f.length() - 4);
                    fich = new File(f);

                    if (fich.exists() && ENCRIPTADO.equals(ext)) {
                        se.desencriptar(fich);
                    } else if (!ENCRIPTADO.equals(ext)) {
                        System.out.println("ERROR: El fichero encriptado debe tener la extension .crip");
                    } else {
                        System.out.println("ERROR: El fichero no existe");
                    }
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("ERROR: Valor no valido");
            }
        } while (!exit);

    }
}
