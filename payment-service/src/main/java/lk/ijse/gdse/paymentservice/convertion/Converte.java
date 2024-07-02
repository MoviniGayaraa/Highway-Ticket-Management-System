package lk.ijse.gdse.paymentservice.convertion;

import lk.ijse.gdse.paymentservice.dto.PaymentDTO;
import lk.ijse.gdse.paymentservice.entity.Payment;
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

    public Payment convertToEntity(PaymentDTO ticketDTO) {
        return modelMapper.map(ticketDTO, Payment.class);
    }

    public List<PaymentDTO> convertToDTOs(List<Payment> tickets) {
        return modelMapper.map(tickets, List.class);
    }
}
