package Repository;

import Model.TipoRuta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRutaRepository extends JpaRepository<TipoRuta, Long> {}
