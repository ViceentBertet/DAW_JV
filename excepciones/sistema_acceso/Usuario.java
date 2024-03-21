package excepciones.sistema_acceso;

import java.time.LocalDateTime;

public class Usuario {
    private String nom;
    private String passwd;
    private int nInicios = 0;
    private LocalDateTime ultimoInicio;
    public Usuario(String usuario, String contra) {
        nom = usuario;
        passwd = contra;
    }
    public Usuario(String usuario, String contra, int nInicios) {
        this(usuario, contra);
        setnInicios(nInicios);
    }
    public String getNom() {
        return nom;
    }
    public String getPasswd() {
        return passwd;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    public int getnInicios() {
        return nInicios;
    }
    public void nuevoInicio(){
        nInicios++;
    }

    public void setnInicios(int nInicios) throws IllegalArgumentException{
        if (nInicios < 0) {
            throw new IllegalArgumentException();
        }
        this.nInicios = nInicios;
    }

    public void setUltimoInicio(LocalDateTime fecha){
        ultimoInicio = fecha;
    }
    public LocalDateTime getUltimoInicio(){
        return ultimoInicio;
    }

}
