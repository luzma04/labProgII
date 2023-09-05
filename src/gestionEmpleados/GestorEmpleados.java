package gestionEmpleados;
import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;

public class GestorEmpleados implements Impuesto{
    Scanner t = new Scanner(System.in).useDelimiter("\n");
    ArrayList<Empleado> empleados = new ArrayList();

    public void agregarEmpleado(){
        System.out.println("--- INGRESE EL QUE CORRESPONDA ---");
        System.out.println("1- Empleado por hora\n2- Empleado asalariado\n3- Empleado con comision");
        int op = t.nextInt();
        Empleado x;
        boolean valido = true;
        switch(op){
            case 1:
                x = new EmpleadoPorHoras();
                EmpleadoPorHoras xC1 = (EmpleadoPorHoras) x;
                System.out.println("Ingrese horas trabajadas: ");
                xC1.setHorasTrabajadas(t.nextInt());
                break;
            case 2:
                x = new EmpleadoAsalariado();
                break;
            case 3:
                x = new EmpleadoComision();
                EmpleadoComision xC2 = (EmpleadoComision) x;
                System.out.println("Ingrese Ventas realizadas: ");
                xC2.setVentasRealizadas(t.nextInt());
                break;
            default:
                System.out.println("opcion no valida");
                x = new EmpleadoComision(); //esta linea no hace nada nada
                valido=false;
                break;
        }
        if (valido){
            System.out.println("Ingrese ID:");
            x.setId(t.nextInt());
            System.out.println("Ingrese nombre: ");
            x.setNombre(t.next());
            System.out.println("Ingrese sueldo base: ");
            x.setSueldoBase(t.nextDouble());
            empleados.add(x);
            System.out.println("Empleado registrado exitosamente");
        }

    }

    public void eliminarEmpleado(){
        Iterator<Empleado> it = empleados.iterator();
        System.out.println("Ingrese ID del empleado a eliminar: ");
        int idDel = t.nextInt();
        while (it.hasNext()){
            Empleado x = it.next();
            if (idDel==x.getId()){
                it.remove();
            }
        }
        System.out.println("Empleado eliminado exitosamente");
    }

    public void modificarEmpleado(){
        System.out.println("Ingrese ID del empleado a modificar");
        int idMod = t.nextInt();
        for (Empleado x : empleados){
            if(x.getId()==idMod){
                System.out.println("Nombre: ");
                x.setNombre(t.next());
                System.out.println("Sueldo base: ");
                x.setSueldoBase(t.nextDouble());
            }
        }
    }

    public void calcularSueldo(){
        System.out.println("Ingrese ID del empleado que desea consultar sueldo");
        int idAux = t.nextInt();
        for (Empleado x : empleados){
            if(x.getId()==idAux){
                System.out.println("Sueldo: "+x.calcularSueldo());
            }
        }
    }

    public void mostrarEmpleados(){
        for(Empleado x : empleados){
            System.out.println("- - - - - - - - - - - - - - - - - -");
            System.out.println("ID - "+x.getId()+"\nNombre: "+x.getNombre()+"\nSueldo: $"+x.calcularSueldo());
        }
    }



    @Override
    public void calcularImpuesto() {
        System.out.println("Ingrese ID del empleado que desea consultar el impuesto correspondiente:");
        int idAux = t.nextInt();
        for (Empleado x : empleados){
            if(x.getId()==idAux){
                System.out.println("Impuesto en base al sueldo: "+x.calcularSueldo()*0.1);
            }
        }
    }
}
