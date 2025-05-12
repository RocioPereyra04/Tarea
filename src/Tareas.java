import java.time.LocalDate;
import java.util.UUID;

public class Tareas {

    // Atributos
    private String codigo;
    private String nombreTarea;
    private String estado;           // Estado: pendiente, en progreso, finalizada
    private String descripcion;
    private LocalDate fechaI;
    private LocalDate fechaF;
    private boolean ALTA;


    // Constructor con parámetros
    public Tareas(String nombreTarea, String descripcion, String estado, LocalDate fechaI, LocalDate fechaF) {
        this.codigo = UUID.randomUUID().toString().substring(0, 5);
        this.nombreTarea = nombreTarea;
        this.estado = estado;
        this.descripcion = descripcion;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.ALTA = true;
    }


    // SETTERS
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechaI(LocalDate fechaI) {
        this.fechaI = fechaI;
    }

    public void setFechaF(LocalDate fechaF) {
        this.fechaF = fechaF;
    }

    public void setALTA(boolean ALTA) {
        this.ALTA = ALTA;
    }

    // GETTERS
    public String getCodigo() {
        return codigo;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public String getEstado() {
        return estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFechaI() {
        return fechaI;
    }

    public LocalDate getFechaF() {
        return fechaF;
    }

    public boolean isALTA() {
        return ALTA;
    }

    @Override
    public String toString() {
        return "Tarea [" +
                "código=" + codigo +
                ", nombre='" + nombreTarea + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", fechaInicio=" + fechaI +
                ", fechaFin=" + fechaF +
                ", esAlta=" + ALTA +
                ']';
    }
}
