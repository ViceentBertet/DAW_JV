package objetos_clases.multiplication_game;

import java.util.Random;
import java.util.Scanner;

public class ThreePlayers implements IMultiplication, IAhorcado {
    private Multiplication multi = new Multiplication();
    private Ahorcado aho = new Ahorcado();
    private Scanner sc = new Scanner(System.in);
    public ThreePlayers() {
    }
    //Multiplication
    @Override
    public void jugarMultiplication(){
        int perdedor = 0;
        int respuesta;
        boolean isCorrect = true;

        while(isCorrect) {
            multi.generarProducto();
            System.out.println("Respuesta jugador 1: ");
            respuesta = sc.nextInt();
            isCorrect = multi.comprovarRespuesta(respuesta);
            if (!isCorrect) {
                perdedor = 1;
            } else {
                System.out.println("Respuesta jugador 2: ");
                respuesta = sc.nextInt();
                isCorrect = multi.comprovarRespuesta(respuesta);
                if (!isCorrect) {
                    perdedor = 2;
                } else {
                    System.out.println("Respuesta jugador 3: ");
                    respuesta = sc.nextInt();
                    isCorrect = multi.comprovarRespuesta(respuesta);
                    if (!isCorrect) {
                        perdedor = 3;
                    }
                }
            }
            sc.close();
        }

        if (perdedor != 1 && perdedor != 2) {
            System.out.println("Los jugadores 1 y 2 han ganado");
        } else if (perdedor != 1){
            System.out.println("Los jugadores 1 y 3 han ganado");
        } else {
            System.out.println("Los jugadores 2 y 3 han ganado");
        }
        System.out.println("¡El jugador numero " + perdedor + " ha  fallado!");
    }
    //Ahorcado
    @Override
    public void jugarAhorcado() {
        Random rnd = new Random();
        Incognita[] incognitas = aho.getIncognitas();
        aho.setAdivinar(incognitas[rnd.nextInt(6)]);
        aho.crearPalabra();

        for(int i = 0; i < 12; i++) {
            int nIntento = i + 1;
            System.out.println("INTENTO " + nIntento);
            if (i == 12 / 3){
                System.out.println("El tema es " + aho.getAdivinar().getTipo());
            }
            aho.resolver();
            if (aho.getAdivinar().getTexto().equals(aho.getPalabra().toString())) {
                break;
            }
        }
        if (!aho.getAdivinar().getTexto().equals(aho.getPalabra().toString())) {
            System.out.println("¡Que mala suerte! Los dos habeis perdido");
            System.out.println("La palabra era " + aho.getAdivinar().getTexto());
        }
    }
}
