package gestionCuentas;

public class CuentaPersona extends Cuenta{
    private String nombre;
    private String apellido;

    public CuentaPersona(){};
    public CuentaPersona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
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
        System.out.println("Nombre : "+nombre+"\nApellido: "+apellido);
        System.out.println("Saldo: "+super.getSaldo());
    }
}
