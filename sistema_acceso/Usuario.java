package sistema_acceso;

public class Usuario {
    private String nom;
    private String passwd;

    public String getNom() {
        return nom;
    }
    public String getPasswd() {
        return passwd;
    }
    public Usuario(String Usuario, String contra) {
        nom = Usuario;
        passwd = contra;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
}
