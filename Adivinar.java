import java.util.Scanner;

public class Adivinar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean flag = true
        System.out.println("Introduce de que tamaño quieres el vector");
        int length = sc.nextInt();

        int[] array = new int[length];
        fillLength(array);

        System.out.println("Escriba el n final que quiere que coincida");
        while (flag == true) {
            int nFinal = sc.nextInt();
            if (nFinal - 10 < 0) {
                System.out.println("ERROR: Solo puede tener un digito. Vuelve a introducir");
            } else {
                flag = false;
            }
        }


    }
    public static void fillLength(int [] array){
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 300);
        }
    }
}
