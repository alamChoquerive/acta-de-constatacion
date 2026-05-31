package Model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "organizaciones_estatales")
public class OrganizacionEstatal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_organizacion")
    private Long id;

    @Column(name = "nombre_organizacion", nullable = false, length = 200)
    private String nombreOrganizacion;

    @Column(name = "localidad", length = 100)
    private String localidad;

    public OrganizacionEstatal() {
    }

    public OrganizacionEstatal(String nombreOrganizacion, String localidad) {
        this.nombreOrganizacion = nombreOrganizacion;
        this.localidad = localidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreOrganizacion() {
        return nombreOrganizacion;
    }

    public void setNombreOrganizacion(String nombreOrganizacion) {
        this.nombreOrganizacion = nombreOrganizacion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
}