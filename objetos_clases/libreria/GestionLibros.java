package objetos_clases.libreria;


import java.util.Scanner;

public class GestionLibros {
    private static final Libro[] LIBRO = new Libro[6];
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        LIBRO[0] = new Libro(1000, "Peter Pan", "James Matthew", 504);
        LIBRO[1] = new Libro(2000, "Moby Dick", "Herman Melville", 823);
        LIBRO[2] = new Libro(3000, "Hamlet", "William Shakespeare", 320);
        LIBRO[3] = new Libro(4000, "Yo, robot", "Isaac Asimov", 328);
        LIBRO[4] = new Libro(5000, "Ulises", "James Joyce", 854);
        LIBRO[5] = new Libro(6000, "El Principito", "Antoine de Saint-Exupéry", 92);

        boolean repetir;
        int nLibro = -1;

        System.out.print("¿De que forma le gustaría buscar el libro que desea, con su isbn o con el titulo (1/2)? ");
        do {
            repetir = false;
            int opcion = sc.nextInt();

            if (1 == opcion) {
                System.out.print("Introduce el isbn del libro que quieres buscar: ");
                int isbn = sc.nextInt();
                nLibro = findISBN(isbn);
            } else if (2 == opcion) {
                sc.nextLine();
                System.out.print("Introduce el titulo del libro que quieres buscar: ");
                String title = sc.nextLine();
                nLibro = findTitle(title);
            } else {
                System.out.print("ERROR. Debe de introducir 1 o 2. Vuelve a intentarlo:");
                repetir = true;
            }
        } while (repetir);

        if (nLibro == -1) {
            System.out.println("ERROR. No se ha encontrado el libro. Cerrando el programa...");
        } else {
            showInformation(nLibro);
        }
        sc.close();
    }
    public static int findISBN(int isbn) {
        int position = -1;
        for(int i = 0; i < LIBRO.length; i++) {
            if (LIBRO[i].getIsbn() == isbn) {
                position = i;
            }
        }
        return position;
    }
    public static int findTitle(String title) {
        int position = -1;
        for(int i = 0; i < LIBRO.length; i++) {
        if (LIBRO[i].getTitulo().equalsIgnoreCase(title)) {
                position = i;
            }
        }
        return position;
    }
    public static void showInformation(int pos) {
        System.out.println("\n\tISBN: " + LIBRO[pos].getIsbn());
        System.out.println("\tTítulo: " + LIBRO[pos].getTitulo());
        System.out.println("\tAutor: " + LIBRO[pos].getAutor());
        System.out.println("\tNumero de paginas: " + LIBRO[pos].getnPag());
    }
}
