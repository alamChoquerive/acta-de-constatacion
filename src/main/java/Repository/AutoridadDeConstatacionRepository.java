package Repository;

import Model.AutoridadDeConstatacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoridadDeConstatacionRepository extends JpaRepository<AutoridadDeConstatacion, Long> {}