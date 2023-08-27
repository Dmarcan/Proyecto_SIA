import java.io.*;

public class Menu{

    public void mostrarFuncionalidades(){
        System.out.println("MENÚ DEL SISTEMA");
            System.out.println("Opcion 1 : Registrar viaje de bus en el sistema.");
            System.out.println("Opcion 2 : Eliminar viaje de bus del sistema.");
            System.out.println("Opcion 3 : Mostrar viajes de bus del sistema.");
            System.out.println("Opcion 4 : Agregar pasajero a viaje de bus.");
            System.out.println("Opcion 5 : Mostrar pasajeros de viaje de bus.");
            System.out.println("Opcion 6 : Anular viaje de bus.");
            System.out.println("Opcion 7 : Anular pasajero de viaje de bus.");
            System.out.println("Opcion 8 : Verificar rentabilidad de buses y reasignación de pasajeros.");
            System.out.println("Opcion 0 : Salir.");
    }
    
    public void registrarViaje() {
        
    }

    public void eliminarViaje() {
        
    }
    
    public void mostrarViajes() {
        
    }
    
    public void agregarPasajero(ViajeBus viajeBus)throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader (System.in));
        
        String codigoViaje;
        String nombrePasajero;
        String rutPasajero;
        String tipoPasajero;
        String ingresado;
        int numeroAsiento;
        
        int cantPasajeros = viajeBus.getCantPasajeros();
        int totalAsientos = viajeBus.getTotalAsientos();
        
        if (cantPasajeros < totalAsientos)
        {
            System.out.println("Ingrese codigo del viaje.");
            codigoViaje = lector.readLine();

            System.out.println("Ingrese nombre del pasajero.");
            nombrePasajero = lector.readLine();
            System.out.println("Ingrese rut del pasajero.");
            rutPasajero = lector.readLine();
            do{
                System.out.println("Ingrese tipo del pasajero.(estudiante-normal-terceraEdad");
                tipoPasajero = lector.readLine();
                
            }while (!tipoPasajero.equals("estudiante") && !tipoPasajero.equals("normal") && !tipoPasajero.equals("tercera edad"));

            byte [] asientosDisponibles = viajeBus.getAsientosDisponibles();
            
            do {
                viajeBus.listarAsientosDisponibles();
                System.out.println("Ingrese numeroAsiento del pasajero.");
                ingresado = lector.readLine();
                numeroAsiento = Integer.parseInt(ingresado);
                
            }while(asientosDisponibles[numeroAsiento - 1] != 0);

            Pasajero pasajero = new Pasajero(nombrePasajero, rutPasajero, tipoPasajero, numeroAsiento, codigoViaje);

            viajeBus.agregarPasajero(pasajero);
        }
    }
    
    public void mostrarPasajerosBus() {
        
    }
    
    public void anularViajeBus() {
        
    }
    
    public void anularPasajero() {
        
    }
    
    public void verificarRentabilidadBus() {
        
    }


    
}