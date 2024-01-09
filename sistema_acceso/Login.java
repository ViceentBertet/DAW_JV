package sistema_acceso;


import java.util.Scanner;

public class Login {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Usuario[] users = new Usuario[2];
        users[0] = new Usuario("Sergi04", "1234");
        users[1] = new Usuario("Roberto05", "1234");

        System.out.println("**Login**\n");
        System.out.print("Introduce tu usuario: ");
        String user = sc.next();
        System.out.print("Introduce tu contraseña: ");
        String contra = sc.next();

        Usuario datos = new Usuario(user, contra);
        verificarUsuario(datos, users);

        sc.close();
    }
    public static void verificarUsuario(Usuario datos, Usuario[] usuarios) {
        if (datos.getNom().equalsIgnoreCase(usuarios[0].getNom()) || datos.getNom().equalsIgnoreCase(usuarios[1].getNom()) && datos.getPasswd().equalsIgnoreCase(usuarios[0].getPasswd()) || datos.getPasswd().equalsIgnoreCase(usuarios[1].getPasswd())) {
            System.out.println("El usuario y contraseña son correctos. Entrando al sistema...");
        } else {
            System.out.println("ERROR: El usuario o la contraseña son incorrectos");
        }
    }
}
