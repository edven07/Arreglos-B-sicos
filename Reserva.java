public class Reserva {
    private Evento evento;
    private Salones salon;
    private boolean pago;
    private double costoTotal;

    public Reserva(Evento evento, Salones salon) {
        this.evento = evento;
        this.salon = salon;
        this.pago = false;
        this.costoTotal = calcularCosto();
    }

    public double calcularCosto() {
        return evento.calcularDuracion() * salon.getCostoHora();
    }

    public boolean validarReserva() {
        if (salon.getTipo().equalsIgnoreCase("Grande") &&
            !evento.getTipoEvento().equalsIgnoreCase("VIP")) {
            return false;
        }
        return salon.isDisponible();
    }

    public void confirmarReserva() {
        if (validarReserva()) {
            salon.reservar();
            pago = true;
            System.out.println("La reserva esta confirmada para el evento: " + evento.getFecha());
        } else {
            System.out.println("No se pudo confirmar la reserva.");
        }
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "evento=" + evento +
                ", salon=" + salon.getNumero() +
                ", costo=" + costoTotal + " Q" +
                ", pagado=" + pago +
                '}';
    }
}
