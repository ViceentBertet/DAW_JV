package metodos;

import java.util.Scanner;

public class Adivinar {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Introduce de que tamaño quieres el vector");
        int length = sc.nextInt();

        int[] array = new int[length];
        fillArray(array);

        System.out.println("Escriba el n final que quiere que coincida");
        int numMatch = sc.nextInt();

        int numFinal = numMatch(numMatch);
        findMatch(numFinal, array);

    }
    public static void fillArray(int [] array){
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.floor(Math.random() * 300) + 1;
        }
    }
    public static int numMatch(int nFinal){
        boolean flag = true;
        while (flag) {
            if (nFinal - 10 > 0) {
                System.out.println("ERROR: Solo puede tener un digito. Vuelve a introducir: ");
                nFinal = sc.nextInt();
            } else {
                flag = false;
            }
        }
        return nFinal;
    }
    public static void findMatch(int numMatch, int[] Array){
        int encontrado = 0;
        for (int i : Array) {
            if ((i - numMatch) % 10 == 0) {
                System.out.printf("Se ha encontrado %d\n", i);
                encontrado++;
            }
        }
        if (encontrado == 0) {
            System.out.println("No se ha encontrado ninguna coincidencia");
        }
    }
}
