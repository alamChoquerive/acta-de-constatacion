package Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;

@Entity
@Table(name = "personas")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_persona")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Long id;


    @NotBlank(message = "El nombre es obligatorio")
    @Pattern(regexp = "^[A-Za-záéíóúÁÉÍÓÚñÑ\\s]+$",
            message = "El nombre solo puede contener letras")
    @Column(name = "nombre", nullable = false, length = 100)
    protected String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Pattern(regexp = "^[A-Za-záéíóúÁÉÍÓÚñÑ\\s]+$",
            message = "El apellido solo puede contener letras")
    @Column(name = "apellido", nullable = false, length = 100)
    protected String apellido;


    @Min(value = 1000000, message = "El DNI debe tener al menos 7 dígitos")
    @Max(value = 99999999, message = "El DNI no puede tener más de 8 dígitos")
    @Column(name = "dni", nullable = false, unique = true)
    protected int dni;

    @Column(name = "genero", length = 50)
    protected String genero;

    // Constructores, getters y setters — idénticos a los originales
    public Persona() {}

    public Persona(String nombre, String apellido, int dni, String genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.genero = genero;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public int getDni() { return dni; }
    public void setDni(int dni) { this.dni = dni; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
}
