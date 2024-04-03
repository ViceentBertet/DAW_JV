package encriptacion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Scanner;

public class Gestion {
    private static Logger LOGGER = LogManager.getRootLogger();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            menu();
        } catch (Exception e) {
            System.out.println("Ha habido un error");
            LOGGER.error(e.getStackTrace());
        } finally {
            sc.close();
        }
    }
    public static void menu(){
        boolean exit = false;

        do {
            System.out.println("\t**Sistema de encriptación**\n");
            System.out.println("(1) Encriptar fichero");
            System.out.println("(2) Desencriptar fichero");
            System.out.println("(3) Salir");
            System.out.print("Introduce que acción deseas hacer: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1, 2:
                    encriptarDesencriptar(opcion);
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("ERROR: Valor no valido");
            }
        } while (!exit);
    }

    public static void encriptarDesencriptar(int opcion) {
        SistemaEncriptado se = new SistemaEncriptado(sc, 1);
        File fich = SistemaEncriptado.pedirFichero();


        if (opcion == 1 && fich != null) {
            se.encriptar(fich);
        } else if (fich != null) {
            boolean ext = SistemaEncriptado.comprobarExtension(fich);

        } else {
            System.out.println("El fichero introducido no existe");
        }
    }
}
