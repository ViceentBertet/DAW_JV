package MetodosDAM;

public class OperacionesArrays {
    public static void main(String[] args){
        int length = (int) (Math.random() * 10) + 1;
        double[] array = new double[length];

        llenarArray(array);
        imprimirArray(array);

        double media = calcularMedia(array);
        System.out.printf("\nLa media es %.2f \n", media);

        encontrarCercano(array, media);
    }
    public static void llenarArray(double[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] = (double) Math.round(Math.random() * 1000) / 100;
        }
    }
    public static void imprimirArray(double[] array){
        for (double n : array) {
            System.out.print(n + " ");
        }
    }
    public static double calcularMedia(double[] array) {
        double media = 0;
        for (double n : array) {
            media += n;
        }
        media /= array.length;
        return media;
    }
    public static void encontrarCercano(double[] array, double media) {
        double cercano = array[0];
        double anterior = Math.abs(media - array[0]);
        for (int i = 0; i < array.length; i++) {
            if (Math.abs(media - array[i]) < anterior) {
                cercano = array[i];
                anterior = Math.abs(media - array[i]);
            }
        }
        System.out.printf("El n mas cercano es %.2f", cercano);
    }
}
