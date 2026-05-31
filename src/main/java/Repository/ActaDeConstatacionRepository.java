package Repository;



import Model.ActaDeConstatacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * CAMBIO GRANDE: Antes tenías ActaDeConstatacionJpaController con ~100 líneas
 * manejando EntityManager, EntityTransaction, try/catch, etc.
 *
 * Ahora esta interfaz hereda de JpaRepository<Entidad, TipoDelId> y Spring Data JPA
 * genera automáticamente la implementación con:
 *   - save(entity)         -> equivale a create() / edit()
 *   - findById(id)         -> equivale a findActaDeConstatacion(id)
 *   - findAll()            -> equivale a findActaDeConstatacionEntities()
 *   - delete(entity)       -> equivale a destroy()
 *   - count()              -> cuenta registros
 *   ... y decenas de métodos más
 *
 * También podés declarar métodos con nombres especiales y Spring los implementa solo:
 */
@Repository
public interface ActaDeConstatacionRepository extends JpaRepository<ActaDeConstatacion, Integer> {

    // Ejemplo: buscar actas por estado (Spring genera el SQL automáticamente por el nombre del método)
    // List<ActaDeConstatacion> findByEstado_NombreEstadoActa(String nombreEstado);
}
