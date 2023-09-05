package gestionEmpleados;

public class EmpleadoPorHoras extends Empleado{
    private int horasTrabajadas;

    public EmpleadoPorHoras() {
    }

    public void setHorasTrabajadas(int horasTrabajadas){
        this.horasTrabajadas = horasTrabajadas;
    }
    public int getHorasTrabajadas(){
        return horasTrabajadas;
    }

    @Override
    public double calcularSueldo() {
        return horasTrabajadas*sueldoBase; //SUELDO POR HORAS
    }


}
