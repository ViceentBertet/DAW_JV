package objetos_clases.multiplication_game;

public class TwoPlayers extends Juego {

    private int respuesta1;
    private int respuesta2;

    public TwoPlayers() {
        super();
    }

    public TwoPlayers(int respuesta1, int respuesta2) {
        super();
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
    }

    public int getRespuesta1() {
        return respuesta1;
    }
    public void setRespuesta1(int respuesta1) {
        this.respuesta1 = respuesta1;
    }
    public int getRespuesta2() {
        return respuesta2;
    }
    public void setRespuesta2(int respuesta2) {
        this.respuesta2 = respuesta2;
    }
}
