package Service;

import Model.*;
import Repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ParametrosServiceImpl implements ParametrosService {

    private final VehiculoRepository vehiculoRepo;
    private final LicenciasRepository licenciasRepo;
    private final TipoDeInfraccionRepository tipoInfraccionRepo;
    private final AutoridadDeConstatacionRepository autoridadRepo;
    private final RutaRepository rutaRepo;
    private final OrganizacionEstatalRepository orgRepo;
    private final EstadoDelActaRepository estadoRepo;
    private final InfraccionRepository infraccionRepo;
    private final ConductorRepository conductorRepo;

    // Constructor único para inyectar todo limpiamente
    public ParametrosServiceImpl(VehiculoRepository vehiculoRepo, LicenciasRepository licenciasRepo,
                                 TipoDeInfraccionRepository tipoInfraccionRepo, AutoridadDeConstatacionRepository autoridadRepo,
                                 RutaRepository rutaRepo, OrganizacionEstatalRepository orgRepo,
                                 EstadoDelActaRepository estadoRepo, InfraccionRepository infraccionRepo,
                                 ConductorRepository conductorRepo) {
        this.vehiculoRepo = vehiculoRepo;
        this.licenciasRepo = licenciasRepo;
        this.tipoInfraccionRepo = tipoInfraccionRepo;
        this.autoridadRepo = autoridadRepo;
        this.rutaRepo = rutaRepo;
        this.orgRepo = orgRepo;
        this.estadoRepo = estadoRepo;
        this.infraccionRepo = infraccionRepo;
        this.conductorRepo = conductorRepo;
    }

    @Override public List<Vehiculo> findAllVehiculos() { return vehiculoRepo.findAll(); }
    @Override public List<Licencias> findAllLicencias() { return licenciasRepo.findAll(); }
    @Override public List<TipoDeInfraccion> findAllTiposInfraccion() { return tipoInfraccionRepo.findAll(); }
    @Override public Optional<TipoDeInfraccion> findTipoInfraccionById(int id) { return tipoInfraccionRepo.findById(id); }
    @Override public List<AutoridadDeConstatacion> findAllAutoridades() { return autoridadRepo.findAll(); }
    @Override public List<Ruta> findAllRutas() { return rutaRepo.findAll(); }
    @Override public List<OrganizacionEstatal> findAllOrganizaciones() { return orgRepo.findAll(); }
    @Override public List<EstadoDelActa> findAllEstados() { return estadoRepo.findAll(); }
    @Override public Optional<EstadoDelActa> findEstadoByNombre(String nombre) { return estadoRepo.findByNombreEstadoActaIgnoreCase(nombre); }
    @Override public Infraccion saveInfraccion(Infraccion infraccion) { return infraccionRepo.save(infraccion); }
    @Override public List<Conductor> findAllConductores() { return conductorRepo.findAll(); }
}