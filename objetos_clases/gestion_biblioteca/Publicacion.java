package objetos_clases.gestion_biblioteca;

public class Publicacion extends Articulo{
    private final boolean isPrestable = Boolean.TRUE;
    public Publicacion(int isbn, String titulo, String autor) {
        super(isbn, titulo, autor);
    }
    public boolean isPrestable() {
        return isPrestable;
    }
}
