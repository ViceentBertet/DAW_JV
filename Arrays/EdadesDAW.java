package Arrays;

public class EdadesDAW {
    public static void main(String[] args){

        String[][] classDAW = {{"Ricardo", "Jesús", "Victor", "Guillem", "Pablo", "Érika", "Filip"},{"Arturo", "Fernando", "Kevin", "Tavi", "Miguel", "Hugo R", "Alberto"}, {"Izan", "Jordi", "Hugo B", "Alex", "Vicent"}};
        int[][] agesDAW= {{20, 20, 19, 19, 28, 17, 19},{31, 29, 24, 21, 19, 19, 19},{18, 20, 18, 23, 18}};

        showYounger(classDAW, agesDAW);
        showOlder(classDAW, agesDAW);
    }
    public static void showYounger(String [][] classDAW, int[][] agesDAW) {
        int lowAge= 40;
        int[] savePosition = new int [2];
        for (int i = 0; i < agesDAW.length; i++) {
            for(int j = 0; j < agesDAW[i].length; j++) {
                if (lowAge > agesDAW[i][j]){
                    lowAge = agesDAW[i][j];
                    savePosition[0] = i;
                    savePosition[1] = j;
                }
            }
        }
        int fila = savePosition[0] + 1;
        int silla = savePosition[1] + 1;
        System.out.printf("La persona menor, se situa en la fila %d silla %d su nombre es %s y tiene %d años\n\n", fila, silla, classDAW[savePosition[0]][savePosition[1]], lowAge);
    }
    public static void showOlder(String [][] classDAW, int[][] agesDAW) {
        int highAge= 0;
        int[] savePosition = new int [2];
        for (int i = 0; i < agesDAW.length; i++) {
            for(int j = 0; j < agesDAW[i].length; j++) {
                if (highAge < agesDAW[i][j]){
                    highAge = agesDAW[i][j];
                    savePosition[0] = i;
                    savePosition[1] = j;
                }
            }
        }
        int fila = savePosition[0] + 1;
        int silla = savePosition[1] + 1;
        System.out.printf("La persona mayor, se situa en la fila %d silla %d su nombre es %s y tiene %d años\n", fila, silla, classDAW[savePosition[0]][savePosition[1]], highAge);
    }
}
