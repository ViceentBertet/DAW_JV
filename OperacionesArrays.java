public class OperacionesArrays {
    public static void main(String[] args){
        int length = (int) (Math.random() * 10);
        double[] array = new double[length];
        llenarArray(array, length);
        imprimirArray(array);
        calcularMedia(array, length);
    }
    public static void llenarArray(double[] array, int veces){
        for (int i = 0; i < veces; i++) {
            array[i] = Math.random() * 10;
        }
    }
    public static void imprimirArray(double[] array){
        for (double n : array) {
            System.out.print(n + " ");
        }
    }
    public static void calcularMedia(double[] array, int length) {
        double media = 0;
        for (double n : array) {
            media += n;
        }
        media /= length;
        System.out.println("\n La media es " + media);
    }
}
