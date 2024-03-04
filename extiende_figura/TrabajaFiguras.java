package extiende_figura;

import java.util.ArrayList;

public class TrabajaFiguras {

    public static void main (String [] args ) {
        Rectangulo r1;
        r1 = new Rectangulo(12.5, 23.7);
        System.out.println("Area de r1 = " + r1.area());

        Rectangulo r2 = new Rectangulo(8.6, 33.1);
        System.out.println("Area de r2 = " + r2.area());

        if (Rectangulo.mayorQue(r1, r2))
            System.out.println("El rectángulo de mayor area es r1");
        else
            System.out.println("El rectángulo de mayor area es r2");

        Triangulo triangulo = new Triangulo(5, 5, 1);

        System.out.println("Es triangulo mayor que r1: " + Figura.mayorQue(triangulo, r1));

        ArrayList<Figura> figuras = new ArrayList<>();
        figuras.add(new Rectangulo(10, 20));
        figuras.add(new Rectangulo(5, 10));
        figuras.add(new Rectangulo(2, 4));
        figuras.add(new Rectangulo(8, 16));
        figuras.add(new Triangulo(10, 12, 1));
        figuras.add(new Triangulo(7, 6, 1));
        figuras.add(new Triangulo(3, 5, 1));
        figuras.add(new Triangulo(4, 4, 1));
        figuras.add(new Circulo(2));
        figuras.add(new Circulo(4));
        figuras.add(new Circulo(6));
        figuras.add(new Circulo(8));
        // No nos deja ordenar, nos da error
        //Collections.sort(figuras);
    }
}