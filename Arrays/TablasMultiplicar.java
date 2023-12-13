package Arrays;

public class TablasMultiplicar {
    public static void main(String[] args) {
        int[][] tablas = new int[10][10];

        fillArray(tablas);
        showArray(tablas);
    }
    public static void fillArray(int [][] tablas){
        for(int i = 0; i < tablas.length;i++) {
            int tablaActual = i + 1;

            for(int j = 0; j < tablas.length; j++){
                int n = tablaActual * (j + 1);
                tablas[i][j] = n;
            }
        }
    }
    public static void showArray(int [][] tablas){
        for(int i = 0; i < tablas.length;i++) {
            int tablaActual = i + 1;

            System.out.printf("\nTabla del " + tablaActual + ":\n");

            for(int j = 0; j < tablas.length; j++){
                if (j + 1 != tablas.length) {
                    System.out.printf("%d, ", tablas[i][j]);
                } else {
                    System.out.printf("%d\n", tablas[i][j]);
                }
            }
        }
    }
}
