package demo_vehiculo;

public class Coche extends Vehiculo implements IVehiculoMotor, IRadio {
    public Coche(int nRuedas, int nAsientos) {
        super(nRuedas, nAsientos);
    }
    @Override
    public void activarAntena() {

    }
    @Override
    public void startRadio() {

    }
    @Override
    public void stopRadio() {

    }
    @Override
    public void cambiarMarcha(int marcha) {

    }
    @Override
    public void encenderDerecha() {

    }
    @Override
    public void encenderIzquierda() {

    }
    @Override
    public void encenderTodos() {

    }
    @Override
    public void apagar() {

    }
    @Override
    public float getMaxVel() {
        return 0;
    }
    @Override
    public void arrancar() {

    }
    @Override
    public void detener() {

    }
}