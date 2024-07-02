package lk.ijse.gdse.ticketservice.service.impl;

import lk.ijse.gdse.ticketservice.Enum.TicketStatus;
import lk.ijse.gdse.ticketservice.convertion.Converte;
import lk.ijse.gdse.ticketservice.dto.TicketDTO;
import lk.ijse.gdse.ticketservice.entity.Ticket;
import lk.ijse.gdse.ticketservice.repository.TicketServiceDAO;
import lk.ijse.gdse.ticketservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

/**
 * @author Amil Srinath
 */

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketServiceDAO ticketServiceDAO;
    @Autowired
    private Converte converte;

    private final RestTemplate restTemplate;

    @Override
    public void save(TicketDTO ticketDTO) {
        ticketServiceDAO.save(converte.convertToEntity(ticketDTO));
    }

    @Override
    public void updateStatus(String ticketId) {
        Optional<Ticket> byId = ticketServiceDAO.findById(ticketId);
        if (byId.isPresent()) {
            Ticket ticket = byId.get();
            ticket.setStatus(TicketStatus.PAID);
            ticketServiceDAO.save(ticket);
        }
    }

    @Override
    public List<TicketDTO> getAll() {
        return converte.convertToDTOs(ticketServiceDAO.findAll());
    }

    @Override
    public boolean isExistsUser(String userId) {
        String url = "http://user-service/api/v1/user/existUser/" + userId;
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return response.getStatusCode() == HttpStatus.OK;
        } catch (HttpClientErrorException e) {
            return false;
        }
    }

    @Override
    public boolean isExistsVehicle(String vehicleId) {
        String url = "http://vehicle-service/api/v1/vehicle/existVehicle/" + vehicleId;
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return response.getStatusCode() == HttpStatus.OK;
        } catch (HttpClientErrorException e) {
            return false;
        }
    }

    @Override
    public boolean isExistsTicket(String ticketId) {
        return ticketServiceDAO.existsById(ticketId);
    }
}
