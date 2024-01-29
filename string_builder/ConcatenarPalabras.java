package string_builder;

import java.util.ArrayList;
import java.util.Scanner;

public class ConcatenarPalabras {
    public static ArrayList<String> words = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("Introduce palabras que quieres, en caso de que quieras parar, introduce <1234salir>");
        introduceWords();
        String frase = createString();
        System.out.println(frase);
    }
    public static void introduceWords() {
        Scanner sc = new Scanner(System.in);
        String palabra = "";
        while (!palabra.equals("1234salir")) {
            palabra = sc.nextLine();
            if (!palabra.equals("1234salir")) {
                words.add(palabra);
            } else {
                System.out.println("Saliendo...");
            }
        }
    }
    public static String createString() {
        StringBuilder frase = new StringBuilder();
        for (String word : words) {
            frase.append(word);
        }
        return frase.toString();
    }
}
