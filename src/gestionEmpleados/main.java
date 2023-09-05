package gestionEmpleados;
import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Scanner t = new Scanner(System.in);
        GestorEmpleados gestor = new GestorEmpleados();
        int aux=1;
        do {
            System.out.println("------- MENU ------- \nREGISTRO DE EMPLEADOS");
            System.out.println("1- Agregar\n2- Eliminar\n3- Modificar\n4- Calcular sueldo\n5 - Calcular Impuesto \n6 - Mostrar empleados");
            int op = t.nextInt();
            switch (op) {
                case 1:
                    gestor.agregarEmpleado();
                    break;
                case 2:
                    gestor.eliminarEmpleado();
                    break;
                case 3:
                    gestor.modificarEmpleado();
                    break;
                case 4:
                    gestor.calcularSueldo();
                    break;
                case 5:
                    gestor.calcularImpuesto();
                    break;
                case 6:
                    gestor.mostrarEmpleados();
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
