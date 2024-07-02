package lk.ijse.gdse.paymentservice.repository;

import lk.ijse.gdse.paymentservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Amil Srinath
 */
public interface PaymentServiceDAO extends JpaRepository<Payment, String> {

}
