package encriptacion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.InputMismatchException;
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
                case 1, 2:
                    fich = pedirFichero();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("ERROR: Valor no valido");
            }
        } while (!exit);
    }
    public static File pedirFichero(){
        System.out.println("Introduce el fichero que deseas encriptar");
        File fich = new File(sc.nextLine());
        if (fich.exists()) {
            return fich;
        }
        return null;
    }
    public static void encriptarDesencriptar(int opcion) {
        SistemaEncriptado se = new SistemaEncriptado(sc, 1);
        File fich;

        if (opcion == 1) {
                System.out.print("Introduce la palabra para encriptar: ");
                String magica = sc.nextLine();
                System.out.print("Vuelvela a introducir para confirmar la palabra para encriptar: ");
                String confirmarMagica = sc.nextLine();

                if (magica.equals(confirmarMagica)) {
                } else {
                    System.out.println("ERROR: Las palabras deben coincidir.");
                }
        } else {
            System.out.println("Introduce el fichero que deseas desencriptar");
            fich = new File(sc.nextLine());

            if (fich.exists() && SistemaEncriptado.comprobarExtension(fich)) {
                System.out.print("Introduce la palabra para desencriptar: ");
                String magica = sc.nextLine();
                se.desencriptar(fich, magica);
            } else if (!SistemaEncriptado.comprobarExtension(fich)) {
                System.out.println("ERROR: El fichero encriptado debe tener la extension .crip");
            } else {
                System.out.println("ERROR: El fichero no existe");
            }
        }
    }
}
