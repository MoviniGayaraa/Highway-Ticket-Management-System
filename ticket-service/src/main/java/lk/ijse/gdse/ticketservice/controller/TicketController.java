package lk.ijse.gdse.ticketservice.controller;

import lk.ijse.gdse.ticketservice.Enum.TicketStatus;
import lk.ijse.gdse.ticketservice.dto.TicketDTO;
import lk.ijse.gdse.ticketservice.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Amil Srinath
 */
@RestController
@RequestMapping("api/v1/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping("/health")
    public String healthCheck() {
        return "Ticket Service is up and running";
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody TicketDTO ticketDTO) {
        ticketDTO.setStatus(TicketStatus.UNPAID);
        if (ticketService.isExistsUser(ticketDTO.getUserId())) {
            if (ticketService.isExistsVehicle(ticketDTO.getVehicleId())) {
                ticketService.save(ticketDTO);
                return ResponseEntity.ok("Ticket saved successfully");
            }else {
                return ResponseEntity.ok("Vehicle does not exists");
            }
        }else {
            return ResponseEntity.ok("User does not exists");
        }
    }

    @PutMapping("/updateStatus/{ticketId}")
    public ResponseEntity<?> updateStatus(@PathVariable String ticketId) {
        ticketService.updateStatus(ticketId);
        return ResponseEntity.ok("Ticket Status updated successfully");
    }

    @GetMapping("/getAllTickets")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(ticketService.getAll());
    }

    @GetMapping("/existTicket/{ticketId}")
    public ResponseEntity<?> existTicket(@PathVariable String ticketId) {
        if (ticketService.isExistsTicket(ticketId)){
            return ResponseEntity.ok("Ticket exists");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ticket does not exist");
        }
    }
}
