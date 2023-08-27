import java.io.*;

public class ViajeBus{    
    private String nombreChofer;
    private String codigoViaje;
    private String matricula;
    
    private String lugarInicio;
    private String lugarDestino;
    
    private String horaInicio;
    private String horaLlegada;
    
    private int tarifaGeneral;
    private int tarifaTerceraEdad;
    private int tarifaEstudiante;

    private int totalAsientos;
    private int cantPasajeros;
    
    private Pasajero[] pasajerosNroAsiento;
    private byte[] asientosDisponibles;
    
    private int gananciaTotal;
    private int costoViaje;
    private double rentabilidad;
    
    public ViajeBus(String nombreChofer, String codigoViaje, String matricula, String lugarInicio,
                String lugarDestino, String horaInicio, String horaLlegada,
                int tarifaGeneral, int tarifaTerceraEdad, int tarifaEstudiante,
                int costoViaje, int totalAsientos) {
        this.totalAsientos = totalAsientos;
        this.nombreChofer = nombreChofer;
        this.codigoViaje = codigoViaje;
        this.matricula = matricula;
        
        this.lugarInicio = lugarInicio;
        this.lugarDestino = lugarDestino;
        this.horaInicio = horaInicio;
        this.horaLlegada = horaLlegada;
        
        this.tarifaGeneral = tarifaGeneral;
        this.tarifaTerceraEdad = tarifaTerceraEdad;
        this.tarifaEstudiante = tarifaEstudiante;
        
        this.costoViaje = costoViaje;
        
        pasajerosNroAsiento = new Pasajero[totalAsientos];
        asientosDisponibles = new byte[totalAsientos];
        cantPasajeros = 0;
        
        gananciaTotal = 0;
        rentabilidad = 0.0;
    }

    public String getCodigo()
    {
        return codigoViaje;
    }

    public void listarAsientosDisponibles()
    {
        int pasillo = 0;
        for (byte i = 0; i < asientosDisponibles.length; i++)
        {
            if(pasillo % 2 == 0 && (pasillo != 0 || pasillo % 3 != 0))
                System.out.println("||  ");
            if (asientosDisponibles[i] != 0) 
            {
                if(i < 10)
                    System.out.println(i + "  ");
                else
                    System.out.println(i + " ");

                pasillo++;
            } 
            else 
            {
                System.out.println('X' + "  ");
            }
            if(i % 3 == 0) System.out.println();
            
                
        }
    }

    /* David 
    public void agregarPasajero(String nombrePasajero, String rutPasajero, String tipoPasajero,int numeroAsiento, String codigoViaje)
    {
        
        Pasajero pasajeroAgregar = new Pasajero(nombrePasajero,rutPasajero,tipoPasajero,numeroAsiento,codigoViaje);
        pasajerosNroAsiento[cantPasajeros] = pasajeroAgregar;
        asientosDisponibles[numeroAsiento-1] = 1;

        actualizarGanancia(tipoPasajero,"agregar");
        cantPasajeros++;
    }
    */

    public void agregarPasajero()throws IOException
    {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String codigoViaje;
        String nombrePasajero;
        String rutPasajero;
        String tipoPasajero;
        String ingresado;
        int numeroAsiento;
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
                    
            do {
                listarAsientosDisponibles();
                System.out.println("Ingrese numeroAsiento del pasajero.");
                ingresado = lector.readLine();
                numeroAsiento = Integer.parseInt(ingresado);
                
            }while(asientosDisponibles[numeroAsiento - 1] != 0);

            Pasajero pasajero = new Pasajero(nombrePasajero, rutPasajero, tipoPasajero, numeroAsiento, codigoViaje);
            
            actualizarGanancia(tipoPasajero,"agregar");
                
            
            asientosDisponibles[numeroAsiento - 1] = 0;
            pasajerosNroAsiento[cantPasajeros - 1] = pasajero;
            cantPasajeros++;
        }
        else
        {
            System.out.println("Todos los buses llenos. No se puede agregar.");
        }
    }
    
    /* Edu
    public void agregarPasajero()
    {
        // Falta: Mostrar y dar elegir el número de asiento al pasajero, ya sea con un algoritmo dentro de este método
        // o llamando a un método auxiliar.
        int numeroAsiento = 0;
        
        if (cantPasajeros < totalAsientos && asientosDisponibles[numeroAsiento - 1] != 0)
        {
            // Falta: Creación objeto Pasajero ya sea con un algoritmo dentro de este método o llamando a un método auxiliar.
            asientosDisponibles[numeroAsiento - 1] = 0;
            // pasajerosNroAsiento[numeroAsiento - 1] = pasajero;
            cantPasajeros++;
        }
    }
    */
    
    public int buscarPasajero(String rut){
        for (int i = 0; i < cantPasajeros; i++){
            if (pasajerosNroAsiento[i] != null)
            {
                Pasajero pasajeroAux = pasajerosNroAsiento[i];
                if (rut.equals(pasajeroAux.getRut())){
                    return i;
                }
            }
        }
        return -1;
    }
    
    public void eliminarPasajero(String rut)
    {
        int posicion = buscarPasajero(rut);
        if (posicion != -1)
        {
            actualizarGanancia(pasajerosNroAsiento[posicion].getTipo(),"eliminar");
                
            int asientoDis = pasajerosNroAsiento[posicion].getAsiento();
            asientosDisponibles[asientoDis + 1] = 0;
            
            pasajerosNroAsiento[posicion] = pasajerosNroAsiento[cantPasajeros - 1];
            cantPasajeros--;

            System.out.println("Persona con rut: "+ rut +", ha sido eliminada.");
            
        }
        else
        {
            System.out.println("Persona con rut: "+ rut +", no se encuentra.");
            return;
        }
    }

    /*
    PALABRAS CLAVES    
    accion:"agregar","eliminar"
    */
    public void actualizarGanancia(String tipoPersona,String accion)
    {
         switch (tipoPersona) 
         {
            case "estudiante":
                 
                 if (accion.equals("eliminar")) gananciaTotal-=tarifaEstudiante;
                 else gananciaTotal+=tarifaEstudiante;
                    
                break;
            case "terceraEdad":
                 
                 if (accion.equals("eliminar")) gananciaTotal-=tarifaTerceraEdad;
                 else gananciaTotal+=tarifaTerceraEdad;
                     
                break;
            case "normal":
                 if (accion.equals("eliminar")) gananciaTotal-=tarifaGeneral;
                 else gananciaTotal+=tarifaGeneral;
                
                break;
            default:
                return;
        }
        actualizarRentabilidad();
        return;
        
    }
    public void actualizarRentabilidad()
    {
        rentabilidad = ((gananciaTotal-costoViaje)/gananciaTotal)*100;
        return;
    }
}
