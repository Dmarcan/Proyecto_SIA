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
    
    private int costoViaje;
    private int gananciaTotal; // No tendrá setter (porque se calcula)
    private double rentabilidad; // No tendrá setter (porque se calcula)

    private Hashtable<String, Pasajero> pasajerosRutMap;
    private byte[] asientosDisponibles;

    
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
        
        pasajerosRutMap = new Hashtable<>(totalAsientos);
        asientosDisponibles = new byte[totalAsientos];
        
        gananciaTotal = 0;
        rentabilidad = 0.0;
    }

    // Setters 
    public void setNombreChofer(String nombreChofer)
    {
        this.nombreChofer = nombreChofer;
    }

    public void setCodigoViaje(String codigoViaje)
    {
        this.codigoViaje = codigoViaje;
    }

    public void setMatricula(String matricula)
    {
        this.matricula = matricula;
    }

    public void setLugarInicio(String lugarInicio)
    {
        this.lugarInicio = lugarInicio;
    }

    public void setLugarLlegada(String lugarLlegada)
    {
        this.lugarLlegada = lugarLlegada;
    }
    
    public void setHoraInicio(String horaInicio)
    {
        this.horaInicio = horaInicio;
    }

    public void setHoraLlegada(String horaLlegada)
    {
        this.horaLlegada = horaLlegada;
    }

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

    public void setTotalAsientos(int totalAsientos)
    {
        this.totalAsientos = totalAsientos;
    }

    public void setCostoViaje(int costoViaje)
    {
        this.costoViaje = costoViaje;
    }
    
    // Getters

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
        return pasajerosRutMap.size();
    }

    public int getGananciaTotal()
    {
        return gananciaTotal;
    }
    
    public double getRentabilidad()
    {
        return rentabilidad;
    }

    // Métodos para Agregar, Eliminar y Listar objetos Pasajero en su colección respectiva del objeto ViajeBus.
    

    public void agregarPasajero(Pasajero pasajero) 
    {
        actualizarGanancia(pasajero.getTipo(),"agregar");
        pasajerosRutMap.put(pasajero.getRut(), pasajero);
        asientosDisponibles[pasajero.getNroAsiento() - 1] = 1;
    }
    
    public void eliminarPasajero(String rut)
    {
        if (pasajerosRutMap.get(rut) != null)
        {
            actualizarGanancia(pasajerosRutMap.get(rut).getTipo(), "eliminar");
            pasajerosRutMap.remove(rut);
            asientosDisponibles[pasajerosRutMap.get(rut).getNroAsiento() - 1] = 0;
            System.out.println("Pasajero con RUT " + rut + " ha sido eliminado.");
        } else {
            System.out.println("Pasajero con RUT " + rut + " no se encuentra en el sistema.");
        }
    }
    
    
    public void listarPasajeros()
    {
        System.out.println("Lista de pasajeros del bus:");  
        Enumeration<Pasajero> enumeration = pasajerosRutMap.elements();
        int i = 0;
        while (enumeration.hasMoreElements()) {
            Pasajero pasajeroCurrent = enumeration.nextElement();
            System.out.println("Pasajero " + (i+1) + ":");
            System.out.println("Nombre: " + pasajeroCurrent.getNombrePasajero());
            System.out.println("RUT: " + pasajeroCurrent.getRut());
            System.out.println("Tipo de pasajero: " + pasajeroCurrent.getTipo());
            System.out.println("Codigo de su viaje: " + pasajeroCurrent.getCodigoViajePasajero());
            System.out.println("Numero de asiento: " + pasajeroCurrent.getNroAsiento());
            System.out.println("\n");
            i++;
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
        int i = 0;
        while (enumeration.hasMoreElements()) {
            Pasajero pasajeroCurrent = enumeration.nextElement();
            if (pasajeroCurrent.getTipo().equals(tipoPasajero)) {
                System.out.println("Pasajero " + (i+1) + ":");
                System.out.println("Nombre: " + pasajeroCurrent.getNombrePasajero());
                System.out.println("RUT: " + pasajeroCurrent.getRut());
                System.out.println("Tipo de pasajero: " + pasajeroCurrent.getTipo());
                System.out.println("Codigo de su viaje: " + pasajeroCurrent.getCodigoViajePasajero());
                System.out.println("Numero de asiento: " + pasajeroCurrent.getNroAsiento());
                System.out.println("\n");
            }
            i++;
        }
    
        if (i == 0) {
            System.out.println("No hay pasajeros coincidentes en el sistema.");
        }
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
                 
                 if (accion.equals("Eliminar")) gananciaTotal -= tarifaEstudiante;
                 else gananciaTotal += tarifaEstudiante;
                    
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
}


