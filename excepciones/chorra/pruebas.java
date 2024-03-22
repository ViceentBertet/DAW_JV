package excepciones.chorra;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;

public class pruebas {

    public static void main(String[] args) {
        String usuarios = "hola";
        for (int i = 0; i < usuarios.length(); i++){
            if (usuarios.charAt(i) == ';') {
                System.out.println("esta");
            }
        }
    }
}
