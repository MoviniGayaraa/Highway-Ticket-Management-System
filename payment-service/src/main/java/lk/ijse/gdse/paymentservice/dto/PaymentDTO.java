package lk.ijse.gdse.paymentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Amil Srinath
 */
@AllArgsConstructor
@NoArgsConstructor
@Data

public class PaymentDTO {
    private String paymentId;
    private String ticketId;
    private String userId;
    private double amount;
    private Date paymentDate;
}
