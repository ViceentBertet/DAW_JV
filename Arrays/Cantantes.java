package Arrays;

import java.util.Scanner;

public class Cantantes {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("¿Cuantos cantantes quieres mostrar? ");
        int nSingers = sc.nextInt();
        sc.nextLine();

        String [] singers = new String[nSingers];

        saveSingers(singers);
        showSingers(singers);

        sc.close();
    }
    public static void saveSingers(String[] singers) {
        for (int i = 0; i < singers.length; i++) {
            int qSingers = singers.length - i;
            System.out.printf("Introduce tu cantante: (faltan %d): ", qSingers);
            singers[i] = sc.nextLine();
        }
        System.out.println("Los cantantes se han introducido todos los datos correctamente");
    }

    public static void showSingers(String[] singers) {
        System.out.printf("Tus %d cantantes son: ", singers.length);
        for (String name : singers) {
            if (!name.equals(singers[singers.length - 1])) {
                System.out.print(name + ", ");
            } else {
                System.out.print(name + ".");
            }
        }
    }
}
