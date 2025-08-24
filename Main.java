import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Controlador controlador = new Controlador(10, 50, 20);

        // Salones Iniciales agregados
        controlador.agregarSalon(new Salones("Grande", "101", "200 personas", 500));
        controlador.agregarSalon(new Salones("Mediano", "102", "100 personas", 300));
        controlador.agregarSalon(new Salones("Pequeño", "103", "50 personas", 150));
        controlador.agregarSalon(new Salones("Pequeño", "104", "50 personas", 150));
    
        int opcion;
        do {
            System.out.println("\nMENU");
            System.out.println("1. Nueva solicitud de evento");
            System.out.println("2. Consultar salones disponibles");
            System.out.println("3. Mostrar reservas");
            System.out.println("4. Mostrar lista de espera");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Encargado: ");
                    String encargado = sc.nextLine();
                    System.out.print("Nombre del evento: ");
                    String nombre = sc.nextLine();
                    System.out.print("Tipo de evento (VIP/Normal): ");
                    String tipo = sc.nextLine();
                    System.out.print("Fecha: ");
                    String fecha = sc.nextLine();
                    System.out.print("Hora inicio (HH): ");
                    String inicio = sc.nextLine();
                    System.out.print("Hora fin (HH): ");
                    String fin = sc.nextLine();

                    Evento evento = new Evento(encargado, nombre, tipo, fecha, inicio, fin);
                    controlador.recibirSolicitud(evento);
                    break;

                case 2:
                    System.out.print("Ingrese fecha a consultar: ");
                    String f = sc.nextLine();
                    controlador.consultarDisponibles(f);
                    break;

                case 3:
                    controlador.mostrarReservas();
                    break;

                case 4:
                    controlador.mostrarListaEspera();
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        sc.close();
    }
}