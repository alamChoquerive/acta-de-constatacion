package Model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tipos_ruta")
public class TipoRuta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_ruta")
    private Long id;

    @Column(name = "descripcion_tipo_ruta", length = 255)
    private String descTipoRuta;

    @Column(name = "nombre_tipo_ruta", nullable = false, length = 100)
    private String nombreTipoDeRuta;

    public TipoRuta() {
    }

    public TipoRuta(String descTipoRuta, String nombreTipoDeRuta) {
        this.descTipoRuta = descTipoRuta;
        this.nombreTipoDeRuta = nombreTipoDeRuta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescTipoRuta() {
        return descTipoRuta;
    }

    public void setDescTipoRuta(String descTipoRuta) {
        this.descTipoRuta = descTipoRuta;
    }

    public String getNombreTipoDeRuta() {
        return nombreTipoDeRuta;
    }

    public void setNombreTipoDeRuta(String nombreTipoDeRuta) {
        this.nombreTipoDeRuta = nombreTipoDeRuta;
    }
}