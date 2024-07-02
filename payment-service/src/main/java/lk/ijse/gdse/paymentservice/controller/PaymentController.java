package lk.ijse.gdse.paymentservice.controller;

import lk.ijse.gdse.paymentservice.dto.PaymentDTO;
import lk.ijse.gdse.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Amil Srinath
 */
@RestController
@RequestMapping("api/v1/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/health")
    public String health() {
        return "Payment Service is up and running";
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody PaymentDTO paymentDTO) {
        if (paymentService.isExistsUser(paymentDTO.getUserId())) {
            if (paymentService.isExistsTicket(paymentDTO.getTicketId())) {
                paymentService.save(paymentDTO);
                return ResponseEntity.ok("Payment saved successfully");
            }else {
                return ResponseEntity.ok("Ticket does not exists");
            }
        }else {
            return ResponseEntity.ok("User does not exists");
        }
    }
}
