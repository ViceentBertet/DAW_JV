package encriptacion;

import java.io.File;
import java.util.Scanner;

public class SistemaEncriptado implements IEncriptar{
    private Scanner sc;
    public SistemaEncriptado(Scanner sc) {
        this.sc = sc;
    }
    @Override
    public void encriptar(File fich) {
        System.out.print("Introduce la palabra para encriptar: ");
        String magica = sc.nextLine();
        System.out.print("Vuelvela a introducir para confirmar la palabra para encriptar: ");
        String confirmarMagica = sc.nextLine();
    }
    @Override
    public void desencriptar(File fich) {
        System.out.print("Introduce la palabra para desencriptar: ");
        String magica = sc.nextLine();
    }
}
