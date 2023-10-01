package Clases;

import Excepciones.PasajeroExisteException;
import Excepciones.PasajeroNoExisteException;
import Excepciones.ViajeBusAsientoFueraRangoException;
import Excepciones.ViajeBusAsientoOcupadoException;
import Excepciones.ViajeBusExisteException;
import Excepciones.ViajeBusNoExisteException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

// La clase Empresa representa la plantilla para el objeto que contendrá la colección de primer nivel que almacena 
// los objetos tipo ViajeBus.
public class Empresa {
    private Hashtable<String, ViajeBus> viajesCodigoMap;
    // Constructor de la clase Empresa, instancia la colección asociada al objeto Empresa.
    public Empresa()
    {
        viajesCodigoMap = new Hashtable<>();
    }

    // Getters
    public int getCantBuses()
    {
        return viajesCodigoMap.size();
    }

    public ViajeBus getViajeBus(String codigoViaje)
    {
        if(!viajesCodigoMap.containsKey(codigoViaje))
            return null;
        return viajesCodigoMap.get(codigoViaje);
    }

    // Métodos para Agregar y Eliminar objetos ViajeBus de la colección asociada al objeto Empresa respectivo.
    public void agregarViajeBus(ViajeBus viajeBus) throws ViajeBusExisteException
    {
        String codigoViaje = viajeBus.getCodigo();

        // Si el codigo de viaje ya existe se lanza la excepcion, no deben haber viajes de bus con codigo repetido
        if (viajesCodigoMap.containsKey(codigoViaje)) {
            throw new ViajeBusExisteException();
        }
        // No existe, por lo que se agregue sin repetir
        viajesCodigoMap.put(codigoViaje, viajeBus);
    }

    public void eliminarViajeBus(String codigo) throws ViajeBusNoExisteException{
        // Si el codigo de viaje no existe lanza la excepcion, no se puede eliminar viaje bus que no existe
        if(!viajesCodigoMap.containsKey(codigo))
            throw new ViajeBusNoExisteException();
        // Existe, por lo que se elimina
        viajesCodigoMap.remove(codigo);
               
    }

    // Métodos para Agregar y Eliminar objetos Pasajero de la colección asociada al objeto ViajeBus respectivo.
    public void agregarPasajero(String codigo, Pasajero pasajero) throws ViajeBusAsientoOcupadoException, ViajeBusAsientoFueraRangoException, ViajeBusNoExisteException, PasajeroExisteException {
        // Si viaje de bus no existe se lanza la excepcion, no se puede agregar pasajero a viaje bus que no existe
        if (!viajesCodigoMap.containsKey(codigo))
            throw new ViajeBusNoExisteException();
        
        ViajeBus viajeBus = viajesCodigoMap.get(codigo);
        // Si el numero de asiento del pasajero es mayor que el total de asientos se lanza excepcion
        if (pasajero.getNroAsiento() > viajeBus.getTotalAsientos())
            throw new ViajeBusAsientoFueraRangoException();

        viajeBus.agregarPasajero(pasajero);
    }

    public Pasajero eliminarPasajero(String codigoViajeBus, String rutPersona) throws ViajeBusNoExisteException, PasajeroNoExisteException {
        // Si viaje de bus no existe se lanza la excepcion, no se puede eliminar pasajero de viaje bus que no existe
        if (!viajesCodigoMap.containsKey(codigoViajeBus))
            throw new ViajeBusNoExisteException();
        
        ViajeBus viajeBus = viajesCodigoMap.get(codigoViajeBus);
        Pasajero pasajeroEliminado = viajeBus.eliminarPasajero(rutPersona);
        
        if (pasajeroEliminado == null)
            throw new PasajeroNoExisteException();
        return pasajeroEliminado;
    }


    // Método para Modificar objeto Pasajero de la colección asociada al objeto ViajeBus respectivo.
    public boolean modificarNombrePasajero(String numeroViaje, String nombrePasajero, String rutPasajero) {
        // Si no existe el numero de viaje retorna false, no se puede modificar nombre de pasajero de un viaje de bus que no existe
        if (!viajesCodigoMap.containsKey(numeroViaje))
            return false;
        
        ViajeBus viajeBus = viajesCodigoMap.get(numeroViaje);
        return viajeBus.modificarNombrePasajero(nombrePasajero,rutPasajero);
    }
    
    public boolean modificarTipoPasajero(String numeroViaje, String tipoPasajero, String rutPasajero) {
        // Si no existe el numero de viaje retorna false, no se puede modificar tipo de pasajero de un viaje de bus que no existe
        if (!viajesCodigoMap.containsKey(numeroViaje))
            return false;
        
        ViajeBus viajeBus = viajesCodigoMap.get(numeroViaje);
        return viajeBus.modificarTipoPasajero(tipoPasajero,rutPasajero) != null;
    }
    
    // rutPasajero -> A: antiguo : N: nuevo
    public boolean modificarRutPasajero(String numeroViaje, String rutPasajeroN, String rutPasajeroA){
        // Si no existe el numero de viaje retorna false, no se puede modificar RUT de pasajero de un viaje de bus que no existe
        if (!viajesCodigoMap.containsKey(numeroViaje))
            return false;
        
        ViajeBus viajeBus = viajesCodigoMap.get(numeroViaje);
        return viajeBus.modificarRutPasajero(rutPasajeroA, rutPasajeroN);
    }
    
    // Método para funcionalidad "Exportar Reporte" con todos los detalles de los objetos ViajeBus de la colección de primer nivel y también de los objetos Pasajero anidados en los objetos ViajeBus respectivos.
    public void exportarReporte(String csv1)
    {
        try (FileWriter fileWriter1 = new FileWriter(csv1)) {
            
            fileWriter1.write("REPORTE DE DATOS PROYECTO\n\n");
            fileWriter1.write("Cantidad de buses en sistema: "+viajesCodigoMap.size()+"\n");
            fileWriter1.write("Lista de todos los buses\n");
            //IMPRIMIR BUSES
            Enumeration<String> keys = viajesCodigoMap.keys();
            int i = 0;
            while (keys.hasMoreElements()) {
                fileWriter1.write("┌────────────────────────────────────────────┐\n");
                fileWriter1.write("                BUS NUMERO "+(i+1)+"\n");
                String codigoViaje = keys.nextElement();
                ViajeBus viajeCurrent = viajesCodigoMap.get(codigoViaje);
                fileWriter1.write(" Código de viaje: " + codigoViaje+"\n");
                fileWriter1.write(" Nombre del chofer: " + viajeCurrent.getNombreChofer()+"\n");
                fileWriter1.write(" Matrícula: " + viajeCurrent.getMatricula()+"\n");
                fileWriter1.write(" Lugar de inicio: " + viajeCurrent.getLugarDeInicio()+"\n");
                fileWriter1.write(" Lugar de llegada: " + viajeCurrent.getLugarDeLlegada()+"\n");
                fileWriter1.write(" Tarifa General: " + viajeCurrent.getTarifaGeneral()+"\n");
                fileWriter1.write(" Tarifa de tercera edad: " + viajeCurrent.getTarifaTerceraEdad()+"\n");
                fileWriter1.write(" Tarifa de estudiante: " + viajeCurrent.getTarifaEstudiante()+"\n");
                fileWriter1.write(" Total de asientos en el bus: " + viajeCurrent.getTotalAsientos()+"\n");
                fileWriter1.write(" Cantidad de pasajeros: " + viajeCurrent.getCantPasajeros()+"\n");
                fileWriter1.write(" Asientos libres: " + (viajeCurrent.getTotalAsientos() - viajeCurrent.getCantPasajeros())+"\n");
                fileWriter1.write(" Ganancia: " + viajeCurrent.getGananciaTotal() +"\n");
                fileWriter1.write(" Costo de viaje: " + viajeCurrent.getCostoTotal() +"\n");
                String rentabilidad = String.format("%.2f", viajeCurrent.getRentabilidad());
                fileWriter1.write(" Rentabilidad: " + rentabilidad + " %" +"\n\n");
                fileWriter1.write(" Gráfico de asientos disponibles del bus " + (i + 1)+"\n");
                //IMPRIMIR ASIENTOS
                int cantAsiento = viajeCurrent.getTotalAsientos();
                byte cont = 2;
                for (byte j = 0; j < cantAsiento; j++)
                {
                    if(cont % 4 == 0)
                        fileWriter1.write("|| ");
                    cont++;
                      
                    if (viajeCurrent.estaDisponible(j+1)) 
                    {
                        if(j < 9)
                            fileWriter1.write((j+1) + "  ");
                        else
                            fileWriter1.write((j+1) + " ");
                    }
                    else 
                        fileWriter1.write("X  ");
                        
                    if((j+1) % 4 == 0 && j != 0) 
                        fileWriter1.write("\n");
                                 
                }
                fileWriter1.write("\n");
                
                //IMPRIMIR PASAJEROS
                ArrayList<Pasajero> listaMostrar = viajeCurrent.obtenerListaPasajeros();
                if (!listaMostrar.isEmpty())
                {
                    fileWriter1.write(" Lista de pasajeros del bus:\n");
                    for (int h = 0;h < listaMostrar.size();h++){
                        Pasajero pasajeroCurrent = listaMostrar.get(h);
                        fileWriter1.write(" Pasajero " + (h+1)+ ":"+"\n");
                        fileWriter1.write(" Nombre: " + pasajeroCurrent.getNombrePasajero()+"\n");
                        fileWriter1.write(" RUT: " + pasajeroCurrent.getRut()+"\n");
                        fileWriter1.write(" Tipo de pasajero: " + pasajeroCurrent.getTipo()+"\n");
                        fileWriter1.write(" Numero de asiento: " + pasajeroCurrent.getNroAsiento()+"\n");
                        fileWriter1.write("\n");
                    }
                }
                fileWriter1.write("└────────────────────────────────────────────┘\n");
                i++;
            }
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Métodos para obtener colecciones para opciones de listar todo o según filtrado (No es getter de atributo)
    public ArrayList<ViajeBus> obtenerTodosViajeBus(double rentabilidad) {
        ArrayList<ViajeBus> listaViajesBuses = new ArrayList<>();
        Enumeration<ViajeBus> keys = viajesCodigoMap.elements();
        while (keys.hasMoreElements()) {
            ViajeBus viajeBus = keys.nextElement();
            if(viajeBus.getRentabilidad() <= rentabilidad)
                listaViajesBuses.add(viajeBus);
        }
        return listaViajesBuses;
    }

    public ArrayList<ViajeBus> obtenerTodosViajeBus() {
        ArrayList<ViajeBus> listaViajeBus = new ArrayList<>();
        Enumeration<String> keys = viajesCodigoMap.keys();
    
        while (keys.hasMoreElements()) {
            String codigoViaje = keys.nextElement();
            ViajeBus viajeCurrent = viajesCodigoMap.get(codigoViaje);
            listaViajeBus.add(viajeCurrent);
        }
        return listaViajeBus;
    }
    
    public ArrayList<ViajeBus> obtenerTodosViajeBus(String lugarDeInicio){
        ArrayList<ViajeBus> listaViajeBus = new ArrayList<>();
        Enumeration<String> keys = viajesCodigoMap.keys();
    
        while (keys.hasMoreElements()) {
            String codigoViaje = keys.nextElement();
            ViajeBus viajeCurrent = viajesCodigoMap.get(codigoViaje);
            if (viajeCurrent.getLugarDeInicio().equals(lugarDeInicio)) listaViajeBus.add(viajeCurrent);
        }
        return listaViajeBus;
    }
        
}
