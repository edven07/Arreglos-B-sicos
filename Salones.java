public class Salones {
    private String tipo; 
    private String numero;
    private String capacidad;
    private double costoHora;
    private boolean disponibilidad;

    public Salones(String tipo, String numero, String capacidad, double costoHora) {
        this.tipo = tipo;
        this.numero = numero;
        this.capacidad = capacidad;
        this.costoHora = costoHora;
        this.disponibilidad = true;
    }

    public boolean estaDisponible(String fecha, String horaInicio, String horaFin) {
        return disponibilidad;
    }

    public void reservar() {
        this.disponibilidad = false;
    }

    public void liberar() {
        this.disponibilidad = true;
    }

    public double getCostoHora() {
        return costoHora;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNumero() {
        return numero;
    }

    public boolean isDisponible() {
        return disponibilidad;
    }

    @Override
    public String toString() {
        return "Salón{" +
                "numero='" + numero + '\'' +
                ", tipo='" + tipo + '\'' +
                ", capacidad='" + capacidad + '\'' +
                ", costoHora=" + costoHora +
                ", disponible=" + disponibilidad +
                '}';
    }
}