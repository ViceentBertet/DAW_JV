package metodos_dam;

import java.util.Scanner;

public class BusquedaArrays {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        final int WORDS = 5;
        String[] palabras = new String[WORDS];
        readWords(palabras);
        findWords(palabras);

        sc.close();
    }
    public static void readWords(String[] palabras) {
        System.out.println("Introduce 5 palabras: ");

        for (int i = 0; i < palabras.length;i++){
            palabras[i] = sc.next();
        }
    }
    public static void findWords(String[] palabras){
        System.out.println("Introduce la palabra que quieres buscar");
        String buscar = sc.next();
        int posicion = -1;
        for (int i = 0; i < palabras.length;i++){
            if (buscar.equalsIgnoreCase(palabras[i])) {
                posicion = i;
                break;
            }
        }
        if (posicion != -1) {
            System.out.printf("La palabra %s estaba en la posicion %d", buscar, posicion);
        } else {
            System.out.println("No se ha encontrado la palabra");
        }
    }

}
