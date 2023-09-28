/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author David
 */
import java.io.*;
import java.util.*;

public class ViajeComercial {
    private String nombreChofer;
    private String matricula;
    private String codigoViaje;
    private String lugarInicio;
    private String lugarLlegada;
    private String horaInicio;
    private String horaLlegada;
    private int totalAsientos;
    private Hashtable<String, Pasajero> pasajerosRutMap;
    private byte[] asientosDisponibles;
    
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
    public boolean agregarPasajero(Pasajero pasajero) throws ViajeBusAsientoOcupadoException, PasajeroExisteException 
    {
        if(pasajerosRutMap.containsKey(pasajero.getRut()))
            throw new PasajeroExisteException();
        if (!estaDisponible(pasajero.getNroAsiento()))
            throw new ViajeBusAsientoOcupadoException();
        pasajerosRutMap.put(pasajero.getRut(), pasajero);
        asientosDisponibles[pasajero.getNroAsiento() - 1] = 1;  
        return true;
    }

    public Pasajero eliminarPasajero(String rutPasajero) throws PasajeroNoExisteException {
        if(!pasajerosRutMap.containsKey(rutPasajero))
            throw new PasajeroNoExisteException();
        return pasajerosRutMap.remove(rutPasajero);
    }
    
    public boolean modificarNombrePasajero(String nombrePasajero, String rutPasajero){
        if(!pasajerosRutMap.containsKey(rutPasajero))
            return false;
        Pasajero pasajero = (Pasajero) pasajerosRutMap.get(rutPasajero);
        pasajero.setNombrePasajero(nombrePasajero);
        return true;
    }
    
    public String modificarTipoPasajero(String tipoPasajero, String rutPasajero) {
        if(!pasajerosRutMap.containsKey(rutPasajero))
            return null;
        Pasajero pasajero = (Pasajero) pasajerosRutMap.get(rutPasajero);
        pasajero.setTipoPasajero(tipoPasajero);
        return pasajero.getTipo();
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
    
    
    
    
    
    //yooo

}

    

