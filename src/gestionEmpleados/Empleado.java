package gestionEmpleados;
abstract class Empleado {
    //ATRIBUTOS
    protected String nombre;
    protected int id;
    protected double sueldoBase;

    //GETTERS & SETTERS
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getSueldoBase() {
        return sueldoBase;
    }
    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    //METODOS
    public abstract double calcularSueldo();
    /*Debe calcular el sueldo del empleado en función de su tipo específico.*/
}
