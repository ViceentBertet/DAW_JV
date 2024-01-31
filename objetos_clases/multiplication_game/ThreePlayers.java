package objetos_clases.multiplication_game;

public class ThreePlayers extends TwoPlayers {
    private double respuesta1;
    private double respuesta2;
    private double respuesta3;
    public ThreePlayers() {
        super();
    }

    public ThreePlayers(int respuesta1, int respuesta2, double respuesta3) {
        super(respuesta1, respuesta2);
        this.respuesta3 = respuesta3;
    }
    public double getRespuesta3() {
        return respuesta3;
    }
    public void setRespuesta3(double respuesta3) {
        this.respuesta3 = respuesta3;
    }
}
