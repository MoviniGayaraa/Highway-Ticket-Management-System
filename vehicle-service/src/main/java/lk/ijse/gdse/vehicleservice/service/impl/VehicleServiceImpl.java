package lk.ijse.gdse.vehicleservice.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.vehicleservice.convertion.Converte;
import lk.ijse.gdse.vehicleservice.dto.VehicleDTO;
import lk.ijse.gdse.vehicleservice.repository.VehicleServiceDAO;
import lk.ijse.gdse.vehicleservice.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Amil Srinath
 */
@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleServiceDAO vehicleServiceDAO;
    private final RestTemplate restTemplate;

    @Autowired
    private Converte converte;

    @Override
    public void save(VehicleDTO vehicleDTO) {
        vehicleServiceDAO.save(converte.convertToEntity(vehicleDTO));
    }

    @Override
    public List<VehicleDTO> getAll() {
        return converte.convertToDTOs(vehicleServiceDAO.findAll());
    }

    @Override
    public boolean isExistsUser(String userId) {
        String url = "http://user-service/api/v1/user/existUser/" + userId;
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                return true;
            }else {
                return false;
            }
        } catch (HttpClientErrorException e) {
            return false;
        }
    }

    @Override
    public boolean isExistsVehicle(String vehicleId) {
        return vehicleServiceDAO.existsById(vehicleId);
    }
}
