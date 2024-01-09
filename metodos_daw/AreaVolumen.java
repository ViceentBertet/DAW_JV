package metodos_daw;

import java.util.Scanner;

public class AreaVolumen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int UNO = 1;
        final int DOS = 2;

        double solucion;

        System.out.println("IMPORTANTE: Los datos tienen que estar en las unidades del SI");
        System.out.println("¿Quiere calcular el area(1) de una superficie o el volumen(2) de un objeto?");
        int calcular = sc.nextInt();

        if (calcular == UNO) {
            System.out.println("Has elegido calcular area");
            int figura = figura(calcular);

            if (figura == UNO) {
                solucion = areaCuadrado();
            } else {
                if (figura == DOS) {
                    solucion = areaTriangulo();
                } else {
                    solucion = areaCirculo();
                }
            }
            System.out.printf("El área de la figura es %.2f metros cuadrados", solucion);
        } else {
            if (calcular == DOS) {
                System.out.println("Has elegido calcular volumen");
                int figura = figura(calcular);

                if (figura == UNO) {
                    solucion = volumenCubo();
                } else {
                    if (figura == DOS) {
                        solucion = volumenPiramide();
                    } else {
                        solucion = volumenCilindro();
                    }
                }
                System.out.printf("El volumen de la figura es %.2f metros cúbicos", solucion);
            } else {
                System.out.println("ERROR: El valor debe ser 1 o 2");

            }
        }
    }
    public static int figura(int calcular){
        Scanner sc = new Scanner(System.in);

        final int UNO = 1;
        final int DOS = 2;
        final int TRES = 3;

        if (calcular == UNO) {
            System.out.println("Que figura quieres calcular? (1: cuadrado (rectangulo) 2: triangulo (equilatero) 3: circulo)");
        } else {
            System.out.println("Que figura quieres calcular? (1: cubo 2: piramide 3: cilindro)");
        }
        int elegirFigura = sc.nextInt();
        if (elegirFigura != UNO && elegirFigura != DOS && elegirFigura != TRES) {
            System.out.println("ERROR: El valor debe ser 1, 2 o 3");
        }
        return elegirFigura;
    }
    public static double areaCuadrado(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la longitud de los lados de tu cuadrado");
        System.out.print("1: ");
        double lado1 = sc.nextDouble();
        System.out.print("2: ");
        double lado2 = sc.nextDouble();

        return lado1 * lado2;
    }
    public static double areaTriangulo(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la longitud de los lados de tu triangulo");
        double lados = sc.nextDouble();

        return lados * lados * Math.cbrt(3) / 4;
    }
    public static double areaCirculo(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el radio de tu circulo");
        double radio = sc.nextDouble();

        return Math.PI * radio * radio;
    }
    public static double volumenCubo(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la longitud de los lados de tu cubo");
        System.out.print("1: ");
        double lado1 = sc.nextDouble();
        System.out.print("2: ");
        double lado2 = sc.nextDouble();
        System.out.print("3: ");
        double lado3 = sc.nextDouble();

        return lado1 * lado2 * lado3;
    }
    public static double volumenPiramide(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce los siguientes datos de tu piramide");
        System.out.print("Primer lado de la base: ");
        double lado1 = sc.nextDouble();
        System.out.print("Segundo lado de la base: ");
        double lado2 = sc.nextDouble();
        System.out.print("Altura de la pirámide: ");
        double altura = sc.nextDouble();

        return lado1 * lado2 * altura * 1 / 3;
    }
    public static double volumenCilindro(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce los siguientes datos de tu cilindro");
        System.out.print("El radio: ");
        double radio = sc.nextDouble();
        System.out.print("La altura: ");
        double altura = sc.nextDouble();

        return Math.PI * radio * radio * altura;
    }
}