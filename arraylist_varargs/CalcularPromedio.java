package arraylist_varargs;

public class CalcularPromedio {
    public static void main(String[] args) {
        int suma = sumaVarArgs();
        System.out.println("El resultado de la suma es: " + suma);
    }
    public static int sumaVarArgs(int... numeros) {
        int suma = 0;
        for (int numero : numeros) {
            suma += numero;
        }
        return suma;
    }
}
