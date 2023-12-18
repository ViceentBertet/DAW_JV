package ArrayList_VarArgs;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaStrings {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("**ADMINISTRADOR DE LISTAS**");
        ArrayList<String> list = new ArrayList<>();
        createList(list);
        menu(list);
    }
    public static void createList(ArrayList<String> list){
        final String finish = "terminar";
        boolean exit = false;

        System.out.println("Introducir elementos a la lista, si quieres terminar, introduce /terminar/: ");
        while(!exit) {
            list.add(sc.next());

            for (int i = 0; i < list.size(); i++) {
                if(finish.equalsIgnoreCase(list.get(i))) {
                    exit = true;
                    list.remove(list.get(i));

                    System.out.println("Has introducido terminar");

                }
            }
        }
    }
    public static void menu(ArrayList<String> list) {
        boolean exit = false;

        System.out.println("MENU DE MANIPULACIÓN DE LISTA\n");
        System.out.println("\tIntroduzca 1 para mostrar la lista");
        System.out.println("\tIntroduzca 2 para agregar elementos");
        System.out.println("\tIntroduzca 3 para buscar elemento");
        System.out.println("\tIntroduzca 4 para eliminar elemento");
        System.out.println("\tIntroduzca 5 para modificar elemento");
        System.out.println("\tIntroduzca 6 para limpiar la lista");
        System.out.println("\tIntroduzca 7 para ordenar la lista");
        System.out.println("\tIntroduzca 8 para salir del programa");

        while (!exit) {
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Ha seleccionado mostrar la lista");
                    showList(list);
                    System.out.print("\nIntroduce lo que quieres hacer ahora: ");
                    break;
                case 2:
                    System.out.println("Ha seleccionado agregar elementos");
                    createList(list);
                    System.out.print("\nIntroduce lo que quieres hacer ahora: ");
                    break;
                case 3:
                    System.out.println("Ha seleccionado buscar la lista");
                    findInList(list);
                    System.out.print("\nIntroduce lo que quieres hacer ahora: ");
                    break;
                case 4:
                    System.out.println("Ha seleccionado eliminar elemento");

                    System.out.print("\nIntroduce lo que quieres hacer ahora: ");
                    break;
                case 5:
                    System.out.println("Ha seleccionado modificar elemento");

                    System.out.print("\nIntroduce lo que quieres hacer ahora: ");
                    break;
                case 6:
                    System.out.println("Ha seleccionado limpiar la lista");

                    System.out.print("\nIntroduce lo que quieres hacer ahora: ");
                    break;
                case 7:
                    System.out.println("Ha seleccionado ordernar la lista");

                    System.out.print("\nIntroduce lo que quieres hacer ahora: ");
                    break;
                case 8:
                    System.out.println("Ha seleccionado salir del programa");

                    exit = true;
                    break;
                default:
                    System.out.print("ERROR: Valor no comprendido. Vuelve a introducir:");
            }
        }
    }
    public static void showList(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                System.out.print(list.get(i) + ", ");
            } else {
                System.out.print(list.get(i));
            }
        }
    }
    public static void findInList(ArrayList<String> list) {
        System.out.println("Introduce como quieres buscar el elemento.");
        System.out.println("\tIntroduzca 1 para buscar por el valor introducido");
        System.out.println("\tIntroduzca 2 para buscar con el indice de la lista");
        int n = sc.nextInt();

        if (n == 1) {
            System.out.println("Has seleccionado buscar por el valor introducido");
        }else if (n == 2) {
            System.out.println("Has seleccionado buscar con el indice de la lista");
        } else {
            System.out.print("ERROR: Valor no comprendido. Vuelve a introducir:");
        }

    }
}
