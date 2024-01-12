package objetos_clases.personajes_atributos;

import java.util.Scanner;

public class GestionRPG {
    private static final Personaje[] P = new Personaje[2];
    private static final Estadistica[] E = new Estadistica[2];
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        P[0] = new Personaje("Finn el humano","Espada Dorada", "Espada corta","Escudo Plateado", "Ropa de Finn", "Gorro de Finn","Mochila de Finn");
        P[1] = new Personaje("Rey hielo", "Explosión de hielo","Cuchillas de hielo","Barricada de hielo","Ropa del Rey Hielo","Corona del Rey hielo","Osito de Marceline");
        E[0] = new Estadistica(55, 15, 23, 0, 35, 15, 75, 45, 5, 25);
        E[1] = new Estadistica(95, 35, 10, 45, 15, 75, 85, 32, 10, 20);

        int opcion;
        String seeStats;
        boolean repetir;

        for (int i = 0; i < P.length; i++) {
            int n = i + 1;
            System.out.println(n + ": " + P[i].getNombre());
        }
        System.out.print("Cual de los anteriores personajes deseas consultar (1/2): ");

        do {
            opcion = SC.nextInt();
            opcion -= 1;
            repetir = false;
            if (opcion == 0 || opcion == 1) {
                showPersonaje(opcion);
            } else {
                repetir = true;
                System.out.print("ERROR: Ese numero no coincide con ningun personaje. Vuelvelo a intentar: ");

            }
        } while (repetir);

        System.out.print("¿Desea ver  las estadisticas de " + P[opcion].getNombre() + " (s/n)? ");

        seeStats = SC.next();
        if ("s".equalsIgnoreCase(seeStats)) {
            showEstadistica(opcion);
        } else if ("n".equalsIgnoreCase(seeStats)){
            System.out.println("Cerrando el programa correctamente...");
        } else {
            System.out.println("ERROR: La elección debe de ser (s/n). Cerrando el programa...");
        }

        SC.close();
    }

    public static void showPersonaje(int opcion) {
        System.out.println("\nAtributos de " +P[opcion].getNombre() + ":");
        System.out.println("\tPrimera arma: " + P[opcion].getArma1());
        System.out.println("\tSegunda arma: " + P[opcion].getArma2());
        System.out.println("\tEscudo: " + P[opcion].getEscudo());
        System.out.println("\tTorso: " + P[opcion].getTorso());
        System.out.println("\tPrimer accesorio: " + P[opcion].getAccesorio1());
        System.out.println("\tSegundo accesorio: " + P[opcion].getAccesorio2() + "\n");
    }
    public static void showEstadistica(int opcion) {
        System.out.println("\nEstadisticas de " + P[opcion].getNombre() + ":");
        System.out.println("\tPuntos de vida: " + E[opcion].getPv());
        System.out.println("\tPuntos de hablidad: " + E[opcion].getPh());
        System.out.println("\tAtaque físico: " + E[opcion].getAtqFis());
        System.out.println("\tAtaque elemental: " + E[opcion].getAtqElem());
        System.out.println("\tDefensa física:  " + E[opcion].getDefFis());
        System.out.println("\tDefensa elemental " + E[opcion].getDefElem());
        System.out.println("\tPrecisión: " + E[opcion].getPrec());
        System.out.println("\tVelocidad: " + E[opcion].getVel());
        System.out.println("\tProbabilidad de critico: " + E[opcion].getCritic());
        System.out.println("\tProbabilidad de evasión: " + E[opcion].getEvasion());
    }
}
