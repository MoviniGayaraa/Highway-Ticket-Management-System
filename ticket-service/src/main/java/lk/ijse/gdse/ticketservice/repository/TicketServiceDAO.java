package lk.ijse.gdse.ticketservice.repository;

import lk.ijse.gdse.ticketservice.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TicketServiceDAO extends JpaRepository<Ticket, String> {

}
