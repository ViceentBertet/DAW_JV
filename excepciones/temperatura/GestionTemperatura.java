package excepciones.temperatura;

public class GestionTemperatura {
    public static void main(String[] args) {
        try {
            Termometro t1 = new Termometro("Juan", 37.5);
            System.out.println(t1.getTemperatura());
        } catch (TemperaturaFueraRangoException e) {
            System.out.println(e.getMessage());
        }
        try {
            Termometro t2 = new Termometro("Carlos", -193.5);
            System.out.println(t2.getTemperatura());
        } catch (TemperaturaFueraRangoException e) {
            System.out.println(e.getMessage());
        }
        try {
            Termometro t3 = new Termometro("Dani", 102);
            System.out.println(t3.getTemperatura());
        } catch (TemperaturaFueraRangoException e) {
            System.out.println(e.getMessage());
        }
    }
}
