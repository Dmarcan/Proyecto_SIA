/**
 *
 * @author cabel
 */
import java.io.*;
import static java.lang.Math.abs;
import java.util.*;

public class ViajeBus extends ViajeComercial{
    private int tarifaGeneral;
    private int tarifaTerceraEdad;
    private int tarifaEstudiante;

    private double costoTotal;
    private double gananciaTotal;
    private double rentabilidad;

    public ViajeBus(String nombreChofer, String codigoViaje, String matricula, String lugarInicio,
                    String lugarLlegada, String horaInicio, String horaLlegada,
                    int tarifaGeneral, int tarifaTerceraEdad, int tarifaEstudiante,
                    double costoTotal, int totalAsientos){
        super(nombreChofer, codigoViaje, matricula, lugarInicio, lugarLlegada, horaInicio, horaLlegada, totalAsientos);
        this.tarifaGeneral = tarifaGeneral;
        this.tarifaTerceraEdad = tarifaTerceraEdad;
        this.tarifaEstudiante = tarifaEstudiante;
        
        this.costoTotal = costoTotal;
        gananciaTotal = 0;
        rentabilidad = 0.0;
    }

    // Setters
    public void setTarifaGeneral(int tarifaGeneral)
    {
        this.tarifaGeneral = tarifaGeneral;
    }
    
    public void setTarifaTerceraEdad(int tarifaTerceraEdad)
    {
        this.tarifaTerceraEdad = tarifaTerceraEdad;
    }

    public void setTarifaEstudiante(int tarifaEstudiante)
    {
        this.tarifaEstudiante = tarifaEstudiante;
    }

    public void setCostoTotal(int costoTotal)
    {
        this.costoTotal = costoTotal;
    }
    
    public void setGananciaTotal(int gananciaTotal) {
        this.gananciaTotal = gananciaTotal;
        actualizarRentabilidad();
    }

    public void setRentabilidad(int rentabilidad)
    {
        this.rentabilidad = rentabilidad;
    }
    
    // Getters
    public int getTarifaGeneral()
    {
        return tarifaGeneral;
    }

    public int getTarifaTerceraEdad()
    {
        return tarifaTerceraEdad;
    }
    
    public int getTarifaEstudiante()
    {
        return tarifaEstudiante;
    }

    public double getGananciaTotal()
    {
        return gananciaTotal;
    }

    public double getCostoTotal()
    {
        return costoTotal;
    }
    
    public double getRentabilidad()
    {
        return rentabilidad;
    }
    
    public boolean modificarNombrePasajero(String nombrePasajero, String rutPasajero){
        return super.modificarNombrePasajero(nombrePasajero,rutPasajero);
    }
    
    
    public String modificarTipoPasajero(String tipoPasajero, String rutPasajero) {
        String tipo = super.modificarTipoPasajero(tipoPasajero,rutPasajero);
        if (tipo != null)
        {
            actualizarGanancia(tipo, "eliminar");
            actualizarGanancia(tipoPasajero, "agregar");
            return tipoPasajero;
        }
        return null;
    }

    // Métodos para Agregar, Eliminar y Listar objetos Pasajero en su colección respectiva del objeto ViajeBus.
    public void agregarPasajero(Pasajero pasajero) throws ViajeBusAsientoOcupadoException, PasajeroExisteException {
            super.agregarPasajero(pasajero);  
        actualizarGanancia(pasajero.getTipo(), "Agregar");
    }

    public Pasajero eliminarPasajero(String rutPasajero) {
        Pasajero aux = (Pasajero) super.eliminarPasajero(rutPasajero);
        if (aux == null)
            return null;
        actualizarGanancia(aux.getTipo(), "Eliminar");
        return aux;
    }
    
    // Funcionalidades Propias
    /*
    PALABRAS CLAVES    
    accion:"agregar","eliminar"
    */
    public void actualizarGanancia(String tipoPersona, String accion)
    {
         switch (tipoPersona) 
         {
            case "Estudiante":
                if (accion.equals("Agregar")) gananciaTotal += tarifaEstudiante;
                else gananciaTotal -= tarifaEstudiante;
                //System.out.println("Estudiante");
                break;
            case "Tercera Edad":
                 
                if (accion.equals("Agregar")) gananciaTotal += tarifaTerceraEdad;
                else gananciaTotal -= tarifaTerceraEdad;
                //System.out.println("Tercera Edad");   
                break;
            case "General":
                if (accion.equals("Agregar")) gananciaTotal += tarifaGeneral;
                else gananciaTotal -= tarifaGeneral;
                //System.out.println("General");
                break;
            default:
                return;
        }
        actualizarRentabilidad();
        return;
    }
    
    public void actualizarRentabilidad()
    {
        rentabilidad = ((gananciaTotal - costoTotal) / costoTotal) * 100;
        return;
    }
}

