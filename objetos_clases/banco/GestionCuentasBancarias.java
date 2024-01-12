package objetos_clases.banco;

import java.util.Scanner;

public class GestionCuentasBancarias {
    private static final Scanner sc = new Scanner(System.in);
    private static final CuentaBancaria c1 = new CuentaBancaria(1000, 500.50);
    public static void main(String[] args) {
        boolean exit = false;
        System.out.print("Introduce el numero de cuenta para poder manipular su saldo: ");
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
                if (opcion == 4) {
                    exit = true;
                }
            }
        }
        sc.close();
    }
    public static void selectOpcionMenu(int opcion){
        double nuevoSaldo;
        switch(opcion) {
            case 1:
                System.out.println("Tu cuenta contiene:  " + c1.getSaldo() + "€");
                break;
            case 2:
                System.out.print("Introduce cuanto dinero vas a depositar: ");
                double depositar = sc.nextDouble();
                nuevoSaldo = c1.getSaldo() + depositar;
                c1.setSaldo(nuevoSaldo);
                System.out.println("\tSu nuevo saldo es de " + c1.getSaldo() + "\n");
                break;
            case 3:
                System.out.println("Introduce cuanto dinero quieres retirar: ");
                double retirar = sc.nextDouble();
                nuevoSaldo = c1.getSaldo() - retirar;
                c1.setSaldo(nuevoSaldo);
                System.out.println("\tSe ha retirado correctamente el saldo indicado...");
                System.out.println("\tSu nuevo saldo es de " + c1.getSaldo() + "\n");
                break;
            case 4:
                System.out.println("Ha seleccionado salir del programa\n");
                break;
            default: System.out.println("ERROR: La opción debe ser comprendida entre 1 y 4.\n");
        }
    }
}
