package excepciones.sistema_acceso;

import java.time.LocalDateTime;
import java.util.Objects;

public class Usuario {
    private String nom;
    private String passwd;
    private int nInicios = 0;
    private LocalDateTime ultimoInicio;
    /**
     * Usuario crea un usuario
     * @param usuario Nombre del usuario
     * @param contra Constraseña del usuario
     * @throws IllegalArgumentException Si contiene un ;
     * */
    public Usuario(String usuario, String contra) throws IllegalArgumentException{
        setNom(usuario);
        setPasswd(contra);
    }
    /**
     * Usuario crea un usuario
     * @param usuario Nombre del usuario
     * @param contra Constraseña del usuario
     * @param nInicios Numero de inicios
     * @throws IllegalArgumentException nInicios no puede ser menor a 0 y nombre o contraseña contienen un ;
     * */
    public Usuario(String usuario, String contra, int nInicios) throws IllegalArgumentException {
        this(usuario, contra);
        try {
            setnInicios(nInicios);
        } catch (IllegalArgumentException e) {
            throw e;
        }

    }
    /**
     * getNom devuelve el nombre de usuario
     * @return nom
     * */
    public String getNom() {
        return nom;
    }
    /**
     * getPasswd devuelve la contraseña
     * @return passwd
     * */
    public String getPasswd() {
        return passwd;
    }
    /**
     * setNom establece el nombre de usuario
     * @param nom nuevo nombre
     * @throws IllegalArgumentException Si contiene un ;
     * */
    public void setNom(String nom) throws IllegalArgumentException {
        for (int i = 0; i < nom.length(); i++){
            if (nom.charAt(i) == ';') {
                throw new IllegalArgumentException();
            }
        }
        this.nom = nom;
    }
    /**
     * setPasswd establece la contraseña
     * @param passwd nueva contraseña
     * @throws IllegalArgumentException Si contiene un ;
     * */
    public void setPasswd(String passwd) {
        for (int i = 0; i < passwd.length(); i++){
            if (passwd.charAt(i) == ';') {
                throw new IllegalArgumentException();
            }
        }
        this.passwd = passwd;
    }
    /**
     * getnInicios devuelve el nombre de Inicios
     * @return nInicios
     * */
    public int getnInicios() {
        return nInicios;
    }
    /**
     * nuevoInicio Aumenta el nInicios una vez
     * */
    public void nuevoInicio(){
        nInicios++;
    }
    /**
     * setnInicios establece el n de inicios
     * @param nInicios numero de veces que el usuario se ha iniciado
     * @throws IllegalArgumentException El argumento no puede ser menor a 0
     * */
    public void setnInicios(int nInicios) throws IllegalArgumentException{
        if (nInicios < 0) {
            throw new IllegalArgumentException();
        }
        this.nInicios = nInicios;
    }
    /**
     * setUltimoInicio establece la fecha del ultimo inicios de sesión del usuario
     * @param fecha nuevo inicio de sesión
     * */
    public void setUltimoInicio(LocalDateTime fecha){
        ultimoInicio = fecha;
    }
    /**
     * getUltimoInicio devuelve la fecha del ultimo inicio de sesión
     * @return ultimoInicio
     * */
    public LocalDateTime getUltimoInicio(){
        return ultimoInicio;
    }
    /**
     * equals compara usuarios
     * @return boolean
     * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nom, usuario.nom) && Objects.equals(passwd, usuario.passwd);
    }
    /**
     * hashcode
     * @return hashcode
     * */
    @Override
    public int hashCode() {
        return Objects.hash(nom, passwd);
    }
}
