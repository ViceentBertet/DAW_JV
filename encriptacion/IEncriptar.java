package encriptacion;

import java.io.File;

public interface IEncriptar {
    void encriptar(File fich, String palabra);
    void desencriptar(File fich, String palabra);
}
