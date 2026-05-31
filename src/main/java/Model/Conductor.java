package Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "conductores")
@DiscriminatorValue("CONDUCTOR")
public class Conductor extends Persona implements Serializable {

    @NotBlank(message = "El domicilio es obligatorio")
    @Column(name = "domicilio", length = 255)
    private String domicilio;

    @OneToOne(mappedBy = "conductor", cascade = CascadeType.ALL)
    private Licencias licencia;

    public Conductor() {}

    public Conductor(String domicilio, String nombre, String apellido, int dni, String genero) {
        super(nombre, apellido, dni, genero);
        this.domicilio = domicilio;
    }

    public String getDomicilio() { return domicilio; }
    public void setDomicilio(String domicilio) { this.domicilio = domicilio; }
    public Licencias getLicencia() { return licencia; }
    public void setLicencia(Licencias licencia) { this.licencia = licencia; }
}
