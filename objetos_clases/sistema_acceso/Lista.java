package objetos_clases.sistema_acceso;

import java.util.Vector;

public class Lista {
    private static Vector<Usuario> datos = new Vector<Usuario>();

    public static void anyadir(Usuario obj) {
        datos.addElement(obj);
    }
    public static void eliminar(int pos) {
        datos.removeElement(pos);
    }
    public static Vector mostrar() {
        return datos;
    }
}
