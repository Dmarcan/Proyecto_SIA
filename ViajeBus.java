import java.io.*;
import java.util.*;

public class ViajeBus extends ViajeComercial{    
    private int tarifaGeneral;
    private int tarifaTerceraEdad;
    private int tarifaEstudiante;

    private int costoTotal;
    private int gananciaTotal;
    private double rentabilidad;

    public ViajeBus(String nombreChofer, String codigoViaje, String matricula, String lugarInicio,
                    String lugarLlegada, String horaInicio, String horaLlegada,
                    int tarifaGeneral, int tarifaTerceraEdad, int tarifaEstudiante,
                    int costoTotal, int totalAsientos){
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

    public int getGananciaTotal()
    {
        return gananciaTotal;
    }

    public int getCostoTotal()
    {
        return costoTotal;
    }
    
    public double getRentabilidad()
    {
        return rentabilidad;
    }

    // Métodos para Agregar, Eliminar y Listar objetos Pasajero en su colección respectiva del objeto ViajeBus.
    public boolean agregarPasajero(Pasajero pasajero) 
    {
        boolean flag = super.agregarPasajero(pasajero);
        if (flag == false)
            return false;
        actualizarGanancia(pasajero.getTipo(), "Agregar");
        return true;
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
                break;
            case "Tercera Edad":
                 
                if (accion.equals("Agregar")) gananciaTotal += tarifaTerceraEdad;
                else gananciaTotal -= tarifaTerceraEdad;
                     
                break;
            case "Normal":
                if (accion.equals("Agregar")) gananciaTotal += tarifaGeneral;
                else gananciaTotal -= tarifaGeneral;
                
                break;
            default:
                return;
        }
        actualizarRentabilidad();
        return;
    }
    
    public void actualizarRentabilidad()
    {
        rentabilidad = ((gananciaTotal - costoTotal) / gananciaTotal) * 100;
        return;
    }  
}
