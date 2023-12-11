package AmbitoVariable;

import java.util.Scanner;

public class CalculadoraSobrecargada {
    static Scanner sc = new Scanner(System.in);

    public static void main(){
        System.out.println("**Calculadora**\n");



        sc.close();
    }
    public static void operacion() {
        System.out.println("Que operacion quieres realizar? 1. Suma 2.Resta 3. Multiplicación 4. División");
        int operacion = sc.nextInt();
    }
}
