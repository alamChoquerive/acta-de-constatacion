package Repository;

import Model.EstadoDelActa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoDelActaRepository extends JpaRepository<EstadoDelActa, Long> {
    // Útil para buscar el estado por defecto "GENERADA"
    java.util.Optional<EstadoDelActa> findByNombreEstadoActaIgnoreCase(String nombre);
}
