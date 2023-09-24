import java.io.*;
import java.util.*;

public class ViajeComercial{
    protected String nombreChofer;
    protected String matricula;
    protected String codigoViaje;
    protected String lugarInicio;
    protected String lugarLlegada;
    protected String horaInicio;
    protected String horaLlegada;
    protected int totalAsientos;
    protected Hashtable<String, Pasajero> pasajerosRutMap;
    protected byte[] asientosDisponibles;
    
    public ViajeComercial(String nombreChofer, String codigoViaje, String matricula, String lugarInicio,
                          String lugarLlegada, String horaInicio, String horaLlegada, int totalAsientos) {
        this.totalAsientos = totalAsientos;
        this.nombreChofer = nombreChofer;
        this.codigoViaje = codigoViaje;
        this.matricula = matricula;
        
        this.lugarInicio = lugarInicio;
        this.lugarLlegada = lugarLlegada;
        this.horaInicio = horaInicio;
        this.horaLlegada = horaLlegada;
                
        pasajerosRutMap = new Hashtable<>(totalAsientos);
        asientosDisponibles = new byte[totalAsientos];
    }

    // Getters
    public String getNombreChofer() {
        return nombreChofer;
    }
    public String getMatricula() {
        return matricula;
    }

    public String getCodigo() {
        return codigoViaje;
    }

    public String getLugarDeInicio() {
        return lugarInicio;
    }

    public String getLugarDeLlegada() {
        return lugarLlegada;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public int getTotalAsientos() {
        return totalAsientos;
    }


    public boolean estaDisponible(int numeroAsiento)
    {
        if(asientosDisponibles[numeroAsiento - 1] == 0) return true;
        return false;
    }

    public int getCantPasajeros()
    {
        return pasajerosRutMap.size();
    }
    

    // Setters
        
    public void setNombreChofer(String nombreChofer) {
        this.nombreChofer = nombreChofer;
    }
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public void setCodigoViaje(String codigoViaje) {
        this.codigoViaje = codigoViaje;
    }
    
    public void setLugarDeInicio(String lugarInicio) {
        this.lugarInicio = lugarInicio;
    }
    
    public void setLugarDeLlegada(String lugarLlegada) {
        this.lugarLlegada = lugarLlegada;
    }
    
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }
    
    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }
    
    public void setTotalAsientos(int totalAsientos) {
        this.totalAsientos = totalAsientos;
    }

    // Funcionalidades
    
    public boolean agregarPasajero(Pasajero pasajero) 
    {
        if(pasajerosRutMap.containsKey(pasajero.getRut()))
            return false;
        pasajerosRutMap.put(pasajero.getRut(), pasajero);
        asientosDisponibles[pasajero.getNroAsiento() - 1] = 1;
        return true;
    }

    public Pasajero eliminarPasajero(String rutPasajero) {
        if(!pasajerosRutMap.containsKey(rutPasajero))
            return null;
        return pasajerosRutMap.remove(rutPasajero);
    }


    public void mostrarPasajero(Pasajero pasajeroCurrent)
    {
        System.out.println("Nombre: " + pasajeroCurrent.getNombrePasajero());
        System.out.println("RUT: " + pasajeroCurrent.getRut());
        System.out.println("Tipo de pasajero: " + pasajeroCurrent.getTipo());
        System.out.println("Codigo de su viaje: " + pasajeroCurrent.getCodigoViajePasajero());
        System.out.println("Numero de asiento: " + pasajeroCurrent.getNroAsiento());
        System.out.println("\n");
    }
    
    public void listarPasajeros()
    {
        if (pasajerosRutMap.size() == 0)
        {
            System.out.println("No hay pasajeros en el sistema.");
            return;
        }
        
        System.out.println("Lista de pasajeros del bus:");  
        Enumeration<Pasajero> enumeration = pasajerosRutMap.elements();
        int i = 0;
        while (enumeration.hasMoreElements()) {
            Pasajero pasajeroCurrent = enumeration.nextElement();
            i++;
            System.out.println("Pasajero " + i + ":");
            mostrarPasajero(pasajeroCurrent);
        }
    }


    public void listarPasajeros(String tipoPasajero)
    {
        if (pasajerosRutMap.size() == 0)
        {
            System.out.println("No hay pasajeros coincidentes en el sistema.");
            return;
        }
        
        System.out.println("Lista de pasajeros de tipo: " + tipoPasajero);
        Enumeration<Pasajero> enumeration = pasajerosRutMap.elements();
        int j = 0;
        while (enumeration.hasMoreElements()) {
            Pasajero pasajeroCurrent = enumeration.nextElement();
            if (pasajeroCurrent.getTipo().equals(tipoPasajero)){
                j++;
                mostrarPasajero(pasajeroCurrent);
            }
        }
    
        if (j == 0) {
            System.out.println("No hay pasajeros coincidentes en el sistema.");
        }
    }

    public void listarAsientosDisponibles()
    {
        byte cont = 2;
        for (byte i = 0; i < asientosDisponibles.length; i++)
        {
            if(cont % 4 == 0)
                System.out.print("|| ");
            cont++;
              
            if (asientosDisponibles[i] == 0) 
            {
                if(i < 9)
                    System.out.print((i+1) + "  ");
                else
                    System.out.print((i+1) + " ");
            }
            else 
                System.out.print("X  ");
                
            if((i+1) % 4 == 0 && i != 0) 
                System.out.println();
                         
        }
        System.out.println();
    }
    
    public ArrayList<Pasajero> obtenerListaPasajeros() {
        
        ArrayList<Pasajero> listaPasajeros = new ArrayList<>();
        Enumeration<Pasajero> keys = pasajerosRutMap.elements();
        while (keys.hasMoreElements()) {
            Pasajero pasajero = keys.nextElement();
            listaPasajeros.add(pasajero);
        }
        return listaPasajeros;
    }
    public ArrayList<Pasajero> obtenerListaPasajeros(String tipoPasajero) {
        
        ArrayList<Pasajero> listaPasajeros = new ArrayList<>();
        
        Enumeration<Pasajero> keys = pasajerosRutMap.elements();
        while (keys.hasMoreElements()) {
            Pasajero pasajero = keys.nextElement();
            if(pasajero.getTipo().equals(tipoPasajero)) listaPasajeros.add(pasajero);
        }
        
        return listaPasajeros;
    }  
}
