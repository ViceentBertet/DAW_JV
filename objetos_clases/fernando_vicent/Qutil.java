package objetos_clases.fernando_vicent;

public class Qutil {
    protected static boolean esVocal(char letra) {
        boolean vocal = false;
        final char A  = 'a';
        final char E  = 'e';
        final char I  = 'i';
        final char O  = 'o';
        final char U  = 'u';
        if (A == letra || E == letra || I == letra || O == letra || U ==letra) {
            vocal = true;
        }
        return vocal;
    }
    protected static boolean esVocal(String palabra){
        boolean vocal;
        vocal = Qutil.esVocal(palabra.toLowerCase().charAt(0));
        return vocal;
    }
}
