import java.io.*;
import java.util.*;

public class ViajeBus{    
    private String nombreChofer;
    private String codigoViaje;
    private String matricula;
    
    private String lugarInicio;
    private String lugarLlegada;
    
    private String horaInicio;
    private String horaLlegada;
    
    private int tarifaGeneral;
    private int tarifaTerceraEdad;
    private int tarifaEstudiante;

    private int totalAsientos;
    private int cantPasajeros;
    
    private ArrayList<Pasajero> pasajerosArray;
    private Hashtable<String, Pasajero> pasajerosRutMap;
    
    private byte[] asientosDisponibles;
    
    private int gananciaTotal;
    private int costoViaje;
    private double rentabilidad;
    
    public ViajeBus(String nombreChofer, String codigoViaje, String matricula, String lugarInicio,
                String lugarLlegada, String horaInicio, String horaLlegada,
                int tarifaGeneral, int tarifaTerceraEdad, int tarifaEstudiante,
                int costoViaje, int totalAsientos) {
        this.totalAsientos = totalAsientos;
        this.nombreChofer = nombreChofer;
        this.codigoViaje = codigoViaje;
        this.matricula = matricula;
        
        this.lugarInicio = lugarInicio;
        this.lugarLlegada = lugarLlegada;
        this.horaInicio = horaInicio;
        this.horaLlegada = horaLlegada;
        
        this.tarifaGeneral = tarifaGeneral;
        this.tarifaTerceraEdad = tarifaTerceraEdad;
        this.tarifaEstudiante = tarifaEstudiante;
        
        this.costoViaje = costoViaje;

        pasajerosArray = new ArrayList<>(totalAsientos);
        pasajerosRutMap = new Hashtable<>(totalAsientos);
        asientosDisponibles = new byte[totalAsientos];
        cantPasajeros = 0;
        
        gananciaTotal = 0;
        rentabilidad = 0.0;
    }

    public String getCodigo()
    {
        return codigoViaje;
    }

    public String getNombreChofer()
    {
        return nombreChofer;
    }
    
    public String getMatricula()
    {
        return matricula;
    }

    public String getLugarDeInicio()
    {
        return lugarInicio;
    }

    public String getLugarDeLlegada()
    {
        return lugarLlegada;
    }

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

    public byte [] getAsientosDisponibles()
    {
        return asientosDisponibles;
    }

    public int getTotalAsientos()
    {
        return totalAsientos;
    }
    
    public int getCantPasajeros()
    {
        return cantPasajeros;
    }
    
    public void listarAsientosDisponibles()
    {
        if (cantPasajeros == 0)
            System.out.println("El bus se encuentra vacio.");
            

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

    public void agregarPasajero(Pasajero pasajero) 
    {
        actualizarGanancia(pasajero.getTipo(),"agregar");
        pasajerosArray.add(pasajero);
        pasajerosRutMap.put(pasajero.getRut(), pasajero);
        asientosDisponibles[pasajero.getNroAsiento() - 1] = 1;
        cantPasajeros++;
    }
    

    /*
    public Pasajero buscarPasajero(String rut){
        return pasajerosRutMap.get(rut);
    }
    */
    public void eliminarPasajero(String rut)
    {
        if (cantPasajeros > 0)
        {
            ;
            if (pasajerosRutMap.get(rut) != null)
            {
                pasajerosArray.remove(pasajerosRutMap.get(rut));
                pasajerosRutMap.remove(rut);
                System.out.println("Pasajero con RUT " + rut + ", ha sido eliminado.");
            }
            else
                System.out.println("Pasajero con RUT " + rut + " no se encuentra en el sistema.");
            return;
        }
    }

    public void listarPasajeros()
    {
        if (cantPasajeros == 0)
            return;
            
        for (int i = 0; i < pasajerosArray.size(); i++)
        {
            if (pasajerosArray.get(i) != null)
            {
                Pasajero pasajeroCurrent = pasajerosArray.get(i);
                System.out.println("Pasajero "+ (i + 1) + ":");
                System.out.println("Nombre:" + pasajeroCurrent.getNombrePasajero());
                System.out.println("RUT:" + pasajeroCurrent.getRut());
                System.out.println("Tipo de pasajero:" + pasajeroCurrent.getTipo());
                System.out.println("Codigo de su viaje:" + pasajeroCurrent.getCodigoViajePasajero());
                System.out.println("Numero de asiento:" + pasajeroCurrent.getNroAsiento());
                System.out.print("\n\n");
            }
        }
    }

    /*
    PALABRAS CLAVES    
    accion:"agregar","eliminar"
    */
    public void actualizarGanancia(String tipoPersona, String accion)
    {
         switch (tipoPersona) 
         {
            case "Estudiante":
                 
                 if (accion.equals("Eliminar")) gananciaTotal -= tarifaEstudiante;
                 else gananciaTotal+=tarifaEstudiante;
                    
                break;
            case "Tercera Edad":
                 
                 if (accion.equals("Eliminar")) gananciaTotal -= tarifaTerceraEdad;
                 else gananciaTotal += tarifaTerceraEdad;
                     
                break;
            case "Normal":
                 if (accion.equals("Eliminar")) gananciaTotal -= tarifaGeneral;
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
