public class Pasajero{
    private String nombrePasajero;
    private String rutPasajero;
    private String tipoPasajero;
    private int numeroAsiento;
    private String codigoViaje;
    
    public Pasajero(String nombrePasajero, String rutPasajero, String tipoPasajero,int numeroAsiento, String codigoViaje) {
        this.nombrePasajero = nombrePasajero;
        this.rutPasajero = rutPasajero;
        this.tipoPasajero = tipoPasajero;
        this.numeroAsiento = numeroAsiento;
        this.codigoViaje = codigoViaje;
    }
    
    public String getRut(){
        return rutPasajero;
    }

    public String getTipo(){
        return tipoPasajero;
    }

    public int getAsiento(){
        return numeroAsiento;
    }
}