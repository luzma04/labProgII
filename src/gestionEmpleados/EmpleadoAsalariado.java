package gestionEmpleados;

public class EmpleadoAsalariado extends Empleado{
    @Override
    public double calcularSueldo() {
        return sueldoBase; //SUELDO FIJO
    }

}
