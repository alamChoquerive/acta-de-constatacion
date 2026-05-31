package Repository;

import Model.OrganizacionEstatal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizacionEstatalRepository extends JpaRepository<OrganizacionEstatal, Long> {}
