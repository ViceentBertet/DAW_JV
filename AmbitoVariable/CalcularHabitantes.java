package AmbitoVariable;

public class CalcularHabitantes {
    public static int kmComunidad = 23255;

    public static void main(String[] args) {
        //1. Valencia 2. Castellón
        double[] kmComunidades = {10000, 6600};
        double[] habComunidades= {2500000, 571000};
        habitantesValencia(kmComunidades, habComunidades);
        habitantesCastelló(kmComunidades, habComunidades);

        double sumaKm = kmComunidades[0] + kmComunidades[1];
        double porcentaje = (sumaKm * 100) / kmComunidad;
        System.out.printf("El porcentaje de km cuadrados que ocupa la suma de castellón y valencia en la Comunidad Valenciana es del %.2f porciento.\n", porcentaje);
    }
    public static void habitantesValencia(double[] comunidad, double[] habitantes){
        double habPorKm = habitantes[0] / comunidad[0];
        System.out.printf("En Valencia hay %.2f habitantes por km cuadrado.\n", habPorKm);
    }
    public static void habitantesCastelló(double[] comunidad, double[] habitantes){
        double habPorKm = habitantes[1] / comunidad[1];
        System.out.printf("En Castellón hay %.2f habitantes por km cuadrado.\n", habPorKm);
    }

}
