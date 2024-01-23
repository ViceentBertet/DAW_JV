package objetos_clases.sistema_acceso;

import java.time.LocalTime;

public class Usuario {
    private String nom;
    private String passwd;
    private int nInicios = 0;
    private LocalTime ultimoInicio;

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
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    public int getnInicios() {
        return nInicios;
    }
    public void nInicioSesion(){
        nInicios++;
    }
    public void setUltimoInicio(LocalTime fecha){
        ultimoInicio = fecha;
    }
    public LocalTime getUltimoInicio(){
        return ultimoInicio;
    }
}
