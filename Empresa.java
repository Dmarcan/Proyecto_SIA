import java.util.*;

public class Empresa {
    
    private ArrayList<ViajeBus> viajesArray;

    private Hashtable<String, ViajeBus> viajesCodigoMap;
    
    private String[] conductores;

    public Empresa(ArrayList viajesArray, Hashtable viajesCodigoMap, String[] conductores) {
        this.viajesArray = viajesArray;
        this.viajesCodigoMap = viajesCodigoMap;
        this.conductores = conductores;
        this.conductores = conductores;
    }


    public void agregarViajeBus(ViajeBus viajeBus)
    {
        if (viajesArray.contains(viajeBus) != true)
        {
            ViajeBus busAgregar = viajeBus;
            viajesCodigoMap.put(busAgregar.getCodigo(), viajeBus);
            viajesArray.add(viajeBus);
            
            System.out.println("Bus con codigo de viaje " + busAgregar.getCodigo() + ", ha sido agregado.");
            return;
        }
        else
        {
            System.out.println("Bus con codigo de viaje " + viajeBus.getCodigo() + ", ya se encuentra.");
            return;
        }
    }

    
    public void eliminarViajeBus(ViajeBus viajeBus)
    {
        Boolean flag;
        flag = viajesArray.remove(viajeBus);
        if (flag)
        {
            viajesCodigoMap.remove(viajeBus.getCodigo());
            System.out.println("Bus con codigo de viaje " + viajeBus.getCodigo() + ", ha sido eliminado.");
        }
        else
            System.out.println("Bus con codigo de viaje " + viajeBus.getCodigo() + ", no se encuentra en el sistema.");
        return;
    }

    public void listarViajeBus(ViajeBus viajeBus)
    {
        for (int i = 0; i < viajesArray.size(); i++)
        {
            if (viajesArray.get(i) != null)
            {
                ViajeBus viajeCurrent = viajesArray.get(i);
                System.out.println((i+1) + "Viaje de bus con código" + viajeCurrent.getCodigo());
            }
        }
    }
}