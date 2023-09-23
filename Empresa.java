import java.util.*;

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
        return viajesCodigoMap.get(codigoViaje);
    }

    // Métodos para agregar, eliminar y listar objetos ViajeBus en su colección respectiva del objeto Empresa.

    public ViajeBus eliminarViajeBus(String codigo){
        if(!viajesCodigoMap.contains(codigo))
            return null;
        return (ViajeBus) viajesCodigoMap.remove(codigo);
    }

    public boolean agregarPasajero(String codigo, Pasajero pasajero) {
        if(viajesCodigoMap.contains(codigo) ) { // Si existe el viaje de bus
            ViajeBus viajeBus = (ViajeBus) viajesCodigoMap.get(codigo);
            if(viajeBus.agregarPasajero(pasajero)) 
                return true;
            return false;
        } 
        return false;
    }
    
    
    public boolean agregarViajeBus(ViajeBus viajeBus)
    {
        String codigoViaje = viajeBus.getCodigo();

        if (!viajesCodigoMap.containsKey(codigoViaje)) {
            viajesCodigoMap.put(codigoViaje, viajeBus);
            return true;
        }
        return false;
    }

    public Pasajero eliminarPasajero(String codigoViajeBus, String rutPersona) {
        if(!viajesCodigoMap.contains(codigoViajeBus))
            return null;
        
        ViajeBus viajeBus = viajesCodigoMap.get(codigoViajeBus);
        Pasajero pasajeroEliminado = viajeBus.eliminarPasajero(rutPersona);
        
        if(pasajeroEliminado != null)
            return pasajeroEliminado;
        return null;
    }
    
    public void listarViajesBus(boolean flag)
    {
        System.out.println("Lista de todos los buses");
        Enumeration<String> keys = viajesCodigoMap.keys();
        int i = 0;
        while (keys.hasMoreElements()) {
            String codigoViaje = keys.nextElement();
            ViajeBus viajeCurrent = viajesCodigoMap.get(codigoViaje);
            System.out.println("Código de viaje: " + codigoViaje);
            if (flag) {
                System.out.println("Nombre del chofer: " + viajeCurrent.getNombreChofer());
                System.out.println("Matrícula: " + viajeCurrent.getMatricula());
                System.out.println("Lugar de inicio: " + viajeCurrent.getLugarDeInicio());
                System.out.println("Lugar de llegada: " + viajeCurrent.getLugarDeLlegada());
                System.out.println("Tarifa General: " + viajeCurrent.getTarifaGeneral());
                System.out.println("Tarifa de tercera edad: " + viajeCurrent.getTarifaTerceraEdad());
                System.out.println("Tarifa de estudiante: " + viajeCurrent.getTarifaEstudiante());
                System.out.println("Total de asientos en el bus: " + viajeCurrent.getTotalAsientos());
                System.out.println("Cantidad de pasajeros: " + viajeCurrent.getCantPasajeros());
                System.out.println("Asientos libres: " + (viajeCurrent.getTotalAsientos() - viajeCurrent.getCantPasajeros()));
                System.out.println();
                System.out.println("Gráfico de asientos disponibles del bus " + (i + 1));
                viajeCurrent.listarAsientosDisponibles();
            }
            System.out.println("\n");
            i++;
        }
    }
    
    public void listarViajesBus(String lugarDeInicio)
    {
        if (viajesCodigoMap.size() == 0)
        {
            System.out.println("No hay viajes de bus coincidentes en el sistema.");
            return;
        }
        
        System.out.println("Lista de buses con lugar de origen: " + lugarDeInicio);
        Enumeration<String> keys = viajesCodigoMap.keys();
        int entro = 0;
        int i = 0;
        while (keys.hasMoreElements()) {
            String codigoViaje = keys.nextElement();
            ViajeBus viajeCurrent = viajesCodigoMap.get(codigoViaje);
            if ((viajeCurrent.getLugarDeInicio()).equals(lugarDeInicio)) {
                entro = 1;
                System.out.println("Viaje de bus "+ (i + 1) + ":");
                System.out.println("Código de viaje: " + viajeCurrent.getCodigo());
                System.out.println("Nombre del chofer: " + viajeCurrent.getNombreChofer());
                System.out.println("Matrícula: " + viajeCurrent.getMatricula());
                System.out.println("Lugar de inicio: " + viajeCurrent.getLugarDeInicio());
                System.out.println("Lugar de llegada: " + viajeCurrent.getLugarDeLlegada());
                System.out.println("Tarifa General: " + viajeCurrent.getTarifaGeneral());
                System.out.println("Tarifa de tercera edad: " + viajeCurrent.getTarifaTerceraEdad());
                System.out.println("Tarifa de estudiante: " + viajeCurrent.getTarifaEstudiante());
                System.out.println("Total de asientos en el bus: " + viajeCurrent.getTotalAsientos());
                System.out.println("Cantidad de pasajeros: " + viajeCurrent.getCantPasajeros());
                System.out.println("Asientos libres: " + (viajeCurrent.getTotalAsientos() - viajeCurrent.getCantPasajeros()));
                System.out.println();
                System.out.println("Gráfico de asientos disponibles del bus " + (i + 1));
                viajeCurrent.listarAsientosDisponibles();
                System.out.println("\n");
            }
            i++;
        }
        if (entro == 0)
        {
            System.out.println("No se encuentran buses con origen " + lugarDeInicio);
            return;
        }
    }


    public ViajeBus obtenerViajeBus(String codigoViaje) {
        return viajesCodigoMap.get(codigoViaje);
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