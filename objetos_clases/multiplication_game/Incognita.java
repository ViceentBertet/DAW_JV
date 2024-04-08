package objetos_clases.multiplication_game;

import java.util.Objects;

public class Incognita {
    private String texto;
    //CONSTRUCTORES
    public Incognita(String texto) {
        this.texto = texto;
    }
    public String getTipo() {
        String clase = getClass().toString();
        String tipo = "Incognita";
        for (int i = clase.length() - 1; i > 0; i--) {
            if(clase.charAt(i) == '.') {
                tipo = clase.substring(i + 1);
                break;
            }
        }
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
                "tipo='" + this.getClass()  +
                ", texto='" + texto  +
                '}';
    }
}
