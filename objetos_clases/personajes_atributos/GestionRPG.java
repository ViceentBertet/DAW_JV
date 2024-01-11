package objetos_clases.personajes_atributos;

import java.util.Scanner;

public class GestionRPG {
    private static final Personaje[] p = new Personaje[2];
    private static final Estadistica[] e = new Estadistica[2];
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        p[0] = new Personaje("Finn el humano","Espada Dorada", "Espada corta","Escudo Plateado", "Ropa de Finn", "Gorro de Finn","Mochila de Finn");
        p[1] = new Personaje("Rey hielo", "Explosión de hielo","Cuchillas de hielo","Barricada de hielo","Ropa del Rey Hielo","Corona del Rey hielo","Osito de Marceline");
        e[0] = new Estadistica(55, 15, 23, 0, 35, 15, 75, 45, 5, 25);
        e[1] = new Estadistica(95, 35, 10, 45, 15, 75, 85, 32, 10, 20);

        int opcion;
        String seeStats;
        boolean repetir;

        for (int i = 0; i < p.length; i++) {
            int n = i + 1;
            System.out.println(n + ": " + p[i].getNombre());
        }
        System.out.print("Cual de los anteriores personajes deseas consultar (1/2): ");

        do {
            opcion = sc.nextInt();
            repetir = false;
            if (opcion == 1 || opcion == 2) {
                showPersonaje(opcion);
            } else {
                repetir = true;
                System.out.println("ERROR");

            }
        } while (repetir);

        System.out.print("¿Desea ver  las estadisticas de " + p[opcion].getNombre() + " (s/n)? ");

        seeStats = sc.next();
        if ("s".equalsIgnoreCase(seeStats)) {
            showEstadistica(opcion);
        } else if ("n".equalsIgnoreCase(seeStats)){
            System.out.println("Cerrando el programa correctamente...");
        } else {
            System.out.println("ERROR: La elección debe de ser (s/n). Cerrando el programa...");
        }

        sc.close();
    }

    public static void showPersonaje(int opcion) {
        System.out.println("\nAtributos de " + p[opcion].getNombre() + ":");
        System.out.println("\tPrimera arma: " + p[opcion].getArma1());
        System.out.println("\tSegunda arma: " + p[opcion].getArma2());
        System.out.println("\tEscudo: " + p[opcion].getEscudo());
        System.out.println("\tTorso: " + p[opcion].getTorso());
        System.out.println("\tPrimer accesorio: " + p[opcion].getAccesorio1());
        System.out.println("\tSegundo accesorio: " + p[opcion].getAccesorio2() + "\n");
    }
    public static void showEstadistica(int opcion) {
        System.out.println("\nEstadisticas de " + p[opcion].getNombre() + ":");
        System.out.println("\tPuntos de vida: " + e[opcion].getPv());
        System.out.println("\tPuntos de hablidad: " + e[opcion].getPh());
        System.out.println("\tAtaque físico: " + e[opcion].getAtqFis());
        System.out.println("\tAtaque elemental: " + e[opcion].getAtqElem());
        System.out.println("\tDefensa física:  " + e[opcion].getDefFis());
        System.out.println("\tDefensa elemental " + e[opcion].getDefElem());
        System.out.println("\tPrecisión: " + e[opcion].getPrec());
        System.out.println("\tVelocidad: " + e[opcion].getVel());
        System.out.println("\tProbabilidad de critico: " + e[opcion].getCritic());
        System.out.println("\tProbabilidad de evasión: " + e[opcion].getEvasion());
    }
}
