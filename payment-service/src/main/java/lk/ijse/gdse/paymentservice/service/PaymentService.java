package lk.ijse.gdse.paymentservice.service;

import lk.ijse.gdse.paymentservice.dto.PaymentDTO;

/**
 * @author Amil Srinath
 */
public interface PaymentService {
    void save(PaymentDTO paymentDTO);
    boolean isExistsUser(String userId);
    boolean isExistsTicket(String ticketId);
}
