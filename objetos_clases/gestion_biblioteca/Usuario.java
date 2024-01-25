package objetos_clases.gestion_biblioteca;

public class Usuario {
    private String user;
    private String passwd;
    private Articulo prestado;

    public Usuario(String user, String passwd) {
        this.user = user;
        this.passwd = passwd;
    }

    public Articulo getPrestado() {
        return prestado;
    }
    public void setPrestado(Articulo prestado) {
        this.prestado = prestado;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getPasswd() {
        return passwd;
    }
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
