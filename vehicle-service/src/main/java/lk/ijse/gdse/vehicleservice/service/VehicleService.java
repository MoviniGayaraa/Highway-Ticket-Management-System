package lk.ijse.gdse.vehicleservice.service;

import lk.ijse.gdse.vehicleservice.dto.VehicleDTO;

import java.util.List;


public interface VehicleService {
    void save(VehicleDTO vehicleDTO);
    List<VehicleDTO> getAll();
    boolean isExistsUser(String userId);
    boolean isExistsVehicle(String vehicleId);
}
