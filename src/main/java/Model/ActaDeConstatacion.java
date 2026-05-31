package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "actas_constatacion")
public class ActaDeConstatacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_acta")
    private int idActa;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "acta_infraccion",
            joinColumns = @JoinColumn(name = "acta_id"),
            inverseJoinColumns = @JoinColumn(name = "infraccion_id")
    )
    private List<Infraccion> infracciones = new ArrayList<>();

    @Column(name = "fecha_vto_pago_voluntario")
    private LocalDate fechaDeVtoPagoVolun;

    @Column(name = "fecha_labrado")
    private LocalDate fechaLabraDo;

    @Column(name = "lugar_constatacion", length = 255)
    private String lugarDeConstatacion;

    @Column(name = "observaciones", length = 500)
    private String observaciones;

    @Column(name = "hora_labrado")
    private LocalTime horaDeLabrado;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "autoridad_id")
    private AutoridadDeConstatacion autoridad;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private EstadoDelActa estado;

    @ManyToOne
    @JoinColumn(name = "organizacion_id")
    private OrganizacionEstatal organizacion;

    public ActaDeConstatacion() {
    }

    public ActaDeConstatacion(LocalDate fechaDeVtoPagoVolun, LocalDate fechaLabraDo,
                              String lugarDeConstatacion, String observaciones,
                              int idActa, LocalTime horaDeLabrado) {
        this.fechaDeVtoPagoVolun = fechaDeVtoPagoVolun;
        this.fechaLabraDo = fechaLabraDo;
        this.lugarDeConstatacion = lugarDeConstatacion;
        this.observaciones = observaciones;
        this.idActa = idActa;
        this.horaDeLabrado = horaDeLabrado;
    }

    // Getters y Setters
    public List<Infraccion> getInfracciones() {
        return infracciones;
    }

    public void setInfracciones(List<Infraccion> infracciones) {
        this.infracciones = infracciones;
    }

    public LocalDate getFechaDeVtoPagoVolun() {
        return fechaDeVtoPagoVolun;
    }

    public void setFechaDeVtoPagoVolun(LocalDate fechaDeVtoPagoVolun) {
        this.fechaDeVtoPagoVolun = fechaDeVtoPagoVolun;
    }

    public LocalDate getFechaLabraDo() {
        return fechaLabraDo;
    }

    public void setFechaLabraDo(LocalDate fechaLabraDo) {
        this.fechaLabraDo = fechaLabraDo;
    }

    public String getLugarDeConstatacion() {
        return lugarDeConstatacion;
    }

    public void setLugarDeConstatacion(String lugarDeConstatacion) {
        this.lugarDeConstatacion = lugarDeConstatacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getIdActa() {
        return idActa;
    }

    public void setIdActa(int idActa) {
        this.idActa = idActa;
    }

    public LocalTime getHoraDeLabrado() {
        return horaDeLabrado;
    }

    public void setHoraDeLabrado(LocalTime horaDeLabrado) {
        this.horaDeLabrado = horaDeLabrado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public AutoridadDeConstatacion getAutoridad() {
        return autoridad;
    }

    public void setAutoridad(AutoridadDeConstatacion autoridad) {
        this.autoridad = autoridad;
    }

    public EstadoDelActa getEstado() {
        return estado;
    }

    public void setEstado(EstadoDelActa estado) {
        this.estado = estado;
    }

    public OrganizacionEstatal getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(OrganizacionEstatal organizacion) {
        this.organizacion = organizacion;
    }

    public void addInfraccion(Infraccion infraccion) {
        this.infracciones.add(infraccion);
    }
}