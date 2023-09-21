package gestionCuentas;
import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorCuentas {
    ArrayList<CuentaPersona> cuentasP = new ArrayList<>();
    ArrayList<CuentaSociedad> cuentasS = new ArrayList<>();
    Scanner t = new Scanner(System.in).useDelimiter("\n");
    //A G R E G A R
    public void agregarCuentaPersona(CuentaPersona cuenta){
        cuentasP.add(cuenta);
        System.out.println("Cuenta registrada exitosamente");
    }
    public void agregarCuentaSociedad(CuentaSociedad cuenta){
        cuentasS.add(cuenta);
        System.out.println("Cuenta registrada exitosamente");
    }
    //E L I M I N A R
    public void eliminarCuentaPersona(int numeroCuenta){
        Iterator<CuentaPersona> it = cuentasP.iterator();
        int idDelete = numeroCuenta;
        while (it.hasNext()){
            CuentaPersona x = it.next();
            if (idDelete==x.getNumeroCuenta()){
                it.remove();
            }
        }
        System.out.println("Cuenta eliminada exitosamente");
    }

    public void eliminarCuentaSociedad(int numeroCuenta){
        Iterator<CuentaSociedad> it = cuentasS.iterator();
        int idDelete = numeroCuenta;
        while (it.hasNext()){
            CuentaSociedad x = it.next();
            if (idDelete==x.getNumeroCuenta()){
                it.remove();
            }
        }
        System.out.println("Cuenta eliminada exitosamente");
    }

    //E D I T A R
    public void editarCuentaPersona(int numeroCuenta, double nuevoSaldo){
        for (CuentaPersona x : cuentasP){
            if(x.getNumeroCuenta()==numeroCuenta){
                x.setSaldo(nuevoSaldo);
                System.out.println("Saldo actualizado exitosamente!");
            }
        }
    }

    public void editarCuentaSociedad(int numeroCuenta, double nuevoSaldo){
        for (CuentaSociedad x : cuentasS){
            if(x.getNumeroCuenta()==numeroCuenta){
                System.out.println("Ingrese nuevo saldo: ");
                x.setSaldo(t.nextDouble());
                System.out.println("Saldo actualizado exitosamente!");
            }
        }
    }

    //M O S T R A R
    public void mostrarTodasLasCuentas(){
        System.out.println("--- Cuentas Persona ---");
        for (CuentaPersona x : cuentasP){
            System.out.println("--------------------");
            x.mostrarInformacion();
            System.out.println("--------------------");
        }
        System.out.println("--- Cuentas Sociedad ---");
        for (CuentaSociedad x : cuentasS){
            System.out.println("--------------------");
            x.mostrarInformacion();
            System.out.println("--------------------");
        }
    }
}
