package excepciones.chorra;

import java.io.IOException;

public class Chorra {
    public Chorra() throws IOException{
        throw new IOException("Hola holita");
    }
    public Chorra(String chorra) throws ArithmeticException {
        throw new ArithmeticException("8M");
    }

}
