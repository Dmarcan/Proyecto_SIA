// La clase ViajeBus corresponde a la plantilla para los objetos almacenados en la colección de primer nivel de este programa.
public class ViajeBus extends ViajeComercial{
    private int tarifaGeneral;
    private int tarifaTerceraEdad;
    private int tarifaEstudiante;

    private double costoTotal;
    private double gananciaTotal;
    private double rentabilidad;

    // Constructor de la clase ViajeBus, inicializa algunos de los atributos de la clase con parámetros formales y otros los inicializa en 0.
    // Al ingresar la ganancia, debe actualizarse la rentabilidad.
    public ViajeBus(String nombreChofer, String codigoViaje, String matricula, String lugarInicio,
                    String lugarLlegada, String horaInicio, String horaLlegada,
                    int tarifaGeneral, int tarifaTerceraEdad, int tarifaEstudiante,
                    double costoTotal, int totalAsientos){
        super(nombreChofer, codigoViaje, matricula, lugarInicio, lugarLlegada, horaInicio, horaLlegada, totalAsientos);
        this.tarifaGeneral = tarifaGeneral;
        this.tarifaTerceraEdad = tarifaTerceraEdad;
        this.tarifaEstudiante = tarifaEstudiante;
        
        this.costoTotal = costoTotal;
        gananciaTotal = 0;
        actualizarRentabilidad();
    }

    // Setters
    public void setTarifaGeneral(int tarifaGeneral)
    {
        this.tarifaGeneral = tarifaGeneral;
    }
    
    public void setTarifaTerceraEdad(int tarifaTerceraEdad)
    {
        this.tarifaTerceraEdad = tarifaTerceraEdad;
    }

    public void setTarifaEstudiante(int tarifaEstudiante)
    {
        this.tarifaEstudiante = tarifaEstudiante;
    }

    public void setCostoTotal(int costoTotal)
    {
        this.costoTotal = costoTotal;
    }

    // Al actualizarse la ganancia, debe actualizarse la rentabilidad.
    public void setGananciaTotal(int gananciaTotal) {
        this.gananciaTotal = gananciaTotal;
        actualizarRentabilidad();
    }

    public void setRentabilidad(int rentabilidad)
    {
        this.rentabilidad = rentabilidad;
    }
    
    // Getters
    public int getTarifaGeneral()
    {
        return tarifaGeneral;
    }

    public int getTarifaTerceraEdad()
    {
        return tarifaTerceraEdad;
    }
    
    public int getTarifaEstudiante()
    {
        return tarifaEstudiante;
    }

    public double getGananciaTotal()
    {
        return gananciaTotal;
    }

    public double getCostoTotal()
    {
        return costoTotal;
    }
    
    public double getRentabilidad()
    {
        return rentabilidad;
    }

    // Métodos para modificar objeto Pasajero en colección asociada al objeto ViajeBus respectivo.
    public String modificarTipoPasajero(String tipoPasajero, String rutPasajero) {
        String tipo = super.modificarTipoPasajero(tipoPasajero,rutPasajero);
        if (tipo != null)
        {
            actualizarGanancia(tipo, "eliminar");
            actualizarGanancia(tipoPasajero, "agregar");
            return tipoPasajero;
        }
        return null;
    }

    // Métodos para Agregar y Eliminar objetos Pasajero de la colección del objeto ViajeBus respectivo.
    public void agregarPasajero(Pasajero pasajero) throws ViajeBusAsientoOcupadoException, PasajeroExisteException {
            super.agregarPasajero(pasajero);  
        actualizarGanancia(pasajero.getTipo(), "Agregar");
    }

    public Pasajero eliminarPasajero(String rutPasajero) {
        Pasajero aux = super.eliminarPasajero(rutPasajero);
        if (aux == null)
            return null;
        actualizarGanancia(aux.getTipo(), "Eliminar");
        return aux;
    }
    
    // Funcionalidades Propias asociadas al negocio del bus.
    
    //    PALABRAS CLAVE
    //Acción: "agregar","eliminar".

    /*El método actualizarGanancia es propio del contexto del tema elegido para el proyecto, consiste en el aumento
    o la disminución de las ganancias del viaje de bus respecto de la compra o anulación de un pasaje, y por ende, 
    el agrega o eliminar un pasajero.*/
    public void actualizarGanancia(String tipoPersona, String accion)
    {
         switch (tipoPersona) 
         {
            case "Estudiante":
                if (accion.equals("Agregar")) gananciaTotal += tarifaEstudiante;
                else gananciaTotal -= tarifaEstudiante;
                break;
            case "Tercera Edad":
                 
                if (accion.equals("Agregar")) gananciaTotal += tarifaTerceraEdad;
                else gananciaTotal -= tarifaTerceraEdad;
                break;
            case "General":
                if (accion.equals("Agregar")) gananciaTotal += tarifaGeneral;
                else gananciaTotal -= tarifaGeneral;
                break;
            default:
                return;
        }
        actualizarRentabilidad();
        return;
    }
    
    /*El método actualizarRentabilidad es propio del contexto del tema elegido para el proyecto, consiste en el cálculo
    por definición de rentabilidad, usando la ganancia total (que puede variar) y el costo total (valor fijo), para luego
    dejar la rentabilidad expresada como porcentaje.
    Algunos conceptos relacionados:
    Rentabilidad negativa: Significa que el viaje de bus ha provocado una pérdida en lugar de una ganancia monetaria
    para la empresa.
    Rentabilidad entre 0 a 50%: Puede considerarse que la rentabilidad ha sido nula, baja o moderada, dependiendo 
    del valor exacto.
    Rentabilidad entre 50 a 100%: Esto representa un nivel de rentabilidad moderado a razonablemente bueno.
    Rentabilidad mayor a 100%: Esto indica un nivel de rentabilidad bastante bueno, donde las ganancias 
    superan significativamente los costos o la inversión inicial.*/
    public void actualizarRentabilidad()
    {
        rentabilidad = ((gananciaTotal - costoTotal) / costoTotal) * 100;
        return;
    }
}

