package objetos_clases.trabajadores;

import java.util.Scanner;

public class GestionTrabajadores {
    private static final Scanner SC = new Scanner(System.in);
    public static void main(String[] args) {
        int nWorkers;
        boolean repetir;

        System.out.print("¿Cuantos trabajadores desearía introducir? ");
        do {
            nWorkers = SC.nextInt();

            if(nWorkers <= 0) {
                System.out.print("ERROR: El numero de trabajadores debe de ser mayor que 0. Vuelve a introducir: ");
            }
        } while (nWorkers <= 0);

        Trabajador[] worker = new Trabajador[nWorkers];
        Proyecto[] project = new Proyecto[nWorkers];

        createWorkers(worker,project);

        System.out.print("¿Desea mostrar los trabajadores que acaba de crear? (s/n)");
        do {
            repetir = false;
            String opcion = SC.next();
            if ("s".equalsIgnoreCase(opcion)) {
                showWorkers(worker, project);
            } else if ("n".equalsIgnoreCase(opcion)) {
                System.out.println("\nCerrando correctamente la aplicación.");
            } else {
                System.out.print("\nERROR: Se ha introducido incorrectamente  la opcion (s/n). Vuelve a introducir");
                repetir = true;
            }
        } while (repetir);

        SC.close();
    }
    public static void createWorkers(Trabajador[] worker, Proyecto[] project) {
        String nombre;
        String edad;
        String sueldo;
        String nombreProyecto;
        String desc;
        for (int i = 0; i < worker.length; i++) {
            int n = i + 1;
            System.out.println("Datos del trabajador " + n + ":");
            System.out.print("Introduce el nombre del trabajador: ");
            nombre = SC.next();
            System.out.print("Introduce la edad del trabajador:");
            edad = SC.next();
            System.out.print("Introduce el sueldo del trabajador: ");
            sueldo = SC.next();
            System.out.println("Datos proyecto del trabajador " + n + ":");
            System.out.print("Introduce el nombre del proyecto: ");
            nombreProyecto = SC.next();
            System.out.print("Introduce la descripción del proyecto: ");
            desc = SC.next();

            if (nombre.isEmpty()) {
                nombre = "vacío";
            }
            if (edad.isEmpty()) {
                edad = "vacío";
            }
            if (sueldo.isEmpty()) {
                sueldo = "vacío";
            }
            if (nombreProyecto.isEmpty()) {
                nombreProyecto = "vacío";
            }
            if (desc.isEmpty()) {
                desc = "vacío";
            }

            worker[i] = new Trabajador(nombre, edad, sueldo);
            project[i] = new Proyecto(nombreProyecto, desc);
        }
    }
    public static void showWorkers(Trabajador[] worker, Proyecto[] project) {
        for (int i = 0; i < worker.length; i++) {
            int n = i + 1;
            System.out.println("Datos del trabajador " + n + ":");
            System.out.print("Nombre del trabajador: " + worker[i].getNombre());
            System.out.print("Edad del trabajador:" + worker[i].getEdad());
            System.out.print("Sueldo del trabajador: " + worker[i].getSueldo());
            System.out.println("Datos proyecto del trabajador " + n + ":");
            System.out.print("Nombre del proyecto: " + project[i].getNombre());
            System.out.print("Descripción del proyecto: " + project[i].getDesc());
        }
    }
}
