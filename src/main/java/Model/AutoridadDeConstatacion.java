package Model;

import jakarta.persistence.*;

@Entity
@Table(name = "autoridades_constatacion")
@DiscriminatorValue("AUTORIDAD")
public class AutoridadDeConstatacion extends Persona {

    @Column(name = "id_placa", nullable = false, unique = true)
    private int idPlaca;

    @Column(name = "id_legajo", nullable = false, unique = true)
    private int idLegajo;

    public AutoridadDeConstatacion() {
    }

    public AutoridadDeConstatacion(int idPlaca, int idLegajo, String nombre, String apellido, int dni, String genero) {
        super(nombre, apellido, dni, genero);
        this.idPlaca = idPlaca;
        this.idLegajo = idLegajo;
    }

    public int getIdPlaca() {
        return idPlaca;
    }

    public void setIdPlaca(int idPlaca) {
        this.idPlaca = idPlaca;
    }

    public int getIdLegajo() {
        return idLegajo;
    }

    public void setIdLegajo(int idLegajo) {
        this.idLegajo = idLegajo;
    }
}