package excepciones.sistema_acceso;


import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Login {
    private static final Usuario[] USERS = new Usuario[3];
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        USERS[0] = new Usuario("AxV", "200623");
        USERS[1] = new Usuario("Roberto05", "1234");
        USERS[2] = new Usuario("Raquel", "060604");

        boolean exit;
        boolean repeat;
        int opcion;

        do {
            exit = false;
            System.out.println("**Login**\n");
            System.out.print("Introduce tu usuario: ");
            String user = sc.nextLine();
            System.out.print("Introduce tu contraseña: ");
            String contra = sc.nextLine();

            Usuario datos = new Usuario(user, contra);
            int nCuenta = inicioSesion(datos);

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
                            changePasswd(nCuenta);
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
        }while (!exit);
        sc.close();
    }
    public static int inicioSesion(Usuario datos) {
        int encontrado = -1;
        for (int i = 0; i < USERS.length; i++) {
            if (datos.getNom().equals(USERS[i].getNom()) && datos.getPasswd().equals(USERS[i].getPasswd())) {
               encontrado = i;
               break;
            }
        }
        if (encontrado != -1) {
            // Mejorar actualización de datos
            USERS[encontrado].nInicioSesion();
            if (USERS[encontrado].getnInicios() == 1) {
                System.out.println("Se ha iniciado por primera vez en  el usuario " + USERS[encontrado].getNom());
                USERS[encontrado].setUltimoInicio(LocalTime.now());
            } else {
                System.out.println("Se han iniciado " + USERS[encontrado].getnInicios() + " veces en el usuario " + USERS[encontrado].getNom());
                System.out.println("Ultimo acceso: " + USERS[encontrado].getUltimoInicio());
                USERS[encontrado].setUltimoInicio(LocalTime.now());
            }
        } else {
            System.out.println("ERROR: El usuario o la contraseña son incorrectos. Introducelo otra vez.");
        }
        return encontrado;
    }
    public static void changePasswd(int nCuenta) {
        String passwd;
        String confirmPasswd;
        boolean exit = false;
        do {
            System.out.print("Por cuestiones de seguridad. Vuelve a introducir la contraseña actual: ");
            passwd = sc.next();

            if (passwd.equals(USERS[nCuenta].getPasswd())) {
                //USERS[nCuenta].cambioPasswd();

                do {
                    System.out.print("Introduce tu nueva contraseña: ");
                    passwd = sc.next();
                    System.out.print("Introduce otra vez tu nueva contraseña: ");
                    confirmPasswd = sc.next();

                    if (passwd.equals(confirmPasswd)) {
                        USERS[nCuenta].setPasswd(confirmPasswd);
                        System.out.println("\nContraseña cambiada correctamente.\n");
                        exit = true;
                    } else {
                        System.out.print("ERROR. No coinciden. ");
                    }
                } while (!exit);
            } else {
                System.out.print("ERROR. No coincide. ");
            }
        } while (!exit);
    }
}
