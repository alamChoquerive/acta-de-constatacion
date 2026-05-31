package Model;


import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "infracciones")
public class Infraccion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_infraccion")
    private Long id;

    @Column(name = "descripcion_infraccion", length = 500)
    private String descrpInfraccion;

    @Column(name = "importe_infraccion")
    private double importeInfraccion;

    @ManyToMany
    @JoinTable(
            name = "infraccion_tipo",
            joinColumns = @JoinColumn(name = "infraccion_id"),
            inverseJoinColumns = @JoinColumn(name = "tipo_infraccion_id")
    )
    private List<TipoDeInfraccion> infraccionNomenclada = new ArrayList<>();

    public Infraccion() {
    }

    public Infraccion(String descrpInfraccion, double importeInfraccion) {
        this.descrpInfraccion = descrpInfraccion;
        this.importeInfraccion = importeInfraccion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescrpInfraccion() {
        return descrpInfraccion;
    }

    public void setDescrpInfraccion(String descrpInfraccion) {
        this.descrpInfraccion = descrpInfraccion;
    }

    public double getImporteInfraccion() {
        return importeInfraccion;
    }

    public void setImporteInfraccion(double importeInfraccion) {
        this.importeInfraccion = importeInfraccion;
    }

    public List<TipoDeInfraccion> getInfraccionNomenclada() {
        return infraccionNomenclada;
    }

    public void setInfraccionNomenclada(List<TipoDeInfraccion> infraccionNomenclada) {
        this.infraccionNomenclada = infraccionNomenclada;
    }

    public void addTipoDeInfraccion(TipoDeInfraccion tipo) {
        this.infraccionNomenclada.add(tipo);
    }
}
