public class Controlador {
    private Salones[] salones;
    private Reserva[] reservas;
    private Evento[] listaEspera;

    private int contadorSalones;
    private int contadorReservas;
    private int contadorEspera;

    public Controlador(int maxSalones, int maxReservas, int maxEspera) {
        salones = new Salones[maxSalones];
        reservas = new Reserva[maxReservas];
        listaEspera = new Evento[maxEspera];
        contadorSalones = 0;
        contadorReservas = 0;
        contadorEspera = 0;
    }

    public void agregarSalon(Salones salon) {
        if (contadorSalones < salones.length) {
            salones[contadorSalones++] = salon;
        } else {
            System.out.println("No se pueden agregar más salones.");
        }
    }

    public void recibirSolicitud(Evento evento) {
        asignarSalon(evento);
    }

    public void asignarSalon(Evento evento) {
        for (int i = 0; i < contadorSalones; i++) {
            if (salones[i].isDisponible()) {
                Reserva reserva = new Reserva(evento, salones[i]);
                if (reserva.validarReserva()) {
                    if (contadorReservas < reservas.length) {
                        reserva.confirmarReserva();
                        reservas[contadorReservas++] = reserva;
                        return;
                    } else {
                        System.out.println("No se pueden aceptar más reservas.");
                        return;
                    }
                }
            }
        }
        System.out.println("No hay salones disponibles, evento agregado a lista de espera.");
        if (contadorEspera < listaEspera.length) {
            listaEspera[contadorEspera++] = evento;
        } else {
            System.out.println("La lista de espera está llena.");
        }
    }

    public void consultarDisponibles(String fecha) {
        System.out.println("Salones disponibles en la fecha: " + fecha);
        boolean hayDisponibles = false;
        for (int i = 0; i < contadorSalones; i++) {
            if (salones[i].isDisponible()) {
                System.out.println(" - Salón " + salones[i].getNumero() + " (" + salones[i].getTipo() + ")");
                hayDisponibles = true;
            }
        }
        if (!hayDisponibles) {
            System.out.println("No hay salones disponibles en esta fecha.");
        }
    }

    public void mostrarReservas() {
        if (contadorReservas == 0) {
            System.out.println("No hay reservas confirmadas.");
            return;
        }
        for (int i = 0; i < contadorReservas; i++) {
            System.out.println(reservas[i]);
        }
    }

    public void mostrarListaEspera() {
        if (contadorEspera == 0) {
            System.out.println("No hay eventos en lista de espera.");
            return;
        }
        for (int i = 0; i < contadorEspera; i++) {
            listaEspera[i].mostrarInfo();
        }
    }
}
