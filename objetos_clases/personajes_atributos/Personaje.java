package objetos_clases.personajes_atributos;

public class Personaje {
    private String nombre;
    private String arma1;
    private String arma2;
    private String escudo;
    private String torso;
    private String accesorio1;
    private String accesorio2;

    public Personaje(String nombre, String arma1, String arma2, String escudo, String torso, String accesorio1, String accesorio2) {
        this.nombre = nombre;
        this.arma1 = arma1;
        this.arma2 = arma2;
        this.escudo = escudo;
        this.torso = torso;
        this.accesorio1 = accesorio1;
        this.accesorio2 = accesorio2;
    }

    public String getNombre() {
        return nombre;
    }

    public String getArma1() {
        return arma1;
    }

    public String getArma2() {
        return arma2;
    }

    public String getEscudo() {
        return escudo;
    }

    public String getTorso() {
        return torso;
    }

    public String getAccesorio1() {
        return accesorio1;
    }

    public String getAccesorio2() {
        return accesorio2;
    }
}
