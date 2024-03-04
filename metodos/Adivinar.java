package metodos;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Adivinar {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int length = 10;
        int[] array = new int[length];
        try {
            System.out.print("Introduce de que tamaño quieres el vector (pred=10): ");
            length= sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Se debe de introducir un valor numerico");
        }

        if (length > 0) {
            array = new int[length];
        } else {
            System.out.println("ERROR: El numero debe ser positivo. Se ha establecido 10 como longitud.");
        }
        fillArray(array);

        try {
            System.out.print("Escriba el n final que quiere que coincida: ");
            int numMatch = sc.nextInt();

            int numFinal = numMatch(numMatch);
            findMatch(numFinal, array);
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Se debe de introducir un valor numerico");
        }

    }
    public static void fillArray(int [] array){
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(300) + 1;
        }
        System.out.println("\n" + Arrays.toString(array) + "\n");
    }
    public static int numMatch(int nFinal) throws InputMismatchException{
        boolean flag = true;
        while (flag) {
            if (nFinal - 10 > 0) {
                System.out.print("ERROR: Solo puede tener un digito. Vuelve a introducir: ");
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
                System.out.printf("Se ha encontrado el %d\n", i);
                encontrado++;
            }
        }
        if (encontrado == 0) {
            System.out.println("No se ha encontrado ninguna coincidencia");
        }
    }
}
