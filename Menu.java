import java.io.*;
// import java.util.*;

public class Menu{
    public void mostrarFuncionalidades(){
        System.out.println("MENU DEL SISTEMA");
            System.out.println("Opcion 1 : Registrar viaje de bus en el sistema.");
            System.out.println("Opcion 2 : Eliminar viaje de bus del sistema.");
            System.out.println("Opcion 3 : Listar viajes de bus del sistema.");
            System.out.println("Opcion 4 : Agregar pasajero a viaje de bus.");
            System.out.println("Opcion 5 : Eliminar pasajero de viaje de bus.");
            System.out.println("Opcion 6 : Listar pasajeros de viaje de bus.");
            System.out.println("Opcion 0 : Salir.");
    }
    
    public void OpcionAgregarViajeBus(Empresa empresa)throws IOException {
        if (empresa != null)
        {
            BufferedReader lector = new BufferedReader(new InputStreamReader (System.in));

            String nombreChofer;
            String codigoViaje;
            String matricula;
        
            String lugarInicio;
            String lugarLlegada;        
            String horaInicio;
            String horaLlegada;
            
            int tarifaGeneral;
            int tarifaTerceraEdad;
            int tarifaEstudiante;
        
            int totalAsientos;
            int costoViaje;
            
            System.out.println("Ingrese el nombre del chofer del viaje de bus.");
            nombreChofer = lector.readLine();

            System.out.println("Ingrese el codigo del viaje de bus.");
            codigoViaje = lector.readLine();

            System.out.println("Ingrese la matricula del bus.");
            matricula = lector.readLine();

            System.out.println("Ingrese el lugar de inicio del viaje de bus.");
            lugarInicio = lector.readLine();

            System.out.println("Ingrese el lugar de llegada del viaje de bus.");
            lugarLlegada = lector.readLine();

            System.out.println("Ingrese la hora hora de inicio del viaje de bus.");
            horaInicio = lector.readLine();

            System.out.println("Ingrese la hora de llegada del viaje de bus.");
            horaLlegada = lector.readLine();

            System.out.println("Ingrese la tarifa para público general del viaje de bus.");
            tarifaGeneral = Integer.parseInt(lector.readLine());

            System.out.println("Ingrese la tarifa para tercera edad del viaje de bus.");
            tarifaTerceraEdad = Integer.parseInt(lector.readLine());

            System.out.println("Ingrese la tarifa para estudiante del viaje de bus.");
            tarifaEstudiante = Integer.parseInt(lector.readLine());

            System.out.println("Ingrese el numero total de asientos del bus.");
            totalAsientos = Integer.parseInt(lector.readLine());

            System.out.println("Ingrese el costo del viaje de bus.");
            costoViaje = Integer.parseInt(lector.readLine());

            ViajeBus viajeBus = new ViajeBus(nombreChofer, codigoViaje, matricula, lugarInicio, lugarLlegada, 
                                horaInicio, horaLlegada, tarifaGeneral, tarifaTerceraEdad, tarifaEstudiante, 
                                totalAsientos, costoViaje);            
            
            empresa.agregarViajeBus(viajeBus);
        }
    }

    public void opcionEliminarViaje(Empresa empresa)throws IOException {
        if (empresa.getCantBuses() > 0)
        {
            opcionListarViajesBus(empresa);

            BufferedReader lector = new BufferedReader(new InputStreamReader (System.in));
            System.out.println("Ingrese el código de viaje del bus a eliminar.");

            String codigoViaje = lector.readLine();
            empresa.eliminarViajeBus(codigoViaje);
        }

    }
    
    public void opcionListarViajesBus(Empresa empresa) {
        if (empresa.getCantBuses() > 0)
        {
            empresa.listarViajesBus();
        }
    }
    
    public void opcionAgregarPasajero(ViajeBus viajeBus)throws IOException {
        if (viajeBus != null)
        {
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
                System.out.println("Ingrese RUT del pasajero.");
                rutPasajero = lector.readLine();
                do{
                    System.out.println("Ingrese tipo del pasajero.(estudiante, normal, o tercera edad)");
                    tipoPasajero = lector.readLine();
                    
                }while (!tipoPasajero.equals("estudiante") && !tipoPasajero.equals("normal") && !tipoPasajero.equals("tercera edad"));

                byte [] asientosDisponibles = viajeBus.getAsientosDisponibles();
                
                do {
                    viajeBus.listarAsientosDisponibles();
                    System.out.println("Ingrese numero de asiento del pasajero.");
                    ingresado = lector.readLine();
                    numeroAsiento = Integer.parseInt(ingresado);
                    
                }while(asientosDisponibles[numeroAsiento - 1] != 0);

                Pasajero pasajero = new Pasajero(nombrePasajero, rutPasajero, tipoPasajero, numeroAsiento, codigoViaje);

                viajeBus.agregarPasajero(pasajero);
            }
        }
    }

    public void opcionEliminarPasajero(ViajeBus viajeBus)throws IOException {
        if (viajeBus != null)
        {
            if (viajeBus.getCantPasajeros() > 0)
            {
                opcionListarPasajeros(viajeBus);
                BufferedReader lector = new BufferedReader(new InputStreamReader (System.in));
                System.out.println("Ingrese el RUT del pasajero a eliminar del bus.");
                String rutPasajero;
                rutPasajero = lector.readLine();
                viajeBus.eliminarPasajero(rutPasajero);
            }
        }
    }
    
    public void opcionListarPasajeros(ViajeBus viajeBus)
    {
        if (viajeBus == null)
            return;
        viajeBus.listarPasajeros();
    }
    

    public ViajeBus elegirBus(Empresa empresa)throws IOException {
        if (empresa.getCantBuses() != 0)
        {
            opcionListarViajesBus(empresa);
            System.out.println("Ingrese el codigo de bus a elegir.");
            BufferedReader lector = new BufferedReader(new InputStreamReader (System.in));
            String codigoViaje;
            codigoViaje = lector.readLine();

            ViajeBus busElegido = empresa.getViajeBus(codigoViaje);
            if (busElegido != null)
                return busElegido;
            else
                return null;
        }
        return null;
    }
}