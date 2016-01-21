package negocio.dominio;
import java.sql.Date;

/**
 *
 * @author fernandoarenasdev
 */
public class Ejercicio {
    private int idEjercicio;
    private String nombreEjercicio;
    private String descripcionEjercicio;
    private String categoriaEjercicio;
    private Date fechaEjercicio;
    private String observacionesEjercicio;

    public Ejercicio() {
    }

    public Ejercicio(String nombreEjercicio, String descripcionEjercicio, String categoriaEjercicio, Date fechaEjercicio, String observacionesEjercicio) {
        this.nombreEjercicio = nombreEjercicio;
        this.descripcionEjercicio = descripcionEjercicio;
        this.categoriaEjercicio = categoriaEjercicio;
        this.fechaEjercicio = fechaEjercicio;
        this.observacionesEjercicio = observacionesEjercicio;
    }

    public Ejercicio(int idEjercicio, String nombreEjercicio, String descripcionEjercicio, String categoriaEjercicio, Date fechaEjercicio, String observacionesEjercicio) {
        this.idEjercicio = idEjercicio;
        this.nombreEjercicio = nombreEjercicio;
        this.descripcionEjercicio = descripcionEjercicio;
        this.categoriaEjercicio = categoriaEjercicio;
        this.fechaEjercicio = fechaEjercicio;
        this.observacionesEjercicio = observacionesEjercicio;
    }

    public int getIdEjercicio() {
        return idEjercicio;
    }

    public void setIdEjercicio(int idEjercicio) {
        this.idEjercicio = idEjercicio;
    }

    public String getNombreEjercicio() {
        return nombreEjercicio;
    }

    public void setNombreEjercicio(String nombreEjercicio) {
        this.nombreEjercicio = nombreEjercicio;
    }

    public String getDescripcionEjercicio() {
        return descripcionEjercicio;
    }

    public void setDescripcionEjercicio(String descripcionEjercicio) {
        this.descripcionEjercicio = descripcionEjercicio;
    }

    public String getCategoriaEjercicio() {
        return categoriaEjercicio;
    }

    public void setCategoriaEjercicio(String categoriaEjercicio) {
        this.categoriaEjercicio = categoriaEjercicio;
    }

    public Date getFechaEjercicio() {
        return fechaEjercicio;
    }

    public void setFechaEjercicio(Date fechaEjercicio) {
        this.fechaEjercicio = fechaEjercicio;
    }

    public String getObservacionesEjercicio() {
        return observacionesEjercicio;
    }

    public void setObservacionesEjercicio(String observacionesEjercicio) {
        this.observacionesEjercicio = observacionesEjercicio;
    }
             
    
}
