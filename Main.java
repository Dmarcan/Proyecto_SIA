import java.io.*;

public class Main{
    public static void main(String args[])throws IOException{
        int opcion;
        BufferedReader lector = new BufferedReader(new InputStreamReader (System.in));
        Empresa empresa = new Empresa(null, null, 0);
        do{
            System.out.println("MENÚ DEL SISTEMA");
            System.out.println("Opcion 1 : Registrar viaje de bus en el sistema");
            System.out.println("Opcion 2 : Eliminar viaje de bus del sistema");
            System.out.println("Opcion 3 : Mostrar viajes de bus del sistem");
            System.out.println("Opcion 4 : Agregar pasajero a viaje de bus");
            System.out.println("Opcion 5 : Mostrar pasajeros de viaje de bus");
            System.out.println("Opcion 6 : Anular viaje de bus");
            System.out.println("Opcion 7 : Anular pasajero de viaje de bus");
            System.out.println("Opcion 8 : Verificar rentabilidad de buses y reasignación de pasajeros");
            System.out.println("Opcion 0 : Salir.");
            
            opcion = Integer.parseInt(lector.readLine());
            switch (opcion){
                default: {
                    break;
                }
            }
        }while (opcion != 0);
    }
}
