package gestionCuentas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in).useDelimiter("\n");
        GestorCuentas gestor = new GestorCuentas();
        int aux=1;
        do {
            System.out.println("------- MENU ------- \nREGISTRO DE CUENTAS");
            System.out.println("1- Agregar\n2- Eliminar\n3- Modificar\n4 - Mostrar todas las cuentas");
            int op = t.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Qué tipo de cuenta desea agregar?\n1.Cuenta de persona\n2.Cuenta de sociedad");
                    CuentaPersona cp = new CuentaPersona();
                    int typeAcc=t.nextInt();
                    if(typeAcc==1){
                        System.out.println("Ingrese numero de cuenta: ");
                        cp.setNumeroCuenta(t.nextInt());
                        System.out.println("Nombre: ");
                        cp.setNombre(t.next());
                        System.out.println("Apellido: ");
                        cp.setApellido(t.next());
                        System.out.println("Saldo: ");
                        cp.setSaldo(t.nextDouble());
                        gestor.agregarCuentaPersona(cp);
                    }else if(typeAcc==2){
                        CuentaSociedad cs = new CuentaSociedad();
                        System.out.println("Ingrese numero de cuenta: ");
                        cs.setNumeroCuenta(t.nextInt());
                        System.out.println("Nombre de la empresa: ");
                        cs.setNombreEmpresa(t.next());
                        System.out.println("Tipo de la empresa: ");
                        cs.setTipoEmpresa(t.next());
                        System.out.println("Saldo: ");
                        cs.setSaldo(t.nextDouble());
                        gestor.agregarCuentaSociedad(cs);
                    }else{
                        System.out.println("Opcion no valida");
                    }
                    break;
                case 2:
                    System.out.println("Qué tipo de cuenta desea eliminar?\n1.Cuenta de persona\n2.Cuenta de sociedad");
                    int typeAccDelete=t.nextInt();
                    if(typeAccDelete==1){
                        System.out.println("Ingrese numero de cuenta: ");
                        gestor.eliminarCuentaPersona(t.nextInt());
                    }else if(typeAccDelete==2){
                        System.out.println("Ingrese numero de cuenta: ");
                        gestor.eliminarCuentaSociedad(t.nextInt());
                    }else{
                        System.out.println("Opcion no valida");
                    }
                    break;
                case 3:
                    System.out.println("Qué tipo de cuenta desea modificar?\n1.Cuenta de persona\n2.Cuenta de sociedad");
                    int typeAccMod=t.nextInt();
                    if(typeAccMod==1){
                        System.out.println("Ingrese numero de cuenta: ");
                        int idAcc=t.nextInt();
                        System.out.println("Ingrese saldo nuevo: ");
                        double saldoMod=t.nextDouble();
                        gestor.editarCuentaPersona(idAcc, saldoMod);
                    }else if(typeAccMod==2){
                        System.out.println("Ingrese numero de cuenta: ");
                        int idAcc=t.nextInt();
                        System.out.println("Ingrese saldo nuevo: ");
                        double saldoMod=t.nextDouble();
                        gestor.editarCuentaSociedad(idAcc, saldoMod);
                    }else{
                        System.out.println("Opcion no valida");
                    }
                    break;
                case 4:
                    gestor.mostrarTodasLasCuentas();
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }
            System.out.println("Desea realizar otra accion? 1.SI 2.NO");
            aux=t.nextInt();
        }while(aux==1);
    }
}
