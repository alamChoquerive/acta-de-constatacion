package Model;


import java.time.LocalDate;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "licencias")
public class Licencias implements Serializable {

    @Id
    @Column(name = "id_licencia")
    private int idLicencia;

    @Column(name = "fecha_vto")
    private LocalDate fechaVto;

    @Column(name = "puntos_licencias")
    private int puntosLicencias;

    @OneToOne
    @JoinColumn(name = "conductor_id", referencedColumnName = "id_persona")
    private Conductor conductor;

    public Licencias() {
    }

    public Licencias(int idLicencia, LocalDate fechaVto, int puntosLicencias, Conductor conductor) {
        this.idLicencia = idLicencia;
        this.fechaVto = fechaVto;
        this.puntosLicencias = puntosLicencias;
        this.conductor = conductor;
    }

    public int getIdLicencia() {
        return idLicencia;
    }

    public void setIdLicencia(int idLicencia) {
        this.idLicencia = idLicencia;
    }

    public LocalDate getFechaVto() {
        return fechaVto;
    }

    public void setFechaVto(LocalDate fechaVto) {
        this.fechaVto = fechaVto;
    }

    public int getPuntosLicencias() {
        return puntosLicencias;
    }

    public void setPuntosLicencias(int puntosLicencias) {
        this.puntosLicencias = puntosLicencias;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }
}