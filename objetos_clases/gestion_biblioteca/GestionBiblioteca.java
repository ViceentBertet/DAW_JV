package objetos_clases.gestion_biblioteca;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
public class GestionBiblioteca {
    public static Scanner sc = new Scanner(System.in);
    public static Biblioteca biblio = new Biblioteca();
    public static final int ERROR = -1;
    public static void main(String[] args) {
        String user;
        String passwd;
        boolean exit = false;

        while (!exit) {
            boolean closeSession = false;

            System.out.println("** BIBLIOTECA **\n");
            System.out.print("Introduce tu usuario: ");
            user = sc.nextLine();
            System.out.print("Introduce tu contraseña: ");
            passwd = sc.nextLine();

            int validar = biblio.validarUsuario(user, passwd);

            if (validar == ERROR) {
                System.out.println("ERROR: El usuario no existe");
            } else {
                System.out.println("Has iniciado sesión\n");
                while (!closeSession) {
                    System.out.println("\t\tMENU");
                    System.out.println("\t1: Pedir prestado un libro");
                    System.out.println("\t2: Depositar libro prestado");
                    System.out.print("¿Que desea hacer? ");
                    int eleccion = sc.nextInt();
                    sc.nextLine();
                    
                    procesarEleccion(eleccion, user);

                    System.out.println("\n1: Seguir en el programa");
                    System.out.println("2: Cerrar sesión");
                    System.out.printf("3: Cerrar el programa");
                    System.out.print("¿Que desea hacer? ");
                    int salir = sc.nextInt();
                    sc.nextLine();

                    switch (salir) {
                        case 1: System.out.println("Cargando menu..."); break;
                        case 2:
                            System.out.println("Cerrando sesión");
                            closeSession = true;
                            break;
                        case 3:
                            System.out.println("Saliendo del programa...");
                            closeSession = true;
                            exit = true;
                            break;
                        default: System.out.println("ERROR: Valor no comprendido. Cargando menu...");
                    }
                }
            }
        }
        sc.close();
    }
    public static void procesarEleccion(int eleccion, String user) {
        switch (eleccion) {
            case 1: prestarLibro(user);break;
            case 2: int error = biblio.depositarLibro(user);
                    if (error == ERROR) {
                        System.out.println("ERROR: El usuario no tenia ningun libro prestado");
                    } else {
                        System.out.println("Se ha depositado el libro correctamente");
                    }
                    break;
            default: System.out.println("ERROR: Elección incorrecta.");
        }
    }
    public static void prestarLibro(String user) {
        int validarError = biblio.tienePrestado(user);
        if (validarError == ERROR) {
            System.out.println("ERROR: El usuario ya tiene prestado un libro");
        } else {
            biblio.mostrarLibros();

            System.out.println("Indica que libro te gustaria llevarte");
            String libroPrestado = sc.nextLine();

            int indexLibro = biblio.obtenerLibro(libroPrestado);

            if (indexLibro == ERROR) {
                System.out.println("ERROR: Libro no encontrado");
            } else {
                int comprobarPrestado = biblio.comprobarLibro(indexLibro);
                if (comprobarPrestado == ERROR) {
                    System.out.println("ERROR: El libro ya esta prestado a otro usuario");
                } else {
                    biblio.prestarLibro(indexLibro, user);
                    System.out.println("Libro prestado");
                }
            }
        }
    }
}
