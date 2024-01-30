package string_builder;

public class SnakeCase {
    /**/
    public static StringBuilder camelCase = new StringBuilder();
    public static StringBuilder snakeCase = new StringBuilder();
    public static void main(String[] args) {
        camelCase.append("hola");
        camelCase.append("Mundo");
        camelCase.append("Maravilloso");
        convertirPalabra();
        System.out.println(snakeCase.toString());
    }
    public static void convertirPalabra() {
        boolean isMayus;
        for (int i = 0; i < camelCase.length(); i++) {
            char a = camelCase.charAt(i);
            isMayus = Character.isUpperCase(a);
            if (!isMayus) {
                snakeCase.append(a);
            } else {
                snakeCase.append("_");
                snakeCase.append(a);
            }
        }
    }
}
