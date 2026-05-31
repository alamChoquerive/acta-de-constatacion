package Model;


import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "marcas")
public class Marca implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marca")
    private Long id;

    @Column(name = "marca_auto", nullable = false, length = 100)
    private String marcaAuto;

    public Marca() {
    }

    public Marca(String marcaAuto) {
        this.marcaAuto = marcaAuto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarcaAuto() {
        return marcaAuto;
    }

    public void setMarcaAuto(String marcaAuto) {
        this.marcaAuto = marcaAuto;
    }
}