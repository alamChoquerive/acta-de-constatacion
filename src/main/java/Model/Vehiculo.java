package Model;


import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vehiculos")
public class Vehiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo")
    private Long id;

    @Column(name = "color", length = 50)
    private String color;

    @Column(name = "dominio", nullable = false, unique = true, length = 20)
    private String dominio;

    @Column(name = "anio_patentamiento")
    private int anioPatentamiento;

    @ManyToOne
    @JoinColumn(name = "marca_id", referencedColumnName = "id_marca")
    private Marca marca;

    public Vehiculo() {
    }

    public Vehiculo(String color, String dominio, int anioPatentamiento, Marca marca) {
        this.color = color;
        this.dominio = dominio;
        this.anioPatentamiento = anioPatentamiento;
        this.marca = marca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public int getAnioPatentamiento() {
        return anioPatentamiento;
    }

    public void setAnioPatentamiento(int anioPatentamiento) {
        this.anioPatentamiento = anioPatentamiento;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}