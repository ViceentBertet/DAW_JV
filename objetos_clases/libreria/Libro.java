package objetos_clases.libreria;

public class Libro {
    private int isbn;
    private String titulo;
    private String autor;
    private int nPag;

    public Libro(int isbn, String titulo, String autor, int nPag) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.nPag = nPag;
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
    public int getnPag() {
        return nPag;
    }
}
