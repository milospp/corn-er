package ftn.corner.repository;

import ftn.corner.model.Plant;
import ftn.corner.model.SoilMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoilMeasurementRepository extends JpaRepository<SoilMeasurement, Long> {
}
