package objetos_clases.multiplication_game;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionJugadores {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Integer> respuestas = new ArrayList<>();
    public static void main(String[] args) {
        int nPlayers = 0;

        System.out.print("¿Cuantos jugadores vais a jugar? (2/3)");
        while (nPlayers != 2 && nPlayers != 3) {
            nPlayers = sc.nextInt();

            switch (nPlayers) {
                case 2: twoPlayers();break;
                case 3: threePlayers();break;
                default: System.out.print("ERROR: La respuesta debe ser comprendida entre 2 y 3. Vuelve a intentarlo: ");
            }
        }

    }
    public static void twoPlayers() {
        TwoPlayers multiplication = new TwoPlayers();
        System.out.println(multiplication);
        System.out.print("Respuesta jugador 1: ");
        respuestas.add(sc.nextInt());
        System.out.print("Respuesta jugador 2: ");
        respuestas.add(sc.nextInt());

        multiplication.setRespuesta1(respuestas.get(0));
        multiplication.setRespuesta1(respuestas.get(1));

        System.out.println("\n");
        for (int i = 0; i < respuestas.size(); i++) {
            int jugador = i + 1;
            if (multiplication.isCorrect(respuestas.get(i))) {
                System.out.println("¡El jugador " + jugador + " ha acertado!");
            } else {
                System.out.println("El jugador " + jugador + " ha fallado");
            }
        }
    }
    public static void threePlayers() {
        ThreePlayers multiplication = new ThreePlayers();
        System.out.println(multiplication);
        System.out.print("Respuesta jugador 1: ");
        respuestas.add(sc.nextInt());
        System.out.print("Respuesta jugador 2: ");
        respuestas.add(sc.nextInt());
        System.out.print("Respuesta jugador 3: ");
        respuestas.add(sc.nextInt());

        multiplication.setRespuesta1(respuestas.get(0));
        multiplication.setRespuesta1(respuestas.get(1));
        multiplication.setRespuesta1(respuestas.get(2));

        System.out.println("\n");
        for (int i = 0; i < respuestas.size(); i++) {
            int jugador = i + 1;
            if (multiplication.isCorrect(respuestas.get(i))) {
                System.out.println("¡El jugador " + jugador + " ha acertado!");
            } else {
                System.out.println("El jugador " + jugador + " ha fallado");
            }
        }
    }
}
