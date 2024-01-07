package SistemaAcceso;

import java.util.Vector;

public class Usuario {
    private String nom;
    private String passwd;

    public String getNom() {
        return nom;
    }
    public String getPasswd() {
        return passwd;
    }
    Usuario(String Usuario, String contra) {
        nom = Usuario;
        passwd = contra;
    }
}
