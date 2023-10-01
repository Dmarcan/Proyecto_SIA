package Excepciones;

// Creación de una clase que se extiende de Exception.
public class ViajeBusExisteException extends Exception{
    public ViajeBusExisteException() {
        super("Viaje Bus existe");
    }
}