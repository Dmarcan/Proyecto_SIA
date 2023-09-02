import java.util.*;

public class Empresa {
    
    private ArrayList<ViajeBus> viajesArray;
    private Hashtable<String, ViajeBus> viajesCodigoMap;
    
    public Empresa()
    {
        viajesArray =  new ArrayList<>();
        viajesCodigoMap = new Hashtable<>();
    }

    // Getters
    
    public int getCantBuses()
    {
        return viajesArray.size();
    }

    public ViajeBus getViajeBus(String codigoViaje)
    {
        return viajesCodigoMap.get(codigoViaje);
    }

    // Métodos para agregar, eliminar y listar objetos ViajeBus en su colección respectiva del objeto Empresa.
    
    public void agregarViajeBus(ViajeBus viajeBus)
    {
        String codigoViaje = viajeBus.getCodigo();

        if (viajesCodigoMap.contains(codigoViaje) != true)
        {
            viajesCodigoMap.put(codigoViaje, viajeBus);
            viajesArray.add(viajeBus);
        }
        else
        {
            System.out.println("Bus con codigo de viaje " + codigoViaje + " ya se encuentra en el sistema.");
        }
    }
    
    public void eliminarViajeBus(String codigoViaje)
    {   
        if (viajesCodigoMap.get(codigoViaje) != null)
        {
            viajesArray.remove(viajesCodigoMap.get(codigoViaje));
            viajesCodigoMap.remove(codigoViaje);
            System.out.println("Bus con codigo de viaje " + codigoViaje + " ha sido eliminado.");
        }
        else
            System.out.println("Bus con codigo de viaje " + codigoViaje + " no se encuentra en el sistema.");
    }

    public void listarViajesBus(boolean flag)
    {
        System.out.println("Lista de todos los buses");
        for (int i = 0; i < viajesArray.size(); i++)
        {
            ViajeBus viajeCurrent = viajesArray.get(i);
            System.out.println("Viaje de bus "+ (i + 1) + ":");
            System.out.println("Código de viaje: " + viajeCurrent.getCodigo());
            if (flag)
            {
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
        }
    }

    public void listarViajesBus(String lugarDeInicio)
    {
        if (viajesArray.size() == 0)
        {
            System.out.println("No hay viajes de bus coincidentes en el sistema.");
            return;
        }
        
        System.out.println("Lista de buses con lugar de origen: "+lugarDeInicio);
        int entro = 0;
        for (int i = 0; i < viajesArray.size() ; i++)
        {
            ViajeBus viajeCurrent = viajesArray.get(i);
            if ((viajeCurrent.getLugarDeInicio()).equals(lugarDeInicio))
            {
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
        }
        if (entro == 0)
        {
            System.out.println("No se encuentran buses con origen " + lugarDeInicio);
            return;
        }
    }
}