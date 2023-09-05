package gestionEmpleados;

public class EmpleadoComision extends Empleado{
    private double ventasRealizadas;

    public double getVentasRealizadas() {
        return ventasRealizadas;
    }

    public void setVentasRealizadas(double ventasRealizadas) {
        this.ventasRealizadas = ventasRealizadas;
    }

    @Override
    public double calcularSueldo() {
        return sueldoBase*(ventasRealizadas*0.2); //COMISION POR VENTAS DEL 20%
    }
}
