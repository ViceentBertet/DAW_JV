package archivos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LeerEscribir {
    private static Logger LOGGER = LogManager.getRootLogger();
    public static void main(String[] args) {
        File fich1 = new File("ficheroPrint.txt");
        File fich2 = new File("ficheroBuffered.txt");
        File fich3 = new File("ficheroStream.txt");
        try {
            escribirPrintWriter(fich1);
            leerScanner(fich1);
            //escribirBuffered(fich2);
            //leerBuffered(fich2);
            //escribirStream(fich3);
            //leerStream(fich3);
        } catch (IOException e){
            LOGGER.error("IOEXCEPTION," + e.getStackTrace());
        } catch (InputMismatchException e) {
            LOGGER.error("INPUTMISMATCHEXCEPTION, " + e.getStackTrace());
        }
    }
    public static void escribirPrintWriter(File fich) throws IOException, InputMismatchException{
        try {
            double d1 = 243.5564342;
            int i1 = 1;
            PrintWriter pw = new PrintWriter(new FileWriter(fich));
            pw.print(i1);
            pw.printf("\nHola %.2f\n", d1);
            pw.println(d1);
            pw.close();
        } catch (IOException e) {
            LOGGER.error("escribirPrintWriter; IOException");
            throw e;
        } catch (InputMismatchException e) {
            LOGGER.error("escribirPrintWriter; InputMisMatch");
            throw e;
        }

    }
    public static void leerScanner(File fich) throws IOException {
        try {
            Scanner sc = new Scanner(fich);
            while (sc.hasNext()) {
                if (sc.hasNextInt()) {
                    System.out.println(sc.nextInt());
                }
                if (sc.hasNextDouble()) {
                    System.out.println(sc.nextDouble());
                }
                if (sc.hasNext()) {
                    System.out.println(sc.next());
                }
            }
            sc.close();
        } catch (IOException e) {
            LOGGER.error("leerScanner");
            throw e;
        }

    }
    public static void escribirBuffered(File fich) throws IOException {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fich));
            for (int i = 1; i <= 50; i++) {
                bw.write("\nLinea " + i);
            }
            bw.close();
        } catch (IOException e) {
            LOGGER.error("escribirBuffered");
            throw e;
        }
    }
    public static void leerBuffered(File fich) throws IOException {
        String linea = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(fich));
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();
        } catch (IOException e) {
            LOGGER.error("leerBuffered");
            throw e;
        }
    }
    public static void escribirStream(File fich) throws IOException{
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(fich));
            out.writeUTF("Vicent");
            out.writeBoolean(true);
            out.writeInt(8);
            out.writeDouble(8.43);
            out.close();
        } catch (IOException e) {
            LOGGER.error("EscribirStream");
            throw e;
        }
    }
    public static void leerStream(File fich) throws IOException{
        try {
            DataInputStream in = new DataInputStream(new FileInputStream(fich));
            System.out.println("Nombre: " + in.readUTF());
            System.out.println("Mayor de edad: " + in.readBoolean());
            System.out.println("Nota: " + in.readInt());
            System.out.println("Nota con decimales: " + in.readDouble());
            in.close();
        } catch (IOException e) {
            LOGGER.error("leerStream");
            throw e;
        }

    }
}
