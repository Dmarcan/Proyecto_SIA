import java.util.*; 
import java.io.*;

public class Main{
    public static void main(String args[])throws IOException{
        Empresa empresa = new Empresa();
        
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(empresa);
        ventanaPrincipal.setVisible(true);
        
    }
}