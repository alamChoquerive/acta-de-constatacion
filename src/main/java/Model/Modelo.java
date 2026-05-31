package Model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "modelos")
public class Modelo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modelo")
    private Long id;

    @Column(name = "modelo_auto", nullable = false, length = 100)
    private String modeloAuto;

    @ManyToOne
    @JoinColumn(name = "marca_id", referencedColumnName = "id_marca")
    private Marca marca;

    public Modelo() {
    }

    public Modelo(String modeloAuto, Marca marca) {
        this.modeloAuto = modeloAuto;
        this.marca = marca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModeloAuto() {
        return modeloAuto;
    }

    public void setModeloAuto(String modeloAuto) {
        this.modeloAuto = modeloAuto;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}