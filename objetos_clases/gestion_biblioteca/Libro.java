package objetos_clases.gestion_biblioteca;

public class Libro extends Articulo {
    private final boolean isPrestable = Boolean.TRUE;
    public Libro(int isbn, String titulo, String autor) {
        super(isbn, titulo, autor);
    }

    public boolean isPrestable() {
        return isPrestable;
    }
}
