package excepciones.sistema_acceso;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaAcceso {
    private static Logger LOGGER = LogManager.getRootLogger();
    private List<Usuario> usuarios = new ArrayList<>();
    private Scanner sc;
    private File fich;
    /**
     * SistemaAcceso carga los usuarios
     * @param sc leer teclado
     * @param fich que fichero contiene los usuarios
     * @throws IOException si no se encuentra el fichero
     * */
    public SistemaAcceso(Scanner sc, File fich) throws IOException {
        this.sc = sc;
        this.fich = fich;
        try {
            ficheroUsuarios();
        } catch (IOException e) {
            LOGGER.error("SistemaAcceso");
            throw e;
        }
    }
    /**
     * Se añaden los nuevos usuarios a la lista
     * @deprecated utilizar ficheroUsuarios
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
     * ficheroUsuarios crea los usuarios a partir de un fichero separados de ;
     * @throws IOException si no se encuentra el fichero
     * */
    public void ficheroUsuarios() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fich));){
            String linea;
            String usuario;
            String contrasenya;

            while ((linea = br.readLine()) != null){
                for (int i = 0; i < linea.length(); i++) {
                    if (linea.charAt(i) == ';') {
                        usuario = linea.substring(0, i);
                        contrasenya = linea.substring(i + 1);
                        usuarios.add(new Usuario(usuario, contrasenya));
                    }
                }
            }

            br.close();
        } catch (IOException e) {
            LOGGER.error("ficheroUsuarios");
            throw e;
        }
    }
    /**
     * inicioSesion comprueba que el usuario existe
     * @return posicion donde se ubica en la lista
     * @throws IOException si no encuentra el fichero
     * */
    public int inicioSesion(Usuario datos) throws IOException {
        //TODO comparar solo el usuario para saber si existe, despues comparar si la contraseña es correcta
        try {
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
                System.out.print("ERROR: El usuario o la contraseña no existen. ¿Desea registrarse (si/no)? ");
                String respuesta = sc.nextLine();
                //TODO mejor poner valores numericos en el switch
                switch (respuesta.toUpperCase()) {
                    case "SI": registrarse();
                               break;
                    case "NO": System.out.println("Ha seleccionado no. El sistema se volverá a iniciar...");
                               break;
                    default: System.out.println("Valor incorrecto. El sistema se volverá a iniciar...");
                }
            }
            return encontrado;
        } catch (IOException e) {
            LOGGER.error("iniciosesion");
            throw e;
        }
    }
    /**
     * addInicio establece el ultimo inicio de sesion y añade un nuevo inicio
     * @param encontrado
     * */
    public void addInicio(int encontrado) {
        usuarios.get(encontrado).nuevoInicio();
        if (usuarios.get(encontrado).getnInicios() == 1) {
            System.out.println("Se ha iniciado por primera vez en  el usuario " + usuarios.get(encontrado).getNom());
        } else {
            System.out.println("Se han iniciado " + usuarios.get(encontrado).getnInicios() + " veces en el usuario " + usuarios.get(encontrado).getNom());
            System.out.println("Ultimo acceso: " + usuarios.get(encontrado).getUltimoInicio().toString());
        }
        usuarios.get(encontrado).setUltimoInicio(LocalDateTime.now());
    }
    /**
     * confirmChangePasswd valida la contraseña para poder ser cambiada
     * @param nCuenta indice de la cuenta
     * */
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
    /**
     * changePasswd cambia la contraseña
     * @param nCuenta indice de la cuenta
     * @return boolean si ha salido con exito o no
     * */
    public boolean changePasswd(int nCuenta) {
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
    /**
     * registrarse añade un nuevo usuario al archivo y al arraylist
     * @throws IOException si no encuentra el archivo de usuarios
     * */
    public void registrarse() throws IOException {
        //TODO comprobar que el usuario nuevo no existe. IDEA: hacer un metodo validarUsuario+
        //TODO simplificar metodo
        String usuario;
        String passwd;
        String confirmarPasswd;
        try {
            FileWriter fw = new FileWriter(fich, true);
            System.out.print("Nombre de usuario: ");
            usuario = sc.nextLine();
            do {
                System.out.print("Contraseña: ");
                passwd = sc.nextLine();
                System.out.print("Introduce nuevamente tu contraseña: ");
                confirmarPasswd = sc.nextLine();
                if (!passwd.equals(confirmarPasswd)){
                    System.out.println("Las contraseñas no coinciden. Vuelvelo a intentar");
                }
            } while (!passwd.equals(confirmarPasswd));

            System.out.println("Tu usuario será: " + usuario);
            System.out.println("Y tu contraseña será: " + passwd);
            System.out.print("¿Estas de acuerdo? (si/no) ");
            String respuesta = sc.nextLine();

            //TODO mejor poner valores numericos en el switch
            switch (respuesta.toUpperCase()) {
                case "SI":
                    System.out.println("¡Usuario añadido!\n");
                    usuarios.add(new Usuario(usuario, passwd));
                    StringBuilder sb = new StringBuilder();
                    sb.append("\n").append(usuario).append(";").append(passwd);
                    fw.write(sb.toString());
                    fw.close();
                    break;
                case "NO":
                    System.out.println("Ha seleccionado no. El sistema se volverá a iniciar...");
                    break;
                default:
                    System.out.println("Valor incorrecto. El sistema se volverá a iniciar...");
            }
        } catch (IOException e) {
            LOGGER.error("registrarse");
            throw e;
        }
    }
}
