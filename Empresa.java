import java.util.*;

public class Empresa {
    
    private ArrayList<ViajeBus> viajesArray;
    private Hashtable<String, ViajeBus> viajesCodigoMap;
    private int cantBuses;
    
    public Empresa()
    {
        viajesArray =  new ArrayList<>();
        viajesCodigoMap = new Hashtable<>();
        cantBuses = 0;
    }

    public int getCantBuses()
    {
        return cantBuses;
    }

    public ViajeBus getViajeBus(String codigoViaje)
    {
        if (cantBuses > 0)
            return viajesCodigoMap.get(codigoViaje);
        else
            return null;
    }

    public void agregarViajeBus(ViajeBus viajeBus)
    {
        String codigoViaje = viajeBus.getCodigo();

        if (viajesCodigoMap.contains(codigoViaje) != true)
        {
            viajesCodigoMap.put(codigoViaje, viajeBus);
            viajesArray.add(viajeBus);
            System.out.println("Bus con codigo de viaje " + codigoViaje + ", ha sido agregado.");
            cantBuses++;
            return;
        }
        else
        {
            System.out.println("Bus con codigo de viaje " + codigoViaje + ", ya se encuentra.");
            return;
        }
    }
    
    public void eliminarViajeBus(String codigoViaje)
    {
        if (cantBuses > 0)
        {
            if (viajesCodigoMap.get(codigoViaje) != null)
            {
                viajesArray.remove(viajesCodigoMap.get(codigoViaje));
                viajesCodigoMap.remove(codigoViaje);
                System.out.println("Bus con codigo de viaje " + codigoViaje + ", ha sido eliminado.");
            }
            else
                System.out.println("Bus con codigo de viaje " + codigoViaje + ", no se encuentra en el sistema.");
            return;
        }
    }

    public void listarViajesBus()
    {
        if (cantBuses == 0)
            return;

        for (int i = 0; i < viajesArray.size(); i++)
        {
            if (viajesArray.get(i) != null)
            {
                ViajeBus viajeCurrent = viajesArray.get(i);
                System.out.println("Viaje de bus "+ (i + 1) + ":");
                System.out.println("Código de viaje:" + viajeCurrent.getCodigo());
                System.out.println("Nombre del chofer:" + viajeCurrent.getNombreChofer());
                System.out.println("Matrícula::" + viajeCurrent.getMatricula());
                System.out.println("Lugar de inicio:" + viajeCurrent.getLugarDeInicio());
                System.out.println("Lugar de llegada:" + viajeCurrent.getLugarDeLlegada());
                System.out.println("Tarifa General:" + viajeCurrent.getTarifaGeneral());
                System.out.println("Tarifa de tercera edad:" + viajeCurrent.getTarifaTerceraEdad());
                System.out.println("Tarifa de estudiante:" + viajeCurrent.getTarifaEstudiante());
                System.out.println("Total de asientos en el bus:" + viajeCurrent.getTotalAsientos());
                System.out.println("Cantidad de pasajeros:" + viajeCurrent.getCantPasajeros());
                System.out.println("Asientos libres:" + (viajeCurrent.getTotalAsientos() - viajeCurrent.getCantPasajeros()));
                System.out.print("\n\n");
            }
        }
    }
}