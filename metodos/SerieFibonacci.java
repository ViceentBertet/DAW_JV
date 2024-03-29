package metodos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SerieFibonacci {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el n que quieres ver de la serie de Fibonacci");
        try {
            int[] array = new int[sc.nextInt()];
            saveFibonacci(array);
            showFibonacci(array);
        } catch (InputMismatchException e){
            System.out.println("Se debe introducir un valor numerico");
        }

    }
    public static void saveFibonacci(int[] n){
        int anterior = 0;
        int actual = 1;
        for (int i = 0; i < n.length; i++) {
            n[i]= actual + anterior;

            anterior = actual;
            actual = n[i];
        }
    }
    public static void showFibonacci(int[] array){
        for (int n: array) {
            System.out.print(n + " ");
        }
    }
}
