import java.io.*;
import java.util.*; 

public class Main{
    public static void main(String args[]) throws IOException{
        int opcion;
        BufferedReader lector = new BufferedReader(new InputStreamReader (System.in));
        Empresa empresa = new Empresa();
        Menu menu = new Menu();
        
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
                    menu.opcionListarViajesBus(empresa);
                    break;
                case 4:
                    menu.opcionAgregarPasajero(menu.elegirBus(empresa));
                    break;
                case 5:
                    menu.opcionEliminarPasajero(menu.elegirBus(empresa));
                    break;
                case 6:
                    menu.opcionListarPasajeros(menu.elegirBus(empresa));
                    break;
                default: 
                    return;
                }
            }
        }
    }