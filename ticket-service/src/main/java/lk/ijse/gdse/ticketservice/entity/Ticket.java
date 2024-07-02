package lk.ijse.gdse.ticketservice.entity;

import jakarta.persistence.*;
import lk.ijse.gdse.ticketservice.Enum.TicketStatus;
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
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    private String ticketId;
    private String vehicleId;
    private String userId;
    private Date issueDate;
    @Enumerated(EnumType.STRING)
    private TicketStatus status;
}
