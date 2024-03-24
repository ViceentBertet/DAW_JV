package archivos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class Buffered {
    private static Logger LOGGER = LogManager.getRootLogger();
    public static void main(String[] args) {
        File fich = new File("ficheroBuffered.txt");
        try {
            escribir(fich);
            leer(fich);
        } catch (IOException e){
            LOGGER.error("IOEXCEPTION");
        }
    }
    public static void escribir(File fich) throws IOException {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fich));
            for (int i = 1; i <= 50; i++) {
                bw.write("\nLinea " + i);
            }
            bw.close();
        } catch (IOException e) {
            throw e;
        }
    }
    public static void leer(File fich) throws IOException {
        String linea = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(fich));
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();
        } catch (IOException e) {
            throw e;
        }
    }
}
