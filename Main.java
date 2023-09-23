import java.util.*; 
import java.io.*;

public class Main{
    public static void main(String args[])throws IOException{
        Empresa empresa = new Empresa();
        //VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(empresa);
        //ventanaPrincipal.setVisible(true);
        
        BufferedReader lector = new BufferedReader(new InputStreamReader (System.in));
        int opcion;
        Menu menu = new Menu();
        //menu.cargaDatosInicialesTemporal(empresa);
        menu.importar(empresa);
        while (true){
            menu.mostrarFuncionalidades();
            opcion = Integer.parseInt(lector.readLine());
            switch (opcion) {
                case 1:
                    menu.OpcionAgregarViajeBus(empresa);
                    break;
                case 2:
                    menu.opcionEliminarViaje(empresa);
                    break;
                case 3:
                    menu.opcionListarViajesBus(empresa, true);
                    break;
                case 4:
                    menu.opcionAgregarPasajero(menu.elegirBus(empresa, true));
                    break;
                case 5:
                    menu.opcionEliminarPasajero(menu.elegirBus(empresa, false));
                    break;
                case 6:
                    menu.opcionListarPasajeros(menu.elegirBus(empresa, false), true);
                    break;
                default: 
                    menu.Exportar(empresa);
                    return;
                }
            }
    }
}