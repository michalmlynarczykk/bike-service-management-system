package michalmlynarczyk.bikeservicemanagement.bike;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeRepository extends JpaRepository<Bike,Long> {

}
