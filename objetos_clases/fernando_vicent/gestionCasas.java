package objetos_clases.fernando_vicent;
import javax.sound.midi.Soundbank;
import javax.xml.transform.Source;
import java.util.Scanner;

public class gestionCasas {
    private static final Casa[] CASAS = new Casa[10];
    private static Casa nuevaCasa;
    private static int nCasas = 0;
    private static final Scanner SC = new Scanner(System.in);
    public static void main(String[] args) {
        /*
        Casa maCasa = new Casa("Major", 12, "Lliria", 98, false, 30);
        Casa maCasa2 = new Casa("Serrano", 48, "Olocau");
        Casa maCasa3 = new Casa("Valencia", 1, "La Pobla de Vallbona", 112, true, 5);
        maCasa2.setSuperficie(130);
        maCasa2.setGaraje(true);
        maCasa2.setAntiguedad(40);
        maCasa.getInfo();
        maCasa2.getInfo();
        maCasa3.getInfo();
        */
        do {
            System.out.println("**Gestión de casas - capacidad de 10 casas**");
            introducirCasa();
            confirmarCasa();
            System.out.println("¿Desea ver las casas guardadas? (s/n)");
            String opcion = SC.next();
            if (opcion.equalsIgnoreCase("s")) {
                System.out.println("Mostrando las casas\n");
            } else if (opcion.equalsIgnoreCase("n")) {
                System.out.println("No se mostrarán las casas guardadas");
            } else {
                System.out.println("ERROR: No se mostrarán las casas guardadas");
            }
            mostrarGuardadas();
        } while (nCasas <= 10);
    }
    public static void introducirCasa() {
        boolean newGaraje = false;
        boolean error;

        System.out.println("Introducir datos. Solo meter los datos explicitos\n");
        System.out.print("Calle: ");
        String newCalle = SC.next();
        System.out.print("Numero: ");
        int newNumero = SC.nextInt();
        System.out.print("Població: ");
        String newPoblacio = SC.next();
        System.out.print("Superfice: ");
        double newSuperficie = SC.nextDouble();
        do {
            error = false;
            System.out.print("Garaje (s/n): ");
            String garaje = SC.next();
            if (garaje.equalsIgnoreCase("s")) {
                newGaraje = true;
            } else if (garaje.equalsIgnoreCase("n")) {
                newGaraje = false;
            } else {
                System.out.print("ERROR: Vuelve a introducir el ");
                error = true;
            }
        } while(!error);
        System.out.print("Años de antiguedad: ");
        int newAntiguedad = SC.nextInt();

        nuevaCasa = new Casa(newCalle, newNumero, newPoblacio, newSuperficie, newGaraje, newAntiguedad);

    }
    public static void confirmarCasa() {
        boolean error;

        nuevaCasa.getInfo();
        System.out.print("\n");
        System.out.print("¿Desea guardar la información mostrada? (s/n)");
        do {
            error = false;
            String guardarInfo = SC.next();

            if (guardarInfo.equalsIgnoreCase("s")) {
                CASAS[nCasas].setCalle(nuevaCasa.getCalle());
                CASAS[nCasas].setNombre(nuevaCasa.getNombre());
                CASAS[nCasas].setPoblacion(nuevaCasa.getPoblacion());
                CASAS[nCasas].setSuperficie(nuevaCasa.getSuperficie());
                CASAS[nCasas].setGaraje(nuevaCasa.getGaraje());
                CASAS[nCasas].setAntiguedad(nuevaCasa.getAntiguedad());
                System.out.println("Los datos se han guardado correctamente");
                nCasas++;
            } else if (guardarInfo.equalsIgnoreCase("n")) {
                System.out.println("Los datos no se han guardado");
            } else {
                System.out.print("ERROR:");
                error = true;
            }
        } while (!error);
    }
    public static void mostrarGuardadas() {
        for(int i = 0; i < nCasas; i++) {
         CASAS[nCasas].getInfo();
        }
    }
}
