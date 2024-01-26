package objetos_clases.gestion_biblioteca;

import java.util.List;
import java.util.Objects;

public class Articulo {
    private int isbn;
    private String titulo;

    // Crear lista de autores
    private String autor;
    //Crear boolean se puede prestar
    public Articulo(int isbn, String titulo, String autor) {
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Articulo articulo = (Libro) o;
        return isbn == articulo.isbn && Objects.equals(titulo, articulo.titulo) && Objects.equals(autor, articulo.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, titulo, autor);
    }
}
