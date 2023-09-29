package ModeloExamen;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in).useDelimiter("\n");
        ArrayList<Habitacion>habitaciones=new ArrayList<>();
        //NOMBRE DE HOTEL DESDE ARCHIVO
        String nombreHotel = "";
        try (Scanner entrada = new Scanner(new File("C:\\Users\\Usuario\\Desktop\\repaso\\src\\ModeloExamen\\nombreHotel.txt"))) {
            nombreHotel = entrada.nextLine();
        } catch (FileNotFoundException e) {
            System.err.println("Error al leer el nombre del hotel desde el archivo: " + e.getMessage());
        }
        //HABITACIONES REGISTRADAS
        habitaciones.add(new Habitacion(3,3,4));
        habitaciones.add(new Habitacion(4,2,2));
        habitaciones.add(new Habitacion(505,1,2));
        Hotel hotel = new Hotel(nombreHotel,habitaciones);

        System.out.println("= = = = = = = "+hotel.getNombre()+" = = = = = = =");

        //MENU
        boolean salir = false;
        while(!salir) {
            System.out.println("""
                    - - - - - - M E N U - - - - - -
                    1. Ver la lista de habitaciones.
                    2. Reservar una habitación.
                    3. Cancelar una reserva.
                    4. Guardar reservas en un archivo.
                    5. Cargar reservas desde un archivo.
                    6. Salir.        
                    """);
            int op = t.nextInt();
            switch (op) {
                case 1:
                    hotel.mostrarListaHabitaciones();
                    break;
                case 2:
                    hotel.reservarHabitacion();
                    break;
                case 3:
                    hotel.cancelarReserva();
                    break;
                case 4:
                    hotel.guardarAchivo("reservas.dat");
                    break;
                case 5:
                    hotel.leerArchivo("reservas.dat");
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;

            }
        }
    }
}
abstract class Persona implements Serializable{
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
interface mostrarInfo{
    public void mostrarInformacion();
}

class Huesped extends Persona implements mostrarInfo, Serializable{
    private int tel;

    public Huesped(){}
    public Huesped(String nombre, int tel){
        this.setNombre(nombre);
        this.tel=tel;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }
    @Override
    public void mostrarInformacion(){
        System.out.println("Nombre: "+getNombre());
    }
}

class Habitacion implements mostrarInfo, Serializable{
    private int num;
    private int cantCamas;
    private int capacidad;
    private boolean libre = true; //TRUE: libre - FALSE: ocupada
    private ArrayList<Huesped> huespedes;

    public Habitacion(int num, int cantCamas, int capacidad) {
        this.num = num;
        this.cantCamas = cantCamas;
        this.capacidad = capacidad;
    }

    public Habitacion(int num, ArrayList<Huesped> huespedes) {
        this.num = num;
        this.huespedes = huespedes;
    }

    public boolean isLibre() {
        return libre;
    }

    public int getNum() {
        return num;
    }

    public void reservar(ArrayList<Huesped> huespedes){
        this.libre=false;
        this.huespedes = huespedes;
    }
    public void cancelarReserva(){
        this.libre=true;
    }
    @Override
    public void mostrarInformacion(){
        System.out.println("- - - HABITACION N°"+num+" - - -");
        System.out.println("Cantidad de camas: "+cantCamas+"\nCapacidad: "+capacidad);
        if(libre){
            System.out.println("Estado: Libre");
        }else{
            System.out.println("Estado: Ocupado");
        }
        if (!libre) {
            System.out.println("Huéspedes:");
            for (Huesped huesped : huespedes) {
                huesped.mostrarInformacion();
            }
        }
    }
}

class Hotel implements Serializable{
    private String nombre;
    private ArrayList<Habitacion>habitaciones;

    Scanner t = new Scanner(System.in).useDelimiter("\n");

    public Hotel(String nombre, ArrayList<Habitacion> habitaciones) {
        this.nombre = nombre;
        this.habitaciones = habitaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrarListaHabitaciones(){
        for(Habitacion x : habitaciones){
            x.mostrarInformacion();
        }
    }
    public void reservarHabitacion(){
        System.out.println("Ingrese el número de habitación que desea reservar: ");
        int numHab = t.nextInt();
        System.out.println("Ingrese la cantidad de huéspedes: ");
        int cantHuespedes = t.nextInt();
        ArrayList<Huesped> huespedes = new ArrayList<>();
        for (int i = 0; i < cantHuespedes; i++) {
            System.out.println("Ingrese el nombre del huésped " + (i + 1) + ": ");
            String nombreHuesped = t.next();
            System.out.println("Ingrese telefono del huésped " + (i + 1) + ": ");
            int tel = t.nextInt();
            huespedes.add(new Huesped(nombreHuesped, tel));
        }
        //VERIFICAR QUE LA HABITACION EXISTA
        Iterator<Habitacion> it = habitaciones.iterator();
        boolean aux = true;
        while (it.hasNext()){
            Habitacion x = it.next();
            if (numHab==x.getNum() && x.isLibre()){
                aux = false;
                x.reservar(huespedes);
                System.out.println("Habitacion reservada exitosamente");
            }
        }
        if(aux){
            System.out.println("Habitacion no disponible");
        }
    }
    public void cancelarReserva(){
        System.out.println("Ingrese el número de habitación para cancelar la reserva: ");
        int numHabDelete = t.nextInt();
        Iterator<Habitacion> it = habitaciones.iterator();
        boolean aux = true;
        while (it.hasNext()){
            Habitacion x = it.next();
            if (numHabDelete==x.getNum()){
                aux = false;
                x.cancelarReserva();
                System.out.println("Reserva cancelada exitosamente");
            }
            if(aux) {
                System.out.println("Habitacion no valida");
            }
        }
    }

    //GUADAR Y CARGAR RESERVAS DESDE ARCHIVOS
    public void guardarAchivo(String nombreArchivo){
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            salida.writeObject(habitaciones);
            System.out.println("Reservas guardadas en archivo exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar las reservas en el archivo: " + e.getMessage());
        }
    }
    public static ArrayList<Habitacion> leerArchivo(String nombreArchivo){
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            System.out.println("Reservas cargadas exitosamente.");
            return (ArrayList<Habitacion>) entrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar las reservas desde el archivo: " + e.getMessage());
            return null;
        }
    }
}