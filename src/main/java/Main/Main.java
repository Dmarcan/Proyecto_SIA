package Main;

import Ventanas.VentanaPrincipal;
import Excepciones.ViajeBusExisteException;
import Excepciones.PasajeroExisteException;
import Excepciones.ViajeBusAsientoOcupadoException;
import Clases.Empresa;
import java.util.*; 

public class Main{
    public static void main(String args[])throws ViajeBusExisteException, ViajeBusAsientoOcupadoException, PasajeroExisteException{
        Empresa empresa = new Empresa();
        
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(empresa);
        ventanaPrincipal.setVisible(true);
    }
}