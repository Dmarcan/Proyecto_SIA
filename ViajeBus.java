import java.io.*;
import java.util.*;

public class ViajeBus{    
    private String nombreChofer;
    private String codigoViaje;
    private String matricula;
    
    private String lugarInicio;
    private String lugarDestino;
    
    private String horaInicio;
    private String horaLlegada;
    
    private int tarifaGeneral;
    private int tarifaTerceraEdad;
    private int tarifaEstudiante;

    private int totalAsientos;
    private int cantPasajeros;
    
    private ArrayList<Pasajero> pasajerosArray;
    private Hashtable pasajerosRutMap;
    
    private byte[] asientosDisponibles;
    
    private int gananciaTotal;
    private int costoViaje;
    private double rentabilidad;
    
    public ViajeBus(String nombreChofer, String codigoViaje, String matricula, String lugarInicio,
                String lugarDestino, String horaInicio, String horaLlegada,
                int tarifaGeneral, int tarifaTerceraEdad, int tarifaEstudiante,
                int costoViaje, int totalAsientos) {
        this.totalAsientos = totalAsientos;
        this.nombreChofer = nombreChofer;
        this.codigoViaje = codigoViaje;
        this.matricula = matricula;
        
        this.lugarInicio = lugarInicio;
        this.lugarDestino = lugarDestino;
        this.horaInicio = horaInicio;
        this.horaLlegada = horaLlegada;
        
        this.tarifaGeneral = tarifaGeneral;
        this.tarifaTerceraEdad = tarifaTerceraEdad;
        this.tarifaEstudiante = tarifaEstudiante;
        
        this.costoViaje = costoViaje;

        pasajerosArray = new ArrayList<Pasajero>(totalAsientos);
        pasajerosRutMap = new Hashtable(totalAsientos);
        asientosDisponibles = new byte[totalAsientos];
        cantPasajeros = 0;
        
        gananciaTotal = 0;
        rentabilidad = 0.0;
    }

    public String getCodigo()
    {
        return codigoViaje;
    }

    public int getTotalAsientos()
    {
        return totalAsientos;
    }
    
    public int getCantPasajeros()
    {
        return cantPasajeros;
    }

    public byte [] getAsientosDisponibles()
    {
        return asientosDisponibles;
    }

    public void listarAsientosDisponibles()
    {
        int pasillo = 0;
        for (byte i = 0; i < asientosDisponibles.length; i++)
        {
            if(pasillo % 2 == 0 && (pasillo != 0 || pasillo % 3 != 0))
                System.out.println("||  ");
            if (asientosDisponibles[i] != 0) 
            {
                if(i < 10)
                    System.out.println(i + "  ");
                else
                    System.out.println(i + " ");
                pasillo++;
            } 
            else 
            {
                System.out.println('X' + "  ");
            }
            if(i % 3 == 0) System.out.println();
            
                
        }
    }


    public void agregarPasajero(Pasajero pasajero) 
    {
        actualizarGanancia(pasajero.getTipo(),"agregar");
        pasajerosArray.add(pasajero);
        pasajerosRutMap.put(pasajero.getRut(), pasajero);
        asientosDisponibles[pasajero.getAsiento() - 1] = 0;
        cantPasajeros++;
    }
    

/*
    public Pasajero buscarPasajero(String rut){
        return pasajerosRutMap.get(rut);
    }
*/
    public void eliminarPasajero(String rut)
    {
        if (pasajerosRutMap.remove(rut) == null)
        {
            System.out.println("Pasajero rut: "+ rut +" no fue eliminado del mapa.");
            return;
        }

        System.out.println("Pasajero fue posible de eliminar de mapa de pasajeros");
        int entro = 0;
        for (int i = 0 ; i < pasajerosArray.size() ; i++)
        {
            Pasajero pasajeroCurrent = pasajerosArray.get(i);
            if ( (pasajeroCurrent.getRut()).equals(rut) )
            {
                actualizarGanancia(pasajeroCurrent.getTipo(),"eliminar");
                pasajerosArray.remove(i);
                System.out.println("Pasajero rut: "+ rut +" fue eliminado de la lista.");
                entro = 1;
                break;
                
            }
                                    
        }
        if(entro == 0)
            System.out.println("Pasajero no fue posible de eliminar de lista");
        return;
 

    }

    /*
    PALABRAS CLAVES    
    accion:"agregar","eliminar"
    */
    public void actualizarGanancia(String tipoPersona, String accion)
    {
         switch (tipoPersona) 
         {
            case "estudiante":
                 
                 if (accion.equals("eliminar")) gananciaTotal -= tarifaEstudiante;
                 else gananciaTotal+=tarifaEstudiante;
                    
                break;
            case "terceraEdad":
                 
                 if (accion.equals("eliminar")) gananciaTotal -= tarifaTerceraEdad;
                 else gananciaTotal += tarifaTerceraEdad;
                     
                break;
            case "normal":
                 if (accion.equals("eliminar")) gananciaTotal-=tarifaGeneral;
                 else gananciaTotal += tarifaGeneral;
                
                break;
            default:
                return;
        }
        actualizarRentabilidad();
        return;
    }
    
    public void actualizarRentabilidad()
    {
        rentabilidad = ((gananciaTotal - costoViaje) / gananciaTotal) * 100;
        return;
    }
}
