import java.sql.*;
class Mainn{
    public static void main(String[]args){
        Hospitall hospital = new Hospitall();
        Date fechaActual = new Date(2023-1900,11-1,12);
        Pacientee pacienteEj = new Pacientee("Juana Perez", 45, "Ninguno", fechaActual);
        hospital.agregarPaciente(pacienteEj);
        hospital.eliminarPaciente("Paciente1");
        hospital.asignarDoctorCabecera("Doctor2", "Juana Perez");
        //hospital.mostrarListaPacientes();
        Date fechaDesde = new Date(2023 - 1900, 11 - 1, 1);
        Date fechaHasta = new Date(2023 - 1900, 12 - 1, 20);
        hospital.mostrarPacientesEntreFechas(fechaDesde, fechaHasta);
    }
}
abstract class Personaa {
    private String nombre;
    private int edad;

    public Personaa( String nombre, int edad) {

        this.nombre = nombre;
        this.edad = edad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
}

class Pacientee extends Personaa{
    private String historialMedico;
    private Date fechaIngreso;
    private int doctorCabecera;

    public Pacientee(String nombre, int edad, String historialMedico, Date fechaIngreso) {
        super( nombre, edad);
        this.historialMedico = historialMedico;
        this.fechaIngreso = fechaIngreso;
    }

    public String getHistorialMedico() {
        return historialMedico;
    }
    public void setHistorialMedico(String historialMedico) {
        this.historialMedico = historialMedico;
    }
    public Date getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public int getDoctorCabecera() {
        return doctorCabecera;
    }
    public void setDoctorCabecera(int doctorCabecera) {
        this.doctorCabecera = doctorCabecera;
    }
}

class Doctorr extends Personaa {
    private String especialidad;

    public Doctorr(String nombre, int edad, String especialidad) {
        super(nombre, edad);
        this.especialidad = especialidad;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}


class DBHelperr {
    private static final String URL = "jdbc:mysql://localhost:3306/hospital_bd2";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void ejecutarConsulta(String consulta) {
        try {

            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            try (PreparedStatement statement = connection.prepareStatement(consulta)) {

                statement.executeUpdate();
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet ejecutarConsultaConResultado(String consulta) {
        try {
            // Establecer la conexión con la base de datos
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Crear la declaración
            PreparedStatement statement = connection.prepareStatement(consulta);

            // Ejecutar la consulta y devolver el conjunto de resultados
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}

class Hospitall{
    public void agregarPaciente(Pacientee paciente) {
        String consulta = "INSERT INTO pacientes (nombre, edad, historial_medico, doctor, fecha_ingreso) VALUES ('" + paciente.getNombre() + "', " + paciente.getEdad() + ", '" + paciente.getHistorialMedico() + "', " + paciente.getDoctorCabecera() + ", '" + paciente.getFechaIngreso() + "')";
        DBHelper.ejecutarConsulta(consulta);
    }
    public void eliminarPaciente(String nombrePaciente) {
        String consulta = "DELETE FROM pacientes WHERE nombre = '" + nombrePaciente + "'";
        DBHelper.ejecutarConsulta(consulta);
    }
    public void mostrarListaPacientes() {
        String consulta = "SELECT * FROM pacientes";
        ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consulta);
        listarPacientes(resultado);
    }
    public void listarPacientes(ResultSet resultado){
        if (resultado != null) {
            try {
                System.out.println("Lista de Pacientes:");
                System.out.printf("%-10s %-15s %-5s %-20s %-12s %-10s\n", "ID", "Nombre", "Edad", "Historial Médico", "Fecha Ingreso", "Doctor");

                while (resultado.next()) {
                    int id = resultado.getInt("id");
                    String nombre = resultado.getString("nombre");
                    int edad = resultado.getInt("edad");
                    String historialMedico = resultado.getString("historial_medico");
                    Date fechaIngreso = resultado.getDate("fecha_ingreso");
                    int idDoctor = resultado.getInt("doctor");

                    System.out.printf("%-10d %-15s %-5d %-20s %-15s %-10d\n", id, nombre, edad, historialMedico, fechaIngreso, idDoctor);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void asignarDoctorCabecera(String nombreDoctor, String nombrePaciente) {
        String consulta = "UPDATE pacientes SET doctor = (SELECT id FROM doctores WHERE nombre = '"+nombreDoctor+"') WHERE nombre = '"+nombrePaciente+"'";
        DBHelper.ejecutarConsulta(consulta);
    }
    public void mostrarPacientesEntreFechas(Date fechaInicio, Date fechaFin) {
        String consulta = "SELECT * FROM pacientes WHERE fecha_ingreso BETWEEN '"+fechaInicio+"' AND '"+fechaFin+"';";
        ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consulta);
        listarPacientes(resultado);
    }
}
