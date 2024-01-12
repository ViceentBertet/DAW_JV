package objetos_clases.banco;

public class CuentaBancaria {
    private final int CUENTA;
    private double saldo;
    public CuentaBancaria(int cuenta, double saldo){
        this.CUENTA = cuenta;
        this.saldo = saldo;
    }
    public int getCuenta() {
        return CUENTA;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        if (saldo < 0) {
            System.out.println("ERROR: El saldo no puede ser negativo");
        } else {
            this.saldo = saldo;
        }
    }
}
