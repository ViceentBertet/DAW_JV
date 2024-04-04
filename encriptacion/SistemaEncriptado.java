package encriptacion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.plugins.convert.Base64Converter;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

public class SistemaEncriptado implements IEncriptar{
    private static Logger LOGGER = LogManager.getRootLogger();
    private static final String CIFRADO = "crip";
    private static final String NOCIFRADO = "txt";
    private static final String ALGORITMO = "AES";
    private static final String TIPO_CIFRADO = "AES/CBC/PKCS5Padding";
    private static Scanner sc;
    private int type;
    public SistemaEncriptado(Scanner sc, int type) throws IllegalArgumentException{
        this.sc = sc;
        if (type < 1 || type > 3) {
            throw new IllegalArgumentException();
        }
        this.type = type;
    }
    public static boolean comprobarExtension(File f){
        String nom = f.getName();
        String ext = "ERROR";
        for (int i = 0; i < nom.length(); i++) {
            if (nom.charAt(i) == '.') {
                ext = nom.substring(i + 1);
                break;
            }
        }

        if (CIFRADO.equals(ext) || NOCIFRADO.equals(ext)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
    public static File cambiarExtension(File fich) {
        String nuevo = "";
        String actual = "";
        for (int i = 0; i < fich.getName().length(); i++) {
            if (fich.getName().charAt(i) == '.') {
                nuevo = fich.getName().substring(0, i + 1);
                actual = fich.getName().substring(i + 1);
                break;
            }
        }
        if (actual.equals(CIFRADO)){
            nuevo += NOCIFRADO;
        } else {
            nuevo += CIFRADO;
        }
        return new File(nuevo);
    }
    public static File pedirFichero(){
        System.out.print("Introduce el fichero: ");
        File fich = new File(sc.nextLine());
        if (fich.exists()) {
            return fich;
        }
        return null;
    }
    public static String pedirPalabra() {
        System.out.print("Introduce la palabra mágica: ");
        String magica = sc.nextLine();
        return magica;
    }
    public static int crearValor(String palabra){
        int valor = 0;
        for (int i = 0; i < palabra.length(); i++) {
            if ( i % 2 == 0) {
                valor += palabra.charAt(i);
            } else {
                valor -= palabra.charAt(i);
            }
        }
        return valor;
    }
    public static void encriptarPorValor(File fich) {
        String palabra = pedirPalabra();
        int valor = crearValor(palabra);
        try {
            BufferedReader encR = new BufferedReader(new FileReader(fich));
            BufferedWriter encW = new BufferedWriter(new FileWriter(cambiarExtension(fich)));
            int viejoValor;
            int nuevoValor;
            while ((viejoValor = encR.read()) != -1) {
                nuevoValor = viejoValor - valor;
                encW.write(nuevoValor);
            }

            encR.close();
            encW.close();
        } catch (IOException e) {
            LOGGER.error(e.getStackTrace());
            System.out.println("ERROR: No se ha podido crear el fichero encriptado");
        }
    }
    public static void encriptarPorBase(File fich) {
        String linea = "";
        String cadenaCodificada = "";
        try {
            BufferedReader encR = new BufferedReader(new FileReader(fich));
            BufferedWriter encW = new BufferedWriter(new FileWriter(cambiarExtension(fich)));

            while ((linea = encR.readLine()) != null) {
                cadenaCodificada = Base64.getEncoder().encodeToString(linea.getBytes());

                encW.write(cadenaCodificada + "\n");
            }

            encR.close();
            encW.close();
        } catch (IOException e) {
            LOGGER.error(e.getStackTrace());
        }
    }
    public static void encriptarPorCipher(File fich) {
        String linea = "";
        String palabra = pedirPalabra();
        String iv = "SECRETO";
        String cadenaCodificada;
        try {
            BufferedReader encR = new BufferedReader(new FileReader(fich));
            BufferedWriter encW = new BufferedWriter(new FileWriter(cambiarExtension(fich)));
            Cipher cipher = Cipher.getInstance(TIPO_CIFRADO);
            SecretKeySpec llave = new SecretKeySpec(palabra.getBytes(), ALGORITMO);
            IvParameterSpec ivParam = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, llave, ivParam);

            while ((linea = encR.readLine()) != null) {
                byte[] encriptado = cipher.doFinal(linea.getBytes());
                cadenaCodificada = Base64.getEncoder().encodeToString(encriptado);
                encW.write(cadenaCodificada + "\n");
            }

            encR.close();
            encW.close();
        } catch (Exception e) {
            LOGGER.error(e.getStackTrace());
        }
    }
    public static void desencriptarPorValor(File fich) {
        String palabra = pedirPalabra();
        int valor = crearValor(palabra);
        try {
            BufferedReader encR = new BufferedReader(new FileReader(fich));
            BufferedWriter encW = new BufferedWriter(new FileWriter(cambiarExtension(fich)));
            int viejoValor;
            int nuevoValor;
            while ((viejoValor = encR.read()) != -1) {
                nuevoValor = viejoValor + valor;
                encW.write(nuevoValor);
            }

            encR.close();
            encW.close();
        } catch (IOException e) {
            LOGGER.error(e.getStackTrace());
            System.out.println("ERROR: No se ha podido leer el fichero encriptado");
        }
    }
    public static void desencriptarPorBase(File fich) {
        String linea = "";
        try {
            BufferedReader encR = new BufferedReader(new FileReader(fich));
            BufferedWriter encW = new BufferedWriter(new FileWriter(cambiarExtension(fich)));

            while ((linea = encR.readLine()) != null) {
                byte[] bytesDecodificados = Base64.getDecoder().decode(linea);
                String cadenaDecodificada = new String(bytesDecodificados);

                encW.write(cadenaDecodificada + "\n");
            }

            encR.close();
            encW.close();
        } catch (IOException e) {
            LOGGER.error(e.getStackTrace());
        }
    }
    public static void desencriptarPorCipher(File fich) {
        String linea = "";
        String palabra = pedirPalabra();
        String iv = "SECRETO";

        try {
            BufferedReader encR = new BufferedReader(new FileReader(fich));
            BufferedWriter encW = new BufferedWriter(new FileWriter(cambiarExtension(fich)));
            Cipher cipher = Cipher.getInstance(TIPO_CIFRADO);
            SecretKeySpec llave = new SecretKeySpec(palabra.getBytes(), ALGORITMO);
            IvParameterSpec ivParam = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, llave, ivParam);

            while ((linea = encR.readLine()) != null) {
                byte[] decode = Base64.getDecoder().decode(linea.getBytes());
                byte[] desencriptado = cipher.doFinal(decode);

                encW.write(new String(desencriptado) + "\n");
            }

            encR.close();
            encW.close();
        } catch (Exception e) {
            LOGGER.error(e.getStackTrace());
        }
    }
    @Override
    public void encriptar(File fich) {
        switch (this.type) {
            case 1:
                encriptarPorValor(fich);
                break;
            case 2:
                encriptarPorBase(fich);
                break;

            case 3:
                encriptarPorCipher(fich);
                break;
        }
    }
    @Override
    public void desencriptar(File fich) {
        if (comprobarExtension(fich)) {
            switch (this.type) {
                case 1:
                    desencriptarPorValor(fich);
                    break;
                case 2:
                    desencriptarPorBase(fich);
                    break;

                case 3:
                    desencriptarPorCipher(fich);
                    break;
            }
        } else {
            System.out.println("ERROR: El fichero debe estar encriptado");
        }
    }
}
