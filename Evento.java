public class Evento {
    private String encargado;
    private String nombre;
    private String tipoEvento; 
    private String fecha;
    private String horaInicio;
    private String horaFin;

    public Evento(String encargado, String nombre, String tipoEvento, String fecha, String horaInicio, String horaFin) {
        this.encargado = encargado;
        this.nombre = nombre;
        this.tipoEvento = tipoEvento;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public int calcularDuracion() {
        int inicio = Integer.parseInt(horaInicio.split(":")[0]);
        int fin = Integer.parseInt(horaFin.split(":")[0]);
        if (fin < inicio) {
            fin += 24;
        }
        return fin - inicio;
    }

    public void mostrarInfo() {
        System.out.println("Evento: " + nombre + " | Encargado: " + encargado + " | Tipo: " + tipoEvento);
        System.out.println("Fecha: " + fecha + " | Hora: " + horaInicio + " - " + horaFin);
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "nombre='" + nombre + '\'' +
                ", encargado='" + encargado + '\'' +
                ", tipo='" + tipoEvento + '\'' +
                ", fecha='" + fecha + '\'' +
                ", hora=" + horaInicio + "-" + horaFin +
                '}';
    }
}