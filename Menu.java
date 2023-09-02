import java.io.*;

public class Menu{

    // Métodos para mostra menús
    
    public void mostrarFuncionalidades(){
        System.out.println("\nMENU DEL SISTEMA");
            System.out.println("Opcion 1 : Registrar viaje de bus en el sistema.");
            System.out.println("Opcion 2 : Eliminar viaje de bus del sistema.");
            System.out.println("Opcion 3 : Listar viajes de bus del sistema.");
            System.out.println("Opcion 4 : Agregar pasajero a viaje de bus.");
            System.out.println("Opcion 5 : Eliminar pasajero de viaje de bus.");
            System.out.println("Opcion 6 : Listar pasajeros de viaje de bus.");
            System.out.println("Opcion 0 : Salir.");
    }

    public void subMenuMostrarPasajeros() {
        System.out.println("Opcion 1 : Listar todos los pasajeros del bus.");
        System.out.println("Opcion 2 : Listar según tipo de pasajero.");
        System.out.println("Opcion 0 : Salir.");
        
    }
    public void subMenuMostrarBuses(){
        System.out.println("Opcion 1 : Listar todos los buses en el sistema.");
        System.out.println("Opcion 2 : Listar los buses en base al lugar de inicio.");
        System.out.println("Opcion 0 : Salir.");
        
    }

    // Opciones Agregar, Eliminar y Listar para la colección de objetos ViajeBus de la clase empresa.
    
    public void OpcionAgregarViajeBus(Empresa empresa)throws IOException {
        if (empresa == null)
            return;

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
        System.out.println("El viaje de bus con código " + codigoViaje + " fue agregado exitosamente.");
    }

    public void opcionEliminarViaje(Empresa empresa)throws IOException {
        if (empresa == null)
            return;
        
        if (empresa.getCantBuses() == 0)
        {
            System.out.println("No hay viajes agendados en el sistema.");
            return;
        }
        
        empresa.listarViajesBus(false);

        BufferedReader lector = new BufferedReader(new InputStreamReader (System.in));
        System.out.println("Ingrese el código de viaje del bus a eliminar.");

        String codigoViaje = lector.readLine();
        empresa.eliminarViajeBus(codigoViaje);
    }

    public void opcionListarViajesBus(Empresa empresa, boolean flag) throws IOException {
        if (empresa == null)
            return;
        
        if (empresa.getCantBuses() == 0)
        {
            System.out.println("No hay viajes de bus disponibles en el sistema.");
        }
        
        if (flag == false)
        {
            empresa.listarViajesBus(flag);
            return;
        }
        
        BufferedReader lector = new BufferedReader(new InputStreamReader (System.in));
        int opcion;
        
        do {
            subMenuMostrarBuses();
            opcion = Integer.parseInt(lector.readLine());
            switch (opcion) {
            case 1:
                empresa.listarViajesBus(flag);
                break;
            case 2:
                System.out.println("Indique el lugar de inicio del viaje de bus.");
                String lugarInicio = lector.readLine();
                empresa.listarViajesBus(lugarInicio);
                break;
            default: 
                break;
            }
        } while(opcion != 1 && opcion != 2 && opcion != 0);
    }


    // Opciones Agregar, Eliminar y Listar para la colección de objetos Pasajero de la clase ViajeBus.
    
    public void opcionAgregarPasajero(ViajeBus viajeBus)throws IOException {
        if (viajeBus == null)
            return;
        
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
            codigoViaje = viajeBus.getCodigo();

            System.out.println("Ingrese nombre del pasajero.");
            nombrePasajero = lector.readLine();
            System.out.println("Ingrese RUT del pasajero.");
            rutPasajero = lector.readLine();
            do{
                System.out.println("Ingrese tipo del pasajero.(Estudiante, General, o Tercera Edad)");
                tipoPasajero = lector.readLine();
                
            }while (!tipoPasajero.equals("Estudiante") && !tipoPasajero.equals("General") && !tipoPasajero.equals("Tercera Edad"));

            byte [] asientosDisponibles = viajeBus.getAsientosDisponibles();
            
            do {
                do{
                    viajeBus.listarAsientosDisponibles();
                    System.out.println("Ingrese numero de asiento del pasajero.");
                    ingresado = lector.readLine();
                    numeroAsiento = Integer.parseInt(ingresado);
                    
                }while(numeroAsiento > totalAsientos);
            }while(asientosDisponibles[numeroAsiento - 1] != 0);

            Pasajero pasajero = new Pasajero(nombrePasajero, rutPasajero, tipoPasajero, numeroAsiento, codigoViaje);

            viajeBus.agregarPasajero(pasajero);
            System.out.println("El pasajero con RUT " + rutPasajero + " fue agregado exitosamente.");
        }
        else
        {
                System.out.println("El viaje de bus con código de viaje " + viajeBus.getCodigo() + " no se encuentra con asientos disponibles.");
        }
    }

    public void opcionEliminarPasajero(ViajeBus viajeBus)throws IOException {
        if (viajeBus == null)
            return;

        if (viajeBus.getCantPasajeros() == 0)
        {
            System.out.println("El viaje de bus con código " + viajeBus.getCodigo() + " no se encuentra con pasajeros disponibles.");
            return;
        }
        
        opcionListarPasajeros(viajeBus, false);
        BufferedReader lector = new BufferedReader(new InputStreamReader (System.in));
        System.out.println("Ingrese el RUT del pasajero a eliminar del bus.");
        String rutPasajero;
        rutPasajero = lector.readLine();
        viajeBus.eliminarPasajero(rutPasajero);
    }
    
    public void opcionListarPasajeros(ViajeBus viajeBus, boolean flag) throws IOException {
        if (viajeBus == null)
            return;
        
        if (viajeBus.getCantPasajeros() == 0)
        {
            System.out.println("El viaje de bus con código " + viajeBus.getCodigo() + " no se encuentra con pasajeros disponibles.");
            return;
        }
        
        if (flag == false)
        {
            viajeBus.listarPasajeros();
            return;
        }
        
        BufferedReader lector = new BufferedReader(new InputStreamReader (System.in));
        int opcion;
        
        do{
            subMenuMostrarPasajeros();
            opcion = Integer.parseInt(lector.readLine());
    
            switch(opcion) {
                case 1:
                    viajeBus.listarPasajeros();
                    break;
                case 2:
                    String tipoPersona;
                    do {
                        System.out.println("Ingrese tipo de persona a buscar (Estudiante, Tercera Edad, General)");
                        tipoPersona = lector.readLine();
                    } while(!tipoPersona.equals("Estudiante") && !tipoPersona.equals("General") && !tipoPersona.equals("Tercera Edad"));
                    viajeBus.listarPasajeros(tipoPersona);
                    break;
                default:
                    break;
            }          
        } while(opcion != 1 && opcion != 2 && opcion != 0);
    }

    
    // Método auxiliar para efectos del programa.
    
    public ViajeBus elegirBus(Empresa empresa, boolean flag)throws IOException {
        if (empresa.getCantBuses() == 0)
        {
            System.out.println("No hay viajes de bus disponibles en el sistema.");
            return null;
        }
        
        opcionListarViajesBus(empresa, false);
        
        System.out.println("Ingrese el codigo del bus a elegir.");
        BufferedReader lector = new BufferedReader(new InputStreamReader (System.in));
        String codigoViaje;
        codigoViaje = lector.readLine();

        ViajeBus busElegido = empresa.getViajeBus(codigoViaje);
        if (busElegido != null){
            if (busElegido.getTotalAsientos() == busElegido.getCantPasajeros() && flag){
                System.out.println("El viaje de bus con código de viaje " + codigoViaje + " no se encuentra con asientos disponibles.");
                return null;
            }
            return busElegido;
        }
        else
        {
            System.out.println("El bus con codigo de viaje "+ codigoViaje +" no se encuentra en el sistema.");
            return null;
        }
    }


    // Carga de datos iniciales
    
    public void cargaDatosInicialesTemporal(Empresa empresa){
        System.out.println("Cargando datos iniciales de manera temporal...");
        
        //BUS 1
        ViajeBus viajeBus = new ViajeBus("Patricio C.","29345","OPTD3472","Quillota","Valparaíso","13:40:00","15:45:00",3500,2000,1850,15000,20);
        empresa.agregarViajeBus(viajeBus);
        //AGREGAR PASAJEROS BUS 1
        
        Pasajero pasajero = new Pasajero("Ana", "12345678-9", "General", 5, "29345");
        viajeBus.agregarPasajero(pasajero);
        
        pasajero = new Pasajero("Pedro", "98765432-1", "Tercera Edad", 12, "29345");
        viajeBus.agregarPasajero(pasajero);
        
        pasajero = new Pasajero("María", "45678901-2", "Estudiante", 20, "29345");
        viajeBus.agregarPasajero(pasajero);
        
        pasajero = new Pasajero("Juan", "56789012-3", "General", 8, "29345");
        viajeBus.agregarPasajero(pasajero);
        
        pasajero = new Pasajero("Luisa", "34567890-4", "General", 15, "29345");
        viajeBus.agregarPasajero(pasajero);
        
        //BUS 2
        viajeBus = new ViajeBus("Juan Perez","29346","LPBY-17","Santiago","Atacama","08:00:00","16:00:00",20000,15000,15000,800000,40);
        empresa.agregarViajeBus(viajeBus);
        
        //AGREGAR PASAJEROS BUS 2
        
        pasajero = new Pasajero("Fernando", "78901234-5", "General", 3, "29346");
        viajeBus.agregarPasajero(pasajero);
        
        pasajero = new Pasajero("Isabel", "89012345-6", "Tercera Edad", 9, "29346");
        viajeBus.agregarPasajero(pasajero);
        
        pasajero = new Pasajero("Gabriel", "90123456-7", "Estudiante", 15, "29346");
        viajeBus.agregarPasajero(pasajero);
        
        pasajero = new Pasajero("Sofía", "01234567-8", "General", 18, "29346");
        viajeBus.agregarPasajero(pasajero);
        
        pasajero = new Pasajero("Diego", "12345678-9", "General", 7, "29346");
        viajeBus.agregarPasajero(pasajero);
        
        pasajero = new Pasajero("Marta", "23456789-0", "General", 14, "29346");
        viajeBus.agregarPasajero(pasajero);
        
        pasajero = new Pasajero("Javier", "34567890-1", "Estudiante", 6, "29346");
        viajeBus.agregarPasajero(pasajero);
        

        //BUS 3
        viajeBus = new ViajeBus("Luis M.", "29347", "ERXG-5621", "Santiago", "Rancagua", "08:30:00", "10:45:00", 3000, 1800, 1500, 12000, 25);
        empresa.agregarViajeBus(viajeBus);

        //AGREGAR PASAJEROS BUS 3

        pasajero = new Pasajero("Fernando", "78901234-5", "General", 3, "29347");
        viajeBus.agregarPasajero(pasajero);
        
        pasajero = new Pasajero("Isabel", "89012345-6", "Tercera Edad", 9, "29347");
        viajeBus.agregarPasajero(pasajero);
        
        pasajero = new Pasajero("Gabriel", "90123456-7", "Estudiante", 15, "29347");
        viajeBus.agregarPasajero(pasajero);
        
        pasajero = new Pasajero("Sofía", "01234567-8", "General", 18, "29347");
        viajeBus.agregarPasajero(pasajero);
        
        pasajero = new Pasajero("Diego", "12345678-9", "General", 7, "29347");
        viajeBus.agregarPasajero(pasajero);
        
        pasajero = new Pasajero("Marta", "23456789-0", "General", 14, "29347");
        viajeBus.agregarPasajero(pasajero);
        
        pasajero = new Pasajero("Javier", "34567890-1", "Estudiante", 6, "29347");
        viajeBus.agregarPasajero(pasajero);

        
        //BUS 4
        viajeBus = new ViajeBus("María R.", "29348", "TYSF-9876", "Cali", "Medellín", "09:15:00", "12:30:00", 2800, 1600, 1400, 11000, 30);
        empresa.agregarViajeBus(viajeBus);
        //AGREGAR PASAJEROS BUS 4
        pasajero = new Pasajero("Juan", "98765432-1", "General", 7, "29348");
        viajeBus.agregarPasajero(pasajero);
        pasajero = new Pasajero("Ana", "45678901-2", "Tercera Edad", 12, "29348");
        viajeBus.agregarPasajero(pasajero);
        pasajero = new Pasajero("Carlos", "76543210-9", "General", 25, "29348");
        viajeBus.agregarPasajero(pasajero);
        pasajero = new Pasajero("María", "11223344-5", "Especial", 2, "29348");
        
        //BUS 5
        viajeBus = new ViajeBus("Diego Torres", "29349", "XYZ-789", "Punta Arenas", "Torres del Paine", "06:00", "15:00", 30000, 25000, 25000, 1050000,35);
        empresa.agregarViajeBus(viajeBus);
        }
}