package objetos_clases.banco;

public class CuentaBancaria {
    private final int cuenta;
    private double saldo;
    public CuentaBancaria(int cuenta, double saldo){
        this.cuenta = cuenta;
        this.saldo = saldo;
    }
    public int getCuenta() {
        return cuenta;
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
