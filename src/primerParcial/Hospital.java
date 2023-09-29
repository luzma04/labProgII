package primerParcial;
import java.io.*;
import java.util.*;
public class Hospital {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in).useDelimiter("\n");
        //CARGAR DOCTORES
        ArrayList<Doctor>doctores = new ArrayList <>();
        Doctor d1 = new Doctor("Pedro Suarez",20143345,01,2,1990,"Cardiologo");
        Doctor d2 = new Doctor("Claudia Aguirre",37143675,27,8,1995,"Clinico");
        doctores.add(d1);
        doctores.add(d2);
        String datos="";
        gestionHospital hospital = new gestionHospital();
        try (Scanner entrada = new Scanner(new File("C:\\Users\\Usuario\\Desktop\\examen\\src\\primerParcial\\datos.txt"))) {
            datos = entrada.nextLine();
        } catch (FileNotFoundException e) {
            System.err.println("Error al leer el nombre del hotel desde el archivo: " + e.getMessage());
        }
        hospital.setDatos(datos);
        boolean salir = false;
        while(!salir) {
            System.out.println("= = = = = = = "+hospital.getDatos()+" = = = = = = =");
            System.out.println(" - - - - - - M E N U - - - - - - \n" +
                    "1.Listar Doctores.\n" +
                    "2. Registrar un nuevo paciente.\n" +
                    "3. Actualizar información personal de un paciente.\n" +
                    "4. Consultar el historial médico de un paciente.\n" +
                    "5. Nuevo historial para un paciente. \n" +
                    "6. Guardar Historial de pacientes en archivo \n" +
                    "7. Cargar Historial de pacientes desde archivo \n" +
                    "8. Salir.\n");
            int op = t.nextInt();
            switch (op) {
                case 1:
                    hospital.listarDoctores(doctores);
                    break;
                case 2:
                    hospital.registrarPaciente();
                    break;
                case 3:
                    hospital.modificarPaciente();
                    break;
                case 4:
                    hospital.verHistorial();
                    break;
                case 5:
                    hospital.cargarHistorial();
                    break;
                case 6:
                    hospital.guardarHistArchivo("archivo.dat");
                    break;
                case 7:
                    hospital.leerHistArchivo("archivo.dat");
                    break;
                case 8:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;

            }

        }
    }
}
abstract class Persona{
    private String nombre;
    private int DNI;
    private int nacDia;
    private int nacMes;
    private int nacYear;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public int getNacDia() {
        return nacDia;
    }

    public void setNacDia(int nacDia) {
        this.nacDia = nacDia;
    }

    public int getNacMes() {
        return nacMes;
    }

    public void setNacMes(int nacMes) {
        this.nacMes = nacMes;
    }

    public int getNacYear() {
        return nacYear;
    }

    public void setNacYear(int nacYear) {
        this.nacYear = nacYear;
    }
}

class Doctor extends Persona implements Serializable{
    private String especialidad;

    public Doctor(String nombre, int DNI, int d, int m, int a, String especialidad) {
        this.setNombre(nombre);
        this.setDNI(DNI);
        this.setNacDia(d);
        this.setNacMes(m);
        this.setNacYear(a);
        this.especialidad = especialidad;
    }

    public void mostrarInfo(){
        System.out.println("Nombre: "+this.getNombre()+"\nDNI: "+this.getDNI());
        System.out.println("Fecha de Nacimiento: "+this.getNacDia()+"/"+this.getNacMes()+"/"+this.getNacYear());
        System.out.println("Especialidad: "+especialidad);
    }
}

interface Informacion{
    public void verHistorialDeEventos();
}

class Historial implements Serializable{
    private String fecha;
    private String observaciones;

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Historial() {}

    @Override
    public String toString() {
        return "--- H I S T O R I A L ---\n" +
                fecha + " - " + observaciones;
    }
}

class Paciente extends Persona implements Informacion, Serializable{
    private int tel;
    private int bloodType;
    private ArrayList<Historial>historial = new ArrayList <>();

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getBloodType() {
        return bloodType;
    }

    public void setBloodType(int bloodType) {
        this.bloodType = bloodType;
    }



    public void setHistorial(Historial h) {
        historial.add(h);
    }

    public Paciente(){}

    @Override
    public void verHistorialDeEventos() {
        for(Historial x : historial){
            System.out.println(x);
        }
    }
}

class gestionHospital implements Serializable{
    private String datos;

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    Scanner t = new Scanner(System.in).useDelimiter("\n");
    ArrayList<Paciente>pacientes = new ArrayList <>();
    public void listarDoctores(ArrayList<Doctor>doctores){
        for(Doctor x : doctores){
            System.out.println("-------------------------------------");
            x.mostrarInfo();
            System.out.println("-------------------------------------");
        }
    }

    public void registrarPaciente(){
        Paciente p = new Paciente();
        System.out.println("Ingrese nombre: ");
        p.setNombre(t.next());
        System.out.println("Ingrese DNI: ");
        p.setDNI(t.nextInt());
        System.out.print("Fecha de nacimiento\n Dia: ");
        p.setNacDia(t.nextInt());
        System.out.print(" Mes: ");
        p.setNacMes(t.nextInt());
        System.out.print(" Año: ");
        p.setNacYear(t.nextInt());
        System.out.println("Telefono: ");
        p.setTel(t.nextInt());
        System.out.println("Tipo sangineo: ");
        p.setBloodType(t.nextInt());
        pacientes.add(p);
        System.out.println("Paciente registrado exitosamente");

    }
    public void modificarPaciente(){
        System.out.println("Ingrese DNI del paciente a modificar");
        int idMod = t.nextInt();
        for (Paciente x : pacientes){
            if(x.getDNI()==idMod){
                System.out.println("Ingrese nombre: ");
                x.setNombre(t.next());
                System.out.println("Ingrese DNI: ");
                x.setDNI(t.nextInt());
                System.out.print("Fecha de nacimiento\n Dia: ");
                x.setNacDia(t.nextInt());
                System.out.print(" Mes: ");
                x.setNacMes(t.nextInt());
                System.out.print(" Año: ");
                x.setNacYear(t.nextInt());
                System.out.println("Telefono: ");
                x.setTel(t.nextInt());
                System.out.println("Tipo sangineo: ");
                x.setBloodType(t.nextInt());
                System.out.println("Paciente actualizado");
            }
        }

    }
    public void verHistorial(){
        System.out.println("Ingrese DNI del paciente para ver historial");
        int idHist = t.nextInt();
        for (Paciente x : pacientes){
            if(x.getDNI()==idHist){
                x.verHistorialDeEventos();
            }
        }

    }
    public void cargarHistorial(){
        System.out.println("Ingrese DNI del paciente para agregar historial");
        int idHist = t.nextInt();
        for (Paciente x : pacientes){
            if(x.getDNI()==idHist){
                Historial h = new Historial();
                System.out.println("Ingrese fecha de observacion: (dd/mm/aaa)");
                h.setFecha(t.next());
                System.out.println("Ingrese observacion: ");
                h.setObservaciones(t.next());
                x.setHistorial(h);
            }
        }
        System.out.println("Historial guardado");
    }

    //ARCHIVOS
    public void guardarHistArchivo(String nombreArchivo){
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            salida.writeObject(pacientes);
            System.out.println("Reservas guardadas en archivo exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar las reservas en el archivo: " + e.getMessage());
        }
    }
    public static ArrayList<Paciente> leerHistArchivo(String nombreArchivo){
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            System.out.println("Pacientes e historial cargados exitosamente.");
            return (ArrayList<Paciente>) entrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar archivo: " + e.getMessage());
            return null;
        }
    }
}