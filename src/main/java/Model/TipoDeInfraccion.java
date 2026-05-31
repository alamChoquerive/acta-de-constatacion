package Model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tipos_infraccion")
public class TipoDeInfraccion implements Serializable {

    @Id
    @Column(name = "id_infrac")
    private int id_infrac;

    @Column(name = "descripcion_infraccion", length = 500)
    private String descripcionInfraccion;

    @Column(name = "tipo_gravedad", length = 50)
    private String tipoGravedad;

    @Column(name = "importe_asignado")
    private double importeAsignadoInfraccion;

    @Column(name = "porcentaje_descuento")
    private double porcentajeDescuento;

    public TipoDeInfraccion() {
    }

    public TipoDeInfraccion(int id_infrac, String descripcionInfraccion, String tipoGravedad,
                            double importeAsignadoInfraccion, double porcentajeDescuento) {
        this.id_infrac = id_infrac;
        this.descripcionInfraccion = descripcionInfraccion;
        this.tipoGravedad = tipoGravedad;
        this.importeAsignadoInfraccion = importeAsignadoInfraccion;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public int getId_infrac() {
        return id_infrac;
    }

    public void setId_infrac(int id_infrac) {
        this.id_infrac = id_infrac;
    }

    public String getDescripcionInfraccion() {
        return descripcionInfraccion;
    }

    public void setDescripcionInfraccion(String descripcionInfraccion) {
        this.descripcionInfraccion = descripcionInfraccion;
    }

    public String getTipoGravedad() {
        return tipoGravedad;
    }

    public void setTipoGravedad(String tipoGravedad) {
        this.tipoGravedad = tipoGravedad;
    }

    public double getImporteAsignadoInfraccion() {
        return importeAsignadoInfraccion;
    }

    public void setImporteAsignadoInfraccion(double importeAsignadoInfraccion) {
        this.importeAsignadoInfraccion = importeAsignadoInfraccion;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }
}