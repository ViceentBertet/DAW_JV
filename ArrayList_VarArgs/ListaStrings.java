package ArrayList_VarArgs;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaStrings {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args){
        System.out.println("**ADMINISTRADOR DE LISTAS**\n");

        createList();
        menu();
    }
    public static void createList(){
        final String finish = "terminar";
        boolean exit = false;

        System.out.println("Introducir elementos a la lista, si quieres terminar, introduce /terminar/: ");
        while(!exit) {
            list.add(sc.next().toLowerCase());

            for (int i = 0; i < list.size(); i++) {
                if(finish.equalsIgnoreCase(list.get(i))) {
                    exit = true;
                    list.remove(list.get(i));

                    System.out.println("Has introducido terminar");

                }
            }
        }
    }
    public static void menu() {
        boolean exit = false;

        System.out.println("\nMENU DE MANIPULACIÓN DE LISTA\n");
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
                    showList();
                    System.out.print("\nIntroduce lo que quieres hacer ahora: ");
                    break;
                case 2:
                    System.out.println("Ha seleccionado agregar elementos");
                    createList();
                    System.out.print("\nIntroduce lo que quieres hacer ahora: ");
                    break;
                case 3:
                    System.out.println("Ha seleccionado buscar la lista");
                    findInList();
                    System.out.print("\nIntroduce lo que quieres hacer ahora: ");
                    break;
                case 4:
                    System.out.println("Ha seleccionado eliminar elemento");
                    deleteInList();
                    System.out.print("\nIntroduce lo que quieres hacer ahora: ");
                    break;
                case 5:
                    System.out.println("Ha seleccionado modificar elemento");
                    modifyInList();
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
    public static void showList() {
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                System.out.print(list.get(i) + ", ");
            } else {
                System.out.print(list.get(i));
            }
        }
    }
    public static void findInList() {
        System.out.println("Introduce como quieres buscar el elemento.");
        System.out.println("\tIntroduzca 1 para buscar por el valor introducido");
        System.out.println("\tIntroduzca 2 para buscar con el indice de la lista");
        int n = sc.nextInt();

        if (n == 1) {
            System.out.println("Has seleccionado buscar por el valor introducido");
            System.out.print("Introduce el valor a buscar: ");
            String buscar = sc.next().toLowerCase();

            if (!list.contains(buscar)) {
                System.out.println("Valor no encontrado");
            } else {
                System.out.println("La palabra" + buscar + " esta en la posición " + list.indexOf(buscar));
            }
        }else if (n == 2) {
            System.out.println("Has seleccionado buscar con el indice de la lista");
            System.out.print("Introduce el valor a buscar: ");
            int buscar = sc.nextInt();

            if (buscar >= list.size()) {
                System.out.println("El indice esta fuera de la lista");
            } else {
                System.out.println("La palabra" + list.get(buscar) + " esta en la posición " + buscar);
            }
        } else {
            System.out.print("ERROR: Valor no comprendido. Vuelve a introducir:");
        }
    }
    public static void deleteInList() {
        System.out.println("Introduce como quieres eliminar el elemento.");
        System.out.println("\tIntroduzca 1 para eliminar por el valor introducido");
        System.out.println("\tIntroduzca 2 para eliminar con el indice de la lista");
        int n = sc.nextInt();

        if (n == 1) {
            System.out.println("Has seleccionado eliminar por el valor introducido");
            System.out.print("Introduce el valor a eliminar: ");
            String buscar = sc.next().toLowerCase();

            if (!list.contains(buscar)) {
                System.out.println("Valor no encontrado");
            } else {
                list.remove(buscar);
            }
        }else if (n == 2) {
            System.out.println("Has seleccionado eliminar con el indice de la lista");
            System.out.print("Introduce el valor a eliminar: ");
            int buscar = sc.nextInt();

            if (buscar >= list.size()) {
                System.out.println("El indice esta fuera de la lista");
            } else {
                list.remove(buscar);
            }
        } else {
            System.out.print("ERROR: Valor no comprendido. Vuelve a introducir:");
        }
    }
    public static void modifyInList() {
        System.out.println("Introduce como quieres eliminar el elemento.");
        System.out.println("\tIntroduzca 1 para eliminar por el valor introducido");
        System.out.println("\tIntroduzca 2 para eliminar con el indice de la lista");
        int n = sc.nextInt();

        if (n == 1) {
            System.out.println("Has seleccionado eliminar por el valor introducido");
            System.out.print("Introduce el valor a eliminar: ");
            String buscar = sc.next().toLowerCase();

            if (!list.contains(buscar)) {
                System.out.println("Valor no encontrado");
            } else {
                list.remove(buscar);
            }
        }else if (n == 2) {
            System.out.println("Has seleccionado eliminar con el indice de la lista");
            System.out.print("Introduce el valor a eliminar: ");
            int buscar = sc.nextInt();

            if (buscar >= list.size()) {
                System.out.println("El indice esta fuera de la lista");
            } else {
                list.remove(buscar);
            }
        } else {
            System.out.print("ERROR: Valor no comprendido. Vuelve a introducir:");
        }
    }
}
