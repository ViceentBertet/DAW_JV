package objetos_clases.gestion_biblioteca;
import java.util.Scanner;
public class GestionBiblioteca {
    public static Scanner sc = new Scanner(System.in);
    public static Biblioteca biblio = new Biblioteca();
    public static void main(String[] args) {
        final int ERROR = -1;

        String user;
        String passwd;
        boolean exit = false;

        System.out.println("** BIBLIOTECA **\n");
        System.out.print("Introduce tu usuario:");
        user = sc.nextLine();
        System.out.print("Introduce tu contraseña");
        passwd = sc.nextLine();

        int validar = biblio.validarUsuario(user, passwd);

        if (validar == ERROR) {
            System.out.println("ERROR: El usuario no existe");
        } else {
            while (!exit) {
                System.out.println("Has iniciado sesión\n");
                System.out.println("\t\tMENU");
                System.out.println("\t1: Pedir prestado un libro");
                System.out.println("\t2: Depositar libro prestado");
                System.out.print("¿Que desea hacer? ");
                int eleccion = sc.nextInt();
                sc.nextLine();
                int validarEleccion = procesarEleccion(eleccion, user);

                if (validarEleccion == 0) {

                }
            }
        }
        sc.close();
    }
    public static int procesarEleccion(int eleccion, String user) {
        int validarError = 0;
        switch (eleccion) {
            case 1: validarError = biblio.prestarLibro(user);     break;
            case 2: validarError = biblio.depositarLibro(user);   break;
            default:
                System.out.println("ERROR: Elección incorrecta.");
                validarError = -1;
        }
        return validarError;
    }
}
