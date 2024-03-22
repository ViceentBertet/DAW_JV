package excepciones.sistema_acceso;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Login {
    private static Logger LOGGER = LogManager.getRootLogger();
    private static Scanner sc = new Scanner(System.in);
    /**
     * main El usuario mete sus datos y se mandan a validar
     * */
    public static void main(String[] args) {
        File fich = new File("usuarios.txt");
        try {
            SistemaAcceso sa = new SistemaAcceso(sc, fich);
            boolean exit;
            do {
                System.out.println("**Login**\n");
                System.out.print("Introduce tu usuario: ");
                String user = sc.nextLine();
                System.out.print("Introduce tu contraseña: ");
                String contra = sc.nextLine();

                Usuario datos = new Usuario(user, contra);
                int nCuenta = sa.inicioSesion(datos);

                exit = gestionCuenta(nCuenta, sa);

            } while (!exit);

        } catch (IOException e) {
            System.out.println("No se pueden cargar los usuarios");
            LOGGER.error("IOException");
        } finally {
            sc.close();
        }
    }
    /**
     * gestionCuenta se contemplan todas las acciones que puede ejecutar el usuario
     * */
    public static boolean gestionCuenta(int nCuenta, SistemaAcceso sa) {
        //TODO añadir opcion de registrarse
        boolean repeat;
        int opcion;
        boolean exit = false;
        if (nCuenta != -1){
            do {
                repeat = false;
                System.out.println("\n**Gestión de la cuenta**");
                System.out.println("\t1: Cambiar contraseña");
                System.out.println("\t2: Cerrar sesión");
                System.out.println("\t3: Terminar el programa ");
                System.out.println("¿Cual de las anteriores opciones quieres realizar (1/2/3)? ");
                try {
                    opcion = sc.nextInt();
                } catch (InputMismatchException e) {
                    opcion = 0;
                }
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        sa.confirmChangePasswd(nCuenta);
                        repeat = true;
                        break;
                    case 2:
                        System.out.println("Cerrando sesión...\n");
                        break;
                    case 3:
                        System.out.println("Cerrando el programa...");
                        exit = true;
                        break;
                    default:
                        System.out.print("ERROR: Se debe escojer entre (1/2/3). Vuelvelo a intentar: ");
                        repeat = true;
                }
            } while (repeat);
        }
        return exit;
    }
}

