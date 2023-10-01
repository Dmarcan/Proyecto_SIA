package Clases;

// La clase Pasajero corresponde a la plantilla para los objetos almacenados en la colección de segundo nivel de este programa.
public class Pasajero{
    private String nombrePasajero;
    private String rutPasajero;
    private String tipoPasajero;
    private int numeroAsiento;
    private String codigoViaje;

    // Constructor de la clase Pasajero, inicializa los atributos de la clase con parámetros formales.
    public Pasajero(String nombrePasajero, String rutPasajero, String tipoPasajero,int numeroAsiento, String codigoViaje) {
        this.nombrePasajero = nombrePasajero;
        this.rutPasajero = rutPasajero;
        this.tipoPasajero = tipoPasajero;
        this.numeroAsiento = numeroAsiento;
        this.codigoViaje = codigoViaje;
    }

    // Setters
    public void setNombrePasajero(String nombrePasajero){
        this.nombrePasajero = nombrePasajero;
    }

    public void setRutPasajero(String rutPasajero){
        this.rutPasajero = rutPasajero;
    }
    
    public void setTipoPasajero(String tipoPasajero){
        this.tipoPasajero = tipoPasajero;
    }

    public void setNumeroAsiento(int numeroAsiento){
        this.numeroAsiento = numeroAsiento;
    }
    
    public void setCodigoViaje(String codigoViaje){
        this.codigoViaje = codigoViaje;
    }


    // Getters
    public String getNombrePasajero(){
        return nombrePasajero;
    }

    public String getRut(){
        return rutPasajero;
    }

    public String getTipo(){
        return tipoPasajero;
    }

    public int getNroAsiento(){
        return numeroAsiento;
    }
    
    public String getCodigoViajePasajero(){
        return codigoViaje;
    }
}