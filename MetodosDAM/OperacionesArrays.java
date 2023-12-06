public class OperacionesArrays {
    public static void main(String[] args){
        int length = (int) (Math.random() * 10) + 1;
        double[] array = new double[length];

        llenarArray(array, length);
        imprimirArray(array);

        double media = calcularMedia(array, length);
        System.out.printf("\nLa media es %.2f \n", media);

        encontrarCercano(array, length, media);
    }
    public static void llenarArray(double[] array, int length){
        for (int i = 0; i < length; i++) {
            array[i] = (double) Math.round(Math.random() * 1000) / 100;
        }
    }
    public static void imprimirArray(double[] array){
        for (double n : array) {
            System.out.print(n + " ");
        }
    }
    public static double calcularMedia(double[] array, int length) {
        double media = 0;
        for (double n : array) {
            media += n;
        }
        media /= length;
        return media;
    }
    public static void encontrarCercano(double[] array, int length, double media) {
        //El valor es 20 porque es la máxima diferencia que puede haber debido a que el n max es < 11
        double cercano = array[0];
        double anterior = Math.abs(media - array[0]);
        for (int i = 0; i < length; i++) {
            if (Math.abs(media - array[i]) < anterior) {
                cercano = array[i];
                anterior = Math.abs(media - array[i]);
            }
        }
        System.out.printf("El n mas cercano es %.2f", cercano);
    }
}
