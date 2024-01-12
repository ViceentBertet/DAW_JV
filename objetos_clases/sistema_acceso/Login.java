package objetos_clases.sistema_acceso;


import java.util.Scanner;

public class Login {
    private static final Usuario[] USERS = new Usuario[2];
    private static final Scanner SC = new Scanner(System.in);
    public static void main(String[] args) {

        USERS[0] = new Usuario("Sergi04", "1234");
        USERS[1] = new Usuario("Roberto05", "1234");

        System.out.println("**Login**\n");
        System.out.print("Introduce tu usuario: ");
        String user = SC.next();
        System.out.print("Introduce tu contraseña: ");
        String contra = SC.next();

        Usuario datos = new Usuario(user, contra);
        inicioSesion(datos);

        SC.close();
    }
    public static void inicioSesion(Usuario datos) {
        for (int i = 0; i < USERS.length; i++) {
            if (datos.getNom().equalsIgnoreCase(USERS[i].getNom())) {
                System.out.print("El usuario es correcto");
                if (datos.getNom().equalsIgnoreCase(USERS[i].getPasswd())) {
                    if (USERS[i].nInicioSesion() == 1) {
                        System.out.println("Se ha iniciado por primera vez en  el usuario " + USERS[i].getNom());
                    } else {
                        System.out.println("Se han iniciado " + USERS[i].nInicioSesion() + "veces en el usuario " + USERS[i].getNom());
                        System.out.println("Ultimo acceso: ");
                    }
                } else {
                    System.out.print(", pero la contaseña es incorrecta");
                }
            } else {
                System.out.println("ERROR: El usuario o la contraseña son incorrectos");
            }
        }
    }
}
