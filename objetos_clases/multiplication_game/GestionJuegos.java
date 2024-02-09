package objetos_clases.multiplication_game;

import java.util.Scanner;

public class GestionJuegos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
