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
                System.out.println("Has elegido " + juegos.get(jugar));
                multiGame();
                break;
            case 2:
                System.out.println("Has elegido " + juegos.get(jugar));
                //jugar al ahorcado
                break;
            default:
                System.out.println("El n elegido no corresponde a ningun juego.");
        }


    }
    public static void mostrarJuegos(){
        int nJuego;
        for (int i = 0; i < juegos.size(); i++) {
            nJuego = i + 1;
            System.out.println(nJuego + ": " + juegos.get(i));
        }
    }
    public static void multiGame(){
        System.out.print("¿Cuantos jugadores (2/3)? ");
        int nPlayers = sc.nextInt();
        if (nPlayers != 2 && nPlayers != 3) {
            System.out.println("Numero de jugadores incorrecto");
        } else if (nPlayers == 2) {
            TwoPlayers two = new TwoPlayers();
            two.jugar();
        } else {
            ThreePlayers three = new ThreePlayers();
            three.jugar();
        }
    }
}
