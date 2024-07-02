package lk.ijse.gdse.vehicleservice.service;

import lk.ijse.gdse.vehicleservice.dto.VehicleDTO;

import java.util.List;

/**
 * @author Amil Srinath
 */
public interface VehicleService {
    void save(VehicleDTO vehicleDTO);
    List<VehicleDTO> getAll();
    boolean isExistsUser(String userId);
    boolean isExistsVehicle(String vehicleId);
}
