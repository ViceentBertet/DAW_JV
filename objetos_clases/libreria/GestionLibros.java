package objetos_clases.libreria;


import java.util.Scanner;

public class GestionLibros {
    private static final Libro[] libro = new Libro[6];
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        libro[0] = new Libro(1000, "Peter Pan", "James Matthew", 504);
        libro[1] = new Libro(2000, "Moby Dick", "Herman Melville", 823);
        libro[2] = new Libro(3000, "Hamlet", "William Shakespeare", 320);
        libro[3] = new Libro(4000, "Yo, robot", "Isaac Asimov", 328);
        libro[4] = new Libro(5000, "Ulises", "James Joyce", 854);
        libro[5] = new Libro(6000, "El Principito", "Antoine de Saint-Exupéry", 92);

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
        for(int i = 0; i < libro.length; i++) {
            if (libro[i].getIsbn() == isbn) {
                position = i;
            }
        }
        return position;
    }
    public static int findTitle(String title) {
        int position = -1;
        for(int i = 0; i < libro.length; i++) {
            if (libro[i].getTitulo().equalsIgnoreCase(title)) {
                position = i;
            }
        }
        return position;
    }
    public static void showInformation(int pos) {
        System.out.println("\n\tISBN: " + libro[pos].getIsbn());
        System.out.println("\tTítulo: " + libro[pos].getTitulo());
        System.out.println("\tAutor: " + libro[pos].getAutor());
        System.out.println("\tNumero de paginas: " + libro[pos].getnPag());
    }
}
