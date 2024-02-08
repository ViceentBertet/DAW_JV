package objetos_clases.gestion_biblioteca;

public class Revista extends Articulo {
    private final boolean isPrestable = Boolean.FALSE;
    public Revista(int isbn, String titulo, String autor) {
        super(isbn, titulo, autor);
    }

    public boolean isPrestable() {
        return isPrestable;
    }
}
