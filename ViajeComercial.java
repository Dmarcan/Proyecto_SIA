import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

// La clase ViajeComercial corresponde a la clase padre de la clase ViajeBus, tal que la clase ViajeBus hereda todos los métodos públicos de la clase ViajeComercial.
public class ViajeComercial {
    private String nombreChofer;
    private String matricula;
    private String codigoViaje;
    private String lugarInicio;
    private String lugarLlegada;
    private String horaInicio;
    private String horaLlegada;
    private int totalAsientos;
    private Hashtable<String, Pasajero> pasajerosRutMap;
    private byte[] asientosDisponibles;

    // Constructor de la clase ViajeComercial, inicializa algunos de los atributos de la clase con parámetros formales e instancia las colecciones
    public ViajeComercial(String nombreChofer, String codigoViaje, String matricula, String lugarInicio,
                          String lugarLlegada, String horaInicio, String horaLlegada, int totalAsientos) {
        this.totalAsientos = totalAsientos;
        this.nombreChofer = nombreChofer;
        this.codigoViaje = codigoViaje;
        this.matricula = matricula;
        
        this.lugarInicio = lugarInicio;
        this.lugarLlegada = lugarLlegada;
        this.horaInicio = horaInicio;
        this.horaLlegada = horaLlegada;
                
        pasajerosRutMap = new Hashtable<>(totalAsientos);
        asientosDisponibles = new byte[totalAsientos];
    }


    
    // Getters
    public String getNombreChofer() {
        return nombreChofer;
    }
    public String getMatricula() {
        return matricula;
    }

    public String getCodigo() {
        return codigoViaje;
    }

    public String getLugarDeInicio() {
        return lugarInicio;
    }

    public String getLugarDeLlegada() {
        return lugarLlegada;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public int getTotalAsientos() {
        return totalAsientos;
    }


    public boolean estaDisponible(int numeroAsiento)
    {
        if(asientosDisponibles[numeroAsiento - 1] == 0) return true;
        return false;
    }

    public int getCantPasajeros()
    {
        return pasajerosRutMap.size();
    }
    

    
    // Setters
    public void setNombreChofer(String nombreChofer) {
        this.nombreChofer = nombreChofer;
    }
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public void setCodigoViaje(String codigoViaje) {
        this.codigoViaje = codigoViaje;
    }
    
    public void setLugarDeInicio(String lugarInicio) {
        this.lugarInicio = lugarInicio;
    }
    
    public void setLugarDeLlegada(String lugarLlegada) {
        this.lugarLlegada = lugarLlegada;
    }
    
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }
    
    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }
    
    public void setTotalAsientos(int totalAsientos) {
        this.totalAsientos = totalAsientos;
    }

    // Funcionalidades para agregar y eliminar Pasajero en coleccion Hashtable de Pasajeros
    public void agregarPasajero(Pasajero pasajero) throws ViajeBusAsientoOcupadoException, PasajeroExisteException 
    {
        if(pasajerosRutMap.containsKey(pasajero.getRut()))
             throw new PasajeroExisteException();
        if (!estaDisponible(pasajero.getNroAsiento()))
            throw new ViajeBusAsientoOcupadoException();
        pasajerosRutMap.put(pasajero.getRut(), pasajero);
        asientosDisponibles[pasajero.getNroAsiento() - 1] = 1;
    }

    public Pasajero eliminarPasajero(String rutPasajero) {
        if(!pasajerosRutMap.containsKey(rutPasajero))
            return null;
        return pasajerosRutMap.remove(rutPasajero);
    }


    // Métodos para modificar objeto Pasajero en colección asociada al objeto respectivo.
    public boolean modificarNombrePasajero(String nombrePasajero, String rutPasajero){
        if(!pasajerosRutMap.containsKey(rutPasajero))
            return false;
        Pasajero pasajero = pasajerosRutMap.get(rutPasajero);
        pasajero.setNombrePasajero(nombrePasajero);
        return true;
    }
    
    public String modificarTipoPasajero(String tipoPasajero, String rutPasajero) {
        if(!pasajerosRutMap.containsKey(rutPasajero))
            return null;
        
        Pasajero pasajero = pasajerosRutMap.get(rutPasajero);
        String antiguoTipo = pasajero.getTipo();
        pasajero.setTipoPasajero(tipoPasajero);
        return antiguoTipo;
    }
    
    public boolean modificarRutPasajero(String rutPasajero, String nuevoRutPasajero){   
        if (!pasajerosRutMap.containsKey(rutPasajero))
            return false;
        
        if (pasajerosRutMap.containsKey(nuevoRutPasajero))
            return false;
        
        
        Pasajero pasajero = pasajerosRutMap.remove(rutPasajero);
        pasajero.setRutPasajero(nuevoRutPasajero);
        pasajerosRutMap.put(nuevoRutPasajero,pasajero);
        
        return true;
    }
    
    
    // Métodos para obtener coleccion para opcion de listar todos los Pasajeros de viaje bus y listar según filtro.
    public ArrayList<Pasajero> obtenerListaPasajeros() {
        
        ArrayList<Pasajero> listaPasajeros = new ArrayList<>();
        Enumeration<Pasajero> keys = pasajerosRutMap.elements();
        while (keys.hasMoreElements()) {
            Pasajero pasajero = keys.nextElement();
            listaPasajeros.add(pasajero);
        }
        return listaPasajeros;
    }
    
    public ArrayList<Pasajero> obtenerListaPasajeros(String tipoPasajero) {
        
        ArrayList<Pasajero> listaPasajeros = new ArrayList<>();
        
        Enumeration<Pasajero> keys = pasajerosRutMap.elements();
        while (keys.hasMoreElements()) {
            Pasajero pasajero = keys.nextElement();
            if(pasajero.getTipo().equals(tipoPasajero)) listaPasajeros.add(pasajero);
        }
        
        return listaPasajeros;
    }

}
