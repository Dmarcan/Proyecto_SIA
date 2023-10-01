package Excepciones;

// Creación de una clase que se extiende de Exception.
public class PasajeroNoExisteException extends Exception{

    public PasajeroNoExisteException() {
        super("Pasajero No existe");
    }
}
