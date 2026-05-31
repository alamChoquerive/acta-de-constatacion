package Service;



import Model.*;
import java.util.List;
import java.util.Optional;

public interface ParametrosService {
    List<Vehiculo> findAllVehiculos();
    List<Licencias> findAllLicencias();
    List<TipoDeInfraccion> findAllTiposInfraccion();
    Optional<TipoDeInfraccion> findTipoInfraccionById(int id);
    List<AutoridadDeConstatacion> findAllAutoridades();
    List<Ruta> findAllRutas();
    List<OrganizacionEstatal> findAllOrganizaciones();
    List<EstadoDelActa> findAllEstados();
    Optional<EstadoDelActa> findEstadoByNombre(String nombre);
    Infraccion saveInfraccion(Infraccion infraccion);
    List<Conductor> findAllConductores();
}
