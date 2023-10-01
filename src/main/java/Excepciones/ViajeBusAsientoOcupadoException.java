package Excepciones;

// Creación de una clase que se extiende de Exception.
public class ViajeBusAsientoOcupadoException extends Exception {
    public ViajeBusAsientoOcupadoException() {
            super("Viaje Bus Asiento Ocupado");
    }
}