package objetos_clases.multiplication_game;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionJuegos {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<String> juegos = new ArrayList<>();

    public static void main(String[] args) {
        juegos.add("Multiplication Game");
        juegos.add("El ahorcado");

        System.out.println("Introduce el n del juego que quieres jugar");
        mostrarJuegos();
        int jugar = sc.nextInt();

        switch (jugar) {
            case 1:
                System.out.println("Has elegido " + juegos.get(0));
                jugarMultiplication();
                break;
            case 2:
                System.out.println("Has elegido " + juegos.get(1));
                jugarAhorcado();
                break;
            default:
                System.out.println("El n elegido no corresponde a ningún juego.");
        }
        sc.close();
    }
    public static void mostrarJuegos(){
        int nJuego;
        for (int i = 0; i < juegos.size(); i++) {
            nJuego = i + 1;
            System.out.println(nJuego + ": " + juegos.get(i));
        }
    }
    public static void jugarMultiplication(){
        System.out.print("¿Cuantos jugadores (2/3)? ");
        int nPlayers = sc.nextInt();
        if (nPlayers != 2 && nPlayers != 3) {
            System.out.println("Numero de jugadores incorrecto");
        } else if (nPlayers == 2){
           TwoPlayers dos = new TwoPlayers();
           dos.jugarMultiplication();
        } else {
            ThreePlayers tres = new ThreePlayers();
            tres.jugarMultiplication();
        }
    }
    public static void jugarAhorcado() {
        System.out.print("¿Cuantos jugadores (2/3)? ");
        int nPlayers = sc.nextInt();
        if (nPlayers != 2 && nPlayers != 3) {
            System.out.println("Numero de jugadores incorrecto");
        } else if (nPlayers == 2){
            TwoPlayers dos = new TwoPlayers();
            dos.jugarAhorcado();
        } else {
            ThreePlayers tres = new ThreePlayers();
            tres.jugarAhorcado();
        }
    }
}
