package Agenda;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Agenda {
   public static void main(String[] args) {


       String[] Datos = new String[4];
       System.out.println("**AGENDA DE USUARIO**\n");

       introducirNombre(Datos);
       introducirEmail(Datos);
       introducirIP(Datos);
       introducirTelefono(Datos);

       compararDatos(Datos);
   }
   static Scanner sc = new Scanner(System.in);
   public static void introducirNombre(String[] Datos) {
       System.out.print("Introducir los apellidos y el nombre:");
       Datos[0] = sc.next();
   }
   public static void introducirEmail(String[] Datos) {
       System.out.print("Introducir correo electrónico:");
       Datos[1] = sc.next();
   }
   public static void introducirIP(String[] Datos) {
       System.out.print("Introducir dirección IP:");
       Datos[2] = sc.next();
   }
   public static void introducirTelefono(String[] Datos){
       System.out.print("Introducir numero de teléfono:");
       Datos[3] = sc.next();
   }
   public static void compararDatos(String[] Datos) {
       boolean verificardatos = false;

       //Nombre
       while (!verificardatos) {
           Pattern email = Pattern.compile("^[a-zA-Z]{1,15}( ||-)[a-zA-Z]{1,15}( ||-)[a-zA-Z]{1,15}$");

           Matcher emailCorrecto = email.matcher(Datos[0]);
           if(emailCorrecto.find()) {
               verificardatos = true;
           } else {
               System.out.print("ERROR: ");
               introducirNombre(Datos);
           }
       }
       verificardatos = false;

       //Email
       while (!verificardatos) {
           Pattern email = Pattern.compile("^[a-zA-Z0-9]{1,30}\\@(gmail||hotmail||outlook)\\.[a-z]{2,3}$");

           Matcher emailCorrecto = email.matcher(Datos[1]);
           if(emailCorrecto.find()) {
               verificardatos = true;
           } else {
               System.out.print("ERROR: ");
               introducirEmail(Datos);
           }
       }
       verificardatos = false;

       //IP
       while (!verificardatos) {
           Pattern ip = Pattern.compile("^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}$");

           Matcher ipCorrecto = ip.matcher(Datos[2]);
           if(ipCorrecto.find()) {
               verificardatos = true;
           } else {
               System.out.print("ERROR: ");
               introducirIP(Datos);
           }
       }
       verificardatos = false;

       //telefono
       while (!verificardatos) {
           Pattern tlfn = Pattern.compile("^\\+34[0-9]{9}$");

           Matcher tlfnCorrecto = tlfn.matcher(Datos[3]);
           if(tlfnCorrecto.find()) {
               verificardatos = true;
           } else {
               System.out.print("ERROR: ");
               introducirTelefono(Datos);
           }
       }
       System.out.println("Datos añadidos correctamente");
   }
}
