public class ViajeBus{    
    private String nombreChofer;
    private String codigoViaje;
    private String matricula;
    
    private String lugarInicio;
    private String lugarDestino;
    
    private String horaInicio;
    private String horaLlegada;
    
    private int tarifaGeneral;
    private int tarifaTerceraEdad;
    private int tarifaEstudiante;

    private int totalAsientos;
    private int cantPasajeros;
    
    private Pasajero[] pasajerosNroAsiento;
    private byte[] asientosDisponibles;
    
    private int gananciaTotal;
    private int costoViaje;
    private double rentabilidad;
    
    public ViajeBus(String nombreChofer, String codigoViaje, String matricula, String lugarInicio,
                String lugarDestino, String horaInicio, String horaLlegada,
                int tarifaGeneral, int tarifaTerceraEdad, int tarifaEstudiante,
                int costoViaje, int totalAsientos) {
        this.totalAsientos = totalAsientos;
        this.nombreChofer = nombreChofer;
        this.codigoViaje = codigoViaje;
        this.matricula = matricula;
        
        this.lugarInicio = lugarInicio;
        this.lugarDestino = lugarDestino;
        this.horaInicio = horaInicio;
        this.horaLlegada = horaLlegada;
        
        this.tarifaGeneral = tarifaGeneral;
        this.tarifaTerceraEdad = tarifaTerceraEdad;
        this.tarifaEstudiante = tarifaEstudiante;
        
        this.costoViaje = costoViaje;
        
        pasajerosNroAsiento = new Pasajero[totalAsientos];
        asientosDisponibles = new byte[totalAsientos];
        cantPasajeros = 0;
        
        gananciaTotal = 0;
        rentabilidad = 0.0;
    }

    public String getCodigo()
    {
        return codigoViaje;
    }

    
    public void agregarPasajero()
    {
        // Falta: Mostrar y dar elegir el número de asiento al pasajero, ya sea con un algoritmo dentro de este método
        // o llamando a un método auxiliar.
        int numeroAsiento = 0;
        
        if (cantPasajeros < totalAsientos && asientosDisponibles[numeroAsiento - 1] != 0)
        {
            // Falta: Creación objeto Pasajero ya sea con un algoritmo dentro de este método o llamando a un método auxiliar.
            asientosDisponibles[numeroAsiento - 1] = 0;
            // pasajerosNroAsiento[numeroAsiento - 1] = pasajero;
            cantPasajeros++;
        }
    }
    
    public int buscarPasajero(String rut){
        for (int i = 0; i < cantPasajeros; i++){
            if (pasajerosNroAsiento[i] != null)
            {
                Pasajero pasajeroAux = pasajerosNroAsiento[i];
                if (rut.equals(pasajeroAux.getRut())){
                    return i;
                }
            }
        }
        return -1;
    }
}
