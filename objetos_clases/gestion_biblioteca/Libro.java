package objetos_clases.gestion_biblioteca;

public class Libro {
    private int isbn;
    private String titulo;
    private String autor;

    public Libro(int isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
    }

    public int getIsbn() {
        return isbn;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
}
