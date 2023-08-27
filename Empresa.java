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

    public void agregarViajeBus(String nombreChofer, String codigoViaje, String matricula, String lugarInicio,
                                String lugarDestino, String horaInicio, String horaLlegada,
                                int tarifaGeneral, int tarifaTerceraEdad, int tarifaEstudiante,
                                int costoViaje,int totalAsientos)
    {
        int posicion = buscarViajeBus(codigoViaje);
        if (posicion == -1) 
        {
            ViajeBus busAgregar = new ViajeBus(nombreChofer,codigoViaje,matricula,lugarInicio,lugarDestino,
                                               horaInicio,horaLlegada,tarifaGeneral,tarifaTerceraEdad,
                                               tarifaEstudiante,costoViaje,totalAsientos);
            viajes[cantBuses] = busAgregar;
            cantBuses++;
            System.out.println("Bus con codigo de viaje " + codigoViaje + ", ha sido agregado.");
            return;
        }
        else
        {
            System.out.println("Bus con codigo de viaje " + codigoViaje + ", ya se encuentra.");
            return;
        }
    }
}