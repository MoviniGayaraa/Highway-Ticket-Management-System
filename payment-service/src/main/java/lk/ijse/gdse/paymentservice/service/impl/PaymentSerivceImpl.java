package lk.ijse.gdse.paymentservice.service.impl;

import lk.ijse.gdse.paymentservice.convertion.Converte;
import lk.ijse.gdse.paymentservice.dto.PaymentDTO;
import lk.ijse.gdse.paymentservice.repository.PaymentServiceDAO;
import lk.ijse.gdse.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * @author Amil Srinath
 */
@Service
@RequiredArgsConstructor
public class PaymentSerivceImpl implements PaymentService {
    @Autowired
    private PaymentServiceDAO paymentServiceDAO;

    @Autowired
    private Converte converte;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void save(PaymentDTO paymentDTO) {
        setPaidStatus(paymentDTO.getTicketId());
        paymentServiceDAO.save(converte.convertToEntity(paymentDTO));
    }

    private void setPaidStatus(String ticketId) {
        String url = "http://ticket-service/api/v1/ticket/updateStatus/" + ticketId;
        restTemplate.exchange(url, HttpMethod.PUT, null, String.class);
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
    public boolean isExistsTicket(String ticketId) {
        String url = "http://ticket-service/api/v1/ticket/existTicket/" + ticketId;
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return response.getStatusCode() == HttpStatus.OK;
        } catch (HttpClientErrorException e) {
            return false;
        }
    }
}
