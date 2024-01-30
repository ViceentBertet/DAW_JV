package string_builder;

public class Capicua {
    public static StringBuilder numeros = new StringBuilder();
    public static void main(String[] args) {
        numeros.append("1234");
        numeros.append("4321");
        boolean capicua  = isCapicua();
        if (capicua) {
            System.out.println("Es capicua");
        } else {
            System.out.println("No es capicua");
        }
    }
    public static boolean isCapicua(){
        if (numeros.charAt(0) == numeros.charAt(numeros.length() - 1)) {
            return true;
        }
        return false;
    }
}
