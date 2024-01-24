package objetos_clases.gestion_biblioteca;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> libros;
    private ArrayList<Usuario> usuarios;
    public Biblioteca() {
        this.libros = crearLibros();
        this.usuarios = crearUsuarios();
    }
    private ArrayList<Libro> crearLibros() {
        ArrayList<Libro> libros = new ArrayList<>();
        Libro libro1 = new Libro(1000, "Peter Pan", "James Matthew");
        Libro libro2 = new Libro(2000, "Moby Dick", "Herman Melville");
        Libro libro3 = new Libro(3000, "Hamlet", "William Shakespeare");
        Libro libro4 = new Libro(4000, "Yo, robot", "Isaac Asimov");
        Libro libro5 = new Libro(5000, "Ulises", "James Joyce");
        Libro libro6 = new Libro(6000, "El Principito", "Antoine de Saint-Exupéry");

        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);
        libros.add(libro4);
        libros.add(libro5);
        libros.add(libro6);

        return libros;
    }
    private ArrayList<Usuario> crearUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Usuario usu1 = new Usuario("Vicent05","1234");
        Usuario usu2 = new Usuario("Alex00","asdf");
        Usuario usu3 = new Usuario("Jordi03","0987");

        usuarios.add(usu1);
        usuarios.add(usu2);
        usuarios.add(usu3);

        return usuarios;
    }
    public ArrayList<Libro> getLibros() {
        return libros;
    }
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    public int validarUsuario(String user, String passwd){
        int validar = -1;

        for ( Usuario usuario : usuarios) {
            if (usuario.getUser().equals(user)) {
              if(usuario.getPasswd().equals(passwd)) {
                  validar = 0;
              }
            }
        }

        return validar;
    }
    public int prestarLibro(String user) {
        int contador = 0;
        int validarError = 0;
        for (Usuario usuario : usuarios) {
            if (usuario.getUser().equals(user)) {
                break;
            }
            contador++;
        }
        if (usuarios.get(contador).getPrestado() != null) {
            validarError = -1;
        }
        return validarError;
    }
    public int depositarLibro(String user) {
        return 1;
    }
}
