package objetos_clases.multiplication_game;

import java.util.Random;

public class Juego {
    private Random nRandom = new Random();
    private int operando1;
    private int operando2;
    private int solucion;
    public Juego() {
        operando1 = crearOperando();
        operando2 = crearOperando();
        solucion = operando1 * operando2;
    }
    private int crearOperando() {
        return nRandom.nextInt(51);
    }
    public int getOperando1() {
        return operando1;
    }
    public int getOperando2() {
        return operando2;
    }
    public int getSolucion() {
        return solucion;
    }
    public boolean isCorrect(int respuesta){
        if(solucion == respuesta) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public String toString() {
        return "La operacion es " + operando1 + " multiplicado por " + operando2;
    }
}
