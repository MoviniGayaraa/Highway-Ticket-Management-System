package lk.ijse.gdse.vehicleservice.convertion;

import lk.ijse.gdse.vehicleservice.dto.VehicleDTO;
import lk.ijse.gdse.vehicleservice.entity.Vehicle;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Amil Srinath
 */
@Component
@RequiredArgsConstructor
public class Converte {
    private final ModelMapper modelMapper;

    public Vehicle convertToEntity(VehicleDTO vehicleDTO) {
        return modelMapper.map(vehicleDTO, Vehicle.class);
    }

    public List<VehicleDTO> convertToDTOs(List<Vehicle> vehicles) {
        return modelMapper.map(vehicles, List.class);
    }
}
