package Model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rutas")
public class Ruta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ruta")
    private Long id;

    @Column(name = "nombre_ruta", nullable = false, length = 100)
    private String nombreRuta;

    @Column(name = "km_ruta", length = 50)
    private String kmRuta;

    @ManyToOne
    @JoinColumn(name = "tipo_ruta_id")
    private TipoRuta tipoRuta;

    public Ruta() {
    }

    public Ruta(String nombreRuta, String kmRuta) {
        this.nombreRuta = nombreRuta;
        this.kmRuta = kmRuta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    public String getKmRuta() {
        return kmRuta;
    }

    public void setKmRuta(String kmRuta) {
        this.kmRuta = kmRuta;
    }

    public TipoRuta getTipoRuta() {
        return tipoRuta;
    }

    public void setTipoRuta(TipoRuta tipoRuta) {
        this.tipoRuta = tipoRuta;
    }
}