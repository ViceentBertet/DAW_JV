package arraylist_varargs;

public class ImprimirLista {
    public static void main(String[] args) {
        printText("Hola", "Mundo");
    }
    public static void printText(String... words) {
        System.out.println("La lista contiene: ");
        for (String word : words){
            if (!word.equalsIgnoreCase(words[words.length - 1])) {
                System.out.print(word + ", ");
            } else {
                System.out.print(word + ".");
            }
        }
    }
}
