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
            SC.nextLine();
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
        final String VACIO = "vacío";

        String nombre;
        String edad;
        String sueldo;
        String nombreProyecto;
        String desc;

        for (int i = 0; i < worker.length; i++) {
            int n = i + 1;
            System.out.println("Datos del trabajador " + n + ":");
            System.out.print("Introduce el nombre del trabajador: ");
            nombre = SC.nextLine();
            System.out.print("Introduce la edad del trabajador:");
            edad = SC.nextLine();
            System.out.print("Introduce el sueldo del trabajador: ");
            sueldo = SC.nextLine();
            System.out.println("Datos proyecto del trabajador " + n + ":");
            System.out.print("Introduce el nombre del proyecto: ");
            nombreProyecto = SC.nextLine();
            System.out.print("Introduce la descripción del proyecto: ");
            desc = SC.nextLine();

            if (nombre.isEmpty()) {
                nombre = VACIO;
            }
            if (edad.isEmpty()) {
                edad = VACIO;
            }
            if (sueldo.isEmpty()) {
                sueldo = VACIO;
            }
            if (nombreProyecto.isEmpty()) {
                nombreProyecto = VACIO;
            }
            if (desc.isEmpty()) {
                desc = VACIO;
            }

            worker[i] = new Trabajador(nombre, edad, sueldo);
            project[i] = new Proyecto(nombreProyecto, desc);
        }
    }
    public static void showWorkers(Trabajador[] worker, Proyecto[] project) {
        for (int i = 0; i < worker.length; i++) {
            int n = i + 1;
            System.out.println("Datos del trabajador " + n + ":");
            System.out.println("Nombre del trabajador: " + worker[i].getNombre());
            System.out.println("Edad del trabajador:" + worker[i].getEdad());
            System.out.println("Sueldo del trabajador: " + worker[i].getSueldo());
            System.out.println("Datos proyecto del trabajador " + n + ":");
            System.out.println("Nombre del proyecto: " + project[i].getNombre());
            System.out.println("Descripción del proyecto: " + project[i].getDesc());
        }
    }
}
