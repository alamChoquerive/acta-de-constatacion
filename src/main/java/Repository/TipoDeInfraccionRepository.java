package Repository;

import Model.TipoDeInfraccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDeInfraccionRepository extends JpaRepository<TipoDeInfraccion, Integer> {}
