package lk.ijse.gdse.paymentservice.repository;

import lk.ijse.gdse.paymentservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaymentServiceDAO extends JpaRepository<Payment, String> {

}
