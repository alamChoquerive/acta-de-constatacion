package Repository;

import Model.Infraccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfraccionRepository extends JpaRepository<Infraccion, Long> {}