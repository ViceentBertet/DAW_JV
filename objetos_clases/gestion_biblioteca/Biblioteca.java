package objetos_clases.gestion_biblioteca;

import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;

public class Biblioteca {
    private static final int ERROR = -1;
    private static final int OK = 0;
    private ArrayList<Articulo> articulos;
    private ArrayList<Usuario> usuarios;
    public Biblioteca() {
        this.articulos = crearArticulos();
        this.usuarios = crearUsuarios();
    }
    private ArrayList<Articulo> crearArticulos() {
        ArrayList<Articulo> articulos = new ArrayList<>();
        Articulo libro1 = new Libro(1000, "Peter Pan", "James Matthew");
        Articulo libro2 = new Libro(2000, "Moby Dick", "Herman Melville");
        Articulo libro3 = new Libro(3000, "Hamlet", "William Shakespeare");
        Articulo libro4 = new Libro(4000, "Yo, robot", "Isaac Asimov");
        Articulo libro5 = new Libro(5000, "Ulises", "James Joyce");
        Articulo libro6 = new Libro(6000, "El Principito", "Antoine de Saint-Exupéry");

        Articulo publicacion = new Publicacion(1000, "Madrid vs Barça 2-6", "Pep Guardiola");
        articulos.add(libro1);
        articulos.add(libro2);
        articulos.add(libro3);
        articulos.add(libro4);
        articulos.add(libro5);
        articulos.add(libro6);

        return articulos;
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
    public ArrayList<Articulo> getArticulos() {
        return articulos;
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
    public void mostrarArticulo() {
        int contador = 1;
        for (Articulo articulo : articulos) {
            System.out.println("\nLIBRO " + contador);
            System.out.println("\tISBN: " + articulo.getIsbn());
            System.out.println("\tNombre: " + articulo.getTitulo());
            System.out.println("\tAutor: " + articulo.getAutor());
            contador++;
        }
    }
    public int obtenerLibro(String  buscar) {
        int contador = 0;
        for (Articulo articulo : articulos) {
            if (articulo.getTitulo().equals(buscar)) {
                break;
            }
            contador++;
        }

        if (contador >= articulos.toArray().length) {
            try {
                int buscarIsbn = Integer.parseInt(buscar);
                contador = 0;
                for (Articulo articulo : articulos) {
                    if (articulo.getIsbn() == buscarIsbn) {
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
    public int comprobarLibro(int indexPrestado) {
        int libroPrestado = OK;
        for (Usuario usuario : usuarios) {
            if (usuario.getPrestado() != null && usuario.getPrestado().equals(articulos.get(indexPrestado))) {
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
        usuarios.get(indiceUsuario).setPrestado(articulos.get(indiceLibro));
    }

    // Metodos para depositar articulo
    public int depositarArticulo(String user) {
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
