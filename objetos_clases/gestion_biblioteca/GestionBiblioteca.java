package objetos_clases.gestion_biblioteca;
import java.util.Scanner;
public class GestionBiblioteca {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        final int ERROR = -1;
        String user;
        String passwd;

        System.out.println("** BIBLIOTECA **\n");
        System.out.print("Introduce tu usuario:");
        user = sc.nextLine();
        System.out.print("Introduce tu contraseña");
        passwd = sc.nextLine();
        int validar = validarUsuario(user, passwd);

        if (validar != ERROR) {

        }

        sc.close();
    }

}
