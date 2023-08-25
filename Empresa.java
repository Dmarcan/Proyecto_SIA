public class Empresa {
    private ViajeBus [] viajes;
    private String[] conductores;
    private int cantBuses;

    public Empresa(ViajeBus[] viajes, String[] conductores, int cantBuses) {
        this.viajes = viajes;
        this.conductores = conductores;
        this.cantBuses = cantBuses;
    }
    
    public int buscarViajeBus(String codigoViaje)
    {
        if (cantBuses == 0) return -1;
        for (int i = 0; i < cantBuses ; i++)
        {
            if(codigoViaje.equals(viajes[i].getCodigo())) 
                return i;
        }
        return -1;
    }

    public void eliminarViajeBus(String codigoViaje)
    {
        int posicion = buscarViajeBus(codigoViaje);
          
        if (posicion == -1) {
          System.out.println("Bus a eliminar no se encuentra.");
          return;
        }
          
        viajes[posicion] = viajes[cantBuses - 1];
        cantBuses--;
        System.out.println("Bus con codigo de viaje " + codigoViaje + ", ha sido eliminado.");
        return;
    }
}