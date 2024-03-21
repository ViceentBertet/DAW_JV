package excepciones.sistema_acceso;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaAcceso {
    private List<Usuario> usuarios = new ArrayList<>();
    private Scanner sc;
    /**
     * SistemaAcceso carga los usuarios
     * @param sc Leer teclado
     * */
    public SistemaAcceso(Scanner sc) {
        this.sc = sc;
        cargarUsuarios();
    }
    /**
     * Se añaden los nuevos usuarios a la lista
     * */
    public void cargarUsuarios() {
        boolean error = false;
        try {
            usuarios.add(new Usuario("Vicent", "2005"));
            usuarios.add(new Usuario("Roberto05", "1234"));
            usuarios.add(new Usuario("Raquel", "hola"));
            usuarios.add(new Usuario("Alex", "adios", 5));
            usuarios.add(new Usuario("Jordi", "si", 7));
            usuarios.add(new Usuario("Hugo", "no", 9));
        } catch (IllegalArgumentException e) {
            System.out.println("\nERROR: El número de inicios no es correcto");
            error = true;
        }

        if (!error) {
            System.out.println("\nSe han cargado correctamente los usuarios\n");
        }
    }
    /**
     * inicioSesion comprueba que el usuario existe
     * @return posicion donde se ubica en la lista
     * */
    public int inicioSesion(Usuario datos) {
        int encontrado = -1;
        for (int i = 0; i < usuarios.size(); i++) {
            if (datos.equals(usuarios.get(i))) {
                encontrado = i;
                break;
            }
        }
        if (encontrado != -1) {
            addInicio(encontrado);
        } else {
            System.out.println("ERROR: El usuario o la contraseña son incorrectos. Introducelo otra vez.");
        }
        return encontrado;
    }
    public void addInicio(int encontrado){
        usuarios.get(encontrado).nuevoInicio();
        if (usuarios.get(encontrado).getnInicios() == 1) {
            System.out.println("Se ha iniciado por primera vez en  el usuario " + usuarios.get(encontrado).getNom());
        } else {
            System.out.println("Se han iniciado " + usuarios.get(encontrado).getnInicios() + " veces en el usuario " + usuarios.get(encontrado).getNom());
            System.out.println("Ultimo acceso: " + usuarios.get(encontrado).getUltimoInicio().toString());
        }
        usuarios.get(encontrado).setUltimoInicio(LocalDateTime.now());
    }
    public void confirmChangePasswd(int nCuenta) {
        String passwd;
        boolean exit = false;
        do {
            System.out.print("Por cuestiones de seguridad. Vuelve a introducir la contraseña actual: ");
            passwd = sc.next();

            if (passwd.equals(usuarios.get(nCuenta).getPasswd())) {
                exit = changePasswd(nCuenta);
            } else {
                System.out.print("ERROR. No coincide. ");
            }
        } while (!exit);
    }
    public boolean changePasswd(int nCuenta){
        String passwd;
        String confirmPasswd;
        boolean exit = false;
        do {
            System.out.print("Introduce tu nueva contraseña: ");
            passwd = sc.next();
            System.out.print("Introduce otra vez tu nueva contraseña: ");
            confirmPasswd = sc.next();

            if (passwd.equals(confirmPasswd)) {
                usuarios.get(nCuenta).setPasswd(confirmPasswd);
                System.out.println("\nContraseña cambiada correctamente.\n");
                exit = true;
            } else {
                System.out.print("ERROR. No coinciden. ");
            }
        } while (!exit);
        return exit;
    }
}
