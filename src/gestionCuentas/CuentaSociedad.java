package gestionCuentas;

public class CuentaSociedad extends Cuenta{
    private String nombreEmpresa;
    private String tipoEmpresa;

    public CuentaSociedad(){};
    public CuentaSociedad(String nombreEmpresa, String tipoEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.tipoEmpresa = tipoEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(String tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    @Override
    public void depositar(double cantidad) {
        super.setSaldo(super.getSaldo()+cantidad);
    }

    @Override
    public void retirar(double cantidad) {
        if(super.getSaldo()>=cantidad){
            super.setSaldo(super.getSaldo()-cantidad);
        }else{
            System.out.println("No hay suficientes fondos");
        }

    }

    @Override
    public void mostrarInformacion() {
        System.out.println("N° de Cuenta: "+super.getNumeroCuenta());
        System.out.println("Tipo de Empresa: "+tipoEmpresa+"\nEmpresa: "+nombreEmpresa);
        System.out.println("Saldo: "+super.getSaldo());
    }
}
