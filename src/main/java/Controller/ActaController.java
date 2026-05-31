package Controller;

import Model.*;
import Service.ActaService;
import Service.ParametrosService; // <-- IMPORTANTE: Importar el nuevo servicio
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/actas")
public class ActaController {

    // Declaramos ambos servicios como final
    private final ActaService actaService;
    private final ParametrosService parametrosService;

    // Inyección limpia por constructor (Spring se encarga de todo)
    public ActaController(ActaService actaService, ParametrosService parametrosService) {
        this.actaService = actaService;
        this.parametrosService = parametrosService;
    }

    /**
     * GET /actas/nueva -> Muestra el formulario de crear acta
     */
    @GetMapping("/nueva")
    public String mostrarFormularioCrear(Model model) {
        // CAMBIO: Ahora estos datos maestros se le piden a parametrosService
        model.addAttribute("vehiculos", parametrosService.findAllVehiculos());
        model.addAttribute("licencias", parametrosService.findAllLicencias());
        model.addAttribute("tiposInfraccion", parametrosService.findAllTiposInfraccion());
        model.addAttribute("autoridades", parametrosService.findAllAutoridades());
        model.addAttribute("rutas", parametrosService.findAllRutas());
        model.addAttribute("organizaciones", parametrosService.findAllOrganizaciones());

        model.addAttribute("acta", new ActaDeConstatacion());
        return "crearActa";
    }

    /**
     * POST /actas/nueva -> Procesa el formulario y guarda el acta
     */
    @PostMapping("/nueva")
    public String crearActa(
            @RequestParam Long vehiculoId,
            @RequestParam Integer licenciaId,
            @RequestParam Integer tipoInfraccionId,
            @RequestParam Long autoridadId,
            @RequestParam Long rutaId,
            @RequestParam Long organizacionId,
            @RequestParam String fechaLabrado,
            @RequestParam(required = false) String observaciones,
            RedirectAttributes redirectAttrs) {

        try {
            ActaDeConstatacion acta = new ActaDeConstatacion();

            // Fecha labrado
            LocalDate fecha = LocalDate.parse(fechaLabrado);
            acta.setFechaLabraDo(fecha);
            acta.setFechaDeVtoPagoVolun(fecha.plusDays(10));
            acta.setHoraDeLabrado(LocalTime.now());

            // Observaciones
            acta.setObservaciones(
                    (observaciones != null && !observaciones.isBlank())
                            ? observaciones
                            : "Acta generada desde el sistema"
            );

            // CAMBIOS AQUÍ ABAJO: Todo lo que sea buscar catálogos usa parametrosService

            // Vehículo
            List<Vehiculo> vehiculos = parametrosService.findAllVehiculos();
            vehiculos.stream()
                    .filter(v -> v.getId().equals(vehiculoId))
                    .findFirst()
                    .ifPresent(acta::setVehiculo);

            // Lugar de constatación (desde la ruta)
            List<Ruta> rutas = parametrosService.findAllRutas();
            rutas.stream()
                    .filter(r -> r.getId().equals(rutaId))
                    .findFirst()
                    .ifPresent(ruta -> acta.setLugarDeConstatacion(ruta.getNombreRuta() + " KM " + ruta.getKmRuta()));

            // Autoridad
            parametrosService.findAllAutoridades().stream()
                    .filter(a -> a.getId().equals(autoridadId))
                    .findFirst()
                    .ifPresent(acta::setAutoridad);

            // Organización
            parametrosService.findAllOrganizaciones().stream()
                    .filter(o -> o.getId().equals(organizacionId))
                    .findFirst()
                    .ifPresent(acta::setOrganizacion);

            // Estado por defecto "GENERADA"
            parametrosService.findEstadoByNombre("GENERADA")
                    .or(() -> parametrosService.findAllEstados().stream().findFirst())
                    .ifPresent(acta::setEstado);

            // Infracción
            Optional<TipoDeInfraccion> tipoOpt = parametrosService.findTipoInfraccionById(tipoInfraccionId);
            if (tipoOpt.isPresent()) {
                TipoDeInfraccion tipo = tipoOpt.get();
                Infraccion infraccion = new Infraccion();
                infraccion.setDescrpInfraccion(tipo.getDescripcionInfraccion());
                infraccion.setImporteInfraccion(tipo.getImporteAsignadoInfraccion());
                infraccion.addTipoDeInfraccion(tipo);
                // El guardado de la infracción también va por parámetros
                infraccion = parametrosService.saveInfraccion(infraccion);
                acta.addInfraccion(infraccion);
            }

            // El acta sí se guarda usando el actaService principal
            ActaDeConstatacion actaGuardada = actaService.saveActa(acta);
            redirectAttrs.addFlashAttribute("exito", "Acta creada exitosamente. ID: " + actaGuardada.getIdActa());
            return "redirect:/actas/nueva";

        } catch (Exception e) {
            redirectAttrs.addFlashAttribute("error", "Error al crear el acta: " + e.getMessage());
            return "redirect:/actas/nueva";
        }
    }

    /**
     * GET /actas/consulta -> Lista todas las actas
     */
    @GetMapping("/consulta")
    public String consultarActas(Model model) {
        List<ActaDeConstatacion> actas = actaService.findAllActas();
        model.addAttribute("actas", actas);
        return "consulta";
    }
}