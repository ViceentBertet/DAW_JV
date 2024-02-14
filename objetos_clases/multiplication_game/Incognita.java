package objetos_clases.multiplication_game;

import java.util.Objects;

public class Incognita {
    private String tipo;
    private String texto;
    //CONSTRUCTORES
    public Incognita() {
    }
    public Incognita(String tipo, String texto) {
        this.tipo = tipo;
        this.texto = texto;
    }

    //GETTERS & SETTERS
    public String getTipo() {
        return tipo;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    //METODOS

    /**
     * Compara el texto de la incognita
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Incognita incognita = (Incognita) o;
        return Objects.equals(texto, incognita.texto);
    }
    @Override
    public int hashCode() {
        return Objects.hash(texto);
    }

    @Override
    public String toString() {
        return "Incognita{" +
                "tipo='" + tipo  +
                ", texto='" + texto  +
                '}';
    }
}
