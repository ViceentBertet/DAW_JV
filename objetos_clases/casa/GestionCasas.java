package objetos_clases.casa;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionCasas {
    private static final Casa[] CASAS = new Casa[10];
    private static Casa nuevaCasa;
    private static int nCasas = 0;
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        /*
        Casa maCasa = new Casa("Major", 12, "Lliria", 98, false, 30);
        Casa maCasa2 = new Casa("Serrano", 48, "Olocau");
        Casa maCasa3 = new Casa("Valencia", 1, "La Pobla de Vallbona", 112, true, 5);
        maCasa2.setSuperficie(130);
        maCasa2.setGaraje(true);
        maCasa2.setAntiguedad(40);
        System.out.println(maCasa.getInfo());
        System.out.println(maCasa2.getInfo());
        System.out.println(maCasa3.getInfo());
        */
        int casasRestantes;
        do {
            casasRestantes = CASAS.length - nCasas;
            System.out.println("\n**Gestión de casas - capacidad restante de " + casasRestantes +" casas**");

            introducirCasa();
            confirmarCasa();

            System.out.println("¿Desea ver las casas guardadas? (s/n)");
            String opcion = sc.next();
            if (opcion.equalsIgnoreCase("s")) {
                System.out.println("Mostrando las casas\n");
            } else if (opcion.equalsIgnoreCase("n")) {
                System.out.println("No se mostrarán las casas guardadas");
            } else {
                System.out.println("ERROR: No se mostrarán las casas guardadas");
            }
            mostrarGuardadas();
        } while (nCasas <= 10);

        sc.close();
    }
    public static void introducirCasa() {
        boolean newGaraje = false;
        boolean error;
        nuevaCasa = null;
        try {
            System.out.println("Introducir datos. Solo meter los datos explicitos\n");
            System.out.print("Calle: ");
            String newCalle = sc.next();
            System.out.print("Numero: ");
            int newNumero = sc.nextInt();
            System.out.print("Població: ");
            String newPoblacio = sc.next();
            System.out.print("Superfice: ");
            double newSuperficie = sc.nextDouble();
            do {
                error = false;
                System.out.print("Garaje (s/n): ");
                String garaje = sc.next();
                if (garaje.equalsIgnoreCase("s")) {
                    newGaraje = true;
                } else if (garaje.equalsIgnoreCase("n")) {
                    newGaraje = false;
                } else {
                    System.out.print("ERROR: Vuelve a introducir el ");
                    error = true;
                }
            } while(error);
            System.out.print("Años de antiguedad: ");
            int newAntiguedad = sc.nextInt();

            nuevaCasa = new Casa(newCalle, newNumero, newPoblacio, newSuperficie, newGaraje, newAntiguedad);
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Tipo de dato incorrecto");
        } catch (SuperficieException | EdadException e) {
            System.out.println(e.getMessage());
        }


    }
    public static void confirmarCasa() {
        boolean error;
        try {
            nuevaCasa.getInfo();
        } catch (NullPointerException e) {
            System.out.println("No se ha creado la casa");
            return;
        }
            System.out.print("\n");
            do {
                error = false;

                System.out.print("¿Desea guardar la información mostrada? (s/n)");
                String guardarInfo = sc.next();

                if (guardarInfo.equalsIgnoreCase("s")) {
                    try {
                        CASAS[nCasas] = new Casa(nuevaCasa.getCalle(), nuevaCasa.getNombre(), nuevaCasa.getPoblacion(), nuevaCasa.getSuperficie(), nuevaCasa.getGaraje(),nuevaCasa.getAntiguedad());
                        System.out.println("Los datos se han guardado correctamente");
                        nCasas++;
                    } catch (SuperficieException | EdadException e) {
                        System.out.println(e.getMessage());
                    }

                } else if (guardarInfo.equalsIgnoreCase("n")) {
                    System.out.println("Los datos no se han guardado");
                } else {
                    System.out.print("ERROR:");
                    error = true;
                }
            } while (error);
    }
    public static void mostrarGuardadas() {
        for(int i = 0; i < nCasas; i++) {
            System.out.println(CASAS[i].getInfo());
        }
    }
}
