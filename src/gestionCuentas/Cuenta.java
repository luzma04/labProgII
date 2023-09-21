package gestionCuentas;
public abstract class Cuenta {
    protected int numeroCuenta;
    protected double saldo;

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public abstract void depositar(double cantidad);
    public abstract void retirar(double cantidad);
    public abstract void mostrarInformacion();
}
