package objetos_clases.banco;

import java.util.Scanner;

public class GestionCuentasBancarias {
    private static Scanner sc = new Scanner(System.in);
    private static CuentaBancaria c1 = new CuentaBancaria(1000, 500.50);
    public static void main(String[] args) {
        boolean exit = false;
        System.out.println("Introduce el numero de cuenta para poder manipular su saldo");
        int cuenta = sc.nextInt();
        if (c1.getCuenta() != cuenta) {
            System.out.println("Su numero de cuenta no coincide con ninguno existente. Inicie la aplicación de nuevo para volver a intentarlo");
        } else {
            System.out.println("Su numero de cuenta coincide con uno existente\n");
            while (!exit) {
                System.out.println("\t1: Mostrar dinero actual");
                System.out.println("\t2: Depositar dinero");
                System.out.println("\t3: Retirar dinero");
                System.out.println("\t4: Salir");
                System.out.print("Introduzca la opción que desea realizar ahora: ");
                int opcion = sc.nextInt();
                selectOpcionMenu(opcion);

            }
        }
    }
    public static void selectOpcionMenu(int opcion){
        switch(opcion) {
            case 1:
                System.out.println("El dinero actual que contine la cuenta " + )
        }
    }
}
