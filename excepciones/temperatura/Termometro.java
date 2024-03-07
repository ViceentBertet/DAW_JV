package excepciones.temperatura;

public class Termometro {
    private String nombre;
    private double temperatura;
    public Termometro() {
        super();
    }
    public Termometro(String nombre, double temperatura) throws TemperaturaFueraRangoException {
        if (temperatura >= -192 && temperatura <= 100) {
            this.temperatura = temperatura;
        } else {
            throw new TemperaturaFueraRangoException("ERROR: Temperatura incorrecta");
        }
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getTemperatura() {
        return temperatura;
    }
    public void setTemperatura(double temperatura) throws TemperaturaFueraRangoException {
        if (temperatura >= -192 || temperatura <= 100) {
            this.temperatura = temperatura;
        } else {
            throw new TemperaturaFueraRangoException("ERROR: Temperatura incorrecta");
        }
    }
}
