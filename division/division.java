package division;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;


public class division {
    //private static Logger LOGGER = LogManager.getRootLogger();
    private static Logger LOGGER = LogManager.getRootLogger();
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            System.out.println("Resultado: " + divisio());

        } catch (InputMismatchException e ) {
            System.out.println("ERROR: Valor no valido");
        } catch (ArithmeticException e) {
            //LOGGER.error("¡Error aritmético! No se puede dividir por cero");
            LOGGER.debug("¡Error aritmético! No se puede dividir por cero");
        } finally {
            sc.close();
        }

    }
    public static int divisio() throws InputMismatchException, ArithmeticException{
        System.out.println("Operando 1: ");
        int a = sc.nextInt();

        System.out.println("Operando 2: ");
        int b = sc.nextInt();
        LOGGER.debug("Operando 1: " + a + " operando 2: " + b);
        return a / b;
    }
}