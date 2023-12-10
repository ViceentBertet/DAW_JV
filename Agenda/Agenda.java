package Agenda;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Agenda {
   public static void main(String[] args) {
       String[] datos = new String[60];
       boolean verificarDatos = false;
       boolean salir = false;
       int i = 0;
       System.out.println("**AGENDA DE USUARIO - Capacidad 10 contactos**");

       while(!salir){
           System.out.println("\n**NUEVO CONTACTO**\n");
           i = introducirNombre(datos, i);
           verificarNombre(datos, verificarDatos, i);

           introducirEmail(datos, i);
           verificarEmail(datos, verificarDatos, i);
           i++;

           introducirIP(datos, i);
           verificarIP(datos, verificarDatos, i);
           i++;

           introducirTelefono(datos, i);
           verificarTelefono(datos, verificarDatos, i);
           i++;

           System.out.println("¿Desea terminar la entrada de datos? (s/n)");
           salir = salir();
           if (salir) {
               for (int j = 0; j < i; j++) {
                   System.out.println("Nombre y apellidos:\t" + datos[j]);
                   j++;
                   System.out.println("Correo electrónico:\t" + datos[j]);
                   j++;
                   System.out.println("Dirección IP:\t" + datos[j]);
                   j++;
                   System.out.println("Numero de teléfono:\t" + datos[j]);
               }
           }
       }
   }
   static Scanner sc = new Scanner(System.in);
   public static int introducirNombre(String[] datos, int i) {
       System.out.print("Introducir primer apellido: ");
       datos[i] = sc.next();
       i++;
       System.out.print("Introducir segundo apellido: ");
       datos[i] = sc.next();
       i++;
       System.out.print("Introducir nombre: ");
       datos[i] = sc.next();
       i++;
       return i;
   }
   public static void introducirEmail(String[] datos, int i) {
       System.out.print("Introducir correo electrónico:");
       datos[i] = sc.next();
   }
   public static void introducirIP(String[] datos, int i) {
       System.out.print("Introducir dirección IP:");
       datos[i] = sc.next();
   }
   public static void introducirTelefono(String[] datos, int i){
       System.out.print("Introducir numero de teléfono (formato:+34611222333):");
       datos[i] = sc.next();
   }
   public static void verificarNombre(String[] datos, boolean verificarDatos, int i) {
       while (!verificarDatos) {
           i -= 3;
           Pattern nom = Pattern.compile("^[A-Za-z]+$");
           Matcher apeCorrecto1 = nom.matcher(datos[i]);
           Matcher apeCorrecto2 = nom.matcher(datos[i + 1]);
           Matcher nomCorrecto = nom.matcher(datos[i + 2]);

           if(nomCorrecto.find() && apeCorrecto1.find() && apeCorrecto2.find()) {
               verificarDatos = true;
           } else {
               System.out.print("ERROR: ");
               i = introducirNombre(datos, i);
           }
       }
   }
   public static void verificarEmail(String[] datos, boolean verificarDatos, int i) {
       while (!verificarDatos) {
           Pattern email = Pattern.compile("^[_A-Za-z0-9]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
           Matcher emailCorrecto = email.matcher(datos[i]);

           if(emailCorrecto.find()) {
               verificarDatos = true;
           } else {
               System.out.print("ERROR: ");
               introducirEmail(datos, i);
           }
       }
   }
   public static void verificarIP(String[] datos, boolean verificarDatos, int i) {
        while (!verificarDatos) {
            Pattern ip = Pattern.compile("^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$");
            Matcher ipCorrecto = ip.matcher(datos[i]);

            if(ipCorrecto.find()) {
                verificarDatos = true;
            } else {
                System.out.print("ERROR: ");
                introducirIP(datos, i);
            }
        }
    }
   public static void verificarTelefono(String[] datos, boolean verificarDatos, int i) {
        while (!verificarDatos) {
            Pattern tlfn = Pattern.compile("^\\+34[0-9]{9}$");

            Matcher tlfnCorrecto = tlfn.matcher(datos[i]);
            if(tlfnCorrecto.find()) {
                verificarDatos = true;
            } else {
                System.out.print("ERROR: ");
                introducirTelefono(datos, i);
            }
        }
        System.out.println("Datos añadidos correctamente");
    }
   public static boolean salir(){
       boolean correcto = false;
       boolean salir = true;
       while(!correcto) {
           String salida = sc.next();
           switch (salida) {
               case "s":
                   System.out.println("Has seleccionado SÍ");
                   correcto = true;
                   break;
               case "n":
                   System.out.println("Has seleccionado NO");
                   correcto = true;
                   salir = false;
                   break;
               default:
                   System.out.println("ERROR: valor no comprendido entre (s/n) vuelve a introducir:");
           }
       }
       return salir;
   }
}
