/**
 *
 * @author cabel
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class Empresa {
    
    
    private Hashtable<String, ViajeBus> viajesCodigoMap;
    
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

    
    // Métodos para agregar y eliminar objetos ViajeBus en su colección respectiva del objeto Empresa.

    public void agregarViajeBus(ViajeBus viajeBus) throws ViajeBusExisteException
    {
        String codigoViaje = viajeBus.getCodigo();

        if (viajesCodigoMap.containsKey(codigoViaje)) {
            throw new ViajeBusExisteException();
        }
        viajesCodigoMap.put(codigoViaje, viajeBus);
    }

    public void eliminarViajeBus(String codigo) throws ViajeBusNoExisteException{
        if(!viajesCodigoMap.containsKey(codigo))
            throw new ViajeBusNoExisteException();
        viajesCodigoMap.remove(codigo);
               
    }

    // Métodos para agregar y eliminar objetos Pasajero en su colección respectiva del objeto ViajeBus.

    public void agregarPasajero(String codigo, Pasajero pasajero) throws ViajeBusAsientoOcupadoException, ViajeBusAsientoFueraRangoException, ViajeBusNoExisteException, PasajeroExisteException {
        if(!viajesCodigoMap.containsKey(codigo)) // Si no existe el viaje de bus
            throw new ViajeBusNoExisteException();
        
        ViajeBus viajeBus = (ViajeBus) viajesCodigoMap.get(codigo);
        if (pasajero.getNroAsiento() > viajeBus.getTotalAsientos())
            throw new ViajeBusAsientoFueraRangoException();

        viajeBus.agregarPasajero(pasajero);
            
    }

    public Pasajero eliminarPasajero(String codigoViajeBus, String rutPersona) throws ViajeBusNoExisteException, PasajeroNoExisteException {
        if(!viajesCodigoMap.containsKey(codigoViajeBus))
            throw new ViajeBusNoExisteException();
        
        ViajeBus viajeBus = viajesCodigoMap.get(codigoViajeBus);
        Pasajero pasajeroEliminado = viajeBus.eliminarPasajero(rutPersona);
        
        if(pasajeroEliminado == null)
            throw new PasajeroNoExisteException();
        return pasajeroEliminado;
    }


    // Métodos para funcionalidades "Modificar Pasajero" en objetos Pasajero en su colección respectiva del objeto ViajeBus.
    
    public boolean modificarNombrePasajero(String numeroViaje, String nombrePasajero, String rutPasajero) {
        if(!viajesCodigoMap.containsKey(numeroViaje))
            return false;
        
        ViajeBus viajeBus = (ViajeBus) viajesCodigoMap.get(numeroViaje);
        if(viajeBus.modificarNombrePasajero(nombrePasajero,rutPasajero))
            return true;
        return false;
    }
    
    public boolean modificarTipoPasajero(String numeroViaje, String tipoPasajero, String rutPasajero) {
        if(!viajesCodigoMap.containsKey(numeroViaje))
            return false;
        
        ViajeBus viajeBus = (ViajeBus) viajesCodigoMap.get(numeroViaje);
        if(viajeBus.modificarTipoPasajero(tipoPasajero,rutPasajero) != null)
            return true;
        return false;
    }
    
    // rutPasajero -> A: antiguo : N: nuevo
    public boolean modificarRutPasajero(String numeroViaje, String rutPasajeroN, String rutPasajeroA) throws ViajeBusNoExisteException, PasajeroExisteException, PasajeroNoExisteException, ViajeBusAsientoOcupadoException, ViajeBusAsientoFueraRangoException{
        if(!viajesCodigoMap.containsKey(numeroViaje))
            return false;
        
        Pasajero pasajeroAux = eliminarPasajero(numeroViaje,rutPasajeroA);
        if(pasajeroAux == null)
            return false;
        
        Pasajero pasajero = new Pasajero(pasajeroAux.getNombrePasajero(),rutPasajeroN,pasajeroAux.getTipo(),pasajeroAux.getNroAsiento(),numeroViaje);
        
        agregarPasajero(numeroViaje,pasajero);
            return true;
        //return false;
       
    }
    
    // Método para funcionalidad "Exportar Reporte" en objetos Pasajero en su colección respectiva del objeto ViajeBus.
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
                fileWriter1.write(" Asientos libres: " + (viajeCurrent.getTotalAsientos() - viajeCurrent.getCantPasajeros())+"\n\n");
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
            System.out.println("fasdgf");
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
