package lk.ijse.gdse.ticketservice.convertion;

import lk.ijse.gdse.ticketservice.dto.TicketDTO;
import lk.ijse.gdse.ticketservice.entity.Ticket;
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

    public Ticket convertToEntity(TicketDTO ticketDTO) {
        return modelMapper.map(ticketDTO, Ticket.class);
    }

    public List<TicketDTO> convertToDTOs(List<Ticket> tickets) {
        return modelMapper.map(tickets, List.class);
    }
}
