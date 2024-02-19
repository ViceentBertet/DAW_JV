package objetos_clases.multiplication_game;

import java.util.Random;

public class Multiplication {
    private int producto;
    public void generarProducto() {
        Random r = new Random();
        int operando1 = r.nextInt(51);
        int operando2 = r.nextInt(51);
        System.out.println(operando1 + " por " + operando2);
        this.producto = operando1 * operando2;
    }

    public boolean comprovarRespuesta(int respuesta) {
        if (this.producto == respuesta) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
}
