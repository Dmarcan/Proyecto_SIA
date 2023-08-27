import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        int opcion;
        BufferedReader lector = new BufferedReader(new InputStreamReader (System.in));
        Empresa empresa = new Empresa(null, null, 0);
        
        Menu menu = new Menu();
        
        while (true){
            menu.mostrarFuncionalidades();
            
            opcion = Integer.parseInt(lector.readLine());
        
            switch (opcion) {
                case 1:
                    menu.registrarViaje();
                    break;
                case 2:
                    menu.eliminarViaje();
                    break;
                case 3:
                    menu.mostrarViajes();
                    break;
                case 4:
                    menu.mostrarViajes();
                    
                    //menu.agregarPasajero(menu.elegirBus());
                    break;
                case 5:
                    menu.mostrarPasajerosBus();
                    break;
                case 6:
                    menu.anularViajeBus();
                    break;

                case 7:
                    menu.anularPasajero();
                    break;
                case 8:
                    menu.verificarRentabilidadBus();
                    break;
                default: 
                    return;
                }
            }
        }
    }