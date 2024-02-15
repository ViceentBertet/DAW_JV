package objetos_clases.multiplication_game;

import java.util.Random;
import java.util.Scanner;

public class ThreePlayers implements IMultiplication, IJuego {
    private int producto;
    public ThreePlayers() {
    }
    @Override
    public void generarProducto() {
        Random r = new Random();
        int operando1 = r.nextInt(51);
        int operando2 = r.nextInt(51);
        System.out.println(operando1 + " por " + operando2);
        this.producto = operando1 * operando2;
    }
    @Override
    public boolean comprovarRespuesta(int respuesta) {
        if (this.producto == respuesta) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
    @Override
    public void jugar(){
        Scanner sc = new Scanner(System.in);
        int perdedor = 0;
        int respuesta;
        boolean isCorrect = true;

        while(isCorrect) {
            generarProducto();
            System.out.println("Respuesta jugador 1: ");
            respuesta = sc.nextInt();
            isCorrect = comprovarRespuesta(respuesta);
            if (!isCorrect) {
                perdedor = 1;
            } else {
                System.out.println("Respuesta jugador 2: ");
                respuesta = sc.nextInt();
                isCorrect = comprovarRespuesta(respuesta);
                if (!isCorrect) {
                    perdedor = 2;
                } else {
                    System.out.println("Respuesta jugador 3: ");
                    respuesta = sc.nextInt();
                    isCorrect = comprovarRespuesta(respuesta);
                    if (!isCorrect) {
                        perdedor = 3;
                    }
                }
            }
        }

        if (perdedor != 1 && perdedor != 2) {
            System.out.println("Los jugadores 1 y 2 han ganado");
        } else if (perdedor != 1 && perdedor != 3){
            System.out.println("Los jugadores 1 y 3 han ganado");
        } else {
            System.out.println("Los jugadores 2 y 3 han ganado");
        }
        System.out.println("¡El jugador numero " + perdedor + " ha  fallado!");
    }
}
