package lk.ijse.gdse.vehicleservice.repository;

import lk.ijse.gdse.vehicleservice.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VehicleServiceDAO extends JpaRepository<Vehicle, String> {
}
