package SIstemaAcceso;

import java.util.Scanner;

public class Valid {
    private static Scanner sc = new Scanner(System.in);
    private static User sergi = new User("ohnecroh");
    private static Password passwdSergi = new Password(sergi, "Sergi1234");
    public static void main(String[] args) {
        System.out.println("**SISTEMA DE ACCESO**");
        System.out.print("Introduce usuario: ");
        String introducirUsuario = sc.next();

        boolean isValid = validarUsuario(introducirUsuario);


    }
    public static boolean validarUsuario(String usuario){
        if () {
            return true;
        } else {
            return false;
        }
    }
}
