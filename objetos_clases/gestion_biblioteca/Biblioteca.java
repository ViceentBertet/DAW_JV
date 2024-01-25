package objetos_clases.gestion_biblioteca;

import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;

public class Biblioteca {
    private static final int ERROR = -1;
    private static final int OK = 0;
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
        Usuario usu1 = new Usuario("Vicent05","240105");
        Usuario usu2 = new Usuario("Raquel04","060604");
        Usuario usu3 = new Usuario("Sergi04","210704");

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
        int validar = ERROR;

        for ( Usuario usuario : usuarios) {
            if (usuario.getUser().equals(user)) {
              if(usuario.getPasswd().equals(passwd)) {
                  validar = OK;
                  break;
              }
            }
        }

        return validar;
    }

    // Metodos para prestar libro
    public int tienePrestado(String user) {
        int contador = 0;
        int validarError = OK;
        for (Usuario usuario : usuarios) {
            if (usuario.getUser().equals(user)) {
                break;
            }
            contador++;
        }
        if (usuarios.get(contador).getPrestado() != null) {
            validarError = ERROR;
        }
        return validarError;
    }
    public void mostrarLibros() {
        int contador = 1;
        for (Libro libro : libros) {
            System.out.println("\nLIBRO " + contador);
            System.out.println("\tISBN: " + libro.getIsbn());
            System.out.println("\tNombre: " + libro.getTitulo());
            System.out.println("\tAutor: " + libro.getAutor());
            contador++;
        }
    }
    public int obtenerLibro(String  buscar) {
        int contador = 0;
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(buscar)) {
                break;
            }
            contador++;
        }

        if (contador >= libros.toArray().length) {
            try {
                int buscarIsbn = Integer.parseInt(buscar);
                contador = 0;
                for (Libro libro : libros) {
                    if (libro.getIsbn() == buscarIsbn) {
                        break;
                    }
                    contador++;
                }
            } catch (NumberFormatException e){
                contador = ERROR;
            }
        }
        return contador;
    }
    public int comprobarLibro(int indexLibro) {
        int libroPrestado = OK;
        for (Usuario usuario : usuarios) {
            if (usuario.getPrestado() != null && usuario.getPrestado().equals(libros.get(indexLibro))) {
                libroPrestado = ERROR;
                break;
            }
        }
        return libroPrestado;
    }
    public void prestarLibro(int indiceLibro, String user) {
        int indiceUsuario = 0;
        for (Usuario usuario : usuarios) {
            if (usuario.getUser().equals(user)) {
                break;
            }
            indiceUsuario++;
        }
        usuarios.get(indiceUsuario).setPrestado(libros.get(indiceLibro));
    }

    // Metodos para depositar libro
    public int depositarLibro(String user) {
        int contieneLibro = 0;
        int indiceUser = 0;
        for (Usuario usuario : usuarios) {
            if (usuario.getUser().equals(user)) {
                break;
            }
            indiceUser++;
        }
        if (usuarios.get(indiceUser).equals(null)) {
            contieneLibro = -1;
        } else {
            usuarios.get(indiceUser).setPrestado(null);
        }
        return contieneLibro;
    }
}
